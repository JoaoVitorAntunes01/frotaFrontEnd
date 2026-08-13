package com.frontprojetofinal.frontprojetofinal.controller;

import com.frontprojetofinal.frontprojetofinal.model.VeiculoDTO;
import com.frontprojetofinal.frontprojetofinal.service.ApiService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastrarVeiculoController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/veiculos")
    public String listarVeiculos(HttpSession session, Model model) {
        String redirect = exigirEmpresaLogada(session);
        if (redirect != null) {
            return redirect;
        }

        Long idEmpresa = (Long) session.getAttribute("idPerfil");
        List<VeiculoDTO> veiculos = apiService.listarVeiculosPorEmpresa(idEmpresa);
        model.addAttribute("veiculos", veiculos);
        return "listarveiculos";
    }

    @GetMapping("/veiculos/novo")
    public String novoVeiculo(HttpSession session, Model model) {
        String redirect = exigirEmpresaLogada(session);
        if (redirect != null) {
            return redirect;
        }

        model.addAttribute("veiculo", new VeiculoDTO());
        return "cadastrarveiculo";
    }

    @PostMapping("/veiculos")
    public String cadastrarVeiculo(VeiculoDTO veiculo, HttpSession session) {
        String redirect = exigirEmpresaLogada(session);
        if (redirect != null) {
            return redirect;
        }

        Long idEmpresa = (Long) session.getAttribute("idPerfil");
        veiculo.setId_empresa(idEmpresa);
        apiService.cadastrarVeiculo(veiculo);
        return "redirect:/?veiculoCadastrado";
    }

    private String exigirEmpresaLogada(HttpSession session) {
        Object tipo = session.getAttribute("tipo");
        if (!"EMPRESA".equals(tipo)) {
            return "redirect:/login";
        }
        return null;
    }
}
