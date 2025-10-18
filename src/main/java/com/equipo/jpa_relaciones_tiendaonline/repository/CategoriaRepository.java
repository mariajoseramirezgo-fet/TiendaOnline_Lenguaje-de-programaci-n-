package com.equipo.jpa_relaciones_tiendaonline.repository;

import com.equipo.jpa_relaciones_tiendaonline.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNombre(String nombre);
}
