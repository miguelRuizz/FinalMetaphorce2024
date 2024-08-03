package com.metaphorce.catalogos.repositories;
import com.metaphorce.catalogos.models.Consola;
import com.metaphorce.catalogos.models.Videojuego;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.stream.Collectors;

public interface ConsolaRepository extends MongoRepository<Consola, String> {
}
