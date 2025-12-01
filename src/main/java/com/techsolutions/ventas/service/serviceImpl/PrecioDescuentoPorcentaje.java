package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.service.StrategyPrecio;

import java.math.BigDecimal;

public class PrecioDescuentoPorcentaje implements StrategyPrecio {
    private final BigDecimal porcentaje;

    public PrecioDescuentoPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public BigDecimal calcularPrecio(BigDecimal precioBase) {
        return precioBase.subtract(
                precioBase.multiply(porcentaje).divide(new BigDecimal("100"))
        );
    }
}
