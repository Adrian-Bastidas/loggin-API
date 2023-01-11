package com.kruger.loggin.service;

import com.kruger.loggin.model.Music;
import com.kruger.loggin.model.Persona;
import com.kruger.loggin.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MusicService {
    @Autowired
    private MusicRepository repository;
    public Music addMusica(Music music){
        music.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(music);
    }
    public List<Music> findAllMusic(){
        return repository.findAll();
    }
    public Music getbyId(String id){
        return repository.findById(id).get();
    }
    public List<Music> getbyTitulo(String titulo){
        return repository.findByTitulo(titulo);
    }
    public List<Music> getbyNombre(String nombreDueno){
        return repository.findByNombre(nombreDueno);
    }
    public Music updateMusica(Music musicarequest){
        Music musicaExistente=repository.findById(musicarequest.getId()).get();
        musicaExistente.setMusica(musicarequest.getMusica());
        musicaExistente.setLetra(musicarequest.getLetra());
        musicaExistente.setAnio(musicarequest.getAnio());
        musicaExistente.setCarilla(musicarequest.getCarilla());
        musicaExistente.setTitulo(musicarequest.getTitulo());
        return repository.save(musicaExistente);
    }
    public String deleteMusica(String id){
        repository.deleteById(id);
        return "Musica borrada correctamente";
    }
}
