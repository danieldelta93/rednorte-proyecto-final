package com.rednorte.servicio_gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator configurarRutas(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("rutas-pacientes", r -> r.path("/api/pacientes", "/api/pacientes/**")
                .uri("http://servicio-pacientes:8080"))
            
            .route("rutas-citas", r -> r.path("/api/citas", "/api/citas/**")
                .uri("http://servicio-citas:8081"))
            
            .route("rutas-espera", r -> r.path("/api/lista-espera", "/api/lista-espera/**")
                .uri("http://servicio-lista-espera:8082"))
            
            .route("rutas-notificaciones", r -> r.path("/api/notificaciones", "/api/notificaciones/**")
                .uri("http://servicio-notificaciones:8083"))
            .build();
    }
}