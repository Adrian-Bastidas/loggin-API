package com.kruger.loggin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
