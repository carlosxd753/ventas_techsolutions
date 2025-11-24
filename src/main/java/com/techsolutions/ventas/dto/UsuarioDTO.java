package com.techsolutions.ventas.dto;

import com.techsolutions.ventas.enums.Estado;

import java.time.LocalDateTime;

public record UsuarioDTO(
        Long id,
        String correo,
        RolDTO rol,
        Estado estado,
        LocalDateTime fecha_creacion) {
}
