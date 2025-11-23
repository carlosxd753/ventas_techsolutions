package com.techsolutions.ventas.service;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listarTodos();
    UsuarioDTO obtenerPorId(Long id);
    UsuarioDTO crear(UsuarioCreateDTO dto);
    UsuarioDTO editar(UsuarioUpdateDTO dto);
    void borrarPorId(Long id);
}
