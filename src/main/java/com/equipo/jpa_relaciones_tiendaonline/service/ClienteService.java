package com.equipo.jpa_relaciones_tiendaonline.service;

import com.equipo.jpa_relaciones_tiendaonline.entity.Cliente;
import com.equipo.jpa_relaciones_tiendaonline.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepo;

    public List<Cliente> listarClientes() {
        return clienteRepo.findAll();
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepo.findById(id);
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente clienteActualizado) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setEmail(clienteActualizado.getEmail());
        return clienteRepo.save(cliente);
    }

    public void eliminarCliente(Long id) {
        clienteRepo.deleteById(id);
    }
}
