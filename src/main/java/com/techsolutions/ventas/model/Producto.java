package com.techsolutions.ventas.model;

import com.techsolutions.ventas.enums.Estado;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Producto extends BaseModel{
    private String nombre;
    private BigDecimal precioVenta;
    private int stock;
    private BigDecimal precioCompra;
    private int stockMinimo;
    private Estado estado = Estado.ACTIVO;
}
