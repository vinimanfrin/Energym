package com.globalsolution.energym.controllers;

import com.globalsolution.energym.domain.entities.Exercicio;
import com.globalsolution.energym.services.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exercicios")
public class ExercicioController {

    @Autowired
    private ExercicioService service;

    @GetMapping
    public String listarExercicios(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            Model model) {
        Page<Exercicio> exerciciosPage = service.getPageExercicios(page, size);
        model.addAttribute("exerciciosPage", exerciciosPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", exerciciosPage.getTotalPages());
        return "exercicios/index";
    }
}
