package com.metaphorce.bitacora.repositories;
import com.metaphorce.bitacora.models.Bitacora;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraRepository extends MongoRepository<Bitacora, String> {
}
