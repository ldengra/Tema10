package com.luisdengra.tema10.Ejercicio10;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Empleado {
    /**
     * atributos
     */
    private String dni;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private float sueldo;
    private ArrayList<Hijo> listaHijos = new ArrayList<>();

    public Empleado(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, float sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public float getSueldo() {
        return sueldo;
    }

    public ArrayList<Hijo> getListaHijos() {
        return listaHijos;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sueldo=" + sueldo +
                ", listaHijos=" + listaHijos +
                '}' + '\n';
    }

    public void addHijo(Hijo h){
        listaHijos.add(h);
    }
    public void borrarHijo(Hijo h){
        listaHijos.remove(h);
    }
    public int getEdad(){
        LocalDate ahora = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, ahora);
        int a = periodo.getYears();
        return a;

    }

}
