package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Reposicao;

public interface ReposicaoRepository extends JpaRepository<Reposicao, String> {
    
}
