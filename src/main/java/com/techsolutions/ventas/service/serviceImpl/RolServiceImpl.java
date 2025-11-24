package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.dto.RolDTO;
import com.techsolutions.ventas.dto.RolRequestDTO;
import com.techsolutions.ventas.enums.Estado;
import com.techsolutions.ventas.model.Rol;
import com.techsolutions.ventas.repository.RolRepository;
import com.techsolutions.ventas.service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {
    private final RolRepository rolRepository;

    @Override
    public List<RolDTO> listarTodos() {
        List<Rol> roles = rolRepository.findAll();

        return roles.stream()
                .map(r -> new RolDTO(
                        r.getId(),
                        r.getNombre(),
                        r.getEstado(),
                        r.getFecha_creacion()
                ))
                .toList();
    }

    @Override
    public RolDTO obtenerPorId(Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Rol no encontrado con id: " + id));

        return new RolDTO(
                rol.getId(),
                rol.getNombre(),
                rol.getEstado(),
                rol.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public RolDTO crear(RolRequestDTO dto) {
        Rol rol = new Rol();
        rol.setNombre(dto.nombre());

        Rol rolGuardado = rolRepository.save(rol);

        return new RolDTO(
                rolGuardado.getId(),
                rolGuardado.getNombre(),
                rolGuardado.getEstado(),
                rolGuardado.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public RolDTO editar(Long id, RolRequestDTO dto) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Rol no encontrado con id: " + id));

        rol.setNombre(dto.nombre());

        Rol rolActualizado = rolRepository.save(rol);

        return new RolDTO(
                rolActualizado.getId(),
                rolActualizado.getNombre(),
                rolActualizado.getEstado(),
                rolActualizado.getFecha_creacion()
        );
    }

    @Override
    @Transactional
    public void deshabilitarPorId(Long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new EntidadNoEncontradaException("Rol no encontrado con id: " + id));

        rol.setEstado(Estado.INACTIVO);

        rolRepository.save(rol);
    }
}
