package com.rednorte.servicio_notificaciones.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.function.Consumer;

@Service
public class NotificacionListener {

    // Spring Cloud Stream buscará este Bean para procesar los mensajes 
    // que lleguen al destino configurado en el application.properties
    @Bean
    public Consumer<String> notificaciones() {
        return mensaje -> {
            System.out.println("=========================================");
            System.out.println("📩 MENSAJE RECIBIDO DESDE RABBITMQ:");
            System.out.println(mensaje);
            System.out.println("Preparando envío de correo al paciente...");
            System.out.println("=========================================");
            
            // Aquí puedes agregar la lógica para enviar el correo real más adelante
        };
    }
}