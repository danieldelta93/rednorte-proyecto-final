package com.rednorte.servicio_lista_espera.repository;

import com.rednorte.servicio_lista_espera.model.ListaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaEsperaRepository extends JpaRepository<ListaEspera, Long> {
    // Aquí podrías agregar métodos personalizados en el futuro, 
    // como buscar por especialidad.
}