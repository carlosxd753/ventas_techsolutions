package com.techsolutions.ventas.dto;

public record UsuarioCreateDTO(
        String correo,
        String password,
        Long idRol
) {
}
