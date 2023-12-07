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

import com.example.demo.entities.Colaborador;
import com.example.demo.services.ColaboradorService;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    ColaboradorService colaboradorService;
    
    @GetMapping("/{idColaborador}")
    @Secured(value = { "ROLE_ADMIN", "ROLE_GESTOR", })
    public Colaborador getColaborador(@PathVariable String idColaborador) {
        Colaborador colaborador = colaboradorService.getColaborador(idColaborador);
        return colaborador;
    }

    @PostMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void cadastrarUsuario(@RequestBody Colaborador colaborador) {
        colaboradorService.salvar(colaborador);
    }

    @PutMapping
    @Secured(value = { "ROLE_ADMIN" })
    public void atualizarUsuario(@RequestBody Colaborador colaborador) {
        colaboradorService.atualizar(colaborador);
    }

    @DeleteMapping("/{idColaborador}")
    @Secured(value = { "ROLE_ADMIN" })
    public void removerUsuario(@PathVariable String idColaborador) {
        colaboradorService.remover(idColaborador);
    }
}