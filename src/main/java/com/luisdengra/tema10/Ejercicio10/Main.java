package com.luisdengra.tema10.Ejercicio10;

import com.luisdengra.tema10.Utils.Lib;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
                    nuevoHijo();
                    break;
                case 3:
                    modificarSueldo();
                    break;
                case 4:
                    borrarEmpleado();
                    break;
                case 5:
                    borrarHijo();
                    break;
                case 6:
                    consultas();
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
            }
        } while(opcion != 0);

    }

    public static void consultas(){
        int opcion;
        do {
            opcion = menuConsulta();
            switch (opcion) {
                case 1:
                    buscarDni();
                    break;
                case 2:
                    buscarNombre();
                    break;
                case 3:
                    buscarRangoEdad();
                    break;
                case 4:
                    buscarRangoSueldo();
                    break;
                case 5:
                    buscarHijosMenores();
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

    public static int menuConsulta(){
        int opcion = -1;
        try {
            do {

                Lib.limpiarPantalla();
                System.out.println("***************************");
                System.out.println("**  CONSULTAS EMPLEADOS  **");
                System.out.println("***************************");
                System.out.println("1. Buscar por NIF...");
                System.out.println("2. Buscar por nombre...");
                System.out.println("3. Buscar por rango de edad...");
                System.out.println("4. Buscar por rango de sueldo...");
                System.out.println("5. Buscar por hijos menores de edad...");
                System.out.println("---------------------------");
                System.out.println("0. Salir de la aplicación\n");
                System.out.println("Elija una opción: ");
                opcion = Integer.parseInt(input.nextLine());
                if (opcion < 0 || opcion > 5) {
                    System.out.println("Elija una opción del menú [0-5]");
                    Lib.pausa();
                }
            } while (opcion < 0 || opcion > 5);

        }catch (NumberFormatException nfe){
            System.err.println("Introduce un numero, cafre");
        }
        return opcion;
    }

    public static void nuevoEmpleado(){
        boolean dniValido;
        String nombre="";
        String apellido="";
        float salario=0;
        String dni = obtindreDNI();
        dni = calcularNIF(dni);
        dniValido = Empresa.existEmpleado(dni);
        LocalDate fechaNacimiento = pedirFechaNacimiento();

        do{
            if(!dniValido){
                System.out.println("Introduce el nombre: ");
                nombre = input.nextLine();
                System.out.println("Introduce el apellido: ");
                apellido= input.nextLine();
                System.out.println("Introduce el salario: ");
                salario = input.nextFloat();
                input.nextLine();
            }else{
                System.out.println("El empleado con "+ dni + " ya existe");
                validado=false;
            }

        }while (!validado);

        Empleado e1 = new Empleado(dni,nombre,apellido, fechaNacimiento,salario);

        Empresa.listaEmpleados.add(e1);
        System.out.println(Empresa.listaEmpleados.get(0));
    }

    public static void nuevoHijo(){
        boolean dniValido;
        String nombre="";
        int edad;
        String dni = obtindreDNI();
        dni = calcularNIF(dni);
        dniValido = Empresa.existEmpleado(dni);

        if(dniValido){
            System.out.println("Introduce el nombre del hijo: ");
            nombre = input.nextLine();
            System.out.println("Introduce la edad del hijo: ");
            edad = input.nextInt();
            input.nextLine();

            Hijo h1 = new Hijo(nombre,edad);
            Empleado e = Empresa.buscarEmpleado(dni);
            e.addHijo(h1);
        }else {
            System.out.println("EL empleado no existe.");
        }

    }

    public static void modificarSueldo(){
        boolean dniValido;
        String dni = obtindreDNI();
        float sueldo;
        dni = calcularNIF(dni);
        dniValido = Empresa.existEmpleado(dni);
        Empleado e = Empresa.buscarEmpleado(dni);
        if(dniValido){
            System.out.println("Introduce el sueldo nuevo: ");
            sueldo = input.nextFloat();
            input.nextLine();
            Empresa.modificarSueldo(e, sueldo);
        }else {
            System.out.println("El empleado no existe.");
        }
    }

    public static void borrarEmpleado(){
        boolean dniValido;
        String dni = obtindreDNI();
        dni = calcularNIF(dni);
        dniValido = Empresa.existEmpleado(dni);
        Empleado e = Empresa.buscarEmpleado(dni);

        if(dniValido){
            Empresa.borrarEmpleado(e);
        }else{
            System.out.println("El empleado no existe o ya fue borrado");
        }
    }

    public static void borrarHijo(){
        boolean dniValido;
        String dni = obtindreDNI();
        dni = calcularNIF(dni);
        dniValido = Empresa.existEmpleado(dni);
        Empleado e = Empresa.buscarEmpleado(dni);
        if(dniValido){
            //e.borrarHijo();
        }
    }

    public static String obtindreDNI() {
        System.out.println("Indica tu DNI: ");
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

    public static void buscarDni(){
        String dni = obtindreDNI();
        Empleado e = Empresa.buscarDni(dni);
        if (e == null){
            System.out.println("El empleado no existe");
        }else{
            System.out.println(e.toString());
        }
    }

    public static void buscarNombre(){
        String nombre;
        System.out.println("Introduce nombre");
        nombre=input.nextLine();
        ArrayList<Empleado> encontrados = new ArrayList<Empleado>();
        Empresa.buscarNombre(nombre);
        if (encontrados.size() == 0){
            System.out.println("No se han encontrado empleados");
        }else{
            System.out.println(encontrados.toString());
        }
    }

    public static void buscarRangoEdad(){
        int[] rango = pedirRango();
        ArrayList<Empleado> encontrados = Empresa.buscarPorEdad(rango[0], rango[1]);
        if (encontrados.size() == 0){
            System.out.println("No se han encontrado empleados");
        }else{
            System.out.println(encontrados.toString());
        }
    }

    public static int[] pedirRango(){
        int[] rango = new int[2];//La primera posición es el mínimo y la segunda el máximo
        do {
            try{
                System.out.println("Introduce el mínimo de edad");
                rango[0] = Integer.parseInt(input.nextLine());
                if (rango[0] > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.err.println("No puedes introducir números negativos");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.err.println("Deben ser dígitos");
            }
        }while (!validado);
        do {
            try{
                System.out.println("Introduce el máximo de edad que debe tener el empleado");
                rango[1] = Integer.parseInt(input.nextLine());
                if (rango[1] > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.err.println("No puedes introducir números negativos");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.err.println("Deben ser dígitos");
            }
        }while (!validado);
        return rango;
    }

    public static void buscarRangoSueldo(){
        double min;
        double max;
        System.out.println("Introduce el sueldo mínimo");
        min = input.nextDouble();
        System.out.println("Introduce el sueldo máximo");
        max = input.nextDouble();
        ArrayList<Empleado> encontrados = Empresa.buscarPorSueldo(min, max);
        if (encontrados.size() == 0){
            System.out.println("No se han encontrado empleados entre ese rango de sueldos");
        }else{
            System.out.println(encontrados.toString());
        }
    }

    public static void buscarHijosMenores(){
        ArrayList<Empleado> encontrados = Empresa.buscarPorHijosMenores();
        if (encontrados.size() == 0){
            System.out.println("No se han encontrado empleados");
        }else{
            System.out.println(encontrados.toString());
        }
    }

}




