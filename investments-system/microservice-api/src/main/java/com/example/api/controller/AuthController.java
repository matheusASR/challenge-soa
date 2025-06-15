package com.example.api.controller;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import com.example.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userRepository.save(user);
        return "Usuário registrado com sucesso";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User found = userRepository.findByUsername(user.getUsername());
        if (found != null && found.getPassword().equals(user.getPassword())) {
            return JwtUtil.generateToken(user.getUsername());
        }
        return "Credenciais inválidas";
    }
}
