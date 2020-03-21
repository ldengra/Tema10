package com.luisdengra.tema10.Ejercicio11;

public class Asignatura {
    private int id;
    private String nombre;
    private Profesor profesor;

    public Asignatura(int id, String nombre, Profesor profesor) {
        this.id = id;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", profesor=" + profesor +
                '}'+'\n';
    }
}
