package com.equipo.jpa_relaciones_tiendaonline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fecha;

    @Column(nullable=false)
    private String estado; // NUEVO, PAGADO, ENVIADO, CANCELADO...

    @Column(nullable=false)
    private BigDecimal total;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id", nullable=false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TiemPedido> items = new ArrayList<>();

    public void addItem(TiemPedido it){
        items.add(it);
        it.setPedido(this);
    }
    public void removeItem(TiemPedido it){
        items.remove(it);
        it.setPedido(null);
    }
}