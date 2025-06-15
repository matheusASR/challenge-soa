package com.example.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class InvestmentSOAPService {

    @WebMethod
    public String getInvestmentRecommendation(String profile) {
        return switch (profile.toLowerCase()) {
            case "conservative" -> "Tesouro Direto e CDBs";
            case "moderate" -> "Fundos Multimercado e Debêntures";
            case "aggressive" -> "Ações e Criptomoedas";
            default -> "Perfil não reconhecido";
        };
    }
}
