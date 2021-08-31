package proyecto.poo;
import java.util.ArrayList;

public class Profesor{
    private int rut;
    private String nombre;
    private ArrayList <Asignatura> asignaturasImpartidas;

    //Constructor
    public Profesor(int rut, String nombre){
        this.rut = rut;
        this.nombre = nombre;
        this.asignaturasImpartidas = new ArrayList<>();
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

}

