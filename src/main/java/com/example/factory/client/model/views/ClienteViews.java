package com.example.factory.client.model.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@Setter
public class ClienteViews {

    @NotNull(message = "El primer nombre es obligatorio")
    @Size(max = 45, message = "El primer nombre no puede tener más de 45 caracteres")
    private String primerNombre;
    private String segundoNombre;
    @NotNull(message = "El primer apellido es obligatorio")
    @Size(max = 45, message = "El primer apellido no puede tener más de 45 caracteres")
    private String primerApellido;
    private String segundoApellido;
    @NotNull(message = "El tipo de documento es obligatorio")
    private Integer tipoDocumento;
    @NotNull(message = "El número de documento es obligatorio")
    @Size(max = 18, message = "El número de documento no puede tener más de 18 caracteres")
    @Pattern(regexp = "^[0-9]*$", message = "El número de documento debe ser numérico")
    private String numeroDocumento;
    @Size(max = 45, message = "La direccion no puede tener más de 45 caracteres")
    private String direccion;
}
