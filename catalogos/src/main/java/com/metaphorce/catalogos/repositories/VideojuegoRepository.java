package com.metaphorce.catalogos.repositories;
import com.metaphorce.catalogos.models.Videojuego;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface VideojuegoRepository extends MongoRepository<Videojuego, String>{
}
