package com.techsolutions.ventas.service;

import java.math.BigDecimal;

public interface StrategyPrecio {
    BigDecimal calcularPrecio(BigDecimal precioBase);
}
