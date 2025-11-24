package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.ProductoDTO;
import com.techsolutions.ventas.dto.ProductoRequestDTO;

import java.util.List;

public interface ProductoService {
    List<ProductoDTO> listarTodos();
    ProductoDTO obtenerPorId(Long id);
    ProductoDTO crear(ProductoRequestDTO dto);
    ProductoDTO editar(Long id, ProductoRequestDTO dto);
    void deshabilitarPorId(Long id);
}
