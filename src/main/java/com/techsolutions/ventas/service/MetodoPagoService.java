package com.techsolutions.ventas.service;

import com.techsolutions.ventas.dto.MetodoPagoCreateDTO;
import com.techsolutions.ventas.dto.MetodoPagoDTO;
import com.techsolutions.ventas.dto.MetodoPagoUpdateDTO;

import java.util.List;

public interface MetodoPagoService {
    List<MetodoPagoDTO> listarTodos();
    MetodoPagoDTO obtenerPorId(Long id);
    MetodoPagoDTO crear(MetodoPagoCreateDTO dto);
    MetodoPagoDTO editar(Long id, MetodoPagoUpdateDTO dto);
    void deshabilitarPorId(Long id);
}
