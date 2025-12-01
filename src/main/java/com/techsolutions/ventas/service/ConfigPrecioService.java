package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.ConfigPrecioDTO;
import com.techsolutions.ventas.model.ConfigPrecio;

public interface ConfigPrecioService {
    ConfigPrecio obtenerConfigPrecio();
    ConfigPrecioDTO obtenerConfigPrecioDTO();
    ConfigPrecioDTO actualizarConfigPrecio(ConfigPrecioDTO configPrecio);
}
