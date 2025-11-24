package com.example.supermarket.supermarket.repositories;

import com.example.supermarket.supermarket.entities.Supermercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupermercadoRepository extends JpaRepository<Supermercado, Long> {
}
