package com.techsolutions.ventas.controller;

import com.techsolutions.ventas.dto.ClienteCreateDTO;
import com.techsolutions.ventas.dto.ClienteDTO;
import com.techsolutions.ventas.dto.ClienteUpdateDTO;
import com.techsolutions.ventas.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping
    public List<ClienteDTO> listarClientes(){
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarClientePorId(@PathVariable Long id){
        return clienteService.obtenerPorId(id);
    }

    @PostMapping
    public ClienteDTO crearCliente(@Valid @RequestBody ClienteCreateDTO dto){
        return clienteService.crear(dto);
    }

    @PutMapping("/{id}")
    public ClienteDTO editarCliente(@PathVariable Long id,
                                    @Valid @RequestBody ClienteUpdateDTO dto){
        return clienteService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deshabilitarClientePorId(@PathVariable Long id){
        clienteService.deshabilitarPorId(id);
    }
}
