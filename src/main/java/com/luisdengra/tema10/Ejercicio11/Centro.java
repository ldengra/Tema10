package com.luisdengra.tema10.Ejercicio11;

import java.util.ArrayList;

public class Centro {

     ArrayList<Alumno>alumnos = new ArrayList<>();
     ArrayList<Grupo>grupos = new ArrayList<>();
     ArrayList<Asignatura>asignaturas = new ArrayList<>();
     ArrayList<Profesor>profesores = new ArrayList<>();
     ArrayList<Aula>aulas = new ArrayList<>();

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

     public void addAula(Aula au1){
         aulas.add(au1);
     }

    /**
     * Metodo para buscar si hay algun alumno con el mismo nombre, de ser asi, devolvera un true
     * @param nombre nombre a comprobar
     * @return si existe true, sino, false
     */
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

    /**
     * Metodo para buscar si existe el grupo que introducimos por parametro
     * @param idGrupo el id que queremos comprobar
     * @return retorna true si el grupo existe, false si no existe
     */
    public boolean buscarGrupo(int idGrupo){
        int idGrupoAux;
        for (int i = 0; i < grupos.size(); i++) {
            idGrupoAux = grupos.get(i).getId();
            if (idGrupoAux==idGrupo){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para buscar devolver el grupo que buscamos
     * @param idGrupo el id que queremos obtener el grupo
     * @return retorna el grupo en caso de que existe, si no existe, null
     */
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

    /**
     * Metodo para devolver la asignatua que le pasamos por parametro
     * @param idAsignatura id por el que buscamos la asignatura
     * @return el objeto asignatura
     */
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

    /**
     * Metodo para devolver el profesor que queremos usar
     * @param dni hacemos la busqueda del profesor a traves de la ID
     * @return retorna el profesor, si existe.
     */
    public Profesor devolverProfesor(String dni){
        String dniAux;
        for(int i = 0 ; i < grupos.size() ; i++){
            dniAux = profesores.get(i).getDni();
            if (dniAux.equals(dni)){
                return profesores.get(i);
            }
        }
        return null;
    }

    /**
     * Metodo para devolver el aula que queremos usar
     * @param id buscamos la aula a traves de su ID
     * @return retorna la aula
     */
    public Aula delvolverAula(int id){
         int idAux;
         for(int i = 0 ; i < aulas.size() ; i++){
             idAux = aulas.get(i).getId();
             if(id==idAux){
                 return aulas.get(i);
             }
         }
         return null;
    }

    /**
     * Metodo para comprobar si existe el profesor
     * @param dni usamos el dni para hacer la comprobacion
     * @return true si existe, false si no
     */
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

    /**
     * Metodo para comprobar si existe el aula
     * @param id usamos la id para ver si existe
     * @return true si existe, false si no
     */
    public boolean existeAula(int id){
         int idAux;
         for (int i = 0; i<aulas.size() ; i++){
             idAux = aulas.get(i).getId();
             if(id==idAux){
                 return true;
             }
         }
         return false;
    }

    public ArrayList<Alumno> alumnosPorGrupo(String grupo){
        ArrayList<Alumno> encontrados = new ArrayList<>();
        String grupoAux;
        for (int i = 0 ; i < alumnos.size() ; i++){
            grupoAux = alumnos.get(i).getGrupo().getNombre();
            if (grupo.contains(grupoAux)){
                encontrados.add(alumnos.get(i));
            }
        }
        return encontrados;
    }

    /**
     * Mirando el profesor del grupo del alumno
     * @param dni
     * @return
     */
    public ArrayList<Alumno> alumnosPorProfesor(String dni){
        ArrayList<Alumno> encontrados = new ArrayList<>();
        ArrayList<Asignatura> asignaturasEncontradas = new ArrayList<>();
        ArrayList<Asignatura> asignaturaAlumnos = new ArrayList<>();
        String dniAux;
        //aqui tengo las asignaturas que imparte el profesor que hemos pasado por parametro
        for(int j = 0 ; j < asignaturas.size() ; j++){
            dniAux = asignaturas.get(j).getProfesor().getDni();
            if(dniAux.equals(dni)){
                asignaturasEncontradas.add(asignaturas.get(j));
            }
        }
        //ahora comparo las asignaturas con los alumnos que las cursan
        //no he sabido como hacerlo
       /** for (int i = 0 ; i < alumnos.size() ; i++){
            asignaturaAlumnos.add(alumnos.get(i).getAsignaturas());
        }
        //    if(asignaturasEncontradas.get(i).getNombre().contains(alumnos.get(i).getAsignaturas().get())){
        } **/
        return encontrados;

    }

    @Override
    public String toString() {
        return "Centro{" +
                "alumnos=" + alumnos +
                ", grupos=" + grupos +
                ", asignaturas=" + asignaturas +
                ", profesores=" + profesores +
                ", aulas=" + aulas +
                '}'+'\n';
    }
}
