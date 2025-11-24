package com.techsolutions.ventas.controller;

import com.techsolutions.ventas.dto.PedidoCreateRequestDTO;
import com.techsolutions.ventas.dto.PedidoDTO;
import com.techsolutions.ventas.dto.PedidoUpdateDTO;
import com.techsolutions.ventas.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @GetMapping
    public List<PedidoDTO> listarPedidos(){
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public PedidoDTO buscarPedidoPorId(@PathVariable Long id){
        return pedidoService.obtenerPorId(id);
    }

    @PostMapping
    public PedidoDTO crearPedido(@Valid @RequestBody PedidoCreateRequestDTO dto){
        return pedidoService.crear(dto);
    }

    @PutMapping("/{id}")
    public PedidoDTO editarPedido(@PathVariable Long id,
                                  @Valid @RequestBody PedidoUpdateDTO dto){
        return pedidoService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id){
        pedidoService.borrarPorId(id);
    }
}
