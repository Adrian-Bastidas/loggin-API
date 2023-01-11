package com.kruger.loggin.repository;

import com.kruger.loggin.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PersonaRepository extends MongoRepository<Persona, String> {
    Persona findByCorreo(String correo);
    List<Persona> findByArtistname(String artistname);
    List<Persona> findByNombre(String nombre);
}
