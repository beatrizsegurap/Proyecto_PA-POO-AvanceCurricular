
package proyecto.poo;

import java.io.*;
import java.util.*;


public class Main{
    
    public static final String SEPARADOR = ";";
    public static final String LOCALIZACION = "Datos_alumnos.csv";//testing
    public static final String LOCALIZACIONCARRERAS = "carreras.csv";//testing

    
    public static void main(String[] args){
        CSV csvAlumnos = null;
        CSV csvCarreras = null;
        Map <String,Estudiante> alumnos = new HashMap<String,Estudiante>();
        Map <String, Malla> carreras = new HashMap<String, Malla>();
        File localizacion = new File("Datos_alumnos.csv");
        File localizacionMalla = new File("carreras.csv");
        String locCarreras = localizacionMalla.getAbsolutePath();
        String locDatosAlumnos = localizacion.getAbsolutePath();
        Scanner lector = new Scanner(System.in);
        int opcion =  99;
        try {
            // Abrir el .csv 
            csvAlumnos = new CSV(locDatosAlumnos);
            csvCarreras = new CSV(locCarreras);
            // CSV ALUMNOS: 0 nombre/1 apellido/2 rut/3 semestre/4-5-6-7-8 notas
            // Leer la primera linea del archivo Datos_alumnos
            String linea = csvAlumnos.firstLine();//Lector archivo Datos_alumnos.csv
            String lineaCarrera = csvCarreras.firstLine();//Lector archivo carreras.csv
            
        
            while (linea != null & lineaCarrera != null) {
                //Obtener los datos desde el archivo csv Alumnos
                String nombre = csvAlumnos.get_csvField(linea, 0);
                String apellido = csvAlumnos.get_csvField(linea, 1);
                String rut = csvAlumnos.get_csvField(linea, 2);
                //
                String nombreCarrera = csvCarreras.get_csvField(lineaCarrera, 0);
                String cantSemestres = csvCarreras.get_csvField(lineaCarrera, 1);
                ArrayList <Asignatura> asignaturas = new ArrayList<Asignatura>();  
                for (int i = 2; i<25; i++){
                    //Creacion del mapa de asignaturas
                  
                    String idAsignatura = csvCarreras.get_csvField(lineaCarrera, i);
                    String nombreRamo = null;
                    String semestreRamo = null;
                    String creditos = null;  
                    Asignatura ramo = new Asignatura(idAsignatura, nombreRamo, semestreRamo, creditos);
                    asignaturas.add(ramo);                                   
                } 
                Malla mallaCarrera = new Malla(nombreCarrera, cantSemestres);
 
                carreras.put(nombreCarrera, mallaCarrera);
                //Creacion del Estudiante e ingreso de datos al HashMap alumnos
                Estudiante infoEstudiante = new Estudiante(rut,nombre,apellido); 
                alumnos.put(rut,infoEstudiante);
                // Volver a leer otra línea del fichero
                linea = csvAlumnos.nextLine();
                lineaCarrera = csvCarreras.nextLine();
            }
            
            System.err.println("Data_alumnos.csv cargada");
            do{
                System.out.println("MENÚ\n");       //Formato de menú
                System.out.println("----------------\nELIGE UNA OPCIÓN\n----------------\n");
                System.out.println("1: AGREGAR UN ALUMNO\n");
                System.out.println("2: BUSCAR ALUMNO POR RUT\n");
                System.out.println("3: MOSTRAR TODOS LOS ALUMNOS\n");
                System.out.println("->\n");
                switch(opcion){
                    case 0: break;
                    case 1: //AGREGAR ALUMNO
                    case 2: //BUSCAR POR RUT
                    case 3: //MOSTRAR TODOS LOS ALUMNO
                }
                opcion = lector.nextInt();
                
            }while(opcion!=0);
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
