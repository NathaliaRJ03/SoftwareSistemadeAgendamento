/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newdesign.gestaovenda.modelo.dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author vinic
 */
public class Venda {
    
    private Long id;
    private Cliente cliente;
    private Usuario usuario;
    private BigDecimal totalDaVenda;
    private BigDecimal valoPago;
    private BigDecimal desconto;
    private BigDecimal troco;
    private LocalDateTime dataHoraCriaca;
    private LocalDateTime ultimaActualizacao;

    public Venda() {
    }

    public Venda(Long id, Cliente cliente, Usuario usuario, BigDecimal totalDaVenda, BigDecimal valoPago, BigDecimal desconto, BigDecimal troco, LocalDateTime dataHoraCriaca, LocalDateTime ultimaActualizacao) {
        this.id = id;
        this.cliente = cliente;
        this.usuario = usuario;
        this.totalDaVenda = totalDaVenda;
        this.valoPago = valoPago;
        this.desconto = desconto;
        this.troco = troco;
        this.dataHoraCriaca = dataHoraCriaca;
        this.ultimaActualizacao = ultimaActualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BigDecimal getTotalDaVenda() {
        return totalDaVenda;
    }

    public void setTotalDaVenda(BigDecimal totalDaVenda) {
        this.totalDaVenda = totalDaVenda;
    }

    public BigDecimal getValoPago() {
        return valoPago;
    }

    public void setValoPago(BigDecimal valoPago) {
        this.valoPago = valoPago;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getTroco() {
        return troco;
    }

    public void setTroco(BigDecimal troco) {
        this.troco = troco;
    }

    public LocalDateTime getDataHoraCriaca() {
        return dataHoraCriaca;
    }

    public void setDataHoraCriaca(LocalDateTime dataHoraCriaca) {
        this.dataHoraCriaca = dataHoraCriaca;
    }

    public LocalDateTime getUltimaActualizacao() {
        return ultimaActualizacao;
    }

    public void setUltimaActualizacao(LocalDateTime ultimaActualizacao) {
        this.ultimaActualizacao = ultimaActualizacao;
    }
    
    
}
