package com.globalsolution.energym.controllers;

import com.globalsolution.energym.domain.entities.User;
import com.globalsolution.energym.dto.AcademiaCreateDTO;
import com.globalsolution.energym.repositories.UserRepository;
import com.globalsolution.energym.services.AcademiaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AcademiaService academiaService;

    @PostMapping(value = "/req/signup")
    @Transactional
    public String createUser(@ModelAttribute @Valid AcademiaCreateDTO academiaCreateDTO, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "signup";
        }
        User user = academiaCreateDTO.getUser();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        academiaService.saveNewAcademia(academiaCreateDTO);
        return "login";
    }
}
