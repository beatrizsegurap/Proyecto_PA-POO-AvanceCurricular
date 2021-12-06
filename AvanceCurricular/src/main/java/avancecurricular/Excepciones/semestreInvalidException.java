/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avancecurricular.Excepciones;

/**
 *
 * @author beatr
 */
public class semestreInvalidException extends Exception{
    public semestreInvalidException(){
        super("Cantidad de semestres invalido");
    }
}
