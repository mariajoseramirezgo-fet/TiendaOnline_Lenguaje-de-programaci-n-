package com.equipo.jpa_relaciones_tiendaonline.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productos")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String nombre;

    @Column(nullable=false)
    private BigDecimal precio;

    @Column(nullable=false)
    private Integer stock;

    @ManyToMany
    @JoinTable(name="producto_categoria",
            joinColumns = @JoinColumn(name="producto_id"),
            inverseJoinColumns = @JoinColumn(name="categoria_id"))
    private Set<Categoria> categorias = new HashSet<>();

    public void addCategoria(Categoria c){
        categorias.add(c);
        c.getProductos().add(this);
    }

    public void removeCategoria(Categoria c){
        categorias.remove(c);
        c.getProductos().remove(this);
    }

    public BigDecimal setPrecio() {
        return precio;
    }
}