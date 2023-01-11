package com.kruger.loggin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "Musica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    @Id
    private String id;
    private String titulo;
    private String letra;
    private String anio;
    private String carilla;
    private String musica;
    private String nombre;
    private String idDueño;
}
