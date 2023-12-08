package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String CNPJ;

    @Column(nullable = false)
    private String nome;
    private String endereco;
    private String item;
    private String telefone; 

    @OneToMany(mappedBy = "fornecedor")
    private List<Reposicao> reposicoes;
}
