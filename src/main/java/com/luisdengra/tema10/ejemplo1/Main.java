package com.luisdengra.tema10.ejemplo1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        ArrayList<Libro> libros = new ArrayList<Libro>();

        /**
         * Creamos los objeto libro.
         */
        Libro l1 = new Libro("El libro de la selva", 280,123456);
        Libro l2 = new Libro("Mar adentro",69,234567);
        Libro l3 = new Libro("Lo que el viento se llevo",321,123457);
        Libro l4 = new Libro("Lujuria en el extraradio",125,234568);
        Libro l5 = new Libro("SuperMan",421,987654);

        /**
         * Añadimos los libros en el arralist
         */
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);
        libros.add(l4);
        libros.add(l5);

        /**
         * ordenamos los libros por el titutlo con la interfaz COMPARABLE
         */
        Collections.sort(libros);
        System.out.println(libros.toString());

        /**
         * ordenamos los libros por su numero de paginas con la interfaz COMPARATOR
         */
        libros.sort(new Libro.ComparatorPaginas());
        System.out.println(libros.toString());

        libros.sort(new Libro.ComparatorIsbn());
        System.out.println(libros.toString());
    }
}
