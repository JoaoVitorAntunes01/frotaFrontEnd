package com.frontprojetofinal.frontprojetofinal.controller;

import com.frontprojetofinal.frontprojetofinal.model.MotoristaDTO;
import com.frontprojetofinal.frontprojetofinal.service.ApiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastrarMotoristaController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/motoristas")
    public String listarMotoristas(Model model) {
        List<MotoristaDTO> motoristas = apiService.listarMotoristas();
        model.addAttribute("motoristas", motoristas);
        return "listarmotoristas";
    }

    @GetMapping("/motoristas/novo")
    public String novoMotorista(Model model) {
        model.addAttribute("motorista", new MotoristaDTO());
        return "cadastrarmotorista";
    }

    @PostMapping("/motoristas")
    public String cadastrarMotorista(MotoristaDTO motorista) {
        apiService.cadastrarMotorista(motorista);
        return "redirect:/home?motoristaCadastrado";
    }
}
