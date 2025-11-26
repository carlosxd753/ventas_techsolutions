package com.techsolutions.ventas.controller;

import com.techsolutions.ventas.dto.ProductoDTO;
import com.techsolutions.ventas.dto.ProductoRequestDTO;
import com.techsolutions.ventas.service.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @GetMapping
    public List<ProductoDTO> listarProductos(){
        System.out.println("TEST");
        return productoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ProductoDTO buscarProductoPorId(@PathVariable Long id){
        return productoService.obtenerPorId(id);
    }

    @PostMapping
    public ProductoDTO crearProducto(@Valid @RequestBody ProductoRequestDTO dto){
        return productoService.crear(dto);
    }

    @PutMapping("/{id}")
    public ProductoDTO editarProducto(@PathVariable Long id,
                                      @Valid @RequestBody ProductoRequestDTO dto){
        return productoService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deshabilitarProducto(@PathVariable Long id){
        productoService.deshabilitarPorId(id);
    }
}
