package com.equipo.jpa_relaciones_tiendaonline.service;

import com.equipo.jpa_relaciones_tiendaonline.entity.Categoria;
import com.equipo.jpa_relaciones_tiendaonline.entity.Producto;
import com.equipo.jpa_relaciones_tiendaonline.repository.CategoriaRepository;
import com.equipo.jpa_relaciones_tiendaonline.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepo;

    @Autowired
    private CategoriaRepository categoriaRepo;

    //  Listar todos los productos
    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }

    //  Obtener producto por ID
    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepo.findById(id);
    }

    //  Crear producto
    public Producto crearProducto(Producto producto) {
        return productoRepo.save(producto);
    }

    //  Actualizar producto existente
    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Producto producto = productoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.setPrecio());
        producto.setPrecio(productoActualizado.getPrecio());

        return productoRepo.save(producto);
    }

    //  Eliminar producto
    public void eliminarProducto(Long id) {
        productoRepo.deleteById(id);
    }

    //  Asignar categorías a un producto
    public Producto asignarCategorias(Long productoId, Set<String> nombresCategorias) {
        Producto producto = productoRepo.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Set<Categoria> categorias = new HashSet<>();

        for (String nombre : nombresCategorias) {
            Categoria categoria = categoriaRepo.findByNombre(nombre).orElse(null);

            if (categoria == null) {
                categoria = new Categoria();
                categoria.setNombre(nombre);
                categoriaRepo.save(categoria);
            }

            categorias.add(categoria);
        }

        producto.setCategorias(categorias);
        return productoRepo.save(producto);
    }
}
