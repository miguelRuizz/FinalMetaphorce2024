package com.metaphorce.catalogos.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "videojuego")
public class Videojuego {
    @Id
    private String id;
    private String nombre;
    private List<String> consolas = new ArrayList<>();;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getConsolas() {
        return consolas;
    }

    public void setConsolas(List<String> consolas) {
        this.consolas = consolas;
    }
}
