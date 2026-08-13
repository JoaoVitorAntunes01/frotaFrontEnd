package com.frontprojetofinal.frontprojetofinal.model;

public class MotoristaDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private UsuarioDTO id_usuario;

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

    public UsuarioDTO getId_usuario() { return id_usuario; }
    public void setId_usuario(UsuarioDTO id_usuario) { this.id_usuario = id_usuario; }
}
