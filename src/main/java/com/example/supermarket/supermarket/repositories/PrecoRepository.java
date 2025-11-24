package com.example.supermarket.supermarket.repositories;

import com.example.supermarket.supermarket.entities.Preco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long> {
    List<Preco> findPrecoByProduto_id(Long id);
    List<Preco> findPrecoBySupermercado_id(Long id);
}
