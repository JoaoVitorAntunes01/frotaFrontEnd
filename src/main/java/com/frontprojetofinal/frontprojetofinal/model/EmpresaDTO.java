/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frontprojetofinal.frontprojetofinal.model;

public class EmpresaDTO {

    private Long id;
    private String cnpj;
    private String nome;
    private String cep;
    private Long id_usuario;

    public EmpresaDTO() {
    }

    public EmpresaDTO(Long id, String cnpj, String nome, String cep, Long id_usuario) {
        this.id = id;
        this.cnpj = cnpj;
        this.nome = nome;
        this.cep = cep;
        this.id_usuario = id_usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
