package com.techsolutions.ventas.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoDTO(
        Long id,
        ClienteDTO cliente,
        MetodoPagoDTO metodoPago,
        List<DetallePedidoDTO> detallePedido,
        LocalDateTime fecha_creacion
) {
}
