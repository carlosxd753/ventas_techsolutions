package com.techsolutions.ventas.dto;

import java.util.List;

public record PedidoCreateRequestDTO(
        Long idCliente,
        Long idMetodoPago,
        List<DetallePedidoCreateRequestDTO> detallePedido
) {
}
