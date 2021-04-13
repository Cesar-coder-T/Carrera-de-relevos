/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.modelo;

import java.util.ArrayList;
import java.util.Collection;
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
    
    boolean finalizar = true;
    String ganador = "Ganador ";

    List<Participante> equipo1 = new ArrayList<>();
    List<Participante> equipo2 = new ArrayList<>();

    public void inicialaizar(){
        Participante p1 = new Participante("Diamante", "Carlos", (byte) 1, true, (byte)1);
        Participante p2 = new Participante("Diamante", "Daniel", (byte) 2, false, (byte)2);
        Participante p5 = new Participante("Diamante", "Cesar", (byte)5,  false,(byte) 3 );
        Participante p3 = new Participante("Esmeralda", "Santi", (byte) 3, true,(byte) 1);
        Participante p4 = new Participante("Esmeralda", "Sergio", (byte) 4, false,(byte) 2);
        Participante p6 = new Participante("Esmeralda", "Miguel", (byte)6, false ,(byte)3);
        
        equipo1.add(p1);
        equipo1.add(p2);
        equipo2.add(p3);
        equipo2.add(p4);
        equipo1.add(p5);
        equipo2.add(p6);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
    }
    
    public void salida(){
        boolean finalizar = true;
        try {
            inicialaizar();
            Thread.sleep(2000);
            System.out.println("a correr");
            int con =1;
                
            while(finalizar){
                despertar(equipo1);
                pasoPivote(equipo1);
                despertar(equipo2);
                pasoPivote(equipo2);
                for (Participante c : equipo1 ) {
                    
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Termino la carrera Y el " + ganador);
       
    }

    public void despertar(List<Participante> equipo){
        for (Participante c : equipo) {
            c.despertar(equipo);
        }
    }
    public void pasoPivote(List<Participante> equipo){

        for (Participante c2 : equipo) {
            if(c2.getCorredor() == 1 && c2.isPivote() == false ){
                for (Participante c3 : equipo) {
                    if(c3.getNombreEquipo().equals(c2.getNombreEquipo())){
                        if(c3.getCorredor() == 2 && c3.isBandera() == false){
                            c3.setPivote(true);
                        }
                    }
                }
            }if(c2.getCorredor() == 2 && c2.isBandera() == true && c2.isPivote() == false){
                for(Participante c3 : equipo){
                    if(c3.getNombreEquipo().equals(c2.getNombreEquipo())){
                        if(c3.getCorredor() == 3 && c3.isBandera() == false){
                            c3.setPivote(true);
                        }
                    }
                }
            }
        }
    }
    

}

