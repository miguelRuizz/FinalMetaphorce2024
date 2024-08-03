package com.metaphorce.bitacora.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

public class Bitacora {
    @Id
    private String id;
    private String jugadorId;
    private String jugadorName;
    private String videojuegoId;
    private String videojuegoName;
    private LocalDateTime fechaHora;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJugadorId() {
        return jugadorId;
    }

    public void setJugadorId(String jugadorId) {
        this.jugadorId = jugadorId;
    }

    public String getJugadorName() {
        return jugadorName;
    }

    public void setJugadorName(String jugadorName) {
        this.jugadorName = jugadorName;
    }

    public String getVideojuegoId() {
        return videojuegoId;
    }

    public void setVideojuegoId(String videojuegoId) {
        this.videojuegoId = videojuegoId;
    }

    public String getVideojuegoName() {
        return videojuegoName;
    }

    public void setVideojuegoName(String videojuegoName) {
        this.videojuegoName = videojuegoName;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
