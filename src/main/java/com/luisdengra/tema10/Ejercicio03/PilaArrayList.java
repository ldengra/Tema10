package com.luisdengra.tema10.Ejercicio03;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;

public class PilaArrayList extends Stack, List implements IPila{

    private int contador; //numero elementos
    private ArrayList<String> pila = new ArrayList();
    //constructor




    /**
     *
     * @param size es el parametro entero que queremos que mida el array, cuando creamos el objeto, le pasamos como
     *             parametro el size
     */
    public PilaArrayList(int size) {
        contador = 0;
    }
    @Override
    public Object push(Object e) {

        return null;
    }

    @Override
    public Object pop() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Object top() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
