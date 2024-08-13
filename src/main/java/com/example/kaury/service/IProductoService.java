package com.example.kaury.service;

import com.example.kaury.dto.entrada.ProductoEntradaDTO;
import com.example.kaury.dto.modificacion.ProductoEntradaModificacionDTO;
import com.example.kaury.dto.salida.ProductoSalidaDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IProductoService {
    ProductoSalidaDTO agregarProducto(ProductoEntradaDTO productoEntradaDTO);

    ProductoSalidaDTO obtenerProductoPorId(Long id);

    List<ProductoSalidaDTO> listarProductos();

    void eliminarProducto(Long id);

    @Transactional
    ProductoSalidaDTO actualizarProducto(ProductoEntradaModificacionDTO productoEntradaModDto);
}
