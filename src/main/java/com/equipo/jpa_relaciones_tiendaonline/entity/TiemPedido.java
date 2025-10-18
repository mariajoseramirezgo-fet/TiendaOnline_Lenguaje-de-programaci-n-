package com.equipo.jpa_relaciones_tiendaonline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "items_pedido",
        uniqueConstraints = @UniqueConstraint(name = "uk_pedido_producto", columnNames = {"pedido_id","producto_id"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class TiemPedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pedido_id", nullable=false)
    private Pedido pedido;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="producto_id", nullable=false)
    private Producto producto;

    @Column(nullable=false)
    private Integer cantidad;

    @Column(nullable=false)
    private BigDecimal precioUnitario;
}
