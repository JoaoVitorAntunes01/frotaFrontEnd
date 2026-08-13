/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frontprojetofinal.frontprojetofinal.model;

import java.security.Timestamp;

public class RotasDTO {
    
    private Long id;
    private String cep_saida;
    private String cep_destino;
    private String distancia;
    private String tempo_estimado;
    private Timestamp hora_saida;
    private Timestamp hora_chegada;
    private String observacao;
    private Long id_veiculo;
    private Long id_motorista;

    public RotasDTO() {
    }

    public RotasDTO(Long id, String cep_saida, String cep_destino, String distancia, String tempo_estimado, Timestamp hora_saida, Timestamp hora_chegada, String observacao, Long id_veiculo, Long id_motorista) {
        this.id = id;
        this.cep_saida = cep_saida;
        this.cep_destino = cep_destino;
        this.distancia = distancia;
        this.tempo_estimado = tempo_estimado;
        this.hora_saida = hora_saida;
        this.hora_chegada = hora_chegada;
        this.observacao = observacao;
        this.id_veiculo = id_veiculo;
        this.id_motorista = id_motorista;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep_saida() {
        return cep_saida;
    }

    public void setCep_saida(String cep_saida) {
        this.cep_saida = cep_saida;
    }

    public String getCep_destino() {
        return cep_destino;
    }

    public void setCep_destino(String cep_destino) {
        this.cep_destino = cep_destino;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getTempo_estimado() {
        return tempo_estimado;
    }

    public void setTempo_estimado(String tempo_estimado) {
        this.tempo_estimado = tempo_estimado;
    }

    public Timestamp getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(Timestamp hora_saida) {
        this.hora_saida = hora_saida;
    }

    public Timestamp getHora_chegada() {
        return hora_chegada;
    }

    public void setHora_chegada(Timestamp hora_chegada) {
        this.hora_chegada = hora_chegada;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public Long getId_motorista() {
        return id_motorista;
    }

    public void setId_motorista(Long id_motorista) {
        this.id_motorista = id_motorista;
    }
    
}
