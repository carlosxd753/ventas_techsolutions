package com.techsolutions.ventas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteCreateDTO(
        @NotBlank(message = "el nombre obligatorio")
        @Size(min = 2, max = 100, message = "el nombre debe tener entre 2 y 100 caracteres")
        String nombre,
        String dni,
        String celular
) {
}
