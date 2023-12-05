package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Cliente;
import com.example.demo.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/{idCliente}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_GESTOR", })
    public Cliente getCliente(@PathVariable String idCliente) {
        Cliente cliente = clienteService.getCliente(idCliente);
        return cliente;
    }

    @PostMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void cadastrarCliente(@RequestBody Cliente cliente) {
        clienteService.salvar(cliente);
    }

    @PutMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void atualizarCliente(@RequestBody Cliente cliente) {
        clienteService.atualizar(cliente);
    }

    @DeleteMapping("/{idCliente}")
    @Secured(value = { "ROLE_ADMIN" })
    public void removerCliente(@PathVariable String idCliente) {
        clienteService.remover(idCliente);
    }
    
}
