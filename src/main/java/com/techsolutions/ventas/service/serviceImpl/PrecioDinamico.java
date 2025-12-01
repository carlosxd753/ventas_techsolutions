package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.service.StrategyPrecio;

import java.math.BigDecimal;

public class PrecioDinamico implements StrategyPrecio {
    private final BigDecimal factor;

    public PrecioDinamico(BigDecimal factor) {
        this.factor = factor;
    }

    @Override
    public BigDecimal calcularPrecio(BigDecimal precioBase) {
        return precioBase.multiply(factor);
    }
}
