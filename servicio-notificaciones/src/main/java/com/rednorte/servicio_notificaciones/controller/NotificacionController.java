package com.rednorte.servicio_notificaciones.controller;

import com.rednorte.servicio_notificaciones.model.Notificacion;
import com.rednorte.servicio_notificaciones.service.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService service;

    @PostMapping
    public Notificacion enviar(@RequestBody Notificacion notificacion) {
        return service.enviarNotificacion(notificacion);
    }

    @GetMapping
    public List<Notificacion> listar() {
        return service.obtenerHistorial();
    }
}