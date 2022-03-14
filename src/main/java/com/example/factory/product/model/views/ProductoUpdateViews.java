package com.example.factory.product.model.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ProductoUpdateViews {

    @NotNull(message = "El valor unidad es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorUnidad;
}
