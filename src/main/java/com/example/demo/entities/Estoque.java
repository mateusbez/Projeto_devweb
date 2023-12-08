package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.util.List;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(nullable = false)
    private String nome;
    private String qtd_minima;

    @ManyToOne
    @JoinColumn(name = "id_colaborador")
    private Colaborador Colaborador;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "estoque")
    private List<Reposicao> reposicao;
    
}
