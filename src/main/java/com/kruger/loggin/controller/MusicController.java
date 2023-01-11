package com.kruger.loggin.controller;

import com.kruger.loggin.model.Music;
import com.kruger.loggin.model.Persona;
import com.kruger.loggin.service.MusicService;
import com.kruger.loggin.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/musica")
public class MusicController {
    @Autowired
    private MusicService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Music addMusica(@RequestBody Music music){
        return service.addMusica(music);
    }

    @GetMapping
    public List<Music> findAllMusic(){
        return service.findAllMusic();
    }
    @GetMapping("/{id}")
    public Music getPersona(@PathVariable String id){
        return service.getbyId(id);
    }

    @GetMapping("/titulo/{titulo}")
    public List<Music> getbyTitulo(@PathVariable String titulo){
        return service.getbyTitulo(titulo);
    }
    @GetMapping("/nombre/{name}")
    public List<Music> getbyNombre(@PathVariable String name){
        return service.getbyNombre(name);
    }
    @PutMapping
    public Music updateMusica(@RequestBody Music music){
        return service.updateMusica(music);
    }
    @DeleteMapping("/{id}")
    public String deleteMusica(@PathVariable String id){
        return service.deleteMusica(id);
    }
}
