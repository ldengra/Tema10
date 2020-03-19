package com.luisdengra.tema10.Ejercicio11;

import java.util.ArrayList;

public class Centro {

     ArrayList<Alumno>alumnos;
     ArrayList<Grupo>grupos;
     ArrayList<Asignatura>asignaturas;
     ArrayList<Profesor>profesores;

     public void addAlumno(Alumno a1){
         alumnos.add(a1);
     }

     public void addProfesor(Profesor p1){
         profesores.add(p1);
     }

     public void addGrupo(Grupo g1){
         grupos.add(g1);
     }

     public void addAsignatura(Asignatura a1){
         asignaturas.add(a1);
     }

    public boolean buscarNombre(String nombre){
        String nombreAux;
        for (int i = 0; i < alumnos.size(); i++) {
            nombreAux = alumnos.get(i).getNombre();
            if (nombreAux.equals(nombre)){
                return true;
            }
        }
        return false;
    }

    public boolean buscarGrupo(int idGrupo){
        int idGrupoAux;
        for (int i = 0; i < alumnos.size(); i++) {
            idGrupoAux = alumnos.get(i).getId();
            if (idGrupoAux==idGrupo){
                return true;
            }
        }
        return false;
    }

    public Grupo devolverGrupo(int idGrupo){
        int idGrupoAux;
        for(int i = 0 ; i < grupos.size() ; i++){
            idGrupoAux = grupos.get(i).getId();
            if (idGrupoAux==idGrupo){
                return grupos.get(i);
            }
        }
        return null;
    }

    public Asignatura devolverAsignatura(int idAsignatura){
        int idAsigAux;
        for(int i = 0 ; i < asignaturas.size() ; i++){
            idAsigAux = asignaturas.get(i).getId();
            if (idAsigAux==idAsignatura){
                return asignaturas.get(i);
            }
        }
        return null;
    }

    public boolean existeProfesor(String dni){
        String dniAux;
        for (int i = 0; i < profesores.size(); i++) {
            dniAux = profesores.get(i).getDni();
            if (dni.equals(dniAux)){
                return true;
            }
        }
        return false;
    }

}
