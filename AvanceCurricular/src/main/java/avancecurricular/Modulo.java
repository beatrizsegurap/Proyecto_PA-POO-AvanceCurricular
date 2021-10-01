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
public class Modulo {
    private Asignatura asignatura;
    private Estudiante estudiante;
    private String nombreProfesor;
    private String periodo;
    private double nota;
    private int id;

    public Modulo(int id,Asignatura asignatura, Estudiante nombreEstudiante, String nombreProfesor, String periodo, double nota) {
        this.asignatura = asignatura;
        this.estudiante = nombreEstudiante;
        this.nombreProfesor = nombreProfesor;
        this.periodo = periodo;
        this.nota = nota;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }
    
    public String getNombreAsignatura() {
        return asignatura.getNombre();
    }
    
    public int getIdAsignatura() {
        return asignatura.getId();
    }
    
    public int getIdModulo() {
        return id;
    }

    public String getNombreEstudiante() {
        return estudiante.getNombre();
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public String getPeriodo() {
        return periodo;
    }

    public double getNota() {
        return nota;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void mostrarEstudiante(){
        System.out.println("Nombre: "+estudiante.getNombre()+"\n"+"Rut: "+estudiante.getRut());
    }
    
    public void mostrarModulo(){
        System.out.println("Nombre asignatura: "+asignatura.getNombre()+"\n"+"Periodo: "+periodo+"\n"+"Nota: "+nota+"\n");
    }
    
}
