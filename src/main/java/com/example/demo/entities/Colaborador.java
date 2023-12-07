package com.example.demo.entities;

import com.example.demo.enums.Cargo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cpf;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false, updatable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
        @Column(nullable = false, updatable = false)
        private Cargo cargo;   
}
