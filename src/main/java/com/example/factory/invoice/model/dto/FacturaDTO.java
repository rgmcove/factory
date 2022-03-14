package com.example.factory.invoice.model.dto;

import com.example.factory.client.model.dto.ClienteDTO;
import com.example.factory.product.model.Producto;
import lombok.Data;

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
