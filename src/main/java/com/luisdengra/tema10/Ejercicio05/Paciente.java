package com.luisdengra.tema10.Ejercicio05;

public class Paciente {

    private int identificador = 0;
    private String nombre;
    private String fNac;
    private char sexo = 'M';
    private float altura;
    private float peso;

    public Paciente(String nombre, String fNac, char sexo, float altura, float peso) {
        this.identificador = identificador+1;
        this.nombre = nombre;
        this.fNac = fNac;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public int getIdentificador() {
        return identificador;
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

