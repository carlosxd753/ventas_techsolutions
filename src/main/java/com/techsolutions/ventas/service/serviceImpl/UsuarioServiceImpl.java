package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.dto.RolDTO;
import com.techsolutions.ventas.dto.UsuarioCreateDTO;
import com.techsolutions.ventas.dto.UsuarioDTO;
import com.techsolutions.ventas.dto.UsuarioUpdateDTO;
import com.techsolutions.ventas.enums.Estado;
import com.techsolutions.ventas.exceptions.EntidadNoEncontradaException;
import com.techsolutions.ventas.model.Rol;
import com.techsolutions.ventas.model.Usuario;
import com.techsolutions.ventas.repository.RolRepository;
import com.techsolutions.ventas.repository.UsuarioRepository;
import com.techsolutions.ventas.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioDTO> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream()
                .map(u -> new UsuarioDTO(
                        u.getId(),
                        u.getCorreo(),
                        new RolDTO(
                                u.getRol().getId(),
                                u.getRol().getNombre(),
                                u.getRol().getEstado(),
                                u.getFecha_creacion()
                        ),
                        u.getEstado(),
                        u.getFecha_creacion()
                ))
                .toList();
    }

    @Override
    public UsuarioDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Usuario no encontrado con id: " + id));

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getCorreo(),
                new RolDTO(
                        usuario.getRol().getId(),
                        usuario.getRol().getNombre(),
                        usuario.getRol().getEstado(),
                        usuario.getFecha_creacion()
                ),
                usuario.getEstado(),
                usuario.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public UsuarioDTO crear(UsuarioCreateDTO dto) {
        Rol rol = rolRepository.findById(dto.idRol())
                .orElseThrow(() -> new EntidadNoEncontradaException("Rol no encontrado con id: " + dto.idRol()));

        Usuario usuario = new Usuario();

        usuario.setCorreo(dto.correo());
        usuario.setPassword(passwordEncoder.encode(dto.password()));
        usuario.setRol(rol);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        return new UsuarioDTO(
                usuarioGuardado.getId(),
                usuarioGuardado.getCorreo(),
                new RolDTO(
                        usuarioGuardado.getRol().getId(),
                        usuarioGuardado.getRol().getNombre(),
                        usuarioGuardado.getRol().getEstado(),
                        usuarioGuardado.getRol().getFecha_creacion()
                ),
                usuarioGuardado.getEstado(),
                usuarioGuardado.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public UsuarioDTO editar(Long id, UsuarioUpdateDTO dto) {
        Rol rol = rolRepository.findById(dto.idRol())
                .orElseThrow(() -> new EntidadNoEncontradaException("Rol no encontrado con id: " + dto.idRol()));

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Usuario no encontrado con id: " + id));

        usuario.setPassword(dto.password());
        usuario.setRol(rol);

        Usuario usuarioActualizado = usuarioRepository.save(usuario);

        return new UsuarioDTO(
                usuarioActualizado.getId(),
                usuarioActualizado.getCorreo(),
                new RolDTO(
                        usuarioActualizado.getRol().getId(),
                        usuarioActualizado.getRol().getNombre(),
                        usuarioActualizado.getRol().getEstado(),
                        usuarioActualizado.getRol().getFecha_creacion()
                ),
                usuarioActualizado.getEstado(),
                usuarioActualizado.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public void deshabilitarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Usuario no encontrado con id: " + id));

        usuario.setEstado(Estado.INACTIVO);

        usuarioRepository.save(usuario);
    }
}
