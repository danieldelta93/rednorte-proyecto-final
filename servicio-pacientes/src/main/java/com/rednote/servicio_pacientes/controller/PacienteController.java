package com.rednote.servicio_pacientes.controller;

import com.rednote.servicio_pacientes.model.Paciente;
import com.rednote.servicio_pacientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    // Endpoint para guardar un paciente
    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente) {
        return pacienteService.crearPaciente(paciente);
    }

    // Endpoint para obtener la lista de pacientes
    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.obtenerTodos();
    }
}