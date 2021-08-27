
package proyecto.poo;

public class Asignatura{
    public int id;
    private String nombre;
    private int semestre;
    private int creditos;
    //private Asignatura[] preRequisitos;

    //Constructor
    public Asignatura(int id, String nombre, int semestre, int creditos){
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;

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

}

