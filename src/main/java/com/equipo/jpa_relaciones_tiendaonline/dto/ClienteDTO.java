package com.equipo.jpa_relaciones_tiendaonline.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String email;
    private DireccionDTO direccion;
}
