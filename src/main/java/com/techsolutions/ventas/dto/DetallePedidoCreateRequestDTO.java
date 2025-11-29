package com.techsolutions.ventas.dto;

import java.math.BigDecimal;

public record DetallePedidoCreateRequestDTO(
        Long idProducto,
        int cantidad,
        BigDecimal subTotal
) {
}
