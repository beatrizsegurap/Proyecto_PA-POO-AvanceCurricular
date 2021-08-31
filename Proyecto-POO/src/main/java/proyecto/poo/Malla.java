
package proyecto.poo;
import java.util.ArrayList;

public class Malla{
    private String nombreCarrera;
    private int cantSemestres;
    private ArrayList <Asignatura> asignaturas;

    //Constructor
    public Malla(String carrera, int semestres){
        nombreCarrera = carrera;
        cantSemestres = semestres;
        this.asignaturas = new ArrayList<>();
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

    public void agregarAsignatura(Asignatura a){
        this.asignaturas.add(a);
    }

    public void mostrarAsignaturas(){
        for(int i=0;i<this.asignaturas.size();i++){
            this.asignaturas.get(i).mostrarAsignatura();
        }
    }

}

