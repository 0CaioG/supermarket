package com.example.supermarket.supermarket.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Long codigo_barras;
    private String categoria;
    private LocalDate data_criacao;

    public Produto(Long id, String nome, Long codigo_barras, String categoria, LocalDate data_criacao) {
        this.id = id;
        this.nome = nome;
        this.codigo_barras = codigo_barras;
        this.categoria = categoria;
        this.data_criacao = data_criacao;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCodigo_barras() {
        return codigo_barras;
    }

    public void setCodigo_barras(Long codigo_barras) {
        this.codigo_barras = codigo_barras;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }
}
