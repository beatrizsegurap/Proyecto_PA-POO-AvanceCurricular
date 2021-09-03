
package proyecto.poo;

import java.io.*;
import java.util.*;


public class Main{
    
    public static final String SEPARADOR = ";";
    public static final String LOCALIZACION = "C:\\Users\\melil\\Desktop\\Proyecto_PA-POO-main\\Proyecto-POO\\src\\main\\java\\proyecto\\poo\\Datos_alumnos.csv";//testing
    
    public static void main(String[] args){
        CSV csvAlumnos = null;
        HashMap alumnos = new HashMap();
        File localizacion = new File("Datos_alumnos.csv");
        String locDatosAlumnos = localizacion.getAbsolutePath();
        try {
            // Abrir el .csv 
            csvAlumnos = new CSV(locDatosAlumnos);
            // CSV ALUMNOS: 0 nombre/1 apellido/2 rut/3 semestre/4-5-6-7-8 notas
            // Leer la primera linea del archivo Datos_alumnos
            String linea = csvAlumnos.firstLine();
        
            while (linea != null) {
                //Obtener los datos desde el archivo csv
                String nombre = csvAlumnos.get_csvField(linea, 0);
                String apellido = csvAlumnos.get_csvField(linea, 1);
                String rut = csvAlumnos.get_csvField(linea, 2);
                
                System.out.println("Rut: |"+rut+"|");//testing purposes
                //Creacion del Estudiante e ingreso de datos al HashMap alumnos
                Estudiante infoEstudiante = new Estudiante(rut,nombre,apellido);
                alumnos.put(rut,infoEstudiante);
                
                //Testing purposes
                if(alumnos.containsKey(rut)){
                    Estudiante infoAlumno = (Estudiante)alumnos.get(rut);
                    System.out.println("Nombre en mapa: "+infoAlumno.getRut());
                }
                System.out.println("Nombre: "+infoEstudiante.getNombre());
    
                // Volver a leer otra línea del fichero
                linea = csvAlumnos.nextLine();
            }
        } 
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
        // Cierro el buffer de lectura
            if (csvAlumnos != null) {
                try {
                    csvAlumnos.close();
                } 
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
