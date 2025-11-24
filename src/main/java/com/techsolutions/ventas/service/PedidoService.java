package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.PedidoCreateRequestDTO;
import com.techsolutions.ventas.dto.PedidoDTO;
import com.techsolutions.ventas.dto.PedidoUpdateDTO;

import java.util.List;

public interface PedidoService {
    List<PedidoDTO> listarTodos();
    PedidoDTO obtenerPorId(Long id);
    PedidoDTO crear(PedidoCreateRequestDTO dto);
    PedidoDTO editar(Long id, PedidoUpdateDTO dto);
    void borrarPorId(Long id);
}
