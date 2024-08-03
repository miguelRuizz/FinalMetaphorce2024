package com.metaphorce.jugadores.services;
import com.metaphorce.jugadores.models.Jugador;
import com.metaphorce.jugadores.repositories.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Jugador getJugadorById(String id) {
        return jugadorRepository.findById(id).orElse(null);
    }

    public Jugador addJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public Jugador updateJugador(String id, Jugador jugadorDetails) {
        Optional<Jugador> optionalJugador = jugadorRepository.findById(id);
        if (optionalJugador.isPresent()) {
            Jugador jugador = optionalJugador.get();
            jugador.setNombre(jugadorDetails.getNombre());
            jugador.setApellido(jugadorDetails.getApellido());
            jugador.setPais(jugadorDetails.getPais());
            return jugadorRepository.save(jugador);
        } else {
            throw new NoSuchElementException("Jugador con id: " +id + " no encontrado ");
        }
    }

    public void deleteJugador(String id) {
        jugadorRepository.deleteById(id);
    }
}
