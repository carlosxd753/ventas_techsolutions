package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.ClienteCreateDTO;
import com.techsolutions.ventas.dto.ClienteDTO;
import com.techsolutions.ventas.dto.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listarTodos();
    ClienteDTO obtenerPorId(Long id);
    ClienteDTO crear(ClienteCreateDTO dto);
    ClienteDTO editar(Long id, ClienteUpdateDTO dto);
    void deshabilitarPorId(Long id);
}
