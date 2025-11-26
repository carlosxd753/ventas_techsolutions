package com.techsolutions.ventas.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        @NotBlank(message = "el nombre obligatorio")
        @Size(min = 2, max = 100, message = "el nombre debe tener entre 2 y 100 caracteres")
        String nombre,

        @NotNull(message = "el precio de venta es obligatorio")
        @DecimalMin(value = "0.01", message = "el precio de venta debe ser mayor a 0")
        BigDecimal precioVenta,

        @Min(value = 0, message = "el stock no puede ser negativo")
        int stock,

        @NotNull(message = "el precio de compra es obligatorio")
        @DecimalMin(value = "0.01", message = "el precio de compra debe ser mayor a 0")
        BigDecimal precioCompra,

        @NotBlank(message = "la url de la imagen del producto es obligatorio")
        String imagenUrl,

        @Min(value = 0, message = "el stock minimo no puede ser negativo")
        int stockMinimo
) {
}
