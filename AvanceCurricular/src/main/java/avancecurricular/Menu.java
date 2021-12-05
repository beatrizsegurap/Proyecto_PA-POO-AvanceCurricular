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
 * @author melil
 */
public class Menu {

    public void cargarDatos(Map carreras, Map ramos){
        //Declaracion de variables
        CSV csvAsignaturas = null;
        CSV csvCarreras = null;
        File localizacionMalla = new File("carreras.csv");//Archivo csv de carreras
        File localizacionAsignatura = new File("asignaturas.csv");//Archivo csv de asignaturas
        String locCarreras = localizacionMalla.getAbsolutePath();
        String locAsignaturas = localizacionAsignatura.getAbsolutePath();
        try {
            //Lectura archivo asignaturas.csv
            csvAsignaturas = new CSV(locAsignaturas);
            String lineaAsignatura = csvAsignaturas.firstLine();//Lector archivo carreras.csv
            while (lineaAsignatura != null) {
                int idAsignatura = Integer.parseInt(csvAsignaturas.get_csvField(lineaAsignatura, 0));
                String nombreAsignatura = csvAsignaturas.get_csvField(lineaAsignatura, 1);
                int semestre = Integer.parseInt(csvAsignaturas.get_csvField(lineaAsignatura, 2));
                int creditos = Integer.parseInt(csvAsignaturas.get_csvField(lineaAsignatura, 3));
                Asignatura ramo = new Asignatura(idAsignatura, nombreAsignatura, semestre, creditos);
                for (int i = 4; i<6; i++){
                    int idAsignaturaPreinscrita = Integer.parseInt(csvAsignaturas.get_csvField(lineaAsignatura, i));
                    if(idAsignaturaPreinscrita!=0){
                        Asignatura preinscrita = (Asignatura) ramos.get(idAsignaturaPreinscrita);
                        ramo.agregarPrerequisito(preinscrita);
                    }
                } 
                ramos.put(idAsignatura, ramo);
                lineaAsignatura = csvAsignaturas.nextLine();
            }
            System.out.println("Datos cargados exitosamente 1/2");
            //================================================================== 
            //Lectura archivo carreras.csv
            csvCarreras = new CSV(locCarreras);
            String lineaCarrera = csvCarreras.firstLine();
            while (lineaCarrera != null) {
                try{
                String nombreCarrera = csvCarreras.get_csvField(lineaCarrera, 0);
                Integer cantSemestres = Integer.parseInt(csvCarreras.get_csvField(lineaCarrera, 1));
                Malla mallaCarrera = new Malla(nombreCarrera, cantSemestres);
  
                for (int i = 2; i<29; i++){
                    //Creacion del mapa de asignaturas
                    int idAsignatura = Integer.parseInt(csvCarreras.get_csvField(lineaCarrera, i));
                    if(idAsignatura!=0){
                        Asignatura asignaturaCarrera = (Asignatura)ramos.get(idAsignatura);
                        mallaCarrera.agregarAsignatura(asignaturaCarrera);
                    }
                }
                lineaCarrera = csvCarreras.nextLine();
                carreras.put(nombreCarrera, mallaCarrera);
                }catch(semestreInvalidException e2){
                    System.out.println("Error en el ingreso de semestres de carrera");
                }
            }
            System.out.println("Datos cargados exitosamente 2/2");
            //================================================================== 
        } 
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
        // Cierro el buffer de lectura
        }
    }
    
}