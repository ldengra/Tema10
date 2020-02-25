package com.luisdengra.tema10.Ejercicio05;

import java.util.ArrayList;

public class Paciente extends ArrayList {

    private int identificador = 0;
    private String nombre;
    private String fNac;
    private int edad;
    private char sexo = 'M';
    private float altura;
    private float peso;

    public Paciente(String nombre, String fNac, int edad, char sexo, float altura, float peso) {
        this.identificador = identificador+1;
        this.nombre = nombre;
        this.fNac = fNac;
        this.edad = edad;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getEdad() {
        return edad;
    }


    public String getNombre() {
        return nombre;
    }

    public String getfNac() {
        return fNac;
    }

    public char getSexo() {
        return sexo;
    }

    public float getAltura() {
        return altura;
    }

    public float getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", fNac='" + fNac + '\'' +
                ", sexo=" + sexo +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}

