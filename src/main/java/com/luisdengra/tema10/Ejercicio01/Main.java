package com.luisdengra.tema10.Ejercicio01;

import com.luisdengra.tema10.Utils.Lib;

import java.util.ArrayList;

public class Main {
    /**
     * He creado los array y arrayList estaticos para poder usarlos en toda la clase main. De esta manera
     * cuando hago las llamadas a los metodos, me ahorro poner el argumento del objeto con el que quiero trabajar
     */
    static int[] array = new int[10];
    static ArrayList<Integer> numeros = new ArrayList<Integer>();
    static ArrayList<Integer> numerosOrdenados = new ArrayList<Integer>();

    /**
     * Desde el main lo unico que hago es llamar a los metodos por orden y despues imprimir el array y el arrayList
     * @param args
     */
    public static void main(String[] args) {

        crearArray();
        crearArrayList();
        ordenarArrayListParImpar();

        System.out.println("Array generado: ");
        for(int i = 0 ; i < array.length ; i++){
            System.out.print(array[i]+"  ");
        }
        System.out.println();

        System.out.println("ArrayList con pares-impares: ");
        for(int i = 0 ; i < numerosOrdenados.size() ; i++){
            System.out.print(numerosOrdenados.get(i)+"  ");
        }
    }

    /**
     * Metodo para rellenar arrays con numeros de manera aleatoria. Uso la libreria que tengo en el proyecto
     * con mis metodos creados
     */
    static void crearArray(){

        for(int i = 0; i < array.length; i++){
            array[i]= Lib.aleatorio(0,50);
        }
    }

    /**
     * Con este metodo lo que hago es crear el ArrayList a partir del array creado antes, con el bucle voy añadiendo
     * los numeros del array a mi nuevo arrayList
     */
    static void crearArrayList(){

        for(int i = 0; i<array.length; i++){
            numeros.add(array[i]);
        }
    }

    /**
     * Con este metodo lo que hago es ordenar a la derecha los numeros pares y a la izquierda los impares.
     * para eso, he creado un arrayList nueva que usare para pasar los datos de una lista a la otra, comparo si
     * el numero es impar, si lo es, lo añado a la lista y lo mismo con los numeros si son pares. Lo hago de esta manera
     * para que el orden sea el que se ha pedido. No se me ha ocurrido una manera mas eficiente de hacerlo
     */
    static void ordenarArrayListParImpar(){
        int aux;

        for (int i=0;i < numeros.size();i++){
            if (numeros.get(i)%2!=0){
                aux = numeros.get(i);
                numerosOrdenados.add(0, aux);
            }
        }
        for (int i=0;i < numeros.size();i++){
            if (numeros.get(i)%2==0){
                aux = numeros.get(i);
                numerosOrdenados.add(0, aux);
            }
        }
    }
}
