package com.metaphorce.catalogos.services;
import com.metaphorce.catalogos.models.Consola;
import com.metaphorce.catalogos.models.Videojuego;
import com.metaphorce.catalogos.repositories.ConsolaRepository;
import com.metaphorce.catalogos.repositories.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ConsolaService {
    @Autowired
    private ConsolaRepository consolaRepository;
    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public List<Consola> getAllConsolas() {
        return consolaRepository.findAll();
    }

    public Consola getConsolaById(String id_videojuego) {
        return consolaRepository.findById(id_videojuego).orElse(null);
    }

    public Consola addConsola(Consola Consola) {
        return consolaRepository.save(Consola);
    }

    public Consola updateConsola(String id, Consola ConsolaDetails) {
        Optional<Consola> optionalConsola = consolaRepository.findById(id);
        if (optionalConsola.isPresent()) {
            Consola Consola = optionalConsola.get();
            Consola.setNombre(ConsolaDetails.getNombre());
            return consolaRepository.save(Consola);
        } else {
            throw new NoSuchElementException("Consola con id: " +id + " no encontrada.");
        }
    }

    public void deleteConsola(String id) {
        consolaRepository.deleteById(id);
    }
}
