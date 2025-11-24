package com.techsolutions.ventas.dto;

import java.math.BigDecimal;

public record DetallePedidoDTO(
    ProductoDTO producto,
    int cantidad,
    BigDecimal subTotal
) {
}
