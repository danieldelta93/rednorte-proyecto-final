package com.rednote.servicio_citas.controller;

import com.rednote.servicio_citas.model.Cita;
import com.rednote.servicio_citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public Cita crear(@RequestBody Cita cita) {
        return citaService.crearCita(cita);
    }

    @GetMapping
    public List<Cita> listar() {
        return citaService.obtenerTodas();
    }

    // Endpoint específico para cancelar una cita
    @PutMapping("/{id}/cancelar")
    public Cita cancelar(@PathVariable Long id) {
        return citaService.cancelarCita(id);
    }
}