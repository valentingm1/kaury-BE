package com.example.kaury.service.impl;

import com.example.kaury.dto.entrada.OrdenesEntradaDTO;
import com.example.kaury.dto.modificacion.CostosEntradaModificacionDTO;
import com.example.kaury.dto.modificacion.OrdenEntradaModificacionDTO;
import com.example.kaury.dto.salida.OrdenesSalidaDTO;
import com.example.kaury.entity.*;
import com.example.kaury.exception.ResourceNotFoundException;
import com.example.kaury.repository.OrdenesRepository;
import com.example.kaury.repository.ProductoRepository;
import com.example.kaury.repository.UsuarioRepository;
import com.example.kaury.service.IOrdenesService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenesService implements IOrdenesService {
    private final OrdenesRepository ordenesRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrdenesService.class);

    public OrdenesService(OrdenesRepository ordenesRepository, UsuarioRepository usuarioRepository, ProductoRepository productoRepository, ModelMapper modelMapper) {
        this.ordenesRepository = ordenesRepository;
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.productoRepository = productoRepository;
    }

    @Override
    public OrdenesSalidaDTO agregarOrden(OrdenesEntradaDTO ordenesEntradaDTO) throws ResourceNotFoundException {
        LOGGER.info("Registrando orden...");

        // Obtener el usuario desde la base de datos usando el usuarioId del DTO
        Usuario usuario = usuarioRepository.findById(ordenesEntradaDTO.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con id " + ordenesEntradaDTO.getUsuarioId() + " no encontrado"));

        // Mapear el DTO de entrada a la entidad Ordenes
        Ordenes ordenes = modelMapper.map(ordenesEntradaDTO, Ordenes.class);

        // Buscar y mapear productos
        List<Producto> productos = ordenesEntradaDTO.getProductosIds().stream()
                .map(id -> productoRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Producto con id " + id + " no encontrado")))
                .collect(Collectors.toList());

        // Establecer la relación con el usuario y los productos
        ordenes.setUsuario(usuario);
        ordenes.setProductos(productos);
        ordenes.setId(null); // A REVISION ####################### ########## ######  ###### ########## #######################

        // Establecer estados iniciales
        ordenes.setEstadoAnterior(EstadoOrden.NUEVA); // Estado inicial puede ser NUEVA
        ordenes.setEstadoActual(EstadoOrden.NUEVA);   // Estado actual también debe ser NUEVA al crear

        // Guardar la nueva orden en la base de datos
        Ordenes ordenesGuardada = ordenesRepository.save(ordenes);
        LOGGER.info("Orden guardada correctamente");

        // Mapear la entidad guardada al DTO de salida
        OrdenesSalidaDTO ordenesSalidaDTO = modelMapper.map(ordenesGuardada, OrdenesSalidaDTO.class);
        return ordenesSalidaDTO;
    }

    @Override
    public List<OrdenesSalidaDTO> listarOrdenes() {
        LOGGER.info("Listando todas las ordenes");
        List<OrdenesSalidaDTO> ordenes = ordenesRepository.findAll().stream()
                .map(orden -> modelMapper.map(orden, OrdenesSalidaDTO.class))
                .collect(Collectors.toList());
        LOGGER.info("Se encontraron {} ordenes", ordenes.size());
        return ordenes;
    }

    @Override
    public OrdenesSalidaDTO buscarOrdenPorId(Long id) {
        LOGGER.info("Buscando orden por ID: {}", id);
        Ordenes ordenesBuscada = ordenesRepository.findById(id).orElse(null);
        OrdenesSalidaDTO ordenesSalidaDTO = ordenesBuscada != null ? modelMapper.map(ordenesBuscada, OrdenesSalidaDTO.class) : null;
        LOGGER.info("Orden encontrada: {}", ordenesSalidaDTO);
        return ordenesSalidaDTO;
    }

    @Override
    public void eliminarOrden(Long id) {
        LOGGER.info("Eliminando orden con ID: {}", id);
        ordenesRepository.findById(id).ifPresent(orden -> {
            ordenesRepository.delete(orden);
            LOGGER.info("Orden eliminada exitosamente");
        });
    }


    @Override
    @Transactional
    public OrdenesSalidaDTO actualizarOrden(OrdenEntradaModificacionDTO ordenEntradaModDto) {
        Long id = ordenEntradaModDto.getId();
        LOGGER.info("Actualizando orden con ID: {}", id);

        Ordenes ordenExistente = ordenesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Orden no encontrada con ID: " + id));

        // Actualizar los campos de la orden existente con los valores del DTO
        if (ordenEntradaModDto.getCanalVenta() != null) {
            ordenExistente.setCanalVenta(ordenEntradaModDto.getCanalVenta());
        }
        if (ordenEntradaModDto.getEnvioSeleccionado() != null) {
            ordenExistente.setEnvioSeleccionado(ordenEntradaModDto.getEnvioSeleccionado());
        }
        if (ordenEntradaModDto.getDatosEnvio() != null) {
            DatosEnvio datosEnvio = modelMapper.map(ordenEntradaModDto.getDatosEnvio(), DatosEnvio.class);
            ordenExistente.setDatosEnvio(datosEnvio);
        }
        if (ordenEntradaModDto.getNote() != null) {
            ordenExistente.setNote(ordenEntradaModDto.getNote());
        }
        if (ordenEntradaModDto.getProductosIds() != null) {
            List<Producto> productos = ordenEntradaModDto.getProductosIds().stream()
                    .map(productoId -> productoRepository.findById(productoId)
                            .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + productoId)))
                    .collect(Collectors.toList());
            ordenExistente.setProductos(productos);
        }
        if (ordenEntradaModDto.getSucursal() != null) {
            ordenExistente.setSucursal(ordenEntradaModDto.getSucursal());
        }
        if (ordenEntradaModDto.getTelefono() != null) {
            ordenExistente.setTelefono(ordenEntradaModDto.getTelefono());
        }
        if (ordenEntradaModDto.getTipoDePago() != null) {
            ordenExistente.setTipoDePago(ordenEntradaModDto.getTipoDePago());
        }
        if (ordenEntradaModDto.getTipoEnvio() != null) {
            ordenExistente.setTipoEnvio(ordenEntradaModDto.getTipoEnvio());
        }
        if (ordenEntradaModDto.getTotal() != null) {
            ordenExistente.setTotal(ordenEntradaModDto.getTotal());
        }
        if (ordenEntradaModDto.getCostos() != null) {
            Costos costosExistentes = ordenExistente.getCostos();
            CostosEntradaModificacionDTO costosNuevos = ordenEntradaModDto.getCostos();

            if (costosNuevos.getAndreaniAsucursal() != null) {
                costosExistentes.setAndreaniAsucursal(costosNuevos.getAndreaniAsucursal());
            }
            if (costosNuevos.getAndreaniCostoDomicilio() != null) {
                costosExistentes.setAndreaniCostoDomicilio(costosNuevos.getAndreaniCostoDomicilio());
            }
            if (costosNuevos.getMinimoCompra() != null) {
                costosExistentes.setMinimoCompra(costosNuevos.getMinimoCompra());
            }
            if (costosNuevos.getTransferencia() != null) {
                costosExistentes.setTransferencia(costosNuevos.getTransferencia());
            }
            ordenExistente.setCostos(costosExistentes);
        }

        // Actualizar usuario
        if (ordenEntradaModDto.getUsuarioId() != null) {
            Usuario nuevoUsuario = usuarioRepository.findById(ordenEntradaModDto.getUsuarioId())
                    .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + ordenEntradaModDto.getUsuarioId()));
            ordenExistente.setUsuario(nuevoUsuario);
        }

        // Actualizar EstadoActual y EstadoAnterior
        if (ordenEntradaModDto.getEstadoActual() != null) {
            EstadoOrden estadoActualAnterior = ordenExistente.getEstadoActual();
            ordenExistente.setEstadoAnterior(estadoActualAnterior);
            ordenExistente.setEstadoActual(ordenEntradaModDto.getEstadoActual());
        }


        Ordenes ordenActualizada = ordenesRepository.save(ordenExistente);
        OrdenesSalidaDTO ordenSalidaDTO = modelMapper.map(ordenActualizada, OrdenesSalidaDTO.class);
        LOGGER.info("Orden actualizada exitosamente: {}", ordenSalidaDTO.toString());
        return ordenSalidaDTO;
    }



}
