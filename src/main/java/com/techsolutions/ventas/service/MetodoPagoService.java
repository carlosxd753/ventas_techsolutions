package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.MetodoPagoDTO;
import com.techsolutions.ventas.dto.MetodoPagoRequestDTO;

import java.util.List;

public interface MetodoPagoService {
    List<MetodoPagoDTO> listarTodos();
    MetodoPagoDTO obtenerPorId(Long id);
    MetodoPagoDTO crear(MetodoPagoRequestDTO dto);
    MetodoPagoDTO editar(MetodoPagoRequestDTO dto);
    void borrarPorId(Long id);
}
