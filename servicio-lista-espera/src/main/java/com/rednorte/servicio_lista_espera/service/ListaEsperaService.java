package com.rednorte.servicio_lista_espera.service;

import com.rednorte.servicio_lista_espera.model.ListaEspera;
import com.rednorte.servicio_lista_espera.repository.ListaEsperaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaEsperaService {

    @Autowired
    private ListaEsperaRepository repository;

    public ListaEspera anotarEnLista(ListaEspera item) {
        // Aquí podrías validar si el paciente ya está en lista, por ejemplo.
        return repository.save(item);
    }

    public List<ListaEspera> obtenerTodaLaLista() {
        return repository.findAll();
    }

    public void eliminarDeLista(Long id) {
        repository.deleteById(id);
    }
}