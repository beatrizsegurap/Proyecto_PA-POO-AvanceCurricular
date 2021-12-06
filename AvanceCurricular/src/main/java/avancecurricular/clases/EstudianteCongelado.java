/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancecurricular.clases;

import avancecurricular.clases.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author beatr
 */
public class EstudianteCongelado extends Estudiante{
    private String periodoCongelacion;

    public EstudianteCongelado(String periodoCongelacion, int rut, String nombre, Malla carrera) {
        super(rut, nombre, carrera);
        this.periodoCongelacion = periodoCongelacion;
    }

    public EstudianteCongelado(String periodoCongelacion, int rut, String nombre, Malla carrera, ArrayList<Modulo> asignaturas) {
        super(rut, nombre, carrera, asignaturas);
        this.periodoCongelacion = periodoCongelacion;
    }

    public String getPeriodoCongelacion() {
        return periodoCongelacion;
    }

    public void setPeriodoCongelacion(String periodoCongelacion) {
        this.periodoCongelacion = periodoCongelacion;
    }

    @Override
    public void informacionPersonal() {
        System.out.println("Nombre: "+getNombre()+" Rut: "+getRut()+" Estado: Alumno Congelado en periodo "+periodoCongelacion+" de "+getCarrera());
    }
    
    public String estado(){
        return "congelado";
    }
}
