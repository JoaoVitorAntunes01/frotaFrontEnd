package com.frontprojetofinal.frontprojetofinal.controller;

import com.frontprojetofinal.frontprojetofinal.model.MotoristaDTO;
import com.frontprojetofinal.frontprojetofinal.model.RotasDTO;
import com.frontprojetofinal.frontprojetofinal.model.VeiculoDTO;
import com.frontprojetofinal.frontprojetofinal.service.ApiService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class CadastrarRotaController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/rotas")
    public String listarRotas(HttpSession session, Model model) {
        String redirect = exigirEmpresaLogada(session);
        if (redirect != null) {
            return redirect;
        }

        Long idEmpresa = (Long) session.getAttribute("idPerfil");
        List<RotasDTO> rotas = apiService.listarRotasPorEmpresa(idEmpresa);
        model.addAttribute("rotas", rotas);
        return "listarrotas";
    }

    @GetMapping("/rotas/novo")
    public String novaRota(HttpSession session, Model model) {
        String redirect = exigirEmpresaLogada(session);
        if (redirect != null) {
            return redirect;
        }

        Long idEmpresa = (Long) session.getAttribute("idPerfil");
        carregarListasDeApoio(idEmpresa, model);
        model.addAttribute("rota", new RotasDTO());
        return "cadastrarrota";
    }

    @PostMapping("/rotas")
    public String cadastrarRota(RotasDTO rota, HttpSession session, Model model) {
        String redirect = exigirEmpresaLogada(session);
        if (redirect != null) {
            return redirect;
        }

        Long idEmpresa = (Long) session.getAttribute("idPerfil");

        if (rota.getHora_chegada() != null && rota.getHora_chegada().isBlank()) {
            rota.setHora_chegada(null);
        }

        try {
            apiService.cadastrarRota(rota);
            return "redirect:/rotas?rotaCadastrada";
        } catch (HttpClientErrorException e) {
            model.addAttribute("erro", "Não foi possível cadastrar a rota. Verifique os dados informados.");
            model.addAttribute("rota", rota);
            carregarListasDeApoio(idEmpresa, model);
            return "cadastrarrota";
        }
    }

    private void carregarListasDeApoio(Long idEmpresa, Model model) {
        List<MotoristaDTO> motoristas = apiService.listarMotoristasPorEmpresa(idEmpresa);
        List<VeiculoDTO> veiculos = apiService.listarVeiculosPorEmpresa(idEmpresa);
        model.addAttribute("motoristas", motoristas);
        model.addAttribute("veiculos", veiculos);
    }

    private String exigirEmpresaLogada(HttpSession session) {
        Object tipo = session.getAttribute("tipo");
        if (!"EMPRESA".equals(tipo)) {
            return "redirect:/login";
        }
        return null;
    }
}
