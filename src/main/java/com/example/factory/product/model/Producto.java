package com.example.factory.product.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Table(name = "producto")
@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Long id;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "valor_unidad", nullable = false, precision = 10)
    private BigDecimal valorUnidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_estado", nullable = false)
    private Estado estado;

}