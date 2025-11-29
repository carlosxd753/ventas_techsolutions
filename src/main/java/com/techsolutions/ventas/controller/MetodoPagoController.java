package com.techsolutions.ventas.controller;

import com.techsolutions.ventas.dto.MetodoPagoCreateDTO;
import com.techsolutions.ventas.dto.MetodoPagoDTO;
import com.techsolutions.ventas.dto.MetodoPagoUpdateDTO;
import com.techsolutions.ventas.service.MetodoPagoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodos_pago")
@RequiredArgsConstructor
public class MetodoPagoController {
    private final MetodoPagoService metodoPagoService;

    @GetMapping
    public ResponseEntity<List<MetodoPagoDTO>> listarMetodosPago(){
        return new ResponseEntity<>(metodoPagoService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPagoDTO> buscarMetodoPagoPorId(@PathVariable Long id){
        return new ResponseEntity<>(metodoPagoService.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MetodoPagoDTO> crearMetodoPago(@Valid @RequestBody MetodoPagoCreateDTO dto){
        return new ResponseEntity<>(metodoPagoService.crear(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPagoDTO> editarEstadoMetodoPago(@PathVariable Long id){
        return new ResponseEntity<>(metodoPagoService.editar(id), HttpStatus.OK);
    }
}
