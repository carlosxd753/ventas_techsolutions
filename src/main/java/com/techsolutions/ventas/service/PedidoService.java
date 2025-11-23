package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.PedidoDTO;
import com.techsolutions.ventas.dto.PedidoRequestDTO;

import java.util.List;

public interface PedidoService {
    List<PedidoDTO> listarTodos();
    PedidoDTO obtenerPorId(Long id);
    PedidoDTO crear(PedidoRequestDTO dto);
    PedidoDTO editar(PedidoRequestDTO dto);
    void borrarPorId(Long id);
}
