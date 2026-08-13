/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frontprojetofinal.frontprojetofinal.model;

public class VeiculoDTO {
    
    private Long id;
    private String placa;
    private String ano;
    private String modelo;
    private String disponibilidade;
    private String quilometragem;
    private String chassi;
    private Long id_empresa;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Long id, String placa, String ano, String modelo, String disponibilidade, String quilometragem, String chassi, Long id_empresa) {
        this.id = id;
        this.placa = placa;
        this.ano = ano;
        this.modelo = modelo;
        this.disponibilidade = disponibilidade;
        this.quilometragem = quilometragem;
        this.chassi = chassi;
        this.id_empresa = id_empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(String quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Long id_empresa) {
        this.id_empresa = id_empresa;
    }

}
