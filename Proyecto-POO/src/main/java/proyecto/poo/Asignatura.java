
package proyecto.poo;
import java.util.ArrayList;

public class Asignatura{
    private int id;
    private String nombre;
    private int semestre;
    private int creditos;
    private ArrayList <Asignatura> asignaturasPrerequisitos;

    //Constructor
    public Asignatura(int id, String nombre, int semestre, int creditos){
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.asignaturasPrerequisitos = new ArrayList<>();

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

    public void mostrarAsignatura(){
        System.out.println(this.nombre);
    }

    public void agregarPrerequisito(Asignatura a){
        this.asignaturasPrerequisitos.add(a);
    }

}

