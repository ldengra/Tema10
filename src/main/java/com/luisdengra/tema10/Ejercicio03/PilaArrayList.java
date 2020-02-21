package com.luisdengra.tema10.Ejercicio03;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class PilaArrayList implements IPila{


    private ArrayList<String> pila = new ArrayList<>();

    @Override
    public Object push(Object e) {
        return null;
    }

    @Override
    /**
     * Este metodo es para usar el ultimo dato de la lista, vemos si no esta vacio y usamos el size-1 para la ultima
     * de la pila que estamos gastando, nos devuelve el dato que hay dentro de la lista y lo eliminamos
     */
    public String pop(){
        String dato = "";
        if(!isEmpty()){
            dato=pila.get(pila.size()-1);
            pila.remove(pila.size()-1);
        }
        return dato;
    }

    @Override
    /**
     * Metodo para ver el tamaño de la lista.
     */
    public int size(){
        return pila.size();
    }


    @Override
    /**
     * metodo para ver el ultimo elemento de la lista introducido SIN borrarlo
     */
    public String top() {
        String dato = "";
        if(!isEmpty()){
            dato=pila.get(pila.size()-1);
        }
        return dato;
    }

    @Override
    /**
     * Boolean para ver si la lista esta vacia, si el size es 0, es que no hay ningun elemento
     */
    public boolean isEmpty() {
        return pila.size()==0;
    }
}
