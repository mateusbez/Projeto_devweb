package com.example.demo.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Estoque;
import com.example.demo.entities.Reposicao;
import com.example.demo.entities.Cliente;
import com.example.demo.repositories.EstoqueRepository;
import com.example.demo.repositories.FornecedorRepository;
import com.example.demo.repositories.ReposicaoRepository;

@Service
public class EstoqueService {
   
    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private ReposicaoRepository reposicaoRepository;

    public Estoque getEstoque(String idEstoque) {
        Optional<Estoque> estoque = estoqueRepository.findById(idEstoque);
        return estoque.get();
    }

    public Estoque salvar(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public Estoque atualizar(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public void remover(String idEstoque) {
        estoqueRepository.deleteById(idEstoque);
    }

    public void verificarEAtualizarEstoque(Estoque estoque) {
       if (estoque.getQtd_atual() < estoque.getQtd_minima()) {
            Reposicao reposicao = new Reposicao();
            reposicao.setEstoque(estoque);
            reposicao.setFornecedor(fornecedor);
            reposicao.setQuantidade(estoque.getQtd_minima() - estoque.getQtd_atual());

            estoque.getReposicao().add(reposicao);
            estoqueRepository.save(estoque);
        }
    }
    public void calcularQuantidadeMinimaPorCliente(Cliente cliente) {
        List<Estoque> estoque = estoqueRepository.findByCliente(cliente);

        int quantidadeMinimaTotal = 0;

        for (Estoque estoque : estoques) {
        quantidadeMinimaTotal += estoque.getQtd_minima();
        }

        reposicaoService.verificarEAtualizarEstoque(cliente, quantidadeMinimaTotal);
    }

}
