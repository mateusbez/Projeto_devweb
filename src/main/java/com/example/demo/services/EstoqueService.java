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

     // Método para verificar a quantidade mínima no estoque e criar um pedido de reposição.
    public void verificarEAtualizarEstoque(Estoque estoque) {
       if (estoque.getQtd_atual() < estoque.getQtd_minima()) {
            // A quantidade está abaixo do mínimo, crie um novo pedido de reposição.
            Reposicao reposicao = new Reposicao();
            reposicao.setEstoque(estoque);
            // Defina o fornecedor adequado e outros detalhes do pedido.
            reposicao.setFornecedor(fornecedor);
            reposicao.setQuantidade(estoque.getQtd_minima() - estoque.getQtd_atual());

            // Adicione o novo pedido de reposição à lista de reposições no estoque.
            estoque.getReposicao().add(reposicao);

            // Salve as alterações no banco de dados.
            estoqueRepository.save(estoque);
        }
    }// Método para somar a quantidade de itens solicitados por cada cliente
    public void calcularQuantidadeMinimaPorCliente(Cliente cliente) {
        List<Estoque> estoque = estoqueRepository.findByCliente(cliente);

        int quantidadeMinimaTotal = 0;

        for (Estoque estoque : estoques) {
        quantidadeMinimaTotal += estoque.getQtd_minima();
        }

    // Agora você pode criar um pedido de reposição se necessário
        reposicaoService.verificarEAtualizarEstoque(cliente, quantidadeMinimaTotal);
    }

}
