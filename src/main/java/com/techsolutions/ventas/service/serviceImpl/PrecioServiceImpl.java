package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.dto.ProductoDTO;
import com.techsolutions.ventas.model.ConfigPrecio;
import com.techsolutions.ventas.service.ConfigPrecioService;
import com.techsolutions.ventas.service.PrecioService;
import com.techsolutions.ventas.service.StrategyPrecio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PrecioServiceImpl implements PrecioService {
    private final ConfigPrecioService configPrecioService;

    @Override
    public BigDecimal obtenerPrecio(BigDecimal precioBase) {
        ConfigPrecio configPrecio = configPrecioService.obtenerConfigPrecio();
        StrategyPrecio estrategia;

        switch (configPrecio.getEstrategiaPrecio()){
            case DESCUENTO -> estrategia = new PrecioDescuentoPorcentaje(configPrecio.getPorcentajeDescuentoGlobal());
            case DINAMICO -> estrategia = new PrecioDinamico(configPrecio.getFactorDinamicoGlobal());
            default -> estrategia = new PrecioEstandar();
        }

        return estrategia.calcularPrecio(precioBase);
    }
}
