package com.luisdengra.tema10.Ejercicio08;

import java.util.HashMap;
import java.util.Iterator;

public class Diccionario {

    HashMap<String, String> diccionario;

    public Diccionario() {
        this.diccionario = new HashMap<>();
    }

    public void anyadirPalabra(String p1, String p2){
        diccionario.put(p1,p2);
    }

    public boolean comprobarPalabra(String p){
        return (diccionario.containsKey(p));
    }

    public void modificarSignificado(String p, String significado){
        diccionario.replace(p,significado);
    }

    public void eliminarPalabra(String p){
        diccionario.remove(p);
    }

    public HashMap<String, String> getDiccionario() {
        return diccionario;
    }

    public String obtenerSignificado(String p){
        return diccionario.get(p);
    }

    public String toString(){
        String aux="";
        String cadena = "";
        Iterator<String> iter = diccionario.keySet().iterator();

        while (iter.hasNext()){
            aux = iter.next();
            cadena += aux + ": " + diccionario.get(aux) + "\n";
        }
        return cadena;
    }
}
