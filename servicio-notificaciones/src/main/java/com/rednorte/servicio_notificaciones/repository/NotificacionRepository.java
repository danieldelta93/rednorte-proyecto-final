package com.rednorte.servicio_notificaciones.repository;

import com.rednorte.servicio_notificaciones.model.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    // Aquí podrías filtrar notificaciones por pacienteId en el futuro
}