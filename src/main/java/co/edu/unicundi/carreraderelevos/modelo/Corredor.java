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
 * Esta clase hereda de la clase "Equipo" y representa al corredor. Aquí, se 
 * puede encontrar las acciones que va a desempeñar en la carrera.
 * @author Diego Cobos
 * @author César Téllez
 * @since 1.0
 * @version 1.2.9
 */
public class Corredor extends Equipo {

    /**
     * Almacena el nombre del corredor.
     */
    private String nombreParticipante;
    /**
     * Almacena el número de cada corredor.
     */
    private byte numeroParticipante;
    /**
     * Almacena la posición del corredor.
     */
    private byte posicion;
    /**
     * Almacena los pasos que va a realizar el corredor.
     */
    private byte pasos;
    /**
     * Define el estado del pivote conforme a la posición del corredor.
     */
    private boolean pivote ;
    /**
     * Almacena el número del corredor.
     */
    private byte  corredor;
    /**
     * Define el estado del final de la carrera. 
     */
    private boolean bandera = false;
    
    /**
     * Constructor por defecto de la clase.
     */
    public Corredor(){
        
    }

    /**
     * Constructor sobrecargado.
     * @param NombreEquipo
     * @param nombreParticipante
     * @param numeroParticipante
     * @param pivote
     * @param corredor
     */
    public Corredor(String NombreEquipo, String nombreParticipante, byte numeroParticipante, boolean pivote , byte corredor, byte pasos) {
        super.setNombreEquipo(NombreEquipo);
        this.nombreParticipante = nombreParticipante;
        this.numeroParticipante = numeroParticipante;
        this.pivote = pivote;
        this.corredor = corredor;
        this.pasos =pasos;
    }

    /**
     * Método sobreescrito de la clase Thread que corre el hilo
     * principal y los que contenga.
     */
    @Override
    public void run(){
        esperar();
        if(pivote!=false){
            correr();
            pivote = false;
        }if(corredor == 3 && pivote == false ){
            System.out.println("!!!LLego el equipo: " + this.getNombreEquipo()+"!!!");
        }
        interrupt();       
    }
    
    /**
     * Método que pone a esperar a los corredores.
     */
    public synchronized void esperar(){
        try {
            System.out.println("Esperando corredor: " + nombreParticipante);
            wait();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
    /**
     * Método que determina cuanto debe correr el corredor.
     */
    public synchronized void correr(){
        try {
            byte cont =0;
            switch(corredor){
                case 1: 
                    pasos = 1;
                    while (pasos <= 30 ) {
                        Thread.sleep(1000);
                        cont = (byte) (Math.random()*4+1);
                        pasos += cont;
                    }
                    pasos = 30;
                    break;
                case 2 :
                    pasos=1;
                    while(pasos <= 30){
                        Thread.sleep(1000);
                        cont = (byte) (Math.random()*4+1);
                        pasos += cont;  
                    }
                    pasos =30;
                    break;
                case 3:
                    pasos=1;
                    while(pasos <= 30){
                        Thread.sleep(1000);
                        cont = (byte) (Math.random()*4+1);
                        pasos += cont;
                    }
                    pasos=30;
                    break;
        }
        bandera = true;
        } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    /**
     * Método que establece los pasos que da el corredor.
     * @return 
     */
    public byte randonPasos(){
        Random p = new Random();
        pasos += (byte) p.nextInt(4) + 1;
        return pasos;
    }


    /**
     * Método get del atributo "nombreParticipante"
     * @return 
     */
    public String getNombreParticipante() {
        return nombreParticipante;
    }

    /**
     * Método set del atributo "nombreParticipante"
     * @param nombreParticipante 
     */
    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }
    
    /**
     * Método get del atributo "pasos"
     * @return 
     */
    public byte getPasos() {
        return pasos;
    }

    /**
     * Método set del atributo "pasos"
     * @param pasos 
     */
    public void setPasos(byte pasos) {
        this.pasos = pasos;
    }

    /**
     * Método get del atributo "numeroParticipante"
     * @return 
     */
    public byte getNumeroParticipante() {
        return numeroParticipante;
    }

    /**
     * Método set del atributo "numeroParticipante"
     * @param numeroParticipante 
     */
    public void setNumeroParticipante(byte numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    /**
     * Método is del atributo "pivote"
     * @return 
     */
    public boolean isPivote() {
        return pivote;
    }

    /**
     * Método set del atributo "pivote"
     * @param Pivote 
     */
    public void setPivote(boolean Pivote) {
        this.pivote = Pivote;
    }

    /**
     * Método get del atributo "corredor"
     * @return 
     */
    public byte getCorredor() {
        return corredor;
    }
    
    /**
     * Método set del atributo "corredor"
     * @param corredor 
     */
    public void setCorredor(byte corredor) {
        this.corredor = corredor;
    }

    /**
     * Método is del atributo "bandera"
     * @return 
     */
    public boolean isBandera() {
        return bandera;
    }

    /**
     * Método set del atributo "bandera"
     * @param bandera 
     */
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    /**
     * Método get del atributo "posicion"
     * @return 
     */
    public byte getPosicion() {
        return posicion;
    }

    /**
     * Método set del atributo "posicion"
     * @param Pocicion 
     */
    public void setPosicion(byte Pocicion) {
        this.posicion = Pocicion;
    }

}
