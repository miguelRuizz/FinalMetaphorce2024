package com.metaphorce.catalogos.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "consola")
public class Consola {
    @Id
    private String id;
    private String nombre;
    private List<String> videojuegos = new ArrayList<>();;

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

    public List<String> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(List<String> videojuegos) {
        this.videojuegos = videojuegos;
    }
}
