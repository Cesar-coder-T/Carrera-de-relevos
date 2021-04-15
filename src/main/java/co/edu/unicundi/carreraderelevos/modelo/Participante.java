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
 * @author Diego y Cesar
 */
public class Participante extends Equipo {

    
    private String nombreParticipante;
    
    private byte numeroParticipante;
    
    private byte Pocicion;
    
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
    public Participante(String NombreEquipo, String nombreParticipante, byte numeroParticipante, boolean pivote , byte corredor, byte pasos) {
        super.setNombreEquipo(NombreEquipo);
        this.nombreParticipante = nombreParticipante;
        this.numeroParticipante = numeroParticipante;
        this.pivote = pivote;
        this.corredor = corredor;
        this.pasos =pasos;
    }

    
    @Override
    public void run(){
        while(true){
            if(pivote!=false){
                correr();
                pivote = false;
            }
            esperar();
        }
             
    }
    /*
    funcion que pone en espera a  los jugadores
    */
    public synchronized void esperar(){
        try {
            System.out.println("esperando corredor " + nombreParticipante);
            wait();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
    public synchronized void correr(){
        try {
            byte cont =0;
            switch(corredor){
                case 1: 
                    while (pasos <= 30 ) {
                        Thread.sleep(1000);
                        cont = (byte) (Math.random()*4+1);
                        pasos+=cont;
                        cont=cont;
                    }
                    pasos = 30;
                    break;
                case 2 :
                    while(pasos <= 40){
                        Thread.sleep(1000);
                        cont = (byte) (Math.random()*4+1);
                        pasos+=cont;
                        cont=cont;
                       
                    }
                    break;
                case 3:
                    while(pasos <= 60){
                        Thread.sleep(1000);
                        cont = (byte) (Math.random()*4+1);
                        pasos+=cont;
                        cont=cont;
                        
                    }
                    break;
        }
        bandera = true;
        } catch (InterruptedException ex) {
                Logger.getLogger(Participante.class.getName()).log(Level.SEVERE, null, ex);
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

    public byte getPocicion() {
        return Pocicion;
    }

    public void setPocicion(byte Pocicion) {
        this.Pocicion = Pocicion;
    }

}
