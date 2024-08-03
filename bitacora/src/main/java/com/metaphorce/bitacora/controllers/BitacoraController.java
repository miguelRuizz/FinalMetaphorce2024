package com.metaphorce.bitacora.controllers;
import com.metaphorce.bitacora.models.Bitacora;
import com.metaphorce.bitacora.services.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bitacoras")
public class BitacoraController {
    @Autowired
    private BitacoraService bitacoraService;

    @GetMapping
    public List<Bitacora> getBitacoras() {
        return bitacoraService.getBitacoras();
    }

    @PostMapping("/registrar")
    public Bitacora registrarActividad(@RequestBody Bitacora bitacora) {
        return bitacoraService.registrarActividad(bitacora.getJugadorId(), bitacora.getVideojuegoId());
    }
}
