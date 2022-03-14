package model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoDTO {
    private Integer id;
    private String descripcion;
}
