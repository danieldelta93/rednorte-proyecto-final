package com.rednorte.servicio_lista_espera.controller;

import com.rednorte.servicio_lista_espera.model.ListaEspera;
import com.rednorte.servicio_lista_espera.service.ListaEsperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lista-espera")
public class ListaEsperaController {

    @Autowired
    private ListaEsperaService service;

    @PostMapping
    public ListaEspera agregar(@RequestBody ListaEspera item) {
        return service.anotarEnLista(item);
    }

    @GetMapping
    public List<ListaEspera> listar() {
        return service.obtenerTodaLaLista();
    }
}