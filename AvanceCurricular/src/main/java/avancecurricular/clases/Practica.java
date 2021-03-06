/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancecurricular.clases;

import avancecurricular.clases.Asignatura;
import avancecurricular.clases.Estudiante;
import avancecurricular.Excepciones.notaInvalidException;

/**
 *
 * @author beatr
 */
public class Practica extends Modulo{
    private int horas;
    private String lugar;

    public Practica(int horas, String lugar, int id, Asignatura asignatura, Estudiante nombreEstudiante, String nombreProfesor, String periodo, double nota) throws notaInvalidException{
        super(id, asignatura, nombreEstudiante, nombreProfesor, periodo, nota);
        this.setHoras(horas);
        this.setLugar(lugar);
    }


    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    

}
