package com.frontprojetofinal.frontprojetofinal.controller;

import com.frontprojetofinal.frontprojetofinal.model.RotasDTO;
import com.frontprojetofinal.frontprojetofinal.service.ApiService;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        Object tipo = session.getAttribute("tipo");

        if (tipo == null) {
            return "redirect:/login";
        }

        model.addAttribute("nome", session.getAttribute("nome"));
        model.addAttribute("tipo", tipo);

        if ("MOTORISTA".equals(tipo)) {
            Long idMotorista = (Long) session.getAttribute("idPerfil");
            List<RotasDTO> rotas = apiService.listarRotasPorMotorista(idMotorista);
            model.addAttribute("rotas", rotas);
            return "homemotorista";
        }

        return "home";
    }
}
