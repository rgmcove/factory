package model.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ProductoViews  {
    @NotNull(message = "La descripcion no puede ser nula")
    @Size(max = 50, message = "La descripcion no puede tener mas de 50 caracteres")
    private String descripcion;
    @NotNull(message = "El valor unidad es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorUnidad;
    @NotNull(message = "El estado es obligatorio")
    private Integer estado;
}
