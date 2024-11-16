package com.globalsolution.energym.controllers;

import com.globalsolution.energym.domain.entities.User;
import com.globalsolution.energym.dto.AcademiaCreateDTO;
import com.globalsolution.energym.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/signup")
    public String getFormCadastro(Model model){
        model.addAttribute("academiaCreateDTO",new AcademiaCreateDTO());
        return "signup";
    }
    @PostMapping("/signup")
    public String createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login";
    }
}
