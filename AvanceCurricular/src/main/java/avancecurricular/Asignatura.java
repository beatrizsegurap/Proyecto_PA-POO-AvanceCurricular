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

    /**
     *
     * @param id
     * @param nombre
     * @param semestre
     * @param creditos
     */
    public Asignatura(int id, String nombre, int semestre, int creditos){
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.creditos = creditos;
        this.asignaturasPrerequisitos = new ArrayList<>();
        this.modulos = new ArrayList<>();
            
    }

    //Get y set

    /**
     *
     * @return
     */
    public int getSemestre(){
        return semestre;
    }

    /**
     *
     * @param semestre
     */
    public void setSemestre(int semestre){
        this.semestre = semestre;
    }

    /**
     *
     * @return
     */
    public String getNombre(){
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public int getCreditos(){
        return creditos;
    }

    /**
     *
     * @param creditos
     */
    public void setCreditos(int creditos){
        this.creditos = creditos;
    }

    /**
     *
     * @return
     */
    public int getId(){
        return id;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Asignatura> getAsignaturasPrerequisitos(){
        return asignaturasPrerequisitos;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Modulo> getModulos(){
        return modulos;
    }

    /**
     *
     */
    public void mostrarAsignatura(){
        System.out.println("Id: "+this.id+"  nombre: "+this.nombre);
        System.out.println("semestre: "+this.semestre);
        System.out.println("creditos: "+this.creditos);
        System.out.println(".......................................................");
    }

    /**
     *
     * @param a
     */
    public void agregarPrerequisito(Asignatura a){
        this.asignaturasPrerequisitos.add(a);
    }
    
    /**
     *
     * @param a
     */
    public void agregarMoodulo(Modulo a){
        this.modulos.add(a);
    }
    
    /**
     *
     */
    public void mostrarPrerequisitos(){
        for(int i=0;i<this.asignaturasPrerequisitos.size();i++){
            this.asignaturasPrerequisitos.get(i).mostrarAsignatura();
        }
    }
    
    /**
     *
     */
    public void mostrarModulos(){
        for(int i=0;i<this.modulos.size();i++){
            this.modulos.get(i).mostrarModulo();
        }
    }
    
    /**
     *
     * @param m
     */
    public void removeModulos(Modulo m){
        for(int i=0;i<this.modulos.size();i++){
            if(this.modulos.get(i).getIdModulo()== m.getIdModulo()){
                this.modulos.get(i).getEstudiante().removeModulos(m);
                this.modulos.remove(this.modulos.get(i));
                return;
            }
        }
        
    }
    
    /**
     *
     */
    public void removeModulos(){
        for(int i=0;i<this.modulos.size();i++){
                removeModulos(this.modulos.get(i));
        }
    }
}
