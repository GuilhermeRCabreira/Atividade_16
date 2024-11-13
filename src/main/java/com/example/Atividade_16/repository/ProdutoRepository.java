package com.example.Atividade_16.repository;

import com.example.Atividade_16.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
