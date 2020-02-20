package com.luisdengra.tema10.Ejercicio02;

import java.util.ArrayList;

public class ArrayListEstadisticas implements MiInterface.IEstadisticas{

     private ArrayList<Double> estadistica = new ArrayList();


    @Override
    /**
     * Metodo para obtener el minimo del arrayList, comparo el numero de la lista con el numero mas alto hasta encontrar
     * el mas bajo
     */
    public double minimo() {
        double minimo = Double.MAX_VALUE;
        for(int i = 0 ; i < estadistica.size() ; i++){
            if(estadistica.get(i)<minimo){
                minimo = estadistica.get(i);
            }
        }

        return minimo;
    }

    @Override
    /**
     * Metodo para obtener el minimo del arrayList, comparo el numero de la lista con el numero mas bajo hasta encontrar
     * el mas alto
     */
    public double maximo() {

        double maximo = Double.MIN_VALUE;
        for(int i = 0 ; i < estadistica.size() ; i++){
            if(estadistica.get(i)>maximo){
                maximo = estadistica.get(i);
            }
        }
        return maximo;
    }

    @Override
    /**
     * Metodo para sumar la lista entera, recorro la lista y voy sumando el contenido de cada indice
     */
    public double sumatorio() {
        double contador = 0;

        for(int i = 0 ; i < estadistica.size() ; i++){
            contador += estadistica.get(i);
        }
        return contador;
    }

    @Override
    /**
     * Metodo para sacar la media de toda la lista, uso el sumatorio y divido entre la longitud de la lista
     */
    public double media() {

        return sumatorio() / estadistica.size();
    }

    @Override
    /**
     * Metodo para sacar la moda de la lista. Para ello anido 2 bucles, uso un contador para ver cuantas veces esta el
     * numero repetido, y el numero que este mas veces, es la moda
     */
    public double moda() {
        int contador = 0;
        int contadorAux;
        double num = 0;
        double elemento;
        for (int i = 0; i < estadistica.size() ; i++) {
            contadorAux = 0;
            elemento = estadistica.get(i);
            for (int j = 0; j < estadistica.size() ; j++) {
                if (elemento == estadistica.get(j)){
                    contadorAux++;
                }
            }
            if (contador < contadorAux){
                num = elemento;
                contador = contadorAux;
            }
        }
        return num;
    }

    /**
     * Metodo para añadir numeros a la lista. Se añade el numero sin borrar el dato anterior
     * @param n numero que queremos introducir a la lista
     */
    public void add(double n){
        estadistica.add(n);
    }

    /**
     * metodo sobrecargado para introducir un numero en el indice que queramos. Se añade sin borrar el numero que
     * habia antes, desplaza los numeros desde el indice hacia la derecha
     * @param index indice que queremos introducir el numero
     * @param n numero qe queremos introducir
     */
    public void add(int index, double n){
        estadistica.add(index, n);
    }

    /**
     * Metodo para eliminar el contenido de una posicion
     * @param index indice que queremos borrar
     */
    public void remove(int index){
        estadistica.remove(index);
    }

    /**
     * Metodo para borrar la lista entera
     */
    public void clear(){
        estadistica.clear();

    }

    /**
     * Metodo para ver si la lista esta vacia. Si lo esta, nos devolvera un TRUE
     */
    public void isEmpty(){
        estadistica.isEmpty();
    }

    /**
     * Metodo para leer(coger) el numero que esta en el indice que le indicamos
     * @param index Indice de la lista que queremos saber su informacion
     */
    public void get(int index){
        estadistica.get(index);
    }

    /**
     * Metodo para modificar el contenido de una lista,
     * @param index el index que queremos modificar
     * @param n el dato nuevo que queremos introducir
     */
    public void set(int index, double n){
        estadistica.set(index, n);
    }

    @Override
    public String toString() {
        return "ArrayListEstadisticas{" +
                "estadistica=" + estadistica +
                '}';
    }
}
