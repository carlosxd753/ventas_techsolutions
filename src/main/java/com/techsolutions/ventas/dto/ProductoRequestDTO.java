package com.techsolutions.ventas.dto;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        String nombre,
        BigDecimal precioVenta,
        int stock,
        BigDecimal precioCompra,
        int stockMinimo
) {
}
