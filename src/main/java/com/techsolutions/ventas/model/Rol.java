package com.techsolutions.ventas.model;

import com.techsolutions.ventas.enums.Estado;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rol extends BaseModel{
    private String nombre;
    private Estado estado = Estado.ACTIVO;
}
