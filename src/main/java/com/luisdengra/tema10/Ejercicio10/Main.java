package com.luisdengra.tema10.Ejercicio10;

import com.luisdengra.tema10.Utils.Lib;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    static boolean validado;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    nuevoEmpleado();
                    break;
                case 2:
                    //nuevoHijo();
                    break;
                case 3:
                    //modificarSueldo();
                    break;
                case 4:
                    //borrarEmpleado();
                    break;
                case 5:
                    //borrarHijo();
                    break;
                case 6:
                    //Consultas();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while(opcion != 0);

    }

    public static int menuPrincipal() {
        int opcion = -1;

        try {
            do {

                Lib.limpiarPantalla();
                System.out.println("***************************");
                System.out.println("**   GESTIÓN EMPLEADOS   **");
                System.out.println("***************************");
                System.out.println("1. Nuevo empleado...");
                System.out.println("2. Nuevo hijo...");
                System.out.println("3. Modificar sueldo...");
                System.out.println("4. Borrar empleado...");
                System.out.println("5. Borrar hijo...");
                System.out.println("6. Consultas...");
                System.out.println("---------------------------");
                System.out.println("0. Salir de la aplicación\n");
                System.out.println("Elija una opción: ");
                opcion = Integer.parseInt(input.nextLine());
                if (opcion < 0 || opcion > 6) {
                    System.out.println("Elija una opción del menú [0-6]");
                    Lib.pausa();
                }
            } while (opcion < 0 || opcion > 6);

        }catch (NumberFormatException nfe){
            System.err.println("Introduce un numero, cafre");
        }
        return opcion;
    }

    public static void nuevoEmpleado(){

        String dni = obtindreDNI();
        if( ){

        }

        String nombre;
        String apellido;
        LocalDate fechaNacimiento = pedirFechaNacimiento();
        System.out.println("El NIF es " + calcularNIF(dni));
    }

    public static String obtindreDNI() {
        System.out.print("Indica tu DNI: ");
        return input.nextLine();
    }

    public static String calcularNIF(String dni) {
        String tabla = new String("TRWAGMYFPDXBNJZSQVHLCKE");
        int dniEntero = Integer.parseInt(dni);
        int posLetra = dniEntero % 23;
        return dni+tabla.charAt(posLetra);
    }

    /**
     * Método para pedir la fecha de nacimiento del paciente
     * @return devuelve la fecha ya validada
     */
    public static LocalDate pedirFechaNacimiento(){

        LocalDate fechaNacimiento = null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        do {
            Lib.limpiarPantalla();
            System.out.println("Fecha de nacimiento (dd-mm-yyyy): ");
            String fechaNacimientoString = input.nextLine();
            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoString,fmt);
                validado = true;
            } catch (DateTimeParseException dtpe) {
                validado = false;
                System.out.println("El formato de la fecha de fabricación no es válido. Recuerde (dd-mm-yyyy).");
                Lib.pausa();
            }
        } while (!validado);
        return fechaNacimiento;
    }

}




