package com.equipo.jpa_relaciones_tiendaonline.dto;

import lombok.*;
import java.math.BigDecimal;

@Data @NoArgsConstructor @AllArgsConstructor
public class ItemPedidoDTO {
    private Long productoId;
    private Integer cantidad;
    private BigDecimal precioUnitario;
}
