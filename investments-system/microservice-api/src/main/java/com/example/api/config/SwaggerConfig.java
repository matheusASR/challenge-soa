package com.example.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI investmentOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Investment Recommendation API")
            .description("API para recomendação de investimentos por perfil")
            .version("v1.0"));
    }
}
