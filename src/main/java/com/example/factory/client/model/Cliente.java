package com.example.factory.client.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    private Long id;

    @Column(name = "primer_nombre", nullable = false, length = 45)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 45)
    private String segundoNombre;

    @Column(name = "primer_apellido", nullable = false, length = 45)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 45)
    private String segundoApellido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "fk_tipo_documento", nullable = false)
    private TipoDocumento tipoDocumento;

    @Column(name = "numero_documento", nullable = false, length = 18)
    private String numeroDocumento;

    @Column(name = "direccion", length = 45)
    private String direccion;
}