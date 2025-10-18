package com.equipo.jpa_relaciones_tiendaonline.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDTO {
    private Long id;
    private String calle;
    private String ciudad;
    private String pais;
    private String zip;
}
