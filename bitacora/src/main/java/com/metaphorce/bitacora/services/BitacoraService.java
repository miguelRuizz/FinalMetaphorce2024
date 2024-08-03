package com.metaphorce.bitacora.services;
import com.metaphorce.bitacora.models.Bitacora;
import com.metaphorce.bitacora.repositories.BitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BitacoraService {
    @Autowired
    private BitacoraRepository bitacoraRepository;
    @Autowired
    private RestTemplate restTemplate;

    public List<Bitacora> getBitacoras() {
        return bitacoraRepository.findAll();
    }

    public Bitacora registrarActividad(String jugadorId, String videojuegoId) {
        // Envía las peticiones al API Gateway, no a los microservicios directamente.
        String jugador = restTemplate.getForObject("http://api-gateway:8087/jugadores/" + jugadorId, String.class);
        String videojuego = restTemplate.getForObject("http://api-gateway:8087/videojuegos/" + videojuegoId, String.class);

        // Se convierten a JsonNode pa pdoer acceder a sus propiedades.
        String nombreJugador = "";
        String nombreVideojuego = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jugadorNode = mapper.readTree(jugador);
            JsonNode videojuegoNode = mapper.readTree(videojuego);
            nombreJugador = jugadorNode.get("nombre").asText();
            nombreVideojuego = videojuegoNode.get("nombre").asText();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Y aquí checa si sí existen el jugador y el videojuego
        if (jugador != null && videojuego != null) {
            Bitacora bitacora = new Bitacora();
            bitacora.setJugadorId(jugadorId);
            bitacora.setJugadorName(nombreJugador);
            bitacora.setVideojuegoId(videojuegoId);
            bitacora.setVideojuegoName(nombreVideojuego);
            bitacora.setFechaHora(LocalDateTime.now());
            return bitacoraRepository.save(bitacora);
        }
        System.out.println("Jugador o Videojuego no encontrados");
        return null;
    }
}
