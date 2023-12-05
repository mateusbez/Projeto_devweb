package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Reposicao;
import com.example.demo.repositories.ReposicaoRepository;

@Service
public class ReposicaoService {
    @Autowired
    private ReposicaoRepository reposicaoRepository;

    public Reposicao getReposicao(String idReposicao) {
        Optional<Reposicao> reposicao = reposicaoRepository.findById(idReposicao);
        return reposicao.get();
    }

    public Reposicao salvar(Reposicao reposicao) {
        return reposicaoRepository.save(reposicao);
    }

    public Reposicao atualizar(Reposicao reposicao) {
        return reposicaoRepository.save(reposicao);
    }

    public void remover(String idReposicao) {
        reposicaoRepository.deleteById(idReposicao);
    }
    
}
