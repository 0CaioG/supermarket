package com.example.supermarket.supermarket.dto;

import java.time.LocalDate;

public class PrecoDTO {

    private Long id;
    private Long produto_id;
    private Long supermercado_id;
    private Double valor;
    private LocalDate inicio_vigencia;
    private LocalDate fim_vigencia;

    public PrecoDTO(Long id, Long produto_id, Long supermercado_id, Double valor, LocalDate inicio_vigencia, LocalDate fim_vigencia) {
        this.id = id;
        this.produto_id = produto_id;
        this.supermercado_id = supermercado_id;
        this.valor = valor;
        this.inicio_vigencia = inicio_vigencia;
        this.fim_vigencia = fim_vigencia;
    }

    public PrecoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(Long produto_id) {
        this.produto_id = produto_id;
    }

    public Long getSupermercado_id() {
        return supermercado_id;
    }

    public void setSupermercado_id(Long supermercado_id) {
        this.supermercado_id = supermercado_id;
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
