package com.dylan.apirest.apirest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configuración de CORS para permitir solicitudes desde un origen específico
        registry.addMapping("/**") // Aplica a todas las rutas
                .allowedOrigins(
                        "https://apirest-railway-java-crud-production.up.railway.app") // Permite solicitudes
                                                                                       // desde este origen
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos HTTP permitidos
                .allowedHeaders("*") // Permite todos los headers
                .allowCredentials(true); // Permite cookies
    }
}
