/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.modelo;

/**
 * Esta clase hereda los métodos de la clase "Thread" para implementar hilos
 * en su clases hijas.
 * @author Diego Cobos
 * @author César Téllez
 * @since 1.0
 * @version 1.2.9
 */
public abstract class Equipo extends Thread {
    
    //private static Object espera = new Object();
    
    private String nombreEquipo;

    /**
     * Método get del atributo "nombreEquipo".
     * @return nombreEquipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }
    
    /**
     * Método set del atributo "nombreEquipo".
     * @param nombreEquipo
     */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    
}
