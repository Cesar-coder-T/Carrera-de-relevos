/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.controlador;

import co.edu.unicundi.carreraderelevos.modelo.Carrera;

/**
 * Esta clase se encarga de ejecutar el programa.
 * @author Diego Cobos
 * @author César Téllez
 * @since 1.0
 * @version 1.2.9
 */
public class Principal {
    /**
    * Este método se encarga de iniciar la ejecución del programar
    * @param args[] es un arreglo con los parámetros que el reciba por consola
    */
    public static void main(String[] args) {
        //Vista vista = new Vista();
        Carrera car= new Carrera();
        car.iniciar();
    }
}
