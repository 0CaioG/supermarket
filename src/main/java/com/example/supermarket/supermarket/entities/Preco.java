package com.example.supermarket.supermarket.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "supermercado_id", referencedColumnName = "id")
    private Supermercado supermercado;

    private Double valor;
    private LocalDate inicio_vigencia;
    private LocalDate fim_vigencia;

    public Preco(Long id, Produto produto, Supermercado supermercado, Double valor, LocalDate inicio_vigencia, LocalDate fim_vigencia) {
        this.id = id;
        this.supermercado = supermercado;
        this.produto = produto;
        this.valor = valor;
        this.inicio_vigencia = inicio_vigencia;
        this.fim_vigencia = fim_vigencia;
    }

    public Preco() {
    }

    public Supermercado getSupermercado() {
        return supermercado;
    }

    public void setSupermercado(Supermercado supermercado) {
        this.supermercado = supermercado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getInicio_vigencia() {
        return inicio_vigencia;
    }

    public void setInicio_vigencia(LocalDate inicio_vigencia) {
        this.inicio_vigencia = inicio_vigencia;
    }

    public LocalDate getFim_vigencia() {
        return fim_vigencia;
    }

    public void setFim_vigencia(LocalDate fim_vigencia) {
        this.fim_vigencia = fim_vigencia;
    }
}
