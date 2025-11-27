package com.techsolutions.ventas.model;

import com.techsolutions.ventas.enums.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Rol extends BaseModel{
    @NotBlank(message = "el nombre obligatorio")
    @Size(min = 2, max = 100, message = "el nombre debe tener entre 2 y 100 caracteres")
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Estado estado = Estado.ACTIVO;
}
