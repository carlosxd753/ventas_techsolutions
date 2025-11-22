package com.techsolutions.ventas.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente extends BaseModel{
    private String nombre;
    private String dni;
    private String celular;
}
