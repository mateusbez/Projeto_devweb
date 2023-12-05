package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Fornecedor;
import com.example.demo.repositories.FornecedorRepository;

@Service
public class FornecedorService {
    
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor getFornecedor(String idFornecedor) {
        Optional<Fornecedor> fornecedor = fornecedorRepository.findById(idFornecedor);
        return fornecedor.get();
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor atualizar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void remover(String idFornecedor) {
        fornecedorRepository.deleteById(idFornecedor);
    }
}
