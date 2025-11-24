package com.techsolutions.ventas.controller;

import com.techsolutions.ventas.dto.UsuarioCreateDTO;
import com.techsolutions.ventas.dto.UsuarioDTO;
import com.techsolutions.ventas.dto.UsuarioUpdateDTO;
import com.techsolutions.ventas.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarUsuarioPorId(@PathVariable Long id){
        return usuarioService.obtenerPorId(id);
    }

    @PostMapping
    public UsuarioDTO crearUsuario(@Valid @RequestBody UsuarioCreateDTO dto){
        return usuarioService.crear(dto);
    }

    @PutMapping("/{id}")
    public UsuarioDTO editarUsuario(@PathVariable Long id,
                                    @Valid @RequestBody UsuarioUpdateDTO dto){
        return usuarioService.editar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deshabilitarUsuario(@PathVariable Long id){
        usuarioService.deshabilitarPorId(id);
    }
}
