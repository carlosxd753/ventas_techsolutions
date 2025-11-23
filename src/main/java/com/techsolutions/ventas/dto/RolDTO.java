package com.techsolutions.ventas.dto;

import java.time.LocalDateTime;

public record RolDTO(
        Long id,
        String nombre,
        LocalDateTime fecha_creacion
) {
}
