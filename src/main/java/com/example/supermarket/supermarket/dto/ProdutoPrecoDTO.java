package com.example.supermarket.supermarket.dto;

import java.time.LocalDateTime;

public class ProdutoPrecoDTO {
    private Long produto_id;
    private String nome_produto;
    private Double preco_valor;
    private LocalDateTime inicio_vigencia;
    private LocalDateTime fim_vigencia;

    public ProdutoPrecoDTO(Long produto_id,String nome_produto, Double preco_valor, LocalDateTime inicio_vigencia, LocalDateTime fim_vigencia) {
        this.produto_id = produto_id;
        this.nome_produto = nome_produto;
        this.preco_valor = preco_valor;
        this.inicio_vigencia = inicio_vigencia;
        this.fim_vigencia = fim_vigencia;
    }

    public ProdutoPrecoDTO() {
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Double getPreco_valor() {
        return preco_valor;
    }

    public void setPreco_valor(Double preco_valor) {
        this.preco_valor = preco_valor;
    }

    public LocalDateTime getInicio_vigencia() {
        return inicio_vigencia;
    }

    public void setInicio_vigencia(LocalDateTime inicio_vigencia) {
        this.inicio_vigencia = inicio_vigencia;
    }

    public LocalDateTime getFim_vigencia() {
        return fim_vigencia;
    }

    public void setFim_vigencia(LocalDateTime fim_vigencia) {
        this.fim_vigencia = fim_vigencia;
    }
}
