package com.techsolutions.ventas.service;

import java.util.List;

public interface RolService {
    List<RolDTO> listarTodos();
    RolDTO obtenerPorId(Long id);
    RolDTO crear(RolCreateDTO dto);
    RolDTO editar(RolUpdateDTO dto);
    void borrarPorId(Long id);
}
