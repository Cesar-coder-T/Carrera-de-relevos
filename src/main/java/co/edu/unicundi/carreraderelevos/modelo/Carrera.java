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
    private boolean finalizar = true;
    /**
     * Aloja el ganador.
     */
    private String ganador = "Ganador ";
    /**
     * Objeto de la clase "Narrador".
     */
    private Narrador na = new Narrador();

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
        Corredor p2 = new Corredor("Diamante", "Daniel", (byte) 2, false, (byte)2, (byte)30);
        Corredor p3 = new Corredor("Diamante", "Cesar", (byte)5,  false,(byte) 3,(byte)30);
        Corredor p4 = new Corredor("Esmeralda", "Santi", (byte) 3, true,(byte) 1,(byte)1);
        Corredor p5 = new Corredor("Esmeralda", "Sergio", (byte) 4, false,(byte) 2,(byte)30);
        Corredor p6 = new Corredor("Esmeralda", "Miguel", (byte)6, false ,(byte)3,(byte)30);
        Corredor p7 = new Corredor("Ruby", "Dante", (byte)6, true ,(byte)1, (byte)1);
        Corredor p8 = new Corredor("Ruby", "Francisco", (byte)6, false ,(byte)2,(byte)30);
        Corredor p9 = new Corredor("Ruby", "Homero", (byte)6, false ,(byte)3,(byte)30);
        
        
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
        getNa().start();
    }
    
    /**
     * Método que se encarga de determinar la salir del corredor.
     */
    public void salir(){
        
        try {
            inicialaizar();
            Thread.sleep(2000);
            System.out.println("a correr");
            while(isFinalizar()){
                Imprimir(todosCorredores);
                pasarPivote(todosCorredores);
                for (Corredor todosCorredore : todosCorredores) {
                    if(todosCorredore.getCorredor() == 3 && todosCorredore.isPivote() == true){
                        setFinalizar(false);
                    }
                }
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
                    c2.notifyAll();
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
            }else if(c2.getCorredor() == 2 && c2.isBandera() == true && c2.isPivote() == false){
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
    
    
    /**
     * Método encargado de mostrar las posiciones de cada corredor.
     * @param lista 
     */
    private void Imprimir(List<Corredor> lista){
        
        na.Equipos(lista);

    }

    /**
     * @return the finalizar
     */
    public boolean isFinalizar() {
        return finalizar;
    }

    /**
     * @param finalizar the finalizar to set
     */
    public void setFinalizar(boolean finalizar) {
        this.finalizar = finalizar;
    }

    /**
     * @return the ganador
     */
    public String getGanador() {
        return ganador;
    }

    /**
     * @param ganador the ganador to set
     */
    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    /**
     * @return the na
     */
    public Narrador getNa() {
        return na;
    }

    /**
     * @param na the na to set
     */
    public void setNa(Narrador na) {
        this.na = na;
    }
    

}

