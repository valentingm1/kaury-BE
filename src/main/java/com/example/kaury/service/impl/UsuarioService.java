package com.example.kaury.service.impl;

import com.example.kaury.dto.entrada.UsuarioEntradaDTO;
import com.example.kaury.dto.modificacion.UsuarioEntradaModificacionDTO;
import com.example.kaury.dto.salida.UsuarioSalidaDTO;
import com.example.kaury.entity.Usuario;
import com.example.kaury.repository.UsuarioRepository;
import com.example.kaury.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository UsuarioRepository;
    private final ModelMapper modelMapper;
    private final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    public UsuarioService(com.example.kaury.repository.UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        UsuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UsuarioSalidaDTO agregarUsuario(UsuarioEntradaDTO usuarioEntradaDTO) {
        Usuario usuario = modelMapper.map(usuarioEntradaDTO, Usuario.class);
        LOGGER.info("Registrando usuario...");

        Usuario UsuarioGuardado = UsuarioRepository.save(usuario);
        LOGGER.info("Usuario guardado correctamente");

        return modelMapper.map(UsuarioGuardado, UsuarioSalidaDTO.class);
    }
    @Override
    public List<UsuarioSalidaDTO> listarUsuarios() {
        LOGGER.info("Listando todos los usuarios");
        List<UsuarioSalidaDTO> usuarios = UsuarioRepository.findAll().stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioSalidaDTO.class))
                .collect(Collectors.toList());
        LOGGER.info("Se encontraron {} usuarios", usuarios.size());
        return usuarios;
    }

    @Override
    public UsuarioSalidaDTO buscarUsuarioPorId(Long id) {
        LOGGER.info("Buscando usuario por ID: {}", id);
        Usuario usuarioBuscado = UsuarioRepository.findById(id).orElse(null);
        UsuarioSalidaDTO usuarioSalidaDTO = usuarioBuscado != null ? modelMapper.map(usuarioBuscado, UsuarioSalidaDTO.class) : null;
        LOGGER.info("Usuario encontrado: {}", usuarioSalidaDTO);
        return usuarioSalidaDTO;
    }

    @Override
    public void eliminarUsuario(Long id) {
        LOGGER.info("Eliminando usuario con ID: {}", id);
        UsuarioRepository.findById(id).ifPresent(usuario -> {
            UsuarioRepository.delete(usuario);
            LOGGER.info("Usuario eliminado exitosamente");
        });
    }

    @Override
    public UsuarioSalidaDTO actualizarUsuario(UsuarioEntradaModificacionDTO usuarioModDto) {
        Long id = usuarioModDto.getId();
        LOGGER.info("Actualizando usuario con ID: {}", id);

        Usuario usuarioExistente = UsuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));

        // Actualizar los campos del usuario existente con los valores del DTO
        if (usuarioModDto.getNombre() != null) {
            usuarioExistente.setNombre(usuarioModDto.getNombre());
        }
        if (usuarioModDto.getApellido() != null) {
            usuarioExistente.setApellido(usuarioModDto.getApellido());
        }
        if (usuarioModDto.getDni() != null) {
            usuarioExistente.setDni(usuarioModDto.getDni());
        }
        if (usuarioModDto.getEmail() != null) {
            usuarioExistente.setEmail(usuarioModDto.getEmail());
        }
        if (usuarioModDto.getTelefono() != null) {
            usuarioExistente.setTelefono(usuarioModDto.getTelefono());
        }
        if (usuarioModDto.getPassword() != null) {
            usuarioExistente.setPassword(usuarioModDto.getPassword());
        }

        Usuario usuarioActualizado = UsuarioRepository.save(usuarioExistente);
        UsuarioSalidaDTO usuarioSalidaDTO = modelMapper.map(usuarioActualizado, UsuarioSalidaDTO.class);
        LOGGER.info("Usuario actualizado exitosamente: {}", usuarioSalidaDTO.toString());
        return usuarioSalidaDTO;
    }


}
