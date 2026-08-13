package com.frontprojetofinal.frontprojetofinal.model;

public class MotoristaDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private Long id_empresa;

    public MotoristaDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public Long getId_empresa() { return id_empresa; }
    public void setId_empresa(Long id_empresa) { this.id_empresa = id_empresa; }
}
