/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancecurricular;
import java.io.*;
import java.util.*;
/**
 *
 * @author beatrizsegurap
 * @author KiboSennin
 * @author melillanf
 */
public class Main {


    public static void main(String[] args){
        
        CSV csvAsignaturas = null;
        CSV csvCarreras = null;
        //Mapa de estudiantes con llave rut
        Map <Integer,Estudiante> alumnos = new HashMap<Integer,Estudiante>();
        //Mapa de mallas de carreras con llave nombre de carrera
        Map <String, Malla> carreras = new HashMap<String, Malla>();
        //Mapa con asignaturas y llave ID de la asignatura
        Map <Integer, Asignatura> ramos = new HashMap<Integer, Asignatura>();
        File localizacionMalla = new File("carreras.csv");
        File localizacionAsignatura = new File("asignaturas.csv");
        String locCarreras = localizacionMalla.getAbsolutePath();
        String locAsignaturas = localizacionAsignatura.getAbsolutePath();
        int opcion =  99;
        try {
            // Abrir el .csv 
            csvAsignaturas = new CSV(locAsignaturas);
            // CSV ALUMNOS: 0 nombre/1 apellido/2 rut/3 semestre/4-5-6-7-8 notas
            // Leer la primera linea del archivo Datos_alumnos
            String lineaAsignatura = csvAsignaturas.firstLine();//Lector archivo carreras.csv
            
            //Leemos el archivo de asignaturas
            while (lineaAsignatura != null) {
                //Obtener los datos desde el archivo csv Alumnos
                int idAsignatura = Integer.parseInt(csvAsignaturas.get_csvField(lineaAsignatura, 0));
                String nombreAsignatura = csvAsignaturas.get_csvField(lineaAsignatura, 1);
                int semestre = Integer.parseInt(csvAsignaturas.get_csvField(lineaAsignatura, 2));
                int creditos = Integer.parseInt(csvAsignaturas.get_csvField(lineaAsignatura, 3));
                Asignatura ramo = new Asignatura(idAsignatura, nombreAsignatura, semestre, creditos);
                //ArrayList <Asignatura> asignaturas = new ArrayList<Asignatura>();  

                for (int i = 4; i<6; i++){
                    //Creacion del mapa de asignaturas
                    int idAsignaturaPreinscrita = Integer.parseInt(csvAsignaturas.get_csvField(lineaAsignatura, i));
                    if(idAsignaturaPreinscrita!=0){
                        Asignatura preinscrita = ramos.get(idAsignaturaPreinscrita);
                        ramo.agregarPrerequisito(preinscrita);
                    }
                } 
                ramos.put(idAsignatura, ramo);
                // Volver a leer otra línea del fichero
                lineaAsignatura = csvAsignaturas.nextLine();
            }
            
            csvCarreras = new CSV(locCarreras);
            String lineaCarrera = csvCarreras.firstLine();//Lector archivo carreras.csv
            //Leemos el archivo de carreras
            while (lineaCarrera != null) {
                //Obtener los datos desde el archivo csv Alumnos
                String nombreCarrera = csvCarreras.get_csvField(lineaCarrera, 0);
                Integer cantSemestres = Integer.parseInt(csvCarreras.get_csvField(lineaCarrera, 1));
                Malla mallaCarrera = new Malla(nombreCarrera, cantSemestres);
                
                
                //ArrayList <Asignatura> asignaturas = new ArrayList<Asignatura>();  
                for (int i = 2; i<27; i++){
                    //Creacion del mapa de asignaturas
                    Integer idAsignatura = Integer.parseInt(csvCarreras.get_csvField(lineaCarrera, i));
                    if(idAsignatura!=0){
                        Asignatura asignaturaCarrera = ramos.get(idAsignatura);
                        mallaCarrera.agregarAsignatura(asignaturaCarrera);
                    }
                } 

                // Volver a leer otra línea del fichero
                lineaCarrera = csvCarreras.nextLine();
                carreras.put(nombreCarrera, mallaCarrera);
            }
            
        } 
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
        // Cierro el buffer de lectura
        }
        
        int op;
        Scanner lector1 = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("Menu Principal");
        System.out.println("Bienvenido/a");
        boolean flag = true;
        
        do{
            System.out.println("1.Registrar Estudiante");
            System.out.println("2.Mostrar todos los Estudiantes");
            System.out.println("3.Buscar Estudiante");
            System.out.println("4.Mostrar carreras y sus asignaturas");
            System.out.println("5.Generar reporte");
            System.out.println("0.Salir");

            op = lector1.nextInt();
            lector1.nextLine();

            switch (op){
                case 1:{
                    System.out.println("Ingrese nombre del Estudiante: ");
                    String nombre = lector1.nextLine();
                    System.out.println("Ingrese rut del estudiante sin guion ni puntos: ");
                    int rut = Integer.parseInt(lector1.nextLine());
                    System.out.println("----------------------------------------");
                    System.out.println("Estas son las carreras impartidas, escriba el nombre exacto de la que esta cursando: ");
                    for(Map.Entry<String,Malla> entry:carreras.entrySet()){
                        System.out.println(entry.getValue().getNombreCarrera());
                    }
                    String nombreCa = lector1.nextLine();
                    Malla carreraEstudiante = carreras.get(nombreCa);
                    Estudiante estudiante = new Estudiante(rut,nombre,carreraEstudiante);
                    //Preguntamos si agregara asignaturas impartidas
                    boolean opcion2=false;
                    System.out.println("¿Desea agregar los modulos aprobados? si=1 /no=0");
                    int agregar = Integer.parseInt(lector1.nextLine());
                    if(agregar==1)opcion2=true;
                    while(opcion2){
                        System.out.println("Estas son las asignaturas asociadas a su carrera, ingrese la id de la asignatura a agregar: ");
                        carreraEstudiante.mostrarAsignaturas();
                        int idAsignaturaCursada = Integer.parseInt(lector1.nextLine());
                        Asignatura aCursada = ramos.get(idAsignaturaCursada);
                        System.out.println("Asignatura seleccionada: "+aCursada.getNombre());
                        System.out.println("Ingrese promedio notas: ");
                        double nota = Double.parseDouble(lector1.nextLine());
                        System.out.println("Ingrese periodo en el que curso la asignatura (ej: 2021-2): ");
                        String periodo = lector1.nextLine();
                        System.out.println("Ingrese nombre Profesor: ");
                        String profesor = lector1.nextLine();
                        Modulo moduloCursado = new Modulo(aCursada,estudiante,profesor,periodo,nota);
                        estudiante.agregarModuloAprobada(moduloCursado);
                        aCursada.agregarMoodulo(moduloCursado);
                        System.out.println("¿Desea agregar mas modulos aprobados?si=1 /no=0: ");
                        agregar= Integer.parseInt(lector1.nextLine());
                        if(agregar!=1)opcion2=false;
                    }
                    alumnos.put(rut,estudiante);
                    System.out.println("El estudiante fue ingresado exitosamente");
                    System.out.println("------------------------------------------------");
                }
                case 2:{
                        if(alumnos.size()==0){
                            System.out.println("Actualmente no se encuentran Estudiantes matriculados");
                        }
                        else{
                            System.out.println("A continuación se muestran todos los estudiantes: ");
                            for(Map.Entry<Integer,Estudiante> entry:alumnos.entrySet()){
                            System.out.println("Nombre: "+ entry.getValue().getNombre());
                            System.out.println("Carrera: "+ entry.getValue().getCarrera());
                            System.out.println("------------------------------------------------");
                        }
                    }
                    
                    break;
                }
                case 3:{
                    boolean correct = true;
                    while(correct){
                        System.out.println("Ingrese el rut del Estudiante a buscar, sin puntos ni guion: ");
                        int rutEstudiante = Integer.parseInt(lector1.nextLine());
                        if(!alumnos.containsKey(rutEstudiante)){
                            System.out.println("Rut incorrecto, no se encontro ningun estudiante asociado a este intentelo nuevamente");
                        }
                        else{
                            System.out.println("Nombre estudiante: "+ alumnos.get(rutEstudiante).getNombre()+"\n"+"Carrera: "+alumnos.get(rutEstudiante).getCarrera());
                            correct=false;
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println("------------------------------------------------");
                    System.out.println("Carreras ");
                    System.out.println("------------------------------------------------");
                    for(Map.Entry<String,Malla> entry:carreras.entrySet()){
                        System.out.println("Nombre Carrera:  "+entry.getValue().getNombreCarrera());
                        System.out.println("Asignaturas--------------------------");
                        entry.getValue().mostrarAsignaturas();
                        System.out.println("------------------------------------------------");
                    }
                    break;
                }
                case 5:{
                    try{
                        BufferedWriter escritorBw;
                        File reporte = new File("reporte.txt");
                        FileWriter w = new FileWriter(reporte);
                        BufferedWriter bw = new BufferedWriter(w);
                        PrintWriter wr = new PrintWriter(bw);
                        if(!reporte.exists()){
                            reporte.createNewFile();
                        }
                        Set<Integer> keysRamos = ramos.keySet();
                        for(Integer key:keysRamos){
                            Asignatura auxAsignatura = ramos.get(key);
                            wr.write("ID asignatura: "+key+"|Nombre asignatura: "+auxAsignatura.getNombre()+"\n");
                        }
                        wr.close();
                        bw.close();
                    }
                    catch(IOException dou){
                        dou.printStackTrace();
                    }
                    break;
                }
                case 0:
                flag=false;
                break;
               
            }
        }while(flag);
     }
    
}
