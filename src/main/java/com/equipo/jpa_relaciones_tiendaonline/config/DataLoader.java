package com.equipo.jpa_relaciones_tiendaonline.config;

import com.equipo.jpa_relaciones_tiendaonline.entity.*;
import com.equipo.jpa_relaciones_tiendaonline.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    private final ProductoRepository productoRepo;
    private final CategoriaRepository categoriaRepo;
    private final ClienteRepository clienteRepo;

    public DataLoader(ProductoRepository productoRepo, CategoriaRepository categoriaRepo, ClienteRepository clienteRepo){
        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
        this.clienteRepo = clienteRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria backend = new Categoria(); backend.setNombre("Backend");
        Categoria frontend = new Categoria(); frontend.setNombre("Frontend");
        categoriaRepo.save(backend); categoriaRepo.save(frontend);

        Producto p1 = new Producto();
        p1.setNombre("Curso Java");
        p1.setPrecio(BigDecimal.valueOf(49.99));
        p1.setStock(10);
        p1.getCategorias().add(backend);
        Producto p2 = new Producto();
        p2.setNombre("Curso JavaScript");
        p2.setPrecio(BigDecimal.valueOf(39.99));
        p2.setStock(20);
        p2.getCategorias().add(frontend);

        productoRepo.save(p1);
        productoRepo.save(p2);

        Cliente c = new Cliente();
        c.setNombre("María");
        c.setEmail("maria@example.com");
        Direccion d = new Direccion();
        d.setCalle("Calle 1");
        d.setCiudad("Bogotá"); d.setPais("Colombia"); d.setZip("110111");
        c.setDireccion(d);
        clienteRepo.save(c);
    }
}
