package com.rednote.servicio_citas.service;

import com.rednote.servicio_citas.model.Cita;
import com.rednote.servicio_citas.repository.CitaRepository;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private StreamBridge streamBridge;

    public Cita crearCita(Cita cita) {
        cita.setEstado("AGENDADA");
        Cita citaGuardada = citaRepository.save(cita);

        String mensaje = "Nueva cita agendada para el paciente ID: " + citaGuardada.getPacienteId();
        
        // Enviamos al destino definido en application.properties
        boolean enviado = streamBridge.send("notificaciones-out-0", mensaje);
        
        System.out.println("DEBUG: Intento de envío a RabbitMQ. ¿Éxito?: " + enviado);
        
        return citaGuardada;
    }

    public List<Cita> obtenerTodas() {
        return citaRepository.findAll();
    }

    public Cita cancelarCita(Long id) {
        return citaRepository.findById(id).map(citaExistente -> {
            citaExistente.setEstado("CANCELADA");
            return citaRepository.save(citaExistente);
        }).orElseThrow(() -> new RuntimeException("Cita con ID " + id + " no encontrada"));
    }
}