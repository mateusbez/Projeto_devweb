package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Cliente;
import com.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getCliente(String idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        return cliente.get();
    }

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void remover(String idCliente) {
        clienteRepository.deleteById(idCliente);
    }
    
}
