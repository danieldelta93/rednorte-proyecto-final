package com.rednote.servicio_citas.service;

import com.rednote.servicio_citas.model.Cita;
import com.rednote.servicio_citas.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public Cita crearCita(Cita cita) {
        cita.setEstado("AGENDADA"); // Toda cita nueva nace agendada
        return citaRepository.save(cita);
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