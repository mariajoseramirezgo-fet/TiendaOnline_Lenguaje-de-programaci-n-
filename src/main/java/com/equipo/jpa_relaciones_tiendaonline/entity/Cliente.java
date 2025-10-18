package com.equipo.jpa_relaciones_tiendaonline.entity;

    import jakarta.persistence .*;
    import lombok.*;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "clientes")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    public class Cliente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String nombre;

        @Column(nullable = false, unique = true)
        private String email;

        // Relación 1:1 con Direccion
        @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        private Direccion direccion;

        // Relación 1:N con Pedido
        @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        private List<Pedido> pedidos = new ArrayList<>();

        // Métodos auxiliares
        public void setDireccion(Direccion d) {
            this.direccion = d;
            if (d != null) d.setCliente(this);
        }

        public void addPedido(Pedido p) {
            pedidos.add(p);
            p.setCliente(this);
        }

        public void removePedido(Pedido p) {
            pedidos.remove(p);
            p.setCliente(null);
        }
    }
