package com.luisdengra.tema10.Ejercicio06;

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
                    introducirPalabras();
                    break;
                case 2:
                    traducirPalabras();
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
            System.out.println("1. Introducir pareja de palabras...");
            System.out.println("2. Traducir palabras...");

            System.out.println("---------------------------");
            System.out.println("0. Salir de la aplicación\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(input.nextLine());
            if(opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-2]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 2);
        return opcion;
    }

    public static void introducirPalabras(){
        int nParejas;
        String p1, p2;

        System.out.println("Cuantas parejas deseas introducir?");
        nParejas = input.nextInt();
        input.nextLine();

        for (int i = 0 ; i < nParejas ; i++){
            System.out.println("Introduce la palabra en ingles: ");
            p1 = input.nextLine().toLowerCase().trim();
            System.out.println("Introduce traduccion al valenciano: ");
            p2 = input.nextLine().toLowerCase().trim();
            miDiccionario.anyadirPalabra(p1,p2);
        }
    }

    public static void traducirPalabras(){
        String p1;

        System.out.println("Introduce la palabra que quieres traducir: ");
        p1 = input.nextLine().toLowerCase();

        System.out.println(miDiccionario.traducirPalabra(p1));

    }
}
