/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.modelo;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Participante extends Equipo{
    
    private String nombreParticipante;
    
    private byte numeroParticipante;
    
    private Object espera = new Object();
    
    private byte pasos;
    
    private boolean pivote ;
    
    private boolean bandera = false;

    public Participante(String NombreEquipo, String nombreParticipante, byte numeroParticipante, boolean pivote) {
        this.setNombreEquipo(nombreParticipante);
        this.nombreParticipante = nombreParticipante;
        this.numeroParticipante = numeroParticipante;
        this.pivote = pivote;
    }
    
    @Override
    public synchronized void run(){
        while(true){           
            if (pivote != true){
                pivote = true;
                esperar();
            }else{
                if(bandera == false){
                   correr();
                   bandera=true;
                }
            }
            if(bandera == true){
               
                notifyAll();
            
            }
        }
    }

    private synchronized  void esperar(){
        try {
            System.out.println("esperando corredor " + numeroParticipante);
            wait();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public synchronized void correr(){
        while (pasos <= 50 ) {
            randonPasos();
            System.out.println("pasos del coorredor " + nombreParticipante + " son "+ pasos);
        }
        
    } 
    
    public byte randonPasos(){
        Random p = new Random();
        
        pasos += (byte) p.nextInt(4) + 1;
        return pasos;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public boolean isCorreo() {
        return bandera;
    }

    public void setCorreo(boolean correo) {
        this.bandera = correo;
    }
    
    public byte getPasos() {
        return pasos;
    }

    public void setPasos(byte pasos) {
        this.pasos = pasos;
    }

    public byte getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(byte numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public boolean isPivote() {
        return pivote;
    }

    public void setPivote(boolean Pivote) {
        this.pivote = Pivote;
    }
    
    
}
