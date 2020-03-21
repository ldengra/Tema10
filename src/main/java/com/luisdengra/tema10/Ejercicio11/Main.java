package com.luisdengra.tema10.Ejercicio11;
import com.luisdengra.tema10.Utils.Lib;

import java.lang.reflect.Array;
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
                    nuevaAula();
                    break;
                case 4:
                    nuevaAsignatura();
                    break;
                case 5:
                    nuevoGrupo();
                    break;
                case 6:
                    casosPrueba();
                    break;
                case 7:
                    buscarPorGrupo();
                    break;
                case 8:
                    buscarPorProfesor();
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
                System.out.println("6. Casos de prueba.");
                System.out.println("7. Buscar alumnos por grupo.");
                System.out.println("8. Buscar alumnos por profesor.");
                System.out.println("-----------------------");
                System.out.println("0. Salir");
                opcion = Integer.parseInt(input.nextLine()) ;
                if (opcion >= 0 && opcion <= 8){
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

    /**
     * Metodo para crear un alumno nuevo. Hago la comprobacion con el nombre
     * El arraylist de asignaturas es para poder asignar varias asignaturas al alumno
     * La id autoincremental es de 4 digitos, los alumnos empiezan desde el 1000(ejemplo Alumno 1 = 1001)
     * Si el grupo no existe, pedira crearlo.
     * Se crea el alumno y se añade a la lista del centro
     */
    public static void nuevoAlumno(){
        String nombre;
        Grupo grupo = null; //lo inicio en null porque sino no me deja crear el objeto alumno
        Asignatura asignatura;
        ArrayList<Asignatura>asignaturas = new ArrayList<>();
        int idGrupo;
        int idAsignatura, nAsignaturas;
        nombre = pedirNombre();

        if(!centro.buscarNombre(nombre)){
            System.out.println("Inserta la ID del grupo al que quieres asignar al nuevo alumno: ");
            idGrupo = input.nextInt();
            input.nextLine();
            if (centro.buscarGrupo(idGrupo)){
                grupo=centro.devolverGrupo(idGrupo);
            }else{
                System.out.println("El grupo seleccionado no existe, crea uno ahora: ");
                nuevoGrupo();
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

    /**
     * Se crea un nuevo profesor y se comprueba si no existe, en caso de existir, dira que ya existe.
     * hago la comprobacion con el DNI
     */
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

        Profesor p1 = new Profesor(dni,nombre,sueldo);
        centro.addProfesor(p1);

    }

    /**
     * Metodo para crear aulas nuevas, hay que introducir la ID que la pide a traves de un metodo y los mnetros cuadrados
     * que mide el aula
     */
    public static void nuevaAula(){
        int id = -1;
        double m2 = -1;

        id=pedirID();
        do {
            try{
                System.out.println("Introduce los metros cuadrados: ");
                m2 = Double.parseDouble(input.nextLine());
                if (m2 > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("La medida no puede ser negativa!!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("No pueden ser letras!!!");
            }
        }while (!validado);

        Aula au1 = new Aula(id, m2);
        centro.addAula(au1);
    }

    /**
     * Metodo para crear asignaturas nuevas, la id y el nombre lo pido a traves de metodos y creamos la asignatura
     * asignandile un profesor
     */
    public static void nuevaAsignatura(){
        int id = -1;
        Profesor p1 = null;
        String nombre;
        String dni;

        id=pedirID();
        nombre = pedirNombre();

        System.out.println("Introduce el dni del profesor que imparte la asignatura: ");
        dni = Lib.pedirDni();
        if(centro.existeProfesor(dni)){
            p1=centro.devolverProfesor(dni);
        }else{
            System.out.println("El profesor no existe");
        }
        Asignatura as1 = new Asignatura(id,nombre,p1);
        centro.addAsignatura(as1);
    }

    /**
     *Metodo para crear un grupo, se le asigna una aula
     */
    public static void nuevoGrupo(){
        int id =-1;
        String nombre;
        Aula au1 = null;

        id=pedirID();
        nombre=pedirNombre();

        if (centro.existeAula(id)){
            au1=centro.delvolverAula(id);
        }
        Grupo g1 = new Grupo(id, nombre, au1);
        centro.addGrupo(g1);
    }

    /**
     * Metodo para pedir una id, hacemos el try catch para que no puedan introducir letras
     * @return devolvemos una ID
     */
    public static int pedirID(){
        int id=-1;
        do {
            try{
                System.out.println("Introduce el numero ID: ");
                id = Integer.parseInt(input.nextLine());
                if (id > 0){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("El ID no puede ser negativo!!");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("No pueden ser letras!!!");
            }
        }while (!validado);

        return id;
    }

    /**
     * Metodo para pedir el sueldo del profesor con un try catch para no meter letras
     * @return un double con el sueldo
     */
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

    /**
     * Metodo para pedir el nombre, lo pasamos a minuscula y quitamos los espacios para asegurarnos de que todos los nombres
     * tienen el mismo formato
     * @return un nombre
     */
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

    /**
     * Metodo para buscar alumnos segun el grupo que quieras
     */
    public static void buscarPorGrupo(){
        String grupo;
        System.out.println("Introduce el nombre del grupo que quieras buscar");
        grupo = input.nextLine();
        ArrayList<Alumno> encontrados = centro.alumnosPorGrupo(grupo);

        if(encontrados.size()==0){
            System.out.println("No se han encontrado alumnos");
        }else{
            System.out.println(encontrados.toString());
        }
    }

    public static void buscarPorProfesor(){
        String dni;
        dni=Lib.pedirDni();
        ArrayList<Alumno> encontrados = centro.alumnosPorProfesor(dni);

        if(encontrados.size()==0){
            System.out.println("No se han encontrado alumnos");
        }else{
            System.out.println(encontrados.toString());
        }
    }

    /**
     * Metodo para crear casos de prueba
     */
    public static void casosPrueba(){
        ArrayList<Asignatura>asignaturas1=new ArrayList<>();
        ArrayList<Asignatura>asignaturas2=new ArrayList<>();

        Aula au1 = new Aula(0001,60);
        Aula au2 = new Aula(0002,75);
        centro.addAula(au1);
        centro.addAula(au2);
        Grupo g1 = new Grupo(0011,"Alpha",au1);
        Grupo g2 = new Grupo(0012,"Beta",au2);
        centro.addGrupo(g1);
        centro.addGrupo(g2);
        Profesor p1 = new Profesor("53629779", "Aurelio", 1200);
        Profesor p2 = new Profesor("53629778", "Amador", 1500);
        centro.addProfesor(p1);
        centro.addProfesor(p2);
        Asignatura as1 = new Asignatura(0101,"Programación",p1);
        Asignatura as2 = new Asignatura(0102,"Base de datos",p2);
        centro.addAsignatura(as1);
        centro.addAsignatura(as2);
        asignaturas1.add(as1);
        asignaturas1.add(as2);
        asignaturas2.add(as2);
        asignaturas2.add(as1);
        Alumno a1 = new Alumno("Luis",g1,asignaturas1);
        Alumno a2 = new Alumno("Victor",g2,asignaturas2);
        centro.addAlumno(a1);
        centro.addAlumno(a2);

        System.out.println(centro.toString());
    }

}
