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
        //Variables a usar
        Map <Integer,Estudiante> alumnos = new HashMap<Integer,Estudiante>();//Mapa de estudiantes con llave rut
        Map <String, Malla> carreras = new HashMap<String, Malla>();//Mapa de mallas de carreras con llave nombre de carrera
        Map <Integer, Asignatura> ramos = new HashMap<Integer, Asignatura>();//Mapa con asignaturas y llave ID de la asignatura
        Map <Integer, Profesor> profesores = new HashMap<Integer, Profesor>();//Mapa con profesores y llave rut del profesor
        Menu menuPrincipal = new Menu();
        
        menuPrincipal.cargarDatos(carreras, ramos);
        
        int op;
        Scanner lector1 = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("Menu Principal");
        System.out.println("Bienvenido/a");
        boolean flag = true;
        
        do{
            System.out.println("1.Registrar Estudiante");
            System.out.println("2.Mostrar todos los Estudiantes");
            System.out.println("3.Buscar Estudiante por rut");
            System.out.println("4.Mostrar carreras y sus asignaturas");
            System.out.println("5.Generar reporte");
            System.out.println("6.Registrar Profesor");
            System.out.println("7.Mostrar todos los Profesor");
            System.out.println("8.Buscar Profesor por rut");
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
                        if(aCursada.getAsignaturasPrerequisitos().size()!=0){
                            for(int i=0;i<aCursada.getAsignaturasPrerequisitos().size();i++){
                                if(!estudiante.cursoAsignatura(aCursada.getAsignaturasPrerequisitos().get(i).getId())){
                                    Asignatura asignaturaPrerequisito = aCursada.getAsignaturasPrerequisitos().get(i);
                                    System.out.println("ID: "+ asignaturaPrerequisito.getId()+"  Nombre: "+asignaturaPrerequisito.getNombre());
                                    System.out.println("Debe inscribir esta asignatura prerequisito previamente");
                                    System.out.println("Ingrese promedio notas: ");
                                    double notaPre = Double.parseDouble(lector1.nextLine());
                                    System.out.println("Ingrese periodo en el que curso la asignatura (ej: 2021-2): ");
                                    String periodoPre = lector1.nextLine();
                                    System.out.println("Ingrese nombre Profesor: ");
                                    String profesorPre = lector1.nextLine();
                                    int idModulo = asignaturaPrerequisito.getId()+asignaturaPrerequisito.getModulos().size();
                                    Modulo moduloPre = new Modulo(idModulo,asignaturaPrerequisito,estudiante,profesorPre,periodoPre,notaPre);
                                    estudiante.agregarModuloAprobada(moduloPre);
                                    asignaturaPrerequisito.agregarMoodulo(moduloPre);
                                }
                            }
                        }
                        System.out.println("Asignatura seleccionada: "+aCursada.getNombre());
                        System.out.println("Ingrese promedio notas: ");
                        double nota = Double.parseDouble(lector1.nextLine());
                        System.out.println("Ingrese periodo en el que curso la asignatura (ej: 2021-2): ");
                        String periodo = lector1.nextLine();
                        System.out.println("Ingrese nombre Profesor: ");
                        String profesor = lector1.nextLine();
                        int idModulo = aCursada.getId()+aCursada.getModulos().size();
                        Modulo moduloCursado = new Modulo(idModulo,aCursada,estudiante,profesor,periodo,nota);
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
                            System.out.println("Rut: "+ entry.getValue().getRut());
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
                            System.out.println("-------------------------------------------------");
                            if(alumnos.get(rutEstudiante).getModulos().size()!=0){
                                System.out.println("Asignaturas aprobadas del estudiante");
                                alumnos.get(rutEstudiante).mostrarModulos();
                            }
                            else{
                                System.out.println("El estudiante no tiene asignaturas ingresadas, o aprobadas");
                            }
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
                
                case 6:{
                    System.out.println("Ingrese nombre del Profesor(a): ");
                    String nombreProf = lector1.nextLine();
                    System.out.println("Ingrese rut del Profesor(a) sin guion ni puntos: ");
                    int rut = Integer.parseInt(lector1.nextLine());
                    System.out.println("----------------------------------------");
                    System.out.println("Estas son las carreras dictadas, seleccione aquella en la que dicta alguna asignatura: ");
                    for(Map.Entry<String,Malla> entry:carreras.entrySet()){
                        System.out.println(entry.getValue().getNombreCarrera());
                    }
                    String nombreCa = lector1.nextLine();
                    Malla carrera = carreras.get(nombreCa);
                    Profesor profesor = new Profesor(rut,nombreProf);
                    boolean opcion2=true;
                    while(opcion2){
                        System.out.println("Estas son las asignaturas, ingrese la id de la asignatura a agregar: ");
                        carrera.mostrarAsignaturas();
                        int idAsignatura = Integer.parseInt(lector1.nextLine());
                        Asignatura asignatura = ramos.get(idAsignatura);
                        System.out.println("Asignatura seleccionada: "+asignatura.getNombre());
                        profesor.agregarAsignaturaImpartida(asignatura);
                        System.out.println("¿Desea agregar mas asignaturas?si=1 /no=0: ");
                        int agregar= Integer.parseInt(lector1.nextLine());
                        if(agregar!=1)opcion2=false;
                    }
                    profesores.put(rut,profesor);
                    System.out.println("El profesor fue ingresado exitosamente");
                    System.out.println("------------------------------------------------");
                    break;
                }
                case 7:{
                        if(profesores.size()==0){
                            System.out.println("Actualmente no se encuentran Profesores registrados");
                        }
                        else{
                            System.out.println("A continuación se muestran todos los profesores del Instituto: ");
                            for(Map.Entry<Integer,Profesor> entry:profesores.entrySet()){
                            System.out.println("Nombre: "+ entry.getValue().getNombre());
                            System.out.println("------------------------------------------------");
                        }
                    }
                    
                    break;
                }
                case 8:{
                    boolean correct = true;
                    while(correct){
                        System.out.println("Ingrese el rut del Profesor a buscar, sin puntos ni guion: ");
                        int rutProfesor = Integer.parseInt(lector1.nextLine());
                        if(!profesores.containsKey(rutProfesor)){
                            System.out.println("Rut incorrecto, no se encontro ningun estudiante asociado a este intentelo nuevamente");
                        }
                        else{
                            System.out.println("Nombre Profesor: "+ profesores.get(rutProfesor).getNombre());
                            System.out.println("-------------------------------------------------");
                            if(profesores.get(rutProfesor).getAsignaturasImpartidas().size()!=0){
                                System.out.println("Asignaturas impartidas por el profesor");
                                profesores.get(rutProfesor).mostrarAsignaturasImpartidas();
                            }
                            else{
                                System.out.println("El Profesor no tiene asignaturas ingresadas, o impartidas");
                            }
                            correct=false;
                        }
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
