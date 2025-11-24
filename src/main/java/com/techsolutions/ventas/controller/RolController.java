package com.techsolutions.ventas.controller;

import com.techsolutions.ventas.dto.RolDTO;
import com.techsolutions.ventas.dto.RolRequestDTO;
import com.techsolutions.ventas.service.RolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {
    private final RolService rolService;

    @GetMapping
    public List<RolDTO> listarRoles(){
        return rolService.listarTodos();
    }

    @GetMapping("/{id}")
    public RolDTO buscarRolPorId(@PathVariable Long id){
        return rolService.obtenerPorId(id);
    }

    @PostMapping
    public RolDTO crearRol(@Valid @RequestBody RolRequestDTO dto){
        return rolService.crear(dto);
    }

    @PutMapping("/{id}")
    public RolDTO  editarRol(@PathVariable Long id,
                             @Valid @RequestBody RolRequestDTO dto){
        return rolService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deshabilitarRol(@PathVariable Long id){
        rolService.deshabilitarPorId(id);
    }
}
