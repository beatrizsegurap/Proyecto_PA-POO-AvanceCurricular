/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancecurricular.clases;

import avancecurricular.clases.Asignatura;
import avancecurricular.clases.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author beatr
 */
public class EstudianteRegular extends Estudiante{
    private ArrayList <Asignatura> asignaturasActuales;

    public EstudianteRegular(int rut, String nombre, Malla carrera) {
        super(rut, nombre, carrera);
        asignaturasActuales = new ArrayList<>();

    }

    public EstudianteRegular(int rut, String nombre, Malla carrera, ArrayList<Modulo> asignaturas) {
        super(rut, nombre, carrera, asignaturas);
        asignaturasActuales = new ArrayList<>();
    }

    public ArrayList<Asignatura> getAsignaturasActuales() {
        return asignaturasActuales;
    }

    public void setAsignaturasActuales(Asignatura asignaturaActual) {
        this.asignaturasActuales.add(asignaturaActual);
    }

    @Override
    public void informacionPersonal() {
        System.out.println("Nombre: "+getNombre()+" Rut: "+getRut()+" Estado: Alumno Regular de "+getCarrera());
    }
    
    public String estado(){
        return "regular";
    }
    
    
}
