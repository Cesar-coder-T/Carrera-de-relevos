/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Carrera {

    boolean finalizar = true;
    String ganador = "Ganador ";
    Narrador na = new Narrador();

    List<Participante> todosCorredores = new ArrayList<>();

    public void inicialaizar(){
        Participante p1 = new Participante("Diamante", "Carlos", (byte) 1, true, (byte)1,(byte)1);
        Participante p2 = new Participante("Diamante", "Daniel", (byte) 2, false, (byte)2, (byte)40);
        Participante p3 = new Participante("Diamante", "Cesar", (byte)5,  false,(byte) 3,(byte)50 );
        Participante p4 = new Participante("Esmeralda", "Santi", (byte) 3, true,(byte) 1,(byte)1);
        Participante p5 = new Participante("Esmeralda", "Sergio", (byte) 4, false,(byte) 2,(byte)40);
        Participante p6 = new Participante("Esmeralda", "Miguel", (byte)6, false ,(byte)3,(byte)50);
        Participante p7 = new Participante("Ruby", "Dante", (byte)6, true ,(byte)1, (byte)1);
        Participante p8 = new Participante("Ruby", "Francisco", (byte)6, false ,(byte)2,(byte)40);
        Participante p9 = new Participante("Ruby", "Homero", (byte)6, false ,(byte)3,(byte)50);
        
        
        todosCorredores.add(p1);
        todosCorredores.add(p2);
        todosCorredores.add(p3);
        todosCorredores.add(p4);
        todosCorredores.add(p5);
        todosCorredores.add(p6);
        todosCorredores.add(p7);
        todosCorredores.add(p8);
        todosCorredores.add(p9);
        
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
        p8.start();
        p9.start();
        na.start();
    }
    
    public void salida(){
        
        try {
            inicialaizar();
            Thread.sleep(2000);
            System.out.println("a correr");
            
            while(finalizar){
                Imprimir(todosCorredores);
                for (Participante c : todosCorredores ) {
                    if(c.getCorredor() ==3 && c.isBandera() == true){
                        ganador = ganador+ c.getNombreEquipo();
                        System.out.println("Termino la carrera Y el " + ganador);
                        finalizar(todosCorredores);
                        return;
                    }
                }
                Imprimir(todosCorredores);
                pasoPivote(todosCorredores);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void pasoPivote(List<Participante> equipo){
        for (Participante c2 : equipo) {
            if(c2.isPivote()== true){
                synchronized(c2){
                    c2.notify();
                }
            }
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

    private void finalizar(List<Participante> lista) {
        for (Participante c : lista) {
            c.interrupt();
        }
        
    }
    
    private void Imprimir(List<Participante> lista){
        byte pocicionCorredor1=0;
        byte pocicionCorredor2=0;
        byte pocicionCorredor3=0;       
        for (Participante c1 : lista) {
            if(c1.getNombreEquipo().equals("Diamante") && c1.getCorredor() == 1){
                pocicionCorredor1 =(byte) c1.getPasos();
            }
            if(c1.getNombreEquipo().equals("Diamante") && c1.getCorredor() == 2){
                pocicionCorredor2 =(byte) c1.getPasos();
            }
            if(c1.getNombreEquipo().equals("Diamante") && c1.getCorredor() == 3){
                pocicionCorredor3 =(byte) c1.getPasos();
            }
        }
        na.Equipos(pocicionCorredor1, pocicionCorredor2, pocicionCorredor3);
        for (Participante c1 : lista) {
            if(c1.getNombreEquipo().equals("Esmeralda")&& c1.getCorredor() == 1){
                pocicionCorredor1 =(byte) c1.getPasos();
            }
            if(c1.getNombreEquipo().equals("Esmeralda")&& c1.getCorredor() == 2){
                pocicionCorredor2 =(byte) c1.getPasos();
            }
            if(c1.getNombreEquipo().equals("Esmeralda")&& c1.getCorredor() == 3){
                pocicionCorredor3 =(byte) c1.getPasos();
            }
        }
        //na.Equipos(pocicionCorredor1, pocicionCorredor2, pocicionCorredor3);
        for (Participante c1 : lista) {
            if(c1.getNombreEquipo().equals("Ruby")&& c1.getCorredor() == 1){
                pocicionCorredor1 =(byte) c1.getPasos();
            }
            if(c1.getNombreEquipo().equals("Ruby")&& c1.getCorredor() == 2){
                pocicionCorredor2 =(byte) c1.getPasos();
            }
            if(c1.getNombreEquipo().equals("Ruby")&& c1.getCorredor() == 3){
                pocicionCorredor3 =(byte) c1.getPasos();
            }
        }
        //na.Equipos(pocicionCorredor1, pocicionCorredor2, pocicionCorredor3);
    }
    

}

