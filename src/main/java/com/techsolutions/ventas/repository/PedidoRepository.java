package com.techsolutions.ventas.repository;

import com.techsolutions.ventas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
