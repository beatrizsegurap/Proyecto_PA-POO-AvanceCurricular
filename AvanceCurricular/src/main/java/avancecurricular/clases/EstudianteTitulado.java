/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancecurricular;

import avancecurricular.clases.Malla;
import avancecurricular.clases.Modulo;
import avancecurricular.clases.Estudiante;
import java.util.ArrayList;

/**
 *
 * @author beatr
 */
public class EstudianteTitulado extends Estudiante{
    private String periodoTitulacion;

    public EstudianteTitulado(String periodoTitulacion, int rut, String nombre, Malla carrera) {
        super(rut, nombre, carrera);
        this.periodoTitulacion = periodoTitulacion;
    }

    public EstudianteTitulado(String periodoTitulacion, int rut, String nombre, Malla carrera, ArrayList<Modulo> asignaturas) {
        super(rut, nombre, carrera, asignaturas);
        this.periodoTitulacion = periodoTitulacion;
    }

    public String getPeriodoTitulacion() {
        return periodoTitulacion;
    }

    public void setPeriodoTitulacion(String periodoTitulacion) {
        this.periodoTitulacion = periodoTitulacion;
    }

    @Override
    public void informacionPersonal() {
        System.out.println("Nombre: "+getNombre()+" Rut: "+getRut()+" Estado: Alumno Titulado año "+periodoTitulacion+" de "+getCarrera());
    }
    
    public String estado(){
        return "titulado";
    }
}
