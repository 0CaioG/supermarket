package com.example.supermarket.supermarket.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Supermercado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private LocalDateTime data_criacao;

    public Supermercado(Long id, String nome, String cnpj, LocalDateTime data_criacao) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.data_criacao = data_criacao;
    }

    public Supermercado() {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDateTime getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }
}
