package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.UsuarioCreateDTO;
import com.techsolutions.ventas.dto.UsuarioDTO;
import com.techsolutions.ventas.dto.UsuarioUpdateDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listarTodos();
    UsuarioDTO obtenerPorId(Long id);
    UsuarioDTO crear(UsuarioCreateDTO dto);
    UsuarioDTO editar(Long id, UsuarioUpdateDTO dto);
    void deshabilitarPorId(Long id);
}
