package com.example.kaury.controller;

import com.example.kaury.dto.entrada.CategoriaProductosEntradaDTO;
import com.example.kaury.dto.salida.CategoriaProductosSalidaDTO;
import com.example.kaury.service.ICategoriaProductosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin
public class CategoriaProductosController {

    private final ICategoriaProductosService categoriaProductosService;

    public CategoriaProductosController(ICategoriaProductosService categoriaProductosService) {
        this.categoriaProductosService = categoriaProductosService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<CategoriaProductosSalidaDTO> agregarCategoria(@Validated @RequestBody CategoriaProductosEntradaDTO categoriaEntradaDTO) {
        CategoriaProductosSalidaDTO categoriaSalidaDTO = categoriaProductosService.agregarCategoria(categoriaEntradaDTO);
        return new ResponseEntity<>(categoriaSalidaDTO, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoriaProductosSalidaDTO> buscarCategoriaPorId(@PathVariable Long id) {
        CategoriaProductosSalidaDTO categoriaSalidaDTO = categoriaProductosService.buscarCategoriaPorId(id);
        return new ResponseEntity<>(categoriaSalidaDTO, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaProductosSalidaDTO>> listarCategorias() {
        List<CategoriaProductosSalidaDTO> categorias = categoriaProductosService.listarCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable Long id) {
        categoriaProductosService.eliminarCategoria(id);
        return new ResponseEntity<>("Categoría eliminada correctamente", HttpStatus.OK);
    }
}
