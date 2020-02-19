package com.luisdengra.tema10.Utils;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Lib {
    public static Scanner lector = new Scanner(System.in);

    /**
     * Borra la pantalla
     */
    public static void limpiarPantalla() {
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }

    /**
     * Solicita INTRO para continuar
     */
    public static void pausa() {
        System.out.println("Pulsa INTRO para continuar...");
        lector.nextLine();
    }

    /**
     * Genera un número aleatorio dentro del rango de los números enteros
     * @return
     */
    public static int aleatorio() {
        Random r = new Random();
        return r.nextInt();
    }

    /**
     * Genera un número entero aleatorio entre un min y un max
     * @param min Valor mínimo a generar
     * @param max Valor máximo a generar
     * @return Número aleatorio generado
     */
    public static int aleatorio(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min +1 ) + min;
    }

    /**
     * Genera un número real (double) aleatorio entre un min y un max
     * @param min Valor mínimo a generar
     * @param max Valor máximo a generar
     * @return Número aleatorio generado
     */
    public static double aleatorio(double min, double max) {
        Random r = new Random();
        return min + r.nextDouble() * (max - min);
    }


    /**
     * Genera un número real (float) aleatorio entre un min y un max
     * @param min Valor mínimo a generar
     * @param max Valor máximo a generar
     * @return Número aleatorio generado
     */
    public static float aleatorio(float min, float max) {
        Random r = new Random();
        return min + r.nextFloat() * (max - min);
    }

    /**
     * Ordena una array
     * @param vector Array a ordenar
     */
    public static void ordenar(int[] vector) {
        boolean hayCambios = true;
        while(hayCambios) {
            hayCambios = false;
            for(int i = 0; i < vector.length - 1; i++) {
                if(vector[i] > vector[i+1]) {
                    intercambio(vector, i, i + 1);
                    hayCambios = true;
                }
            }
        }
    }

    /**
     * Determina si un elemento está en el array
     * @param vector Array sobre el que se realiza la búsqueda
     * @param x Valor buscado
     * @return La posición si elemento se encuentra en el array, -1 en caso contrario
     */
    public static int indexOf(int[] vector, int x) {
        for(int i = 0; i < vector.length; i++) {
            if(vector[i] == x) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Intercambia dos posiciones de un array
     * @param vector Array a intercambiar
     * @param i primera posición a intercambiar
     * @param j segunda posición a intercambiar
     */
    public static void intercambio(int[] vector, int i, int j) {
        int aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;
    }
}

