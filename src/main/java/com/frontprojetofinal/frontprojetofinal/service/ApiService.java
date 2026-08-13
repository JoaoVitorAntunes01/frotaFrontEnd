package com.frontprojetofinal.frontprojetofinal.service;

import com.frontprojetofinal.frontprojetofinal.model.MotoristaDTO;
import com.frontprojetofinal.frontprojetofinal.model.UsuarioDTO;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ApiService {

    private final RestClient restClient = RestClient.builder()
            .baseUrl("http://localhost:9000/")
            .build();

    public String registrar(UsuarioDTO userRequest) {
        return restClient.post()
                .uri("api/cadastrar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(userRequest)
                .retrieve()
                .body(String.class);
    }

    public String logar(UsuarioDTO user) {
        return restClient.post()
                .uri("api/logar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(user)
                .retrieve()
                .body(String.class);
    }

    public List<MotoristaDTO> listarMotoristas() {
        MotoristaDTO[] motoristas = restClient.get()
                .uri("api/motoristas")
                .retrieve()
                .body(MotoristaDTO[].class);
        return Arrays.asList(motoristas != null ? motoristas : new MotoristaDTO[0]);
    }

    public MotoristaDTO cadastrarMotorista(MotoristaDTO motorista) {
        return restClient.post()
                .uri("api/motoristas")
                .contentType(MediaType.APPLICATION_JSON)
                .body(motorista)
                .retrieve()
                .body(MotoristaDTO.class);
    }
}