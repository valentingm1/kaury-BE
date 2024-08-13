package com.example.kaury.controller;
import com.example.kaury.dto.entrada.OrdenesEntradaDTO;
import com.example.kaury.dto.modificacion.OrdenEntradaModificacionDTO;
import com.example.kaury.dto.salida.OrdenesSalidaDTO;
import com.example.kaury.exception.ResourceNotFoundException;
import com.example.kaury.service.impl.OrdenesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
@CrossOrigin
public class OrdenesController {

    private final OrdenesService ordenesService;

    public OrdenesController(OrdenesService ordenesService) {
        this.ordenesService = ordenesService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<OrdenesSalidaDTO> agregarOrden(@Validated @RequestBody OrdenesEntradaDTO ordenesEntradaDTO) {
            OrdenesSalidaDTO ordenSalida = ordenesService.agregarOrden(ordenesEntradaDTO);
            return new ResponseEntity<>(ordenSalida, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenesSalidaDTO> buscarOrdenPorId(@PathVariable Long id) {
        OrdenesSalidaDTO ordenSalida = ordenesService.buscarOrdenPorId(id);
        return new ResponseEntity<>(ordenSalida, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<OrdenesSalidaDTO>> listarOrdenes() {
        List<OrdenesSalidaDTO> ordenes = ordenesService.listarOrdenes();
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarOrden(@PathVariable Long id) {
        ordenesService.eliminarOrden(id);
        return new ResponseEntity<>("Orden eliminada correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<OrdenesSalidaDTO> actualizarOrden(@RequestBody @Valid OrdenEntradaModificacionDTO ordenModDto) {
        OrdenesSalidaDTO ordenActualizada = ordenesService.actualizarOrden(ordenModDto);
        return ResponseEntity.ok(ordenActualizada);
    }
}
