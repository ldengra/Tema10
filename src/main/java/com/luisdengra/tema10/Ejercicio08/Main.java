package com.luisdengra.tema10.Ejercicio08;

import com.luisdengra.tema10.Utils.Lib;

import java.util.Scanner;

public class Main {
    static Diccionario miDiccionario = new Diccionario();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int opcion;
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    nuevaPalabra();
                    break;
                case 2:
                    modificarPalabra();
                    break;
                case 3:
                    eliminarPalabra();
                    break;
                case 4:
                    consultarPalabra();
                    break;
                case 5:
                    mostrarDiccionario();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while(opcion != 0);


    }
    public static int menuPrincipal() {
        int opcion = -1;
        do {

            Lib.limpiarPantalla();
            System.out.println("***************************");
            System.out.println("**  DICCIONARIO DE LUIS  **");
            System.out.println("***************************");
            System.out.println("1. Añadir palabra...");
            System.out.println("2. Modificar palabra...");
            System.out.println("3. Eliminar palabra...");
            System.out.println("4. Consultar palabra...");
            System.out.println("5. Mostrar diccionario...");
            System.out.println("---------------------------");
            System.out.println("0. Salir de la aplicación\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(input.nextLine());
            if(opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-5]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    public static void nuevaPalabra(){

        String palabra ="";
        String significado ="";

        System.out.println("Introduce la nueva palabra que quieres introducir: ");
        palabra = input.nextLine();

        if(!miDiccionario.comprobarPalabra(palabra)){
            System.out.println("Introduce el significado de la palabra");
            significado = input.nextLine();
        }else {
            System.out.println("La palabra introducida ya existe.");
        }

        miDiccionario.anyadirPalabra(palabra, significado);
    }

    public static void modificarPalabra(){

        String palabra="";
        String significado="";
        System.out.println("Introduce la palabra que quieres modificar.");
        palabra = input.nextLine();

        if(miDiccionario.comprobarPalabra(palabra)){
            System.out.println("Introduce el nuevo significado: ");
            significado = input.nextLine();
        }else {
            System.out.println("La palabra no existe");
        }
        miDiccionario.modificarSignificado(palabra,significado);
    }

    public static void eliminarPalabra(){

        String palabra;

        System.out.println("Introduce la palabra que quieres eliminar: ");
        palabra = input.nextLine();
        if (miDiccionario.comprobarPalabra(palabra)){
            miDiccionario.eliminarPalabra(palabra);
        }else {
            System.out.println("La palabra no existe");
        }
    }

    public static void consultarPalabra(){
        String palabra;

        System.out.println("Introduce la palabra que quieres consultar: ");
        palabra = input.nextLine();

        if (miDiccionario.comprobarPalabra(palabra)){
            System.out.println(palabra + ": " + miDiccionario.obtenerSignificado(palabra));
        }
    }

    public static void mostrarDiccionario(){
        System.out.println(miDiccionario.toString());
    }
}
