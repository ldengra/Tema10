package com.luisdengra.tema10.Ejercicio07;

import java.util.HashMap;

public class Conversor {

    HashMap<Integer, Double> conversor;

    public Conversor(){
        this.conversor = new HashMap<>();
        conversor.put(1,1.088);
        conversor.put(2,0.836);
        conversor.put(3,78.214);
        conversor.put(4,1.648);
        conversor.put(5,1.445);
        conversor.put(6,67.206);
        conversor.put(7,7.518);
        conversor.put(8,884.151);
        conversor.put(9,3737.95);
        conversor.put(10,620.433);
        conversor.put(11,28.830);
        conversor.put(12,58.308);
        conversor.put(13,20.759);
    }

    public double seleccionarMoneda(int k){
        return conversor.get(k);
    }
}
