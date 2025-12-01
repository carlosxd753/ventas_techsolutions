package com.techsolutions.ventas.service.serviceImpl;

import com.techsolutions.ventas.dto.ConfigPrecioDTO;
import com.techsolutions.ventas.model.ConfigPrecio;
import com.techsolutions.ventas.repository.ConfigPrecioRepository;
import com.techsolutions.ventas.service.ConfigPrecioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConfigPrecioServiceImpl implements ConfigPrecioService {
    private final ConfigPrecioRepository configPrecioRepository;

    @Override
    public ConfigPrecio obtenerConfigPrecio() {
        return configPrecioRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("La configuracion de los precios no ha sido inicializado"));
    }

    @Override
    public ConfigPrecioDTO obtenerConfigPrecioDTO() {
        ConfigPrecio configPrecio = obtenerConfigPrecio();

        return new ConfigPrecioDTO(
                configPrecio.getEstrategiaPrecio(),
                configPrecio.getPorcentajeDescuentoGlobal(),
                configPrecio.getFactorDinamicoGlobal()
        );
    }

    @Override
    @Transactional
    public ConfigPrecioDTO actualizarConfigPrecio(ConfigPrecioDTO dto) {
        ConfigPrecio configPrecio = configPrecioRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("La configuracion de los precios no ha sido inicializado"));

        configPrecio.setEstrategiaPrecio(dto.estrategiaPrecio());
        configPrecio.setFactorDinamicoGlobal(dto.factorDinamicoGlobal());
        configPrecio.setPorcentajeDescuentoGlobal(dto.porcentajeDescuentoGlobal());

        ConfigPrecio configPrecioActualizado = configPrecioRepository.save(configPrecio);

        return new ConfigPrecioDTO(
                configPrecioActualizado.getEstrategiaPrecio(),
                configPrecioActualizado.getPorcentajeDescuentoGlobal(),
                configPrecioActualizado.getFactorDinamicoGlobal()
        );
    }
}
