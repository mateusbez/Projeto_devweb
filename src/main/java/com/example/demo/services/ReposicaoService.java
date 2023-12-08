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

    public void criarReposicao(String idEstoque, String idFornecedor, int quantidadePedido) {
        Estoque estoque = estoqueRepository.findById(idEstoque).orElse(null);
        Fornecedor fornecedor = fornecedorRepository.findById(idFornecedor).orElse(null);

        if (estoque != null && fornecedor != null) {
            Reposicao reposicao = new Reposicao();
            reposicao.setEstoque(estoque);
            reposicao.setFornecedor(fornecedorNome);
            reposicao.setQuantidade(quantidade);

            // Adicione o novo pedido de reposição à lista de reposições no estoque.
            estoque.getReposicao().add(reposicao);

            // Salve as alterações no banco de dados.
            estoqueRepository.save(estoque);
            reposicaoRepository.save(reposicao);
        }
    }
    
}
