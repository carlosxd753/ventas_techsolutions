package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.RolDTO;
import com.techsolutions.ventas.dto.RolRequestDTO;

import java.util.List;

public interface RolService {
    List<RolDTO> listarTodos();
    RolDTO obtenerPorId(Long id);
    RolDTO crear(RolRequestDTO dto);
    RolDTO editar(Long id, RolRequestDTO dto);
    void deshabilitarPorId(Long id);
}
