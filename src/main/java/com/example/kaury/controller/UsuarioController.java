package com.example.kaury.controller;

import com.example.kaury.dto.entrada.UsuarioEntradaDTO;
import com.example.kaury.dto.modificacion.UsuarioEntradaModificacionDTO;
import com.example.kaury.dto.salida.UsuarioSalidaDTO;
import com.example.kaury.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {

    private final IUsuarioService UsuarioService;


    public UsuarioController(IUsuarioService UsuarioService) {
        this.UsuarioService = UsuarioService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<UsuarioSalidaDTO> agregarUsuario(@Validated @RequestBody UsuarioEntradaDTO usuarioEntradaDTO) {
        return new ResponseEntity<>(UsuarioService.agregarUsuario(usuarioEntradaDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioSalidaDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioSalidaDTO UsuarioSalidaDTO = UsuarioService.buscarUsuarioPorId(id);
        return UsuarioSalidaDTO != null ? ResponseEntity.ok(UsuarioSalidaDTO) : ResponseEntity.notFound().build();
    }


    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioSalidaDTO>> listarUsuarios() {
        return new ResponseEntity<>(UsuarioService.listarUsuarios(), HttpStatus.OK);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        UsuarioService.eliminarUsuario(id);
        return new ResponseEntity<>("Usuario eliminado correctamente", HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<UsuarioSalidaDTO> actualizarUsuario(@RequestBody @Validated UsuarioEntradaModificacionDTO usuarioModDto) {
        UsuarioSalidaDTO usuarioActualizado = UsuarioService.actualizarUsuario(usuarioModDto);
        return new ResponseEntity<>(usuarioActualizado, HttpStatus.OK);
    }
}
