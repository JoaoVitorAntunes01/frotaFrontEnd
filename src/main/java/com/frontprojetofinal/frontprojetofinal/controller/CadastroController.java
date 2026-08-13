/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.frontprojetofinal.frontprojetofinal.controller;

import com.frontprojetofinal.frontprojetofinal.model.UsuarioDTO;
import com.frontprojetofinal.frontprojetofinal.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {
    
    @Autowired
    private ApiService apiService;
    
    @GetMapping("/registro")
    public String registro(Model model){
        UsuarioDTO user = new UsuarioDTO();
        model.addAttribute("user", user);
        return "registrar"; 
    }  
    
    @GetMapping("/login")
    public String login(){
        return "login";   
    }
    
    @PostMapping("/login")
    public String logar(UsuarioDTO user){
        apiService.logar(user);
        return "redirect:/home";
    }
    
    @PostMapping("/registrar")
    public String cadastrar(UsuarioDTO user){
        apiService.registrar(user);
        return "redirect:/login";
    }
}
