package com.techsolutions.ventas.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductoDTO(
        Long id,
        String nombre,
        BigDecimal precioVenta,
        int stock,
        BigDecimal precioCompra,
        int stockMinimo,
        String imagenUrl,
        LocalDateTime fecha_creacion
) {
}
