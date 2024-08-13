package com.example.kaury.service.impl;

import com.example.kaury.dto.entrada.CategoriaProductosEntradaDTO;
import com.example.kaury.dto.salida.CategoriaProductosSalidaDTO;
import com.example.kaury.entity.CategoriaProductos;
import com.example.kaury.repository.CategoriaProductoRepository;
import com.example.kaury.service.ICategoriaProductosService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaProductoService implements ICategoriaProductosService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaProductoService.class);
    private final CategoriaProductoRepository categoriaProductosRepository;
    private final ModelMapper modelMapper;

    public CategoriaProductoService(CategoriaProductoRepository categoriaProductosRepository, ModelMapper modelMapper) {
        this.categoriaProductosRepository = categoriaProductosRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoriaProductosSalidaDTO agregarCategoria(CategoriaProductosEntradaDTO categoriaEntradaDTO) {
        CategoriaProductos categoria = modelMapper.map(categoriaEntradaDTO, CategoriaProductos.class);
        LOGGER.info("Agregando nueva categoría...");

        CategoriaProductos categoriaGuardada = categoriaProductosRepository.save(categoria);
        LOGGER.info("Categoría guardada correctamente");

        CategoriaProductosSalidaDTO categoriaSalidaDTO = modelMapper.map(categoriaGuardada, CategoriaProductosSalidaDTO.class);
        return categoriaSalidaDTO;
    }


    @Override
    public CategoriaProductosSalidaDTO buscarCategoriaPorId(Long id) {
        LOGGER.info("Buscando categoría por ID: {}", id);
        CategoriaProductos categoriaBuscada = categoriaProductosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
        LOGGER.info("Categoría encontrada: {}", categoriaBuscada);

        CategoriaProductosSalidaDTO categoriaSalidaDTO = modelMapper.map(categoriaBuscada, CategoriaProductosSalidaDTO.class);
        return categoriaSalidaDTO;
    }

    @Override
    public List<CategoriaProductosSalidaDTO> listarCategorias() {
        LOGGER.info("Listando todas las categorías");
        List<CategoriaProductosSalidaDTO> categorias = categoriaProductosRepository.findAll().stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaProductosSalidaDTO.class))
                .collect(Collectors.toList());
        LOGGER.info("Se encontraron {} categorías", categorias.size());
        return categorias;
    }

    @Override
    public void eliminarCategoria(Long id) {
        LOGGER.info("Eliminando categoría con ID: {}", id);
        categoriaProductosRepository.findById(id).ifPresent(categoria -> {
            categoriaProductosRepository.delete(categoria);
            LOGGER.info("Categoría eliminada exitosamente");
        });
    }
}
