package com.techsolutions.ventas.model;

import com.techsolutions.ventas.enums.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.ACTIVO;
    private String imagenUrl;
}
