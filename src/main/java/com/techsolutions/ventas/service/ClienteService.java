package com.techsolutions.ventas.service;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<ClienteDTO> listarTodos();
    ClienteDTO obtenerPorId(Long id);
    ClienteDTO crear(ClienteCreateDTO dto);
    ClienteDTO editar(ClienteUpdateDTO dto);
    void borrarPorId(Long id);
}
