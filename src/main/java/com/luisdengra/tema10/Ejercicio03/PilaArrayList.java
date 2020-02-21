package com.luisdengra.tema10.Ejercicio03;


import java.util.ArrayList;


public class PilaArrayList<T> implements IPila<T>{


    private ArrayList<T> pila = new ArrayList<T>();

    @Override
    /**
     * Metodo para insertar datos a la pila.
     */
    public T push(T dato) {
        pila.add(dato);
        return dato;
    }

    @Override
    /**
     * Este metodo es para usar el ultimo dato de la lista, vemos si no esta vacio y usamos el size-1 para la ultima
     * de la pila que estamos gastando, nos devuelve el dato que hay dentro de la lista y lo eliminamos
     */
    public T pop(){
        T dato = null; //cambiar y hacer que no devuelva un string vacio.
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
    public T top() {
        T dato = null;
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
