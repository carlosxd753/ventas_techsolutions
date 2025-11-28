package com.techsolutions.ventas.controller;

import com.techsolutions.ventas.dto.ClienteCreateDTO;
import com.techsolutions.ventas.dto.ClienteDTO;
import com.techsolutions.ventas.dto.ClienteUpdateDTO;
import com.techsolutions.ventas.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes(){
        return new ResponseEntity<>(clienteService.listarTodos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id){
        return new ResponseEntity<>(clienteService.obtenerPorId(id),  HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> crearCliente(@Valid @RequestBody ClienteCreateDTO dto){
        return new ResponseEntity<>(clienteService.crear(dto),  HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> editarCliente(@PathVariable Long id,
                                    @Valid @RequestBody ClienteUpdateDTO dto){
        return new ResponseEntity<>(clienteService.editar(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deshabilitarClientePorId(@PathVariable Long id){
        clienteService.deshabilitarPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
