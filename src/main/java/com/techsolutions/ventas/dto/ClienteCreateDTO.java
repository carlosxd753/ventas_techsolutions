package com.techsolutions.ventas.dto;

public record ClienteCreateDTO(
        String nombre,
        String dni,
        String celular
) {
}
