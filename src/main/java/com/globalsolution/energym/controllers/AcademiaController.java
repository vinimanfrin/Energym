package com.globalsolution.energym.controllers;

import com.globalsolution.energym.domain.entities.Academia;
import com.globalsolution.energym.dto.AcademiaCreateDTO;
import com.globalsolution.energym.dto.EnderecoCreateDTO;
import com.globalsolution.energym.services.AcademiaService;
import com.globalsolution.energym.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("academias")
public class AcademiaController {

    @Autowired
    private AcademiaService service;

    @Autowired
    private UserService userService;

    @GetMapping("detail")
    public String detailAcademia(Model model){
        Academia academia = service.findByUserId(userService.authenticated().getId());
        model.addAttribute("academiaCreateDTO",new AcademiaCreateDTO(
                academia.getCnpj(),
                academia.getNome(),
                new EnderecoCreateDTO(academia.getEndereco()),
                academia.getUser()));
        return "detail-academia";
    }

    @PostMapping("/update")
    public String updateAcademia(Model model, @ModelAttribute @Valid AcademiaCreateDTO academiaCreateDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "detail-academia";
        }
        service.update(academiaCreateDTO,service.findByUserId(userService.authenticated().getId()).getId());
        return "redirect:/";
    }
}
