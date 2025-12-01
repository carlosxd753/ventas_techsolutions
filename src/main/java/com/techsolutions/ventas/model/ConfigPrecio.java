package com.techsolutions.ventas.model;

import com.techsolutions.ventas.enums.TipoPrecio;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class ConfigPrecio extends BaseModel {
    @Enumerated(EnumType.STRING)
    private TipoPrecio estrategiaPrecio = TipoPrecio.ESTANDAR;

    private BigDecimal porcentajeDescuentoGlobal;
    private BigDecimal factorDinamicoGlobal;
}
