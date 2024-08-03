package com.metaphorce.catalogos.controllers;
import com.metaphorce.catalogos.models.Videojuego;
import com.metaphorce.catalogos.services.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/videojuegos")
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping
    public List<Videojuego> getAllVideojuegos() {
        return videojuegoService.getAllVideojuegos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Videojuego> getVideojuegoById(@PathVariable String id) {
        Optional<Videojuego> videojuegoOpt = videojuegoService.getVideojuegoById(id);
        return videojuegoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Videojuego addVideojuego(@RequestBody Videojuego videojuego) {
        return videojuegoService.addVideojuego(videojuego);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Videojuego> updateVideojuego(@PathVariable String id, @RequestBody Videojuego videojuego) {
        if (!videojuegoService.getVideojuegoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        videojuego.setId(id);
        Videojuego updatedVideojuego = videojuegoService.updateVideojuego(videojuego);
        return ResponseEntity.ok(updatedVideojuego);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideojuego(@PathVariable String id) {
        if (!videojuegoService.getVideojuegoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        videojuegoService.deleteVideojuego(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{videojuegoId}/consola/{consolaId}")
    public ResponseEntity<Void> addConsolaToVideojuego(@PathVariable String videojuegoId, @PathVariable String consolaId) {
        videojuegoService.addConsolaToVideojuego(videojuegoId, consolaId);
        return ResponseEntity.ok().build();
    }
}
