package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.service.StrategyPrecio;

import java.math.BigDecimal;

public class PrecioEstandar implements StrategyPrecio {

    @Override
    public BigDecimal calcularPrecio(BigDecimal precioBase) {
        return precioBase;
    }
}
