package com.equipo.jpa_relaciones_tiendaonline.dto;

import lombok.*;
import java.math.BigDecimal;
import java.util.Set;

@Data @NoArgsConstructor @AllArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Integer stock;
    private Set<CategoriaDTO> categorias;
}
