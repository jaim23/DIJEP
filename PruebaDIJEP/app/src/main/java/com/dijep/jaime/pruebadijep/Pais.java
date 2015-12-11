package com.dijep.jaime.pruebadijep;

/**
 * Created by Jaime on 10/12/2015.
 */
public class Pais {
    private String image;
    private String nombre;

    public Pais(){}

    public Pais(String image, String nombre) {
        this.image = image;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getImagen() {
        return image;
    }

    public void setImagen(String imagen){
        this.image = imagen;
    }
}