package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Estoque;
import com.example.demo.entities.Cliente;

public interface EstoqueRepository extends JpaRepository<Estoque, String> {
    List<Estoque> findByCliente(Cliente cliente);
}
