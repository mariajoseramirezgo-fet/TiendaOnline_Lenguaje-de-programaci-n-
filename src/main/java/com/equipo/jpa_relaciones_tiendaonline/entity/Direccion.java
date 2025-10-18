package com.equipo.jpa_relaciones_tiendaonline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(name = "direcciones")
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    public class Direccion {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String calle;
        private String ciudad;
        private String pais;
        private String zip;

        @OneToOne
        @JoinColumn(name = "cliente_id", unique = true)
        private Cliente cliente;

        public void setCliente(Cliente c){ this.cliente = c; }
    }

