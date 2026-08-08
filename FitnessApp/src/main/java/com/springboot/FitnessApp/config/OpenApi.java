package com.springboot.FitnessApp.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApi {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Fitness Tracking application")
                        .version("v1.0")
                        .description("Prodction ready APIs")
                        .contact(new Contact()
                                .name("Gagan")
                                .email("gagankumare@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                        )
                );
    }
}
