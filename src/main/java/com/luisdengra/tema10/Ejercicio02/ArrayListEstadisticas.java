package com.luisdengra.tema10.Ejercicio02;

import java.util.ArrayList;

public class ArrayListEstadisticas implements MiInterface.IEstadisticas{

    static ArrayList<Double> estadistica = new ArrayList<Double>();

    public static void main(String[] args) {

        estadistica.add(20.5);
        estadistica.add(20.3);
        estadistica.add(20.8);
        estadistica.add(20.9);
        estadistica.add(20.1);
        estadistica.add(20.1);
        estadistica.add(20.5);
        estadistica.add(20.6);
        estadistica.add(20.7);




    }

    @Override
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
    public double sumatorio() {
        //no se si sacar el sumatorio de cada elemento del array list o que...
        return 0;
    }

    @Override
    public double media() {
        double media = 0;
        for (int i = 0 ; i < estadistica.size() ; i++){
            media += estadistica.get(i);
        }

        media = media / estadistica.size();
        return media;
    }

    @Override
    public double moda() {
        return 0;
    }
}
