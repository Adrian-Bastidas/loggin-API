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
@RequestMapping("/usuarios")
public class PersonaController {
    @Autowired
    private MusicService servicem;
    @PostMapping("/musicadb/postear")
    @ResponseStatus(HttpStatus.CREATED)
    public Music addMusica(@RequestBody Music music){
        return servicem.addMusica(music);
    }

    @GetMapping("/musicadb")
    public List<Music> findAllMusic(){
        return servicem.findAllMusic();
    }

    @Autowired
    private PersonaService service;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Persona createPersona(@RequestBody Persona persona){
        return service.addPersona(persona);
    }

    @GetMapping
    public List<Persona> getAll(){
        return service.findAll();
    }
    @GetMapping("/musica/{id}")
    public Music getMusica(@PathVariable String id){
        return servicem.getbyId(id);
    }
    @GetMapping("/{id}")
    public Persona getPersona(@PathVariable String id){
        return service.getbyId(id);
    }
    @PutMapping("/musicaUpdate")
    public Music updateMusica(@RequestBody Music music){
        return servicem.updateMusica(music);
    }

    @GetMapping("/titulo/{titulo}")
    public List<Music> getbyTitulo(@PathVariable String titulo){
        return servicem.getbyTitulo(titulo);
    }
    @GetMapping("/correo/{correo}")
    public Persona getCorreo(@PathVariable String correo){
        return service.getbyCorreo(correo);
    }
    @GetMapping("/nick/{artistname}")
    public List<Persona> getNick(@PathVariable String artistname){
        return service.getbyartistname(artistname);
    }
    @GetMapping("/nombre/{nombre}")
    public List<Persona> getNombre(@PathVariable String nombre){
        return service.getbyNombre(nombre);
    }
    @PutMapping
    public Persona modifyPersona(@RequestBody Persona persona){
        return service.updatePersona(persona);
    }
    @PutMapping("/musicaAPI/{id}")
    public Persona updateMusicaGuardada(@RequestBody String music, @PathVariable String id){return service.updateMusicaGuardada(music, id);}
    @PutMapping("/musicaUsuario/{id}/{IDMUSICA}")
    public Persona updateMusicaPersona( @PathVariable String id, @PathVariable String IDMUSICA){return service.updateMusicaPersona(IDMUSICA, id);}
    @PutMapping("/ultima/{id}/{codigo}")
    public Persona updateUltima(@PathVariable String id, @PathVariable String codigo){return service.updateUltima(id,codigo);}
    @DeleteMapping("/{id}")
    public String deletePersona(@PathVariable String id){
        return service.deletePersona(id);
    }
    @DeleteMapping("/musica/{id}/{idm}")
    public String deleteMusica(@PathVariable String id,@PathVariable String idm){
        return service.deleteMusica(id,idm);
    }
    @DeleteMapping("musicaGuardada/{id}")
    public String deleteMusica(@PathVariable String id){
        return servicem.deleteMusica(id);
    }
    @DeleteMapping("/musicaAPI/{id}/{idm}")
    public String deleteMusicaGuardada(@PathVariable String id,@PathVariable String idm){
        return service.deleteMusicaGuardada(id,idm);
    }
}
