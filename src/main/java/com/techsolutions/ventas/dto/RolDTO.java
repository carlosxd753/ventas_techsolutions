package com.techsolutions.ventas.dto;

import com.techsolutions.ventas.enums.Estado;

import java.time.LocalDateTime;

public record RolDTO(
        Long id,
        String nombre,
        Estado estado,
        LocalDateTime fecha_creacion
) {
}
