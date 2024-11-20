package com.globalsolution.energym.controllers;

import com.globalsolution.energym.domain.entities.Praticante;
import com.globalsolution.energym.services.PraticanteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/praticantes")
public class PraticanteController {

    @Autowired
    private PraticanteService praticanteService;

    @GetMapping("/form-pesquisar")
    public String getFormPesquisarPraticantes(Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("currentPath", httpServletRequest.getRequestURI());
        return "praticantes/pesquisar-praticantes";
    }

    @GetMapping("/pesquisar")
    public String pesquisarPraticante(@RequestParam("cpf") String cpf, Model model, HttpServletRequest httpServletRequest) {
        Praticante praticante = praticanteService.buscarPorCpf(cpf);
        model.addAttribute("currentPath", httpServletRequest.getRequestURI());

        if (praticante != null) {
            model.addAttribute("praticante", praticante);
        } else {
            model.addAttribute("notFound", true);
        }

        return "praticantes/pesquisar-praticantes";
    }
}
