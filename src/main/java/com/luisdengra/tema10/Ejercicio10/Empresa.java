package com.luisdengra.tema10.Ejercicio10;

import java.util.ArrayList;

public class Empresa {


    /**
     * atributos
     */
    static ArrayList<Empleado>listaEmpleados = new ArrayList<Empleado>();


    public void casosDePrueba(){
        ArrayList<Empleado>empleadosPrueba = new ArrayList<Empleado>();
        //Empleado eP1 = new Empleado("12345678A","Alberto","Sentí",1212,1200);
    }

    public static ArrayList<Empleado> buscarPorEdad(int min, int max){
        ArrayList<Empleado> encontrados = new ArrayList<>();
        Empleado e;
        for (int i = 0; i < listaEmpleados.size() ; i++) {
            e = listaEmpleados.get(i);
            if (e.getEdad() >= min && e.getEdad() <= max){
                encontrados.add(e);
            }
        }
        return encontrados;
    }

    public static ArrayList<Empleado> buscarPorHijosMenores(){
        ArrayList<Empleado> encontrados = new ArrayList<>();
        int edadHijo;
        boolean encontrado;
        Empleado e;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            e = listaEmpleados.get(i);
            encontrado = false;
            for (int j = 0; j < e.getListaHijos().size(); j++) {
                edadHijo = e.getListaHijos().get(i).getEdad();
                if (edadHijo < 18 && !encontrado){
                    encontrados.add(e);
                    encontrado = true;
                }
            }
        }
        return encontrados;
    }

    public static ArrayList<Empleado> buscarPorSueldo(double min, double max){
        ArrayList<Empleado> encontrados = new ArrayList<>();
        Empleado e;
        for (int i = 0; i < listaEmpleados.size() ; i++) {
            e = listaEmpleados.get(i);
            if (e.getSueldo() >= min && e.getSueldo() <= max){
                encontrados.add(e);
            }
        }
        return encontrados;
    }

    public static ArrayList<Empleado> buscarNombre(String nombre){
        ArrayList<Empleado> encontrados = new ArrayList<>();
        String nombreAux;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            nombreAux = listaEmpleados.get(i).getNombre();
            if (nombreAux.contains(nombre)){
                encontrados.add(listaEmpleados.get(i));
            }
        }
        return encontrados;
    }

    public static Empleado buscarDni(String dni){
        String dniAux;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            dniAux = listaEmpleados.get(i).getDni();
            if (dniAux.equals(dni)){
                return listaEmpleados.get(i);
            }
        }
        return null;
    }

    public static boolean existEmpleado(String dni){
        String auxDni;
        for(int i = 0; i<listaEmpleados.size();i++){
            auxDni = listaEmpleados.get(i).getDni();
            if(dni.equals(auxDni)) {
                return true;
            }
        }
        return false;
    }

    public static Empleado buscarEmpleado(String dni){

        for (Empleado e : listaEmpleados){
            if(e.getDni().equals(dni)){
                return e;
            }
        }
        return null;
    }

    public static void modificarSueldo(Empleado e, float s){
        e.setSueldo(s);
    }

    public static void borrarEmpleado(Empleado e){
        listaEmpleados.remove(e);
    }

    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < listaEmpleados.size() ; i++) {
            aux += listaEmpleados.get(i).toString() + "\n";
        }
        return aux;
    }
}

