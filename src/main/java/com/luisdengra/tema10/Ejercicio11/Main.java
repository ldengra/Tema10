package com.luisdengra.tema10.Ejercicio11;
import com.luisdengra.tema10.Utils.Lib;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner input;
    static boolean validado;
    static Centro centro;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        //casosPrueba();
        int opcion;
        centro = new Centro();
        boolean salir = false;
        do {
            opcion = mostrarMenu();//Opcion del menu validada
            switch (opcion){//Menu principal de la app
                case 1:
                    nuevoAlumno();
                    break;
                case 2:
                    nuevoProfesor();
                    break;
                case 3:
                    //nuevaAula();
                    break;
                case 4:
                    //nuevaAsignatura();
                    break;
                case 5:
                    //nuevoGrupo();
                    break;
                case 6:
                    //consultas();
                    break;
                case 0:
                    salir = true;
                    break;
            }
        }while (!salir);
    }

    public static int mostrarMenu(){
        int opcion = -1;
        do {
            try {
                System.out.println("*********************");
                System.out.println("* GESTIÓN DE CENTRO *");
                System.out.println("*********************");
                System.out.println("1. Nuevo alumno.");
                System.out.println("2. Nuevo profesor.");
                System.out.println("3. Nueva aula.");
                System.out.println("4. Nueva asignatura.");
                System.out.println("5. Nuevo grupo.");
                System.out.println("6. Consultas");
                System.out.println("-----------------------");
                System.out.println("0. Salir");
                opcion = Integer.parseInt(input.nextLine()) ;
                if (opcion >= 0 && opcion <= 6){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción incorrecta!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Solo números");
            }
        }while(!validado);
        return opcion;
    }

    public static void nuevoAlumno(){
        String nombre;
        Grupo grupo = null; //lo inicio en null porque sino no me deja crear el objeto alumno
        Asignatura asignatura;
        ArrayList<Asignatura>asignaturas = new ArrayList<>();
        int idGrupo;
        int idAsignatura, nAsignaturas;
        System.out.println("Introduce el nombre del alumno");
        nombre = pedirNombre();
        if(centro.buscarNombre(nombre)){
            System.out.println("Inserta la ID del grupo al que quieres asignar al nuevo alumno: ");
            idGrupo = input.nextInt();
            input.nextLine();
            if (centro.buscarGrupo(idGrupo)){
                grupo=centro.devolverGrupo(idGrupo);
            }else{
                System.out.println("El grupo seleccionado no existe, desea crear uno ahora?");
                //crearGrupo()
            }

            System.out.println("Introduce el numero de asignaturas de cual quieras matricular al alumno: ");
            nAsignaturas = input.nextInt();
            input.nextLine();

            for (int i = 0 ; i <nAsignaturas ; i++){
                System.out.println("Introduce el ID de la asignatura");
                idAsignatura = input.nextInt();
                input.nextLine();
                asignatura=centro.devolverAsignatura(idAsignatura);
                asignaturas.add(asignatura);
            }

            Alumno a1 = new Alumno(nombre, grupo, asignaturas);
            centro.addAlumno(a1);
        }else {
            System.out.println("El alumno ya existe.");
        }
    }

    public static void nuevoProfesor(){
        String dni;
        String nombre;
        double sueldo;
        dni = Lib.pedirDni();
        nombre = pedirNombre();
        sueldo=pedirSueldo();

        if(centro.existeProfesor(dni)) {
            Profesor p1 = new Profesor(dni, nombre, sueldo);
            centro.addProfesor(p1);
        } else{
            System.out.println("El profesor ya existe");
        }

    }

    public static String pedirNombre(){
        String nombre;
        do {
            System.out.println("Introduce el nombre:");
            nombre = input.nextLine().trim().toLowerCase();
            if (nombre.length() >= 3){
                validado = true;
            }else{
                validado = false;
                System.out.println("El nombre debe tener mínimo 3 caracteres");
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return nombre;
    }

    public static double pedirSueldo(){
        double sueldo = -1;
        do {
            try{
                System.out.println("Introduce el sueldo: ");
                sueldo = Double.parseDouble(input.nextLine());
                if (sueldo > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("El sueldo no puede ser negativo!!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("No pueden ser letras!!!");
            }
        }while (!validado);
        return sueldo;
    }


}
