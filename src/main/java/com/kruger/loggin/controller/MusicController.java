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
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/")
public class MusicController {
    @Autowired
    private MusicService servicem;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Music addMusica(@RequestBody Music music){
        return servicem.addMusica(music);
    }

    @GetMapping
    public List<Music> findAllMusic(){
        return servicem.findAllMusic();
    }
    @GetMapping("/{id}")
    public Music getPersona(@PathVariable String id){
        return servicem.getbyId(id);
    }

    @GetMapping("/titulo/{titulo}")
    public List<Music> getbyTitulo(@PathVariable String titulo){
        return servicem.getbyTitulo(titulo);
    }
    @GetMapping("/nombre/{name}")
    public List<Music> getbyNombre(@PathVariable String name){
        return servicem.getbyNombre(name);
    }
    @PutMapping
    public Music updateMusica(@RequestBody Music music){
        return servicem.updateMusica(music);
    }
    @DeleteMapping("/{id}")
    public String deleteMusica(@PathVariable String id){
        return servicem.deleteMusica(id);
    }
}
