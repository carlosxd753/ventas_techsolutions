package com.techsolutions.ventas.dto;

public record DetallePedidoCreateRequestDTO(
        Long idProducto,
        int cantidad
) {
}
