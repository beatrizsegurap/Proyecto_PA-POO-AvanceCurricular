
package proyecto.poo;

public class Malla{
    private String nombreCarrera;
    private int cantSemestres;
    //private Asignatura[] asignaturas;

    //Constructor
    public Malla(String carrera, int semestres){
        nombreCarrera = carrera;
        cantSemestres = semestres;
    }

    //Get y set
    public int getCantSemestres(){
        return cantSemestres;
    }

    public void setCantSemestres(int semestres){
        cantSemestres = semestres;
    }

    public String getNombreCarrera(){
        return nombreCarrera;
    }

    public void setNombreCarrera(String carrera){
        nombreCarrera = carrera;
    }

}

