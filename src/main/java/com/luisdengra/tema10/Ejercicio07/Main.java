package com.luisdengra.tema10.Ejercicio07;
import com.luisdengra.tema10.Utils.Lib;
import java.util.Scanner;

public class Main {
    static Conversor conversor = new Conversor();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    convertirMoneda();
                    break;
                case 2:
                    //traducirPalabras();
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
            System.out.println("**   CONVERSOR DE LUIS   **");
            System.out.println("***************************");
            System.out.println("1. Convertir moneda...");
            System.out.println("2. Nuevo tipo de moneda...");

            System.out.println("---------------------------");
            System.out.println("0. Salir de la aplicación\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(input.nextLine());
            if(opcion < 0 || opcion > 2) {
                System.out.println("Elija una opción del menú [0-2]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 2);
        return opcion;
    }

    public static void convertirMoneda(){
        double euros, moneda, resultado;
        int opcion;

        do {

            System.out.println("Introduce la cantidad en euros que quieres convertir: ");
            euros = input.nextFloat();
            input.nextLine();
            System.out.println("------TIPO DE MONEDA------");
            System.out.println("1) USD (Dólar USA)");
            System.out.println("2) GBP (Libra esterlina)");
            System.out.println("3) INR (Rupia India)");
            System.out.println("4) AUD (Dólar Australiano)");
            System.out.println("5) CAD (Dólar Canadiense)");
            System.out.println("6) ARS (Peso Argentino)") ;
            System.out.println("7) BOB (Boliviano Boliviano)");
            System.out.println("8) CLP (Peso Chileno)");
            System.out.println("9) COP (Peso Colombiano)");
            System.out.println("10) CRC (Colón Costarricense)");
            System.out.println("11) CUP (Peso Cubano)");
            System.out.println("12) DOP (Peso Dominicano)");
            System.out.println("13) MXN (Peso Mexicano)");
            System.out.println("----------------------------------");
            System.out.println("0) SALIR");
            System.out.println("Introduce la opcion de la moneda:");
            opcion = input.nextInt();
            input.nextLine();

            moneda = conversor.seleccionarMoneda(opcion);

            resultado = euros*moneda;

            System.out.println(resultado);

        }while (opcion==0);


    }
}
