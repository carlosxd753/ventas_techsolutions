package com.techsolutions.ventas.service;

import java.util.List;

public interface PedidoService {
    List<PedidoDTO> listarTodos();
    PedidoDTO obtenerPorId(Long id);
    PedidoDTO crear(PedidoCreateDTO dto);
    PedidoDTO editar(PedidoUpdateDTO dto);
    void borrarPorId(Long id);
}
