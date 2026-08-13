package com.frontprojetofinal.frontprojetofinal.service;

import com.frontprojetofinal.frontprojetofinal.model.EmpresaDTO;
import com.frontprojetofinal.frontprojetofinal.model.LoginRequestDTO;
import com.frontprojetofinal.frontprojetofinal.model.LoginResponseDTO;
import com.frontprojetofinal.frontprojetofinal.model.MotoristaDTO;
import com.frontprojetofinal.frontprojetofinal.model.RotasDTO;
import com.frontprojetofinal.frontprojetofinal.model.VeiculoDTO;
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

    public EmpresaDTO registrarEmpresa(EmpresaDTO empresa) {
        return restClient.post()
                .uri("api/empresas")
                .contentType(MediaType.APPLICATION_JSON)
                .body(empresa)
                .retrieve()
                .body(EmpresaDTO.class);
    }

    public LoginResponseDTO login(LoginRequestDTO request) {
        return restClient.post()
                .uri("api/logar")
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(LoginResponseDTO.class);
    }

    public List<MotoristaDTO> listarMotoristasPorEmpresa(Long idEmpresa) {
        MotoristaDTO[] motoristas = restClient.get()
                .uri("api/motoristas?id_empresa={idEmpresa}", idEmpresa)
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

    public List<VeiculoDTO> listarVeiculosPorEmpresa(Long idEmpresa) {
        VeiculoDTO[] veiculos = restClient.get()
                .uri("api/veiculos?id_empresa={idEmpresa}", idEmpresa)
                .retrieve()
                .body(VeiculoDTO[].class);
        return Arrays.asList(veiculos != null ? veiculos : new VeiculoDTO[0]);
    }

    public VeiculoDTO cadastrarVeiculo(VeiculoDTO veiculo) {
        return restClient.post()
                .uri("api/veiculos")
                .contentType(MediaType.APPLICATION_JSON)
                .body(veiculo)
                .retrieve()
                .body(VeiculoDTO.class);
    }

    public List<RotasDTO> listarRotasPorEmpresa(Long idEmpresa) {
        RotasDTO[] rotas = restClient.get()
                .uri("api/rotas?id_empresa={idEmpresa}", idEmpresa)
                .retrieve()
                .body(RotasDTO[].class);
        return Arrays.asList(rotas != null ? rotas : new RotasDTO[0]);
    }

    public List<RotasDTO> listarRotasPorMotorista(Long idMotorista) {
        RotasDTO[] rotas = restClient.get()
                .uri("api/rotas?id_motorista={idMotorista}", idMotorista)
                .retrieve()
                .body(RotasDTO[].class);
        return Arrays.asList(rotas != null ? rotas : new RotasDTO[0]);
    }

    public RotasDTO cadastrarRota(RotasDTO rota) {
        return restClient.post()
                .uri("api/rotas")
                .contentType(MediaType.APPLICATION_JSON)
                .body(rota)
                .retrieve()
                .body(RotasDTO.class);
    }
}
