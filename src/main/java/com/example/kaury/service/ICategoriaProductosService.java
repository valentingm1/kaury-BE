package com.example.kaury.service;

import com.example.kaury.dto.entrada.CategoriaProductosEntradaDTO;
import com.example.kaury.dto.salida.CategoriaProductosSalidaDTO;

import java.util.List;

public interface ICategoriaProductosService {

    CategoriaProductosSalidaDTO agregarCategoria(CategoriaProductosEntradaDTO categoriaEntradaDTO);

    CategoriaProductosSalidaDTO buscarCategoriaPorId(Long id);

    List<CategoriaProductosSalidaDTO> listarCategorias();

    void eliminarCategoria(Long id);
}
