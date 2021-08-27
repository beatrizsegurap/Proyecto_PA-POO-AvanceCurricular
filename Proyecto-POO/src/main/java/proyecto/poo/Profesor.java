package proyecto.poo;

public class Profesor{
    private String rut;
    private String nombre;
   // private Asignatura[] asignaturasImpartidas;

    //Constructor
    public Profesor(String rut, String nombre){
        this.rut = rut;
        this.nombre = nombre;
    }

    //Get y set
    public String getRut(){
        return rut;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}

