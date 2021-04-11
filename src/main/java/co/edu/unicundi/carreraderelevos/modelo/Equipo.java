/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.modelo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public abstract class Equipo extends Thread{
    
    private static Object espera = new Object();
    
    private String nombreEquipo;

    public String getNombreEquipo() {
        return nombreEquipo;
    }
    
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    
    
}
