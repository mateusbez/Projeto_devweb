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

import com.example.demo.entities.Fornecedor;
import com.example.demo.services.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {
    
    @Autowired
    FornecedorService fornecedorService;
    
    @GetMapping("/{idFornecedor}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_GESTOR", })
    public Fornecedor getFornecedor(@PathVariable String idFornecedor) {
        Fornecedor fornecedor = fornecedorService.getFornecedor(idFornecedor);
        return fornecedor;
    }

    @PostMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void cadastrarFornecedor(@RequestBody Fornecedor fornecedor) {
        fornecedorService.salvar(fornecedor);
    }

    @PutMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void atualizarFornecedor(@RequestBody Fornecedor fornecedor) {
        fornecedorService.atualizar(fornecedor);
    }

    @DeleteMapping("/{idFornecedor}")
    @Secured(value = { "ROLE_ADMIN" })
    public void removerFornecedor(@PathVariable String idFornecedor) {
        fornecedorService.remover(idFornecedor);
    }
}
