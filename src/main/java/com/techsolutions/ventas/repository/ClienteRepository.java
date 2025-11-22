package com.techsolutions.ventas.repository;

import com.techsolutions.ventas.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
