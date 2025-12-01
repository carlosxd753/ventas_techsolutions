package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.ProductoDTO;

import java.math.BigDecimal;

public interface PrecioService {
    BigDecimal obtenerPrecio(BigDecimal precioBase);
}
