package com.techsolutions.ventas.dto;

import java.time.LocalDateTime;

public record PedidoDTO(
        Long id,
        ClienteDTO cliente,
        UsuarioDTO usuario,
        MetodoPagoDTO metodoPago,
        LocalDateTime fecha_creacion
) {
}
