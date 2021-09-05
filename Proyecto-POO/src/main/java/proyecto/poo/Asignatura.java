
package proyecto.poo;
import java.util.ArrayList;

public class Asignatura{
    private String id;
    private String nombre;
    private String semestre;
    private String creditos;
    private ArrayList <Asignatura> asignaturasPrerequisitos;

    //Constructor
    public Asignatura(String id, String nombre, String semestre, String creditos){
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.asignaturasPrerequisitos = new ArrayList<>();
            
    }

    //Get y set
    public String getSemestre(){
        return semestre;
    }

    public void setSemestre(String semestre){
        this.semestre = semestre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

     public String getCreditos(){
        return creditos;
    }

    public void setCreditos(String creditos){
        this.creditos = creditos;
    }

    public String getId(){
        return id;
    }

    public void mostrarAsignatura(){
        System.out.println(this.nombre);
    }

    public void agregarPrerequisito(Asignatura a){
        this.asignaturasPrerequisitos.add(a);
    }

}

