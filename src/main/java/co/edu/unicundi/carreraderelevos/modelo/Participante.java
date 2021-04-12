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
    
    private byte  corredor;
    
    private boolean bandera;

    /**
     *
     * @param NombreEquipo
     * @param nombreParticipante
     * @param numeroParticipante
     * @param pivote
     * @param corredor
     */
    public Participante(String NombreEquipo, String nombreParticipante, byte numeroParticipante, boolean pivote , byte corredor) {
        this.setNombreEquipo(NombreEquipo);
        this.nombreParticipante = nombreParticipante;
        this.numeroParticipante = numeroParticipante;
        this.pivote = pivote;
        this.corredor = corredor;
    }

    
    @Override
    public synchronized void run(){
        esperar();
        if(pivote!=false){
            correr();
            pivote = false;
        }        
    }

    public synchronized void esperar(){
        try {
            System.out.println("esperando corredor " + numeroParticipante);
            wait();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public synchronized void correr(){

        while (pasos <= 50 ) {
            try {
                Thread.sleep(1000);
                randonPasos();
                System.out.println("pasos del coorredor " + nombreParticipante + " son "+ pasos);
            } catch (InterruptedException ex) {
                Logger.getLogger(Participante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bandera= true;
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
    
    public Object getEspera() {
        return espera;
    }

    public void setEspera(Object espera) {
        this.espera = espera;
    }

    public byte getCorredor() {
        return corredor;
    }
    
    public void setCorredor(byte corredor) {
        this.corredor = corredor;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }


 
}
