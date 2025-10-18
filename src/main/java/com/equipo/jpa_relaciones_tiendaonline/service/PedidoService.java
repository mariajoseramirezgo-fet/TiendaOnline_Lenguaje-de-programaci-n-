package com.equipo.jpa_relaciones_tiendaonline.service;

import com.equipo.jpa_relaciones_tiendaonline.entity.Pedido;
import com.equipo.jpa_relaciones_tiendaonline.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepo;

    public List<Pedido> listarPedidos() {
        return pedidoRepo.findAll();
    }

    public Pedido obtenerPorId(Long id) {
        return pedidoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepo.save(pedido);
    }

    public Pedido actualizarPedido(Long id, Pedido pedidoActualizado) {
        Pedido pedido = pedidoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        pedido.setFecha(pedidoActualizado.getFecha());
        pedido.setEstado(pedidoActualizado.getEstado());
        pedido.setTotal(pedidoActualizado.getTotal());
        return pedidoRepo.save(pedido);
    }

    public void eliminarPedido(Long id) {
        pedidoRepo.deleteById(id);
    }
}
