package com.techsolutions.ventas.dto;

import java.time.LocalDateTime;

public record UsuarioDTO(
        Long id,
        String correo,
        RolDTO rol,
        LocalDateTime fecha_creacion) {
}
