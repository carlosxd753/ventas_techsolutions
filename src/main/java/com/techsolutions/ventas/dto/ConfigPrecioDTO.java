package com.techsolutions.ventas.dto;

import com.techsolutions.ventas.enums.TipoPrecio;

import java.math.BigDecimal;

public record ConfigPrecioDTO(
        TipoPrecio estrategiaPrecio,
        BigDecimal porcentajeDescuentoGlobal,
        BigDecimal factorDinamicoGlobal
) {
}
