/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancecurricular;
import java.util.*;
/**
 *
 * @author beatr
 */
public abstract class Estudiante {
    private int rut;
    private String nombre;
    private Malla carrera;
    private ArrayList <Modulo> asignaturasAprobadas;

    //Constructor
    public Estudiante(int rut, String nombre, Malla carrera){
        this.rut = rut;
        this.nombre= nombre;
        this.carrera = carrera;
        asignaturasAprobadas = new ArrayList<>();
    }

    public Estudiante(int rut, String nombre, Malla carrera, ArrayList<Modulo> asignaturas){
        this.rut = rut;
        this.nombre= nombre;
        this.carrera = carrera;
        asignaturasAprobadas = new ArrayList<>();
        asignaturasAprobadas.addAll(asignaturas);

    }
    //Get y set
    public int getRut(){
        return rut;
    }

    public void setRut(int rut){
        this.rut = rut;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCarrera(){
        return carrera.getNombreCarrera();
    }

    public void setCarrera(Malla carrera){
        this.carrera = carrera;
    }

    public void agregarModuloAprobada(Modulo a){
        this.asignaturasAprobadas.add(a);
    }
    
   //Sobrecarga en estudiante
    public boolean removeModulos(Modulo a){
        for(int i=0;i<this.asignaturasAprobadas.size();i++){
            if (this.asignaturasAprobadas.get(i).getIdAsignatura()==a.getIdAsignatura()){
                this.asignaturasAprobadas.remove(this.asignaturasAprobadas.get(i));
                return true;
            }
        }
        return false;
    }
    
    public void removeModulos(){
        for(int i=0;i<this.asignaturasAprobadas.size();i++){
            removeModulos(this.asignaturasAprobadas.get(i));
        }
    }
    
     public ArrayList<Modulo> getModulos(){
        return asignaturasAprobadas;
    }
    
    public void mostrarModulos(){
        for(int i=0;i<this.asignaturasAprobadas.size();i++){
            System.out.println("Nombre asignatura: "+this.asignaturasAprobadas.get(i).getNombreAsignatura());
            System.out.println("Periodo en que la curso: " + this.asignaturasAprobadas.get(i).getPeriodo());
            System.out.println("Nota de aprobacion: " + this.asignaturasAprobadas.get(i).getNota());
            System.out.println("-------------------------------------------------");
        }
    }
   
    public boolean cursoAsignatura(int id){
        for(int i=0;i<this.asignaturasAprobadas.size();i++){
            if (this.asignaturasAprobadas.get(i).getIdAsignatura()==id){
                return true;
            }
        }
        return false;
    }
    
    public void avanceCurricular(){
        //Muestra el avance del alumno mostrando la cantidad de creditos que este lleva aprobado con las asignaturas cursadas y su promedio acumulado de notas
        double creditosAprobados = 0;
        double promedio=0;
        for(int i=0;i<this.asignaturasAprobadas.size();i++){
            creditosAprobados+=this.asignaturasAprobadas.get(i).getAsignatura().getCreditos();
            promedio+=this.asignaturasAprobadas.get(i).getNota();
        }
        double avanceCreditos = this.carrera.totalCreditos()/creditosAprobados;
        promedio=promedio/this.asignaturasAprobadas.size();
        System.out.println("El avance curricular del estudiante "+nombre+" es de\nAvance Curricular por creditos: "+avanceCreditos+"% de la carrera "+carrera.getNombreCarrera());
        System.out.println("Avance curricular por asignaturas: "+this.asignaturasAprobadas.size()+" / "+this.carrera.totalAsignaturas());
        System.out.println("Promedio de notas de estudiante: "+promedio+" \n");
    }
    
    public double promedioNotas(){
        double promedio=0;
        for(int i=0;i<this.asignaturasAprobadas.size();i++){
            promedio+=this.asignaturasAprobadas.get(i).getNota();
        }
        return promedio/this.asignaturasAprobadas.size();
    }

    public abstract void informacionPersonal();
    public abstract String estado();
}
