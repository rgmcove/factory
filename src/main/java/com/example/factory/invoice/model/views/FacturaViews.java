package com.example.factory.invoice.model.views;

import com.example.factory.product.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class FacturaViews {

    @NotNull(message = "El campo cajero no puede estar vacio")
    @Size(max = 100, message = "El número de factura debe tener como máximo 100 caracteres")
    private String cajero;
    @Size(max = 15, message = "El número de factura debe tener como máximo 15 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "El número de factura debe ser numérico")
    @NotNull(message = "El campo número de caja no puede estar vacio")
    private String caja;
    @Pattern(regexp = "^[0-9]*$", message = "El cliente debe contener solo números")
    @NotNull(message = "El campo cliente no puede estar vacio")
    private Long cliente;
    @Pattern(regexp = "^[0-9]*$", message = "El campo cantidad debe contener solo números")
    @NotNull(message = "El campo cantidad no puede estar vacio")
    private Integer cantidad;
    @Pattern(regexp = "^[0-9]*$", message = "El valor debe contener solo números")
    @NotNull(message = "El campo valor no puede estar vacio")
    private BigDecimal valorTotal;
    private Set<Producto> productos;
}
