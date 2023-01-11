package com.kruger.loggin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection= "Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    @Id
    private String id;
    private String nombre;
    private String artistname;
    private String apellido;
    private String correo;
    private String contraseña;
    private String foto;
    private List<String> musicaPropia=new ArrayList<String>();
    private List<String> musicaGuardada=new ArrayList<String>();
    private String idUltima;

}
