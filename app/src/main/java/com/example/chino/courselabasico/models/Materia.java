package com.example.chino.courselabasico.models;

/**
 * Created by FAMILY on 25/12/2016.
 */

public class Materia
{
    private int      id;
    private String   nombre;
    private int      imagenId;

    public Materia ( int id, String nombre, int imagenId )
    {
        this.id         = id;
        this.nombre     = nombre;
        this.imagenId   = imagenId;
    }

    public Materia ( String nombre, int imagenId )
    {
        this.nombre     = nombre;
        this.imagenId   = imagenId;
    }

    public int getId() {
        return id;
    }

    public Materia setId(int id) {
        this.id = id;

        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Materia setNombre(String nombre) {
        this.nombre = nombre;

        return this;
    }

    public int getImagenId() {
        return imagenId;
    }

    public Materia setImagenId(int imagenId) {
        this.imagenId = imagenId;

        return this;
    }
}
