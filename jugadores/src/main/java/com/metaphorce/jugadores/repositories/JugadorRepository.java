package com.metaphorce.jugadores.repositories;
import com.metaphorce.jugadores.models.Jugador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JugadorRepository extends MongoRepository<Jugador, String> {

}
