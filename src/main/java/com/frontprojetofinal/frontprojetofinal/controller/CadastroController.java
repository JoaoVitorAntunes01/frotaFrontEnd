package com.frontprojetofinal.frontprojetofinal.controller;

import com.frontprojetofinal.frontprojetofinal.model.EmpresaDTO;
import com.frontprojetofinal.frontprojetofinal.model.LoginRequestDTO;
import com.frontprojetofinal.frontprojetofinal.model.LoginResponseDTO;
import com.frontprojetofinal.frontprojetofinal.service.ApiService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class CadastroController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/registro")
    public String registro(Model model) {
        model.addAttribute("empresa", new EmpresaDTO());
        return "registrar";
    }

    @PostMapping("/registro")
    public String cadastrar(EmpresaDTO empresa, Model model) {
        try {
            apiService.registrarEmpresa(empresa);
            return "redirect:/login?cadastroSucesso";
        } catch (HttpClientErrorException e) {
            model.addAttribute("erro", "Não foi possível concluir o cadastro. Verifique os dados informados.");
            model.addAttribute("empresa", empresa);
            return "registrar";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String logar(@RequestParam String email,
                         @RequestParam String senha,
                         @RequestParam String tipo,
                         HttpSession session,
                         Model model) {
        try {
            LoginResponseDTO response = apiService.login(new LoginRequestDTO(email, senha, tipo));

            session.setAttribute("idUsuario", response.getIdUsuario());
            session.setAttribute("nome", response.getNome());
            session.setAttribute("email", response.getEmail());
            session.setAttribute("tipo", response.getTipo());
            session.setAttribute("idPerfil", response.getIdPerfil());

            return "redirect:/";
        } catch (HttpClientErrorException.Unauthorized e) {
            model.addAttribute("erro", "E-mail ou senha inválidos.");
            return "login";
        } catch (HttpClientErrorException.Forbidden e) {
            model.addAttribute("erro", "Este usuário não possui esse perfil de acesso.");
            return "login";
        } catch (HttpClientErrorException e) {
            model.addAttribute("erro", "Não foi possível entrar. Tente novamente.");
            return "login";
        }
    }
}
