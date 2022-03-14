package com.example.factory.product.model.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private Long id;
    private String descripcion;
    private BigDecimal valorUnidad;
    private EstadoDTO estado;
}
