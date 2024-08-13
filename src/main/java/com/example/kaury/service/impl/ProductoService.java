package com.example.kaury.service.impl;

import com.example.kaury.dto.entrada.ProductoEntradaDTO;
import com.example.kaury.dto.modificacion.ProductoEntradaModificacionDTO;
import com.example.kaury.dto.salida.ProductoSalidaDTO;
import com.example.kaury.entity.CategoriaProductos;
import com.example.kaury.entity.Producto;
import com.example.kaury.exception.ResourceNotFoundException;
import com.example.kaury.repository.CategoriaProductoRepository;
import com.example.kaury.repository.ProductoRepository;
import com.example.kaury.service.IProductoService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoService.class);

    private final ProductoRepository productoRepository;
    private final CategoriaProductoRepository categoriaProductoRepository;
    private final ModelMapper modelMapper;

    public ProductoService(ProductoRepository productoRepository, CategoriaProductoRepository categoriaProductoRepository, ModelMapper modelMapper) {
        this.productoRepository = productoRepository;
        this.categoriaProductoRepository = categoriaProductoRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    public void setupMapper() {
        modelMapper.createTypeMap(Producto.class, ProductoSalidaDTO.class)
                .addMappings(mapper -> mapper.map(src -> src.getCategorias(), ProductoSalidaDTO::setCategorias));
    }

    public ProductoSalidaDTO agregarProducto(ProductoEntradaDTO productoEntradaDTO) {
        Producto producto = modelMapper.map(productoEntradaDTO, Producto.class);

        // Obtener entidades CategoriaProducto a partir de los IDs
        List<CategoriaProductos> categorias = productoEntradaDTO.getCategoriasIds().stream()
                .map(id -> categoriaProductoRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("CategoriaProducto con id " + id + " no encontrado")))
                .collect(Collectors.toList());

        producto.setCategorias(categorias);

        Producto productoGuardado = productoRepository.save(producto);
        ProductoSalidaDTO productoSalidaDTO = modelMapper.map(productoGuardado, ProductoSalidaDTO.class);

        return productoSalidaDTO;
    }


    @Override
    public ProductoSalidaDTO obtenerProductoPorId(Long id) {
        LOGGER.info("Obteniendo el producto con ID {}", id);
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> {
                    LOGGER.error("Producto no encontrado con ID {}", id);
                    return new RuntimeException("Producto no encontrado");
                });
        ProductoSalidaDTO productoSalidaDTO = modelMapper.map(producto, ProductoSalidaDTO.class);
        LOGGER.info("Producto encontrado con ID {}", productoSalidaDTO.getId());
        return productoSalidaDTO;
    }

    @Override
    public List<ProductoSalidaDTO> listarProductos() {
        LOGGER.info("Listando todos los productos");
        List<ProductoSalidaDTO> productos = productoRepository.findAll().stream()
                .map(producto -> modelMapper.map(producto, ProductoSalidaDTO.class))
                .collect(Collectors.toList());
        LOGGER.info("Se encontraron {} productos", productos.size());
        return productos;
    }

    @Override
    public void eliminarProducto(Long id) {
        LOGGER.info("Eliminando el producto con ID {}", id);
        if (!productoRepository.existsById(id)) {
            LOGGER.error("Producto no encontrado con ID {}", id);
            throw new RuntimeException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
        LOGGER.info("Producto eliminado con ID {}", id);
    }


    @Override
    @Transactional
    public ProductoSalidaDTO actualizarProducto(ProductoEntradaModificacionDTO productoEntradaModDto) {
        Long id = productoEntradaModDto.getId();
        LOGGER.info("Actualizando producto con ID: {}", id);

        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));

        // Actualizar los campos del producto existente con los valores del DTO
        if (productoEntradaModDto.getColor() != null) {
            productoExistente.setColor(productoEntradaModDto.getColor());
        }
        if (productoEntradaModDto.getDescription() != null) {
            productoExistente.setDescription(productoEntradaModDto.getDescription());
        }
        if (productoEntradaModDto.getIdc() != null) {
            productoExistente.setIdc(productoEntradaModDto.getIdc());
        }
        if (productoEntradaModDto.getImageCard() != null) {
            productoExistente.setImageCard(productoEntradaModDto.getImageCard());
        }
        if (productoEntradaModDto.getNombre() != null) {
            productoExistente.setNombre(productoEntradaModDto.getNombre());
        }
        if (productoEntradaModDto.getStock() != null) {
            productoExistente.setStock(productoEntradaModDto.getStock());
        }
        if (productoEntradaModDto.getTalle() != null) {
            productoExistente.setTalle(productoEntradaModDto.getTalle());
        }
        if (productoEntradaModDto.getUnitPrice() != null) {
            productoExistente.setUnitPrice(productoEntradaModDto.getUnitPrice());
        }

        // Convertir IDs de categorías a entidades de categorías
        if (productoEntradaModDto.getCategoriasIds() != null) {
            List<CategoriaProductos> categorias = productoEntradaModDto.getCategoriasIds().stream()
                    .map(categoriaId -> categoriaProductoRepository.findById(categoriaId)
                            .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada con ID: " + categoriaId)))
                    .collect(Collectors.toList());
            productoExistente.setCategorias(categorias);
        }

        Producto productoActualizado = productoRepository.save(productoExistente);
        ProductoSalidaDTO productoSalidaDTO = modelMapper.map(productoActualizado, ProductoSalidaDTO.class);
        LOGGER.info("Producto actualizado exitosamente: {}", productoSalidaDTO.toString());
        return productoSalidaDTO;
    }
}
