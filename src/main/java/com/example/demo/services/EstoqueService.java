package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Estoque;
import com.example.demo.repositories.EstoqueRepository;

@Service
public class EstoqueService {
   
    @Autowired
    private EstoqueRepository estoqueRepository;

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
       if (estoque.getQuantidadeAtual() < estoque.getQuantidadeMinima()) {
            // A quantidade está abaixo do mínimo, crie um novo pedido de reposição.
            Reposicao reposicao = new Reposicao();
            reposicao.setEstoque(estoque);
            // Defina o fornecedor adequado e outros detalhes do pedido.
            reposicao.setFornecedor(fornecedor);
            reposicao.setQuantidadePedido(estoque.getQuantidadeMinima() - estoque.getQuantidadeAtual());
            reposicao.setDataPedido(new Date());

            // Adicione o novo pedido de reposição à lista de reposições no estoque.
            estoque.getReposicao().add(reposicao);

            // Salve as alterações no banco de dados.
            estoqueRepository.save(estoque);
        }
    }// Método para somar a quantidade de itens solicitados por cada cliente
    public void calcularQuantidadeMinimaPorCliente(Clientes cliente) {
        List<Estoque> estoques = estoqueRepository.findByCliente(cliente);

    int quantidadeMinimaTotal = 0;

    for (Estoque estoque : estoques) {
        quantidadeMinimaTotal += estoque.getQuantidadeMinima();
    }

    // Agora você pode criar um pedido de reposição se necessário
    reposicaoService.verificarEAtualizarEstoque(cliente, quantidadeMinimaTotal);
}

}
