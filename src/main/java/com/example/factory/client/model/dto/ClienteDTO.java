package com.example.factory.client.model.dto;

import lombok.*;


import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private TipoDocumentoDTO tipoDocumento;
    private String numeroDocumento;
    private String direccion;
}
