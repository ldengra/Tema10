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
                case 6:
                    jugar();
                    break;
                case 7:
                    //mostrarPuntuaciones();
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
            System.out.println("6. Jugar");
            System.out.println("---------------------------");
            System.out.println("0. Salir de la aplicación\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(input.nextLine());
            if(opcion < 0 || opcion > 7) {
                System.out.println("Elija una opción del menú [0-7]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 7);
        return opcion;
    }

    /**
     * Metodo para añadir palabra nueva en el diccionario, se introduce una palabra y si ya existe, lanza un mensaje
     * de que ya existe, sino te pide introducir la definicion.
     */
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

    /**
     * Introduce la palabra que quiere modificar, si existe pedira el nuevo significado, sino, dira que no existe.
     */
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

    /**
     * Metodo para eliminar una palabra, introduce la palabra que quieres borrar, si existe se eliminara, sino, dira que
     * no existe
     */
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

    /**
     * metodo para consultar la palabra deseada, si no existe lo notificara
     */
    public static void consultarPalabra(){
        String palabra;

        System.out.println("Introduce la palabra que quieres consultar: ");
        palabra = input.nextLine();

        if (miDiccionario.comprobarPalabra(palabra)){
            System.out.println(palabra + ": " + miDiccionario.obtenerSignificado(palabra));
        }
    }

    /**
     * Metodo para mostrar el diccionario entero.
     */
    public static void mostrarDiccionario(){
        System.out.println(miDiccionario.toString());
    }

    public static void jugar(){
        boolean fallo;

        do{

        }while (!fallo);

    }

    public static void palabrasPrueba(){
        miDiccionario.anyadirPalabra("hola","saludo");
        miDiccionario.anyadirPalabra("adios","despedida");
        miDiccionario.anyadirPalabra("comer","se hace al medio dia");
        miDiccionario.anyadirPalabra("merendar","se hace por la tarde");
        miDiccionario.anyadirPalabra("cenar","se hace por la noche");
    }
}
