package com.example.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/recommendations")
public class InvestmentRecommendationController {

    @GetMapping("/{profile}")
    public String getRecommendation(@PathVariable String profile) {
        return switch (profile.toLowerCase()) {
            case "conservative" -> "Tesouro Direto e CDBs";
            case "moderate" -> "Fundos Multimercado e Debêntures";
            case "aggressive" -> "Ações e Criptomoedas";
            default -> "Perfil não reconhecido";
        };
    }
}
