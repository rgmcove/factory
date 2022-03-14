package model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoDTO  {
    private Integer id;
    private String descripcion;
}
