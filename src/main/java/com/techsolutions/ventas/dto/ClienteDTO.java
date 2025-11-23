package com.techsolutions.ventas.dto;

import java.time.LocalDateTime;

public record ClienteDTO(
        Long id,
        String nombre,
        String dni,
        String celular,
        LocalDateTime fecha_creacion
) {
}
