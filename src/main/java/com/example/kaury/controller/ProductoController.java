package com.example.kaury.controller;


import com.example.kaury.dto.entrada.ProductoEntradaDTO;
import com.example.kaury.dto.modificacion.ProductoEntradaModificacionDTO;
import com.example.kaury.dto.modificacion.UsuarioEntradaModificacionDTO;
import com.example.kaury.dto.salida.ProductoSalidaDTO;
import com.example.kaury.dto.salida.UsuarioSalidaDTO;
import com.example.kaury.entity.Producto;
import com.example.kaury.service.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<ProductoSalidaDTO> agregarProducto(@Validated @RequestBody ProductoEntradaDTO productoEntradaDTO) {
        return new ResponseEntity<>(productoService.agregarProducto(productoEntradaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoSalidaDTO> obtenerProductoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerProductoPorId(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProductoSalidaDTO>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return new ResponseEntity<>("Producto eliminado correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<ProductoSalidaDTO> actualizarUsuario(@RequestBody @Validated ProductoEntradaModificacionDTO productoEntradaModificacionDTO) {
        ProductoSalidaDTO productoActualizado = productoService.actualizarProducto(productoEntradaModificacionDTO);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }
}
