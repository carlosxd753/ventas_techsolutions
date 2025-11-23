package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.ClienteCreateDTO;
import com.techsolutions.ventas.dto.ClienteDTO;
import com.techsolutions.ventas.dto.ClienteUpdateDTO;

import java.util.List;

public interface ClienteService {
    List<ClienteDTO> listarTodos();
    ClienteDTO obtenerPorId(Long id);
    ClienteDTO crear(ClienteCreateDTO dto);
    ClienteDTO editar(ClienteUpdateDTO dto);
    void borrarPorId(Long id);
}
