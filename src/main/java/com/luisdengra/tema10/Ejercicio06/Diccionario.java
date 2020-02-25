package com.luisdengra.tema10.Ejercicio06;

import java.util.HashMap;

public class Diccionario {

    HashMap<String, String> diccionario;

    public Diccionario() {
        this.diccionario = new HashMap<>();
    }

    public void anyadirPalabra(String p1, String p2){
        diccionario.put(p1,p2);
    }

    public String traducirPalabra(String p1){
        return diccionario.get(p1);
    }
}
