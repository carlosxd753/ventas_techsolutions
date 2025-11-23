package com.techsolutions.ventas.service;

import java.util.List;

public interface ProductoService {
    List<ProductoDTO> listarTodos();
    ProductoDTO obtenerPorId(Long id);
    ProductoDTO crear(ProductoCreateDTO dto);
    ProductoDTO editar(ProductoUpdateDTO dto);
    void borrarPorId(Long id);
}
