package com.metaphorce.jugadores.controllers;
import com.metaphorce.jugadores.models.Jugador;
import com.metaphorce.jugadores.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
    @Autowired
    private JugadorService jugadorService;

    @GetMapping
    public List<Jugador> getAllJugadores() {
        return jugadorService.getAllJugadores();
    }

    @GetMapping("/{id}")
    public Jugador getJugadorById(@PathVariable String id) {
        return jugadorService.getJugadorById(id);
    }

    @PostMapping
    public Jugador addJugador(@RequestBody Jugador jugador) {
        return jugadorService.addJugador(jugador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jugador> updateJugador(@PathVariable String id, @RequestBody Jugador jugadorDetails) {
        Jugador updatedJugador = jugadorService.updateJugador(id, jugadorDetails);
        return ResponseEntity.ok(updatedJugador);
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable String id) {
        jugadorService.deleteJugador(id);
    }
}
