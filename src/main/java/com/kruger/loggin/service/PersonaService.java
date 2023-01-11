package com.kruger.loggin.service;

import com.kruger.loggin.model.Music;
import com.kruger.loggin.model.Persona;
import com.kruger.loggin.repository.MusicRepository;
import com.kruger.loggin.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository repository;

    public Persona addPersona(Persona persona){
        persona.setId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(persona);
    }
    public List<Persona> findAll(){
        return repository.findAll();
    }
    public Persona getbyId(String id){
        return repository.findById(id).get();
    }
    public Persona getbyCorreo(String correo){
        return repository.findByCorreo(correo);
    }
    public List<Persona> getbyNombre(String nombre){
        return repository.findByNombre(nombre);
    }
    public List<Persona> getbyartistname(String artistname){
        return repository.findByArtistname(artistname);
    }
    public Persona updatePersona(Persona personarequest){
        Persona personaExistente=repository.findById(personarequest.getId()).get();
        personaExistente.setContraseña(personarequest.getContraseña());
        personaExistente.setCorreo(personarequest.getCorreo());
        personaExistente.setArtistname(personarequest.getArtistname());
        personaExistente.setFoto(personarequest.getFoto());

        return repository.save(personaExistente);
    }
    public Persona updateUltima(String id, String codigo){
        Persona personaExistente=repository.findById(id).get();
        personaExistente.setIdUltima(codigo);
        return repository.save(personaExistente);
    }
    public Persona updateMusicaPersona(String music, String id){
        Persona personaExistente=repository.findById(id).get();
        List<String>musicaantes=personaExistente.getMusicaPropia();
        musicaantes.add(music);
        personaExistente.setMusicaPropia(musicaantes);
        return repository.save(personaExistente);
    }
    public String deletePersona(String id){
        repository.deleteById(id);
        return "Usuario borrado correctamente";
    }
    public String deleteMusica(String id, String idm){
        Persona personaExistente=repository.findById(id).get();
        List<String>musicaantes=personaExistente.getMusicaPropia();
        musicaantes.remove(idm);
        personaExistente.setMusicaPropia(musicaantes);
        repository.save(personaExistente);
        return "Canción eliminada correctamente";
    }
}
