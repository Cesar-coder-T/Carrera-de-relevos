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
 * Esta clase contiene las acciones que se realizan en la carrera.
 * @author Diego Cobos
 * @author César Téllez
 * @since 1.0
 * @version 1.2.9
 */
public class Carrera {

    /**
     * Determina si la carrera finalizó.
     */
    boolean finalizar = true;
    /**
     * Aloja el ganador.
     */
    String ganador = "Ganador ";
    /**
     * Objeto de la clase "Narrador".
     */
    Narrador na = new Narrador();

    /**
     * Lista que contiene los corredores.
     */
    List<Corredor> todosCorredores = new ArrayList<>();

    /**
     * Método en donde se crean los objetos, se convierten en hilos y se guardan
     * en la lista.
     */
    public void inicialaizar(){
        Corredor p1 = new Corredor("Diamante", "Carlos", (byte) 1, true, (byte)1,(byte)1);
        Corredor p2 = new Corredor("Diamante", "Daniel", (byte) 2, false, (byte)2, (byte)40);
        Corredor p3 = new Corredor("Diamante", "Cesar", (byte)5,  false,(byte) 3,(byte)50 );
        Corredor p4 = new Corredor("Esmeralda", "Santi", (byte) 3, true,(byte) 1,(byte)1);
        Corredor p5 = new Corredor("Esmeralda", "Sergio", (byte) 4, false,(byte) 2,(byte)40);
        Corredor p6 = new Corredor("Esmeralda", "Miguel", (byte)6, false ,(byte)3,(byte)50);
        Corredor p7 = new Corredor("Ruby", "Dante", (byte)6, true ,(byte)1, (byte)1);
        Corredor p8 = new Corredor("Ruby", "Francisco", (byte)6, false ,(byte)2,(byte)40);
        Corredor p9 = new Corredor("Ruby", "Homero", (byte)6, false ,(byte)3,(byte)50);
        
        
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
    
    /**
     * Método que se encarga de determinar la salir del corredor.
     */
    public void salir(){
        
        try {
            inicialaizar();
            Thread.sleep(2000);
            System.out.println("a correr");
            
            while(finalizar){
                Imprimir(todosCorredores);
                for (Corredor c : todosCorredores ) {
                    if(c.getCorredor() ==3 && c.isBandera() == true){
                        ganador = ganador+ c.getNombreEquipo();
                        System.out.println("Termino la carrera Y el " + ganador);
                        finalizar(todosCorredores);
                        return;
                    }
                }
                Imprimir(todosCorredores);
                pasarPivote(todosCorredores);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que se encarga de despertar al hilo que le corresponda
     * correr de acuerdo al pivote(Si tiene el pivote corra, del lo contrario no).
     * @param equipo 
     */
    public void pasarPivote(List<Corredor> equipo){
        for (Corredor c2 : equipo) {
            if(c2.isPivote()== true){
                synchronized(c2){
                    c2.notify();
                }
            }
            if(c2.getCorredor() == 1 && c2.isPivote() == false ){
                for (Corredor c3 : equipo) {
                    if(c3.getNombreEquipo().equals(c2.getNombreEquipo())){
                        if(c3.getCorredor() == 2 && c3.isBandera() == false){
                            c3.setPivote(true);
                        }
                    }
                }
            }if(c2.getCorredor() == 2 && c2.isBandera() == true && c2.isPivote() == false){
                for(Corredor c3 : equipo){
                    if(c3.getNombreEquipo().equals(c2.getNombreEquipo())){
                        if(c3.getCorredor() == 3 && c3.isBandera() == false){
                            c3.setPivote(true);
                        }
                    }
                }
            }
        }
    }

    /**
     * Método encargado de finalizar la carrera (Terminar la ejecución de los hilos).
     * @param lista 
     */
    private void finalizar(List<Corredor> lista) {
        for (Corredor c : lista) {
            c.interrupt();
        }
        
    }
    
    /**
     * Método encargado de mostrar las posiciones de cada corredor.
     * @param lista 
     */
    private void Imprimir(List<Corredor> lista){
        byte pocicionCorredor1=0;
        byte pocicionCorredor2=0;
        byte pocicionCorredor3=0;       
        for (Corredor c1 : lista) {
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
        for (Corredor c1 : lista) {
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
        for (Corredor c1 : lista) {
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

