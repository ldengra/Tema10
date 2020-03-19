package com.luisdengra.tema10.Ejercicio11;

public class Grupo {
    private int id;
    private String nombre;
    private Aula aula;

    public Grupo(int id, String nombre, Aula aula) {
        this.id = id;
        this.nombre = nombre;
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Aula getAula() {
        return aula;
    }
}
