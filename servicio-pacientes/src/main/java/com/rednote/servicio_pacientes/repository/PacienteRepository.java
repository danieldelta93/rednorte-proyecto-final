package com.rednote.servicio_pacientes.repository;

import com.rednote.servicio_pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Con solo extender JpaRepository, ya tenemos los métodos para guardar, buscar, actualizar y eliminar.
}