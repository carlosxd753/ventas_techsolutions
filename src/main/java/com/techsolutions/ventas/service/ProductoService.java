package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.ProductoDTO;
import com.techsolutions.ventas.dto.ProductoRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {
    Page<ProductoDTO> listarTodos(String busqueda, Pageable pageable);
    ProductoDTO obtenerPorId(Long id);
    ProductoDTO crear(ProductoRequestDTO dto);
    ProductoDTO editar(Long id, ProductoRequestDTO dto);
    void deshabilitarPorId(Long id);
}
