package com.techsolutions.ventas.controller;

import com.techsolutions.ventas.dto.ConfigPrecioDTO;
import com.techsolutions.ventas.service.ConfigPrecioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/config-precios")
@RequiredArgsConstructor
public class ConfigPrecioController {
    private final ConfigPrecioService configPrecioService;

    @GetMapping
    public ResponseEntity<ConfigPrecioDTO> obtenerConfigPrecio(){
        return new ResponseEntity<>(configPrecioService.obtenerConfigPrecioDTO(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ConfigPrecioDTO> actualizar(@RequestBody ConfigPrecioDTO dto) {
        configPrecioService.actualizarConfigPrecio(dto);
        return ResponseEntity.ok().body(dto);
    }
}
