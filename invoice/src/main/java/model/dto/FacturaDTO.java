package model.dto;

import lombok.Data;
import model.Producto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Data
public class FacturaDTO {
    private Long id;
    private String cajero;
    private String caja;
    private ClienteDTO cliente;
    private Integer cantidad;
    private BigDecimal valorTotal;
    private Set<Producto> productos;
}
