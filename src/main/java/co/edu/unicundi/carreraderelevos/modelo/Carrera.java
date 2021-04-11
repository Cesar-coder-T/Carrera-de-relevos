/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.modelo;

import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Carrera {

    public Carrera() {
    }
    
    Participante p1 = new Participante("Diamanete", "Carlos", (byte) 1, true);
    Participante p2 = new Participante("Diamanete", "Daniel", (byte) 2, false);
    Participante p3 = new Participante("Diamanete", "Santi", (byte) 3, true);
    Participante p4 = new Participante("Diamanete", "Sergio", (byte) 4, false);
    
    public void salida(){
        
       p1.start();
       p2.start();
       p3.start();
       p4.start();
    }
}

