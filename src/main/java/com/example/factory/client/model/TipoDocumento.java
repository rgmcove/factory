package com.example.factory.client.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tipo_documento")
@Data
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}