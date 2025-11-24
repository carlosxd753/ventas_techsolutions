package com.techsolutions.ventas.controller;

import com.techsolutions.ventas.dto.MetodoPagoCreateDTO;
import com.techsolutions.ventas.dto.MetodoPagoDTO;
import com.techsolutions.ventas.dto.MetodoPagoUpdateDTO;
import com.techsolutions.ventas.service.MetodoPagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodos_pago")
@RequiredArgsConstructor
public class MetodoPagoController {
    private final MetodoPagoService metodoPagoService;

    @GetMapping
    public List<MetodoPagoDTO> listarMetodosPago(){
        return metodoPagoService.listarTodos();
    }

    @GetMapping("/{id}")
    public MetodoPagoDTO buscarMetodoPagoPorId(@PathVariable Long id){
        return metodoPagoService.obtenerPorId(id);
    }

    @PostMapping
    public MetodoPagoDTO crearMetodoPago(@Valid @RequestBody MetodoPagoCreateDTO dto){
        return metodoPagoService.crear(dto);
    }

    @PutMapping("/{id}")
    public MetodoPagoDTO editarMetodoPago(@PathVariable Long id,
                                          @Valid @RequestBody MetodoPagoUpdateDTO dto){
        return metodoPagoService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deshabilitarMetodoPagoPorId(@PathVariable Long id){
        metodoPagoService.deshabilitarPorId(id);
    }
}
