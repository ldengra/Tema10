package com.luisdengra.tema10.Ejercicio05;

import java.awt.*;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Consultas {
    private static ArrayList<Paciente> listaPacientes = new ArrayList<Paciente>();

    public static void nuevoPaciente (Paciente p){

        listaPacientes.add(p);
    }

    public static int[] majorMenor(){
        int[] mayorMenor = new int[2];
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;





        for(int i = 0 ; i < listaPacientes.size() ; i++){

            if(listaPacientes.get(i).getEdad() < max){
                max = listaPacientes.get(i).getEdad();
            }

            if(listaPacientes.get(i).getEdad() > min){
                min = listaPacientes.get(i).getEdad();
            }
        }

        mayorMenor[0] = max;
        mayorMenor[1] = min;
        return mayorMenor;
    }

    public static int calcularEdad(String fecha) {
        String datetext = fecha;
        try {
            Calendar birth = new GregorianCalendar();
            Calendar today = new GregorianCalendar();
            int age = 0;
            int factor = 0;
            Date birthDate = new SimpleDateFormat("dd-MM-yyyy").parse(datetext);
            Date currentDate = new Date(); //current date
            birth.setTime(birthDate);
            today.setTime(currentDate);
            if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
                if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
                    if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
                        factor = -1; //Aun no celebra su cumpleaños
                    }
                } else {
                    factor = -1; //Aun no celebra su cumpleaños
                }
            }
            age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
            return age;
        } catch (ParseException e) {
            return -1;
        }

    }

    public static int[] hombresMujeres(){
        int[] nSexo = new int[2];
        int m = 0;
        int f = 0;
        for (int i = 0 ; i < listaPacientes.size() ; i++){
            if(listaPacientes.get(i).getSexo() == 'M'){
                m +=1;
            }else {
                f +=1;
            }
        }

        nSexo[0] = m;
        nSexo[1] = f;

        return nSexo;
    }

    public static double calcularIMC(){
        Scanner input = new Scanner(System.in);
        double IMC = 0;
        String paciente;
        System.out.println("Introduce el nombre del paciente: ");
        paciente = input.nextLine();
        double peso = busquedaPesoXNombre(paciente);
        double altura = busquedaAlturaXNombre(paciente);

        IMC= peso/(altura*altura);

        return IMC;
    }

    public static double busquedaPesoXNombre(String nombre){
        double peso;
        for (int i = 0; i < listaPacientes.size() ; i++){
            if (nombre.equals(listaPacientes.get(i).getNombre())){
                peso = listaPacientes.get(i).getPeso();

                return peso;
            }
        }

        return -1;
    }

    public static double busquedaAlturaXNombre(String nombre){
        double altura;
        for (int i = 0; i < listaPacientes.size() ; i++){
            if (nombre.equals(listaPacientes.get(i).getNombre())){
                altura = listaPacientes.get(i).getAltura();

                return altura;
            }
        }

        return -1;
    }

}
