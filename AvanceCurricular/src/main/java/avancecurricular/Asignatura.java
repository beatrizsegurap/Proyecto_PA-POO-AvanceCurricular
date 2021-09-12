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
public class Asignatura {
    private int id;
    private String nombre;
    private int semestre;
    private int creditos;
    private ArrayList <Asignatura> asignaturasPrerequisitos;
    private ArrayList <Modulo> modulos;

    //Constructor
    public Asignatura(int id, String nombre, int semestre, int creditos){
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.asignaturasPrerequisitos = new ArrayList<>();
        this.modulos = new ArrayList<>();
            
    }

    //Get y set
    public int getSemestre(){
        return semestre;
    }

    public void setSemestre(int semestre){
        this.semestre = semestre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

     public int getCreditos(){
        return creditos;
    }

    public void setCreditos(int creditos){
        this.creditos = creditos;
    }

    public int getId(){
        return id;
    }
    
    public ArrayList<Asignatura> getAsignaturasPrerequisitos(){
        return asignaturasPrerequisitos;
    }

    public void mostrarAsignatura(){
        System.out.println(this.id+"  "+this.nombre);
    }

    public void agregarPrerequisito(Asignatura a){
        this.asignaturasPrerequisitos.add(a);
    }
    
    public void agregarMoodulo(Modulo a){
        this.modulos.add(a);
    }
    
    public void mostrarPrerequisitos(){
        for(int i=0;i<this.asignaturasPrerequisitos.size();i++){
            this.asignaturasPrerequisitos.get(i).mostrarAsignatura();
        }
    }
}
