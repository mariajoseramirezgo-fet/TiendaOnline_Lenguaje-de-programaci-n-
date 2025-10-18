package com.equipo.jpa_relaciones_tiendaonline.dto;

import lombok.*;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private Long clienteId;
    private String estado;
    private List<ItemPedidoDTO> items;
}
