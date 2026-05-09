package com.rednorte.servicio_notificaciones.service;

import com.rednorte.servicio_notificaciones.model.Notificacion;
import com.rednorte.servicio_notificaciones.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository repository;

    public Notificacion enviarNotificacion(Notificacion notificacion) {
        // Aquí podrías agregar lógica para validar el formato del mensaje
        return repository.save(notificacion);
    }

    public List<Notificacion> obtenerHistorial() {
        return repository.findAll();
    }
}