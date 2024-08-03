package com.metaphorce.catalogos.services;
import com.metaphorce.catalogos.models.Consola;
import com.metaphorce.catalogos.models.Videojuego;
import com.metaphorce.catalogos.repositories.ConsolaRepository;
import com.metaphorce.catalogos.repositories.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideojuegoService {
    @Autowired
    private VideojuegoRepository videojuegoRepository;

    @Autowired
    private ConsolaRepository consolaRepository;

    public List<Videojuego> getAllVideojuegos() {
        return videojuegoRepository.findAll();
    }

    public Optional<Videojuego> getVideojuegoById(String id) {
        return videojuegoRepository.findById(id);
    }

    public Videojuego addVideojuego(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    public Videojuego updateVideojuego(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }

    public void deleteVideojuego(String id) {
        videojuegoRepository.deleteById(id);
    }

    public void addConsolaToVideojuego(String videojuegoId, String consolaId) {
        Optional<Videojuego> videojuegoOpt = videojuegoRepository.findById(videojuegoId);
        Optional<Consola> consolaOpt = consolaRepository.findById(consolaId);

        if (videojuegoOpt.isPresent() && consolaOpt.isPresent()) {
            Videojuego videojuego = videojuegoOpt.get();
            Consola consola = consolaOpt.get();

            /*if (videojuego.getConsolas() == null) {
                videojuego.setConsolas(new ArrayList<>());
            }

            if (consola.getVideojuegos() == null) {
                consola.setVideojuegos(new ArrayList<>());
            }*/

            if (!videojuego.getConsolas().contains(consola.getNombre())) {
                videojuego.getConsolas().add(consola.getNombre());
                videojuegoRepository.save(videojuego);
            }

            if (!consola.getVideojuegos().contains(videojuego.getNombre())) {
                consola.getVideojuegos().add(videojuego.getNombre());
                consolaRepository.save(consola);
            }
        }
    }
}
