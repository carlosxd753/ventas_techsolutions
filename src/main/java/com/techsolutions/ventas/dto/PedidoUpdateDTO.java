package com.techsolutions.ventas.dto;

import java.util.List;

public record PedidoUpdateDTO(
        List<DetallePedidoDTO> detallePedido
) {
}
