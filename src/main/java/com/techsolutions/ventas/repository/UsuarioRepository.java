package com.techsolutions.ventas.repository;

import com.techsolutions.ventas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
