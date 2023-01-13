package com.kruger.loggin.controller;

import com.kruger.loggin.model.Music;
import com.kruger.loggin.model.Persona;
import com.kruger.loggin.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/usuarios")
public class PersonaController {

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
    @GetMapping("/{id}")
    public Persona getPersona(@PathVariable String id){
        return service.getbyId(id);
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
    @PutMapping("/musicaUsuario/{id}")
    public Persona updateMusicaPersona(@RequestBody String music, @PathVariable String id){return service.updateMusicaPersona(music, id);}
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
    @DeleteMapping("/musicaAPI/{id}/{idm}")
    public String deleteMusicaGuardada(@PathVariable String id,@PathVariable String idm){
        return service.deleteMusicaGuardada(id,idm);
    }
}
