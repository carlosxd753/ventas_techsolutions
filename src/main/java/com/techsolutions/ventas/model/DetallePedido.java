package com.techsolutions.ventas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class DetallePedido extends BaseModel{
    @Min(1)
    private int cantidad;

    private BigDecimal subTotal;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @OneToMany
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
}
