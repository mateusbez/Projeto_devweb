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

import com.example.demo.entities.Reposicao;
import com.example.demo.services.ReposicaoService;

@RestController
@RequestMapping("/reposicao")
public class ReposicaoController {
    
    @Autowired
    ReposicaoService reposicaoService;
    
    @GetMapping("/{idReposicao}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_GESTOR", })
    public Reposicao getReposicao(@PathVariable String idReposicao) {
        Reposicao reposicao = reposicaoService.getReposicao(idReposicao);
        return reposicao;
    }

    @PostMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void cadastrarReposicao(@RequestBody Reposicao reposicao) {
        reposicaoService.salvar(resposicao);
    }

    @PutMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void atualizarReposicao(@RequestBody Reposicao reposicao) {
        reposicaoService.atualizar(reposicao);
    }

    @DeleteMapping("/{idReposicao}")
    @Secured(value = { "ROLE_ADMIN" })
    public void removerReposicao(@PathVariable String idReposicao) {
        reposicaoService.remover(idReposicao);
    }
}
