package com.metaphorce.catalogos.controllers;
import com.metaphorce.catalogos.models.Consola;
import com.metaphorce.catalogos.services.ConsolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consolas")
public class ConsolaController {
    @Autowired
    private ConsolaService consolaService;

    @GetMapping
    public List<Consola> getAllConsolas() {
        return consolaService.getAllConsolas();
    }

    @GetMapping("/{id}")
    public Consola getConsolaById(@PathVariable String id) {
        return consolaService.getConsolaById(id);
    }

    @PostMapping
    public Consola addConsola(@RequestBody Consola consola) {
        return consolaService.addConsola(consola);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consola> updateConsola(@PathVariable String id, @RequestBody Consola ConsolaDetails) {
        Consola updatedConsola = consolaService.updateConsola(id, ConsolaDetails);
        return ResponseEntity.ok(updatedConsola);
    }

    @DeleteMapping("/{id}")
    public void deleteConsola(@PathVariable String id) {
        consolaService.deleteConsola(id);
    }
}
