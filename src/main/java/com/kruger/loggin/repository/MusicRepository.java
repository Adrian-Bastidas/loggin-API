package com.kruger.loggin.repository;

import com.kruger.loggin.model.Music;
import com.kruger.loggin.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MusicRepository extends MongoRepository<Music, String> {
    List<Music> findByTitulo(String titulo);
    List<Music> findByNombre(String nombreDueno);
}
