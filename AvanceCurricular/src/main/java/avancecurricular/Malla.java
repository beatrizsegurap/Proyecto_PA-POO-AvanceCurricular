/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancecurricular;
import java.util.*;
import java.io.*;
/**
 *
 * @author beatr
 */
public class Malla {
    private String nombreCarrera;
    private int cantSemestres;
    ArrayList <Asignatura> asignaturas;

    //Constructor
    public Malla(String carrera, int semestres) throws semestreInvalidException{
        nombreCarrera = carrera;
        this.setCantSemestres(semestres);
        this.asignaturas = new ArrayList<>();
    }

    //Get y set
    public int getCantSemestres(){
        return cantSemestres;
    }

    public void setCantSemestres(int semestres)throws semestreInvalidException{
        if(semestres>=5){
            cantSemestres = semestres;
        }
        else throw new semestreInvalidException();
    }

    public String getNombreCarrera(){
        return nombreCarrera;
    }

    public void setNombreCarrera(String carrera){
        nombreCarrera = carrera;
    }

    public void agregarAsignatura(Asignatura a){
        this.asignaturas.add(a);
    }

    //Sobrecarga de metodos

    public void mostrarAsignaturas(){
        for(int i=0;i<this.asignaturas.size();i++){
            this.asignaturas.get(i).mostrarAsignatura();
        }
    }

    public void mostrarAsignaturas(String nombreAsignatura){
        for(int i=0;i<this.asignaturas.size();i++){
            if (this.asignaturas.get(i).getNombre().equals(nombreAsignatura)){
            this.asignaturas.get(i).mostrarAsignatura();
            }
        }
    }

    public void mostrarAsignaturas(int id){
        for(int i=0;i<this.asignaturas.size();i++){
            if (this.asignaturas.get(i).getId()==id){
            this.asignaturas.get(i).mostrarAsignatura();
            }
        }
    }
    
    public Asignatura asignaturaCarrera(int id){
        for(int i=0;i<this.asignaturas.size();i++){
            if (this.asignaturas.get(i).getId()==id){
            return this.asignaturas.get(i);
            }
        }
        return null;
    }
    
    public void removeAsignatura(Asignatura a){
        for(int i=0;i<this.asignaturas.size();i++){
            if (this.asignaturas.get(i).getId()==a.getId()){
                this.asignaturas.remove(a);
            }
        }
    }
    
    public int creditosSemestre(int semestre){
        int creditos=0;
        for(int i=0;i<this.asignaturas.size();i++){
            if(this.asignaturas.get(i).getSemestre()==semestre){
                creditos+=this.asignaturas.get(i).getCreditos();
            }
        }
        return creditos;
    }
    
    public int asignaturasSemestre(int semestre){
        int asignatura=0;
        for(int i=0;i<this.asignaturas.size();i++){
            if(this.asignaturas.get(i).getSemestre()==semestre){
                asignatura+=1;
            }
        }
        return asignatura;
    }
    
    public int totalCreditos(){
        int creditos=0;
        for(int i=0;i<this.cantSemestres;i++){
            creditos+=creditosSemestre(i);
        }
        return creditos;
    }
    
    public int totalAsignaturas(){
        return this.asignaturas.size();
    }
    public void estudiantesCarrera(Map <Integer,Estudiante> estudiantes){
        int cantEstRegulares=0;
        int cantEstCongelados=0;
        int cantEstTitulados=0;
        for(Map.Entry<Integer,Estudiante> entry:estudiantes.entrySet()){
            if(entry.getValue().getCarrera().equals(nombreCarrera)){
                if(entry.getValue().estado().equals("regular")){
                    cantEstRegulares+=1;
                }
                if(entry.getValue().estado().equals("congelado")){
                    cantEstCongelados+=1;
                }
                if(entry.getValue().estado().equals("titulado")){
                    cantEstTitulados+=1;
                }
            }
        }
        System.out.println("La Cantidad de estudiantes de la carrera "+nombreCarrera+" es: \nEstudiantes Regulares: "+cantEstRegulares+"\nEstudiantes Congelados: "+cantEstCongelados+"\nEstudiantes Titulados: "+cantEstTitulados);
    }
}
