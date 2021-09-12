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
public class Estudiante {
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
   
}
