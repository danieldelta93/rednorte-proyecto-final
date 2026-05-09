package com.rednorte.servicio_lista_espera.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "lista_espera")
public class ListaEspera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long pacienteId;
    private String especialidad;
    private Integer prioridad; // 1: Alta, 2: Media, 3: Baja
    private LocalDateTime fechaInscripcion;

    @PrePersist
    protected void onCreate() {
        fechaInscripcion = LocalDateTime.now();
    }

    // Getters y Setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getPacienteId() { return pacienteId; }
    public void setPacienteId(Long pacienteId) { this.pacienteId = pacienteId; }
    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public Integer getPrioridad() { return prioridad; }
    public void setPrioridad(Integer prioridad) { this.prioridad = prioridad; }
}