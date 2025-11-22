package com.techsolutions.ventas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha_creacion;

    private LocalDateTime fecha_actualizacion;

    @PrePersist
    public void onCreate() {
        fecha_creacion = LocalDateTime.now();
        fecha_actualizacion = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        fecha_actualizacion = LocalDateTime.now();
    }
}
