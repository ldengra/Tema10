package com.luisdengra.tema10.Ejercicio02;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayListEstadisticas estadistica = new ArrayListEstadisticas();

        estadistica.add(20.1);
        estadistica.add(20.2);
        estadistica.add(20.3);
        estadistica.add(20.1);
        estadistica.add(20.6);
        estadistica.add(20.9);
        estadistica.add(21.9);

        System.out.println("El Array List es: " + estadistica.toString());
        System.out.printf("La media del Array es: %2.2f %n", estadistica.media());
        System.out.printf("El mínimo es: %2.2f %n", estadistica.minimo());
        System.out.printf("El máximo es: %2.2f %n", estadistica.maximo());
        System.out.printf("El sumatorio es: %2.2f %n", estadistica.sumatorio());
        System.out.printf("El moda es: %2.2f %n", estadistica.moda());
        System.out.println(estadistica.modaHasMap());
    }
}
