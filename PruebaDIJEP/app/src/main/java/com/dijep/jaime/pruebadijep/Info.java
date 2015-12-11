package com.dijep.jaime.pruebadijep;

/**
 * Created by Jaime on 11/12/2015.
 */
public class Info {
    private int h;
    private String nombre;

    public Info(){}

    public Info(int h, String nombre) {
        this.h = h;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getHabitantes() {
        return h;
    }

    public void setHabitantes(int h){
        this.h = h;
    }
}
