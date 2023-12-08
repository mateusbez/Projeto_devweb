package com.example.demo.controller;

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

import com.example.demo.entities.Estoque;
import com.example.demo.services.EstoqueService;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    
    @Autowired
    EstoqueService estoqueService;
    
    @GetMapping("/{idEstoque}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_GESTOR", })
    public Estoque getEstoque(@PathVariable String idEstoque) {
        Estoque estoque = estoqueService.getEstoque(idEstoque);
        return estoque;
    }

    @PostMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void cadastrarEstoque(@RequestBody Estoque estoque) {
        estoqueService.salvar(estoque);
    }

    @PutMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void atualizarEstoque(@RequestBody Estoque Estoque) {
        estoqueService.atualizar(estoque);
    }

    @DeleteMapping("/{idEstoque}")
    @Secured(value = { "ROLE_ADMIN" })
    public void removerEstoque(@PathVariable String idEstoque) {
        estoqueService.remover(idEstoque);
    }
}
