package com.luisdengra.tema10.Ejercicio04;

import com.luisdengra.tema10.Ejercicio03.IPila;

import java.util.ArrayList;
import java.util.LinkedList;


public class ColaArrayList<T> implements ICola<T>{

    private ArrayList<T> cola = new ArrayList<T>();

    @Override
    public void add(T e) {
        cola.add(e);
    }

    @Override
    public T remove() {
        T dato = null;
        if(!isEmpty()) {
            dato = cola.get(0);
            cola.remove(0);
        }
        return dato;

    }

    @Override
    public int size() {
        return cola.size();
    }

    @Override
    public T peek() {
        return cola.get(0);
    }

    @Override
    public boolean isEmpty() {
        return cola.size()==0;
    }
}
