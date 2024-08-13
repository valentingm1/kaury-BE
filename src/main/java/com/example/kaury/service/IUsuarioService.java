package com.example.kaury.service;

import com.example.kaury.dto.entrada.UsuarioEntradaDTO;
import com.example.kaury.dto.modificacion.UsuarioEntradaModificacionDTO;
import com.example.kaury.dto.salida.UsuarioSalidaDTO;

import java.util.List;

public interface IUsuarioService {
    UsuarioSalidaDTO agregarUsuario(UsuarioEntradaDTO usuarioEntradaDTO);

    List<UsuarioSalidaDTO> listarUsuarios();

    UsuarioSalidaDTO buscarUsuarioPorId(Long id);

    void eliminarUsuario(Long id);

    UsuarioSalidaDTO actualizarUsuario(UsuarioEntradaModificacionDTO usuarioModDto);
}
