package com.frontprojetofinal.frontprojetofinal.model;

public class RotasDTO {

    private Long id;
    private String cep_saida;
    private String cep_destino;
    private String distancia;
    private String tempo_estimado;

    // Formato "yyyy-MM-ddTHH:mm" (igual ao enviado por <input type="datetime-local">)
    private String hora_saida;
    private String hora_chegada;

    private String observacao;
    private Long id_veiculo;
    private Long id_motorista;

    // Somente leitura, preenchidos pelo backend para exibição
    private String veiculo_placa;
    private String veiculo_modelo;
    private String motorista_nome;

    public RotasDTO() {
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

    public String getHora_saida() {
        return hora_saida;
    }

    public void setHora_saida(String hora_saida) {
        this.hora_saida = hora_saida;
    }

    public String getHora_chegada() {
        return hora_chegada;
    }

    public void setHora_chegada(String hora_chegada) {
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

    public String getVeiculo_placa() {
        return veiculo_placa;
    }

    public void setVeiculo_placa(String veiculo_placa) {
        this.veiculo_placa = veiculo_placa;
    }

    public String getVeiculo_modelo() {
        return veiculo_modelo;
    }

    public void setVeiculo_modelo(String veiculo_modelo) {
        this.veiculo_modelo = veiculo_modelo;
    }

    public String getMotorista_nome() {
        return motorista_nome;
    }

    public void setMotorista_nome(String motorista_nome) {
        this.motorista_nome = motorista_nome;
    }
}
