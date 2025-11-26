package com.example.supermarket.supermarket.dto;

public class MercadoDadosDTO {
    private Long mercado_id;
    private String mercado_nome;
    private Long produtos_vigentes;

    public MercadoDadosDTO(Long mercado_id, String mercado_nome, Long produtos_vigentes) {
        this.mercado_id = mercado_id;
        this.mercado_nome = mercado_nome;
        this.produtos_vigentes = produtos_vigentes;
    }

    public MercadoDadosDTO() {
    }

    public Long getMercado_id() {
        return mercado_id;
    }

    public void setMercado_id(Long mercado_id) {
        this.mercado_id = mercado_id;
    }

    public String getMercado_nome() {
        return mercado_nome;
    }

    public void setMercado_nome(String mercado_nome) {
        this.mercado_nome = mercado_nome;
    }

    public Long getProdutos_vigentes() {
        return produtos_vigentes;
    }

    public void setProdutos_vigentes(Long produtos_vigentes) {
        this.produtos_vigentes = produtos_vigentes;
    }
}
