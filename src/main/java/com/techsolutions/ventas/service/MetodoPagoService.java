package com.techsolutions.ventas.service;

import java.util.List;

public interface MetodoPagoService {
    List<MetodoPagoDTO> listarTodos();
    MetodoPagoDTO obtenerPorId(Long id);
    MetodoPagoDTO crear(MetodoPagoCreateDTO dto);
    MetodoPagoDTO editar(MetodoPagoUpdateDTO dto);
    void borrarPorId(Long id);
}
