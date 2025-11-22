package com.techsolutions.ventas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario extends BaseModel{
    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String correo;

    @NotBlank
    @Column(nullable = false)
    @Size(min = 6)
    private String password;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_rol",  nullable = false)
    private Rol rol;
}
