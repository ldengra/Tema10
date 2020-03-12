package com.luisdengra.tema10.Ejercicio10;

import java.util.ArrayList;

public class Empresa {

    /**
     * atributos
     */
    ArrayList<Empleado>listaEmpleados = new ArrayList<Empleado>();


    public void casosDePrueba(){
        ArrayList<Empleado>empleadosPrueba = new ArrayList<Empleado>();
        //Empleado eP1 = new Empleado("12345678A","Alberto","Sentí",1212,1200);
    }

    public boolean existEmpleado(String dni){
        String auxDni;
        for(int i = 0; i<listaEmpleados.size();i++){
            auxDni = listaEmpleados.get(i).getDni();
            if(dni.equals(auxDni)) {
                return true;
            }
        }
        return false;
    }
}
