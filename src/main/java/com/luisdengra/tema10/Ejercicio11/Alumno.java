package com.luisdengra.tema10.Ejercicio11;

import java.util.ArrayList;

public class Alumno {
    static int nId = 1000;
    private int id;
    private String nombre;
    private Grupo grupo;
    private ArrayList<Asignatura> asignaturas;

    public Alumno(String nombre, Grupo grupo, ArrayList<Asignatura> asignaturas) {
        this.id = nId;
        this.nombre = nombre;
        this.grupo = grupo;
        this.asignaturas = asignaturas;
        nId++;
    }

    public static int getnId() {
        return nId;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", grupo=" + grupo +
                ", asignaturas=" + asignaturas +
                '}'+'\n';
    }
}
