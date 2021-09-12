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
public class Profesor {
    private int rut;
    private String nombre;
    private ArrayList <Asignatura> asignaturasImpartidas;

    //Constructor con sobrecarga
    public Profesor(int rut, String nombre){
        this.rut = rut;
        this.nombre = nombre;
        this.asignaturasImpartidas = new ArrayList<>();
    }

    public Profesor(int rut, String nombre, ArrayList<Asignatura> aImpartidas){
        this.rut = rut;
        this.nombre = nombre;
        asignaturasImpartidas = new ArrayList<>();
        asignaturasImpartidas.addAll(aImpartidas);
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

    public void agregarAsignaturaImpartida(Asignatura a){
        this.asignaturasImpartidas.add(a);
    }

    public void mostrarAsignaturasImpartidas(){
        for(int i=0;i<this.asignaturasImpartidas.size();i++){
            this.asignaturasImpartidas.get(i).mostrarAsignatura();
        }
    }

    public void mostrarAsignaturasImpartidas(String nombreAsignatura){
        for(int i=0;i<this.asignaturasImpartidas.size();i++){
            if (this.asignaturasImpartidas.get(i).getNombre().equals(nombreAsignatura)){
            this.asignaturasImpartidas.get(i).mostrarAsignatura();
            }
        }
    }

    public void mostrarAsignaturasImpartidas(int id){
        for(int i=0;i<this.asignaturasImpartidas.size();i++){
            if (this.asignaturasImpartidas.get(i).getId()==id){
            this.asignaturasImpartidas.get(i).mostrarAsignatura();
            }
        }
    }
}
