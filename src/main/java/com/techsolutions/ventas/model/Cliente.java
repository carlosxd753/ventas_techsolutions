package com.techsolutions.ventas.model;

import com.techsolutions.ventas.enums.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente extends BaseModel{
    private String nombre;
    private String dni;
    private String celular;
    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.ACTIVO;
}
