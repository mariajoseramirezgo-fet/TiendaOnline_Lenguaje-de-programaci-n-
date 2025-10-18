package com.equipo.jpa_relaciones_tiendaonline.controller;

import com.equipo.jpa_relaciones_tiendaonline.entity.Producto;
import com.equipo.jpa_relaciones_tiendaonline.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    //  Listar todos los productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    //  Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
        return productoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //  Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevo = productoService.crearProducto(producto);
        return ResponseEntity.ok(nuevo);
    }

    //  Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto productoActualizado) {

        Producto actualizado = productoService.actualizarProducto(id, productoActualizado);
        return ResponseEntity.ok(actualizado);
    }

    //  Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

    //  Asignar categorías a un producto existente
    @PostMapping("/{id}/categorias")
    public ResponseEntity<Producto> asignarCategorias(
            @PathVariable Long id,
            @RequestBody Set<String> nombresCategorias) {

        Producto actualizado = productoService.asignarCategorias(id, nombresCategorias);
        return ResponseEntity.ok(actualizado);
    }
}
