package com.luisdengra.tema10.Ejercicio05;
import com.luisdengra.tema10.Utils.Lib;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        int opcion;
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    Consultas.nuevoPaciente(nuevoPaciente());
                    break;
                case 2:
                    //venderBicicleta();
                    break;
                case 3:
                    //consultas();
                    break;
                case 4:
                    //mostrarStock();
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
            System.out.println("**  CONSULTORIO DE LUIS  **");
            System.out.println("***************************");
            System.out.println("1. Añadir paciente...");
            System.out.println("2. Consulat mayor y menor...");
            System.out.println("3. Consultar sexo...");
            System.out.println("4. Consultar IMC...");
            System.out.println("5. Consultar edad.");
            System.out.println("---------------------------");
            System.out.println("0. Salir\n");
            System.out.println("Elija una opción: ");
            opcion = Integer.parseInt(input.nextLine());
            if(opcion < 0 || opcion > 5) {
                System.out.println("Elija una opción del menú [0-5]");
                Lib.pausa();
            }
        } while (opcion < 0 || opcion > 4);
        return opcion;
    }

    public static Paciente nuevoPaciente(){
         String nombre;
         String fNac;
         char sexo;
         float altura;
         float peso;
         System.out.println("Introduce el nombre del paciente.");
         nombre = input.nextLine();
         System.out.println("Introduce la fecha de nacimiento 'dd/mm/aaaa'.");
         fNac = input.nextLine();
         System.out.println("Introduce el sexo del paciente. 'M/F'.");
         sexo = input.nextLine().charAt(0);
         System.out.println("Introduce la altura del paciente 'X.XX'.");
         altura = input.nextFloat();
         input.nextLine();
         System.out.println("Introduce el peso del paciente 'XX.X'.");
         peso = input.nextFloat();
         input.nextLine();

         Paciente p = new Paciente(nombre, fNac, sexo, altura, peso);

         return p;
    }


}
