package com.example.api.controller;

import com.example.api.model.User;
import com.example.api.repository.UserRepository;
import com.example.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Usuário registrado com sucesso";
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User found = userRepository.findByUsername(user.getUsername());
        if (found != null && passwordEncoder.matches(user.getPassword(), found.getPassword())) {
            String token = JwtUtil.generateToken(found.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
    }
}
