/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.modelo;

/**
 * Esta clase hereda de la clase "Thread" y representa al narrador
 * de la carrera de relevos.Es decir, muestra al corredor de acuerdo a su 
 * posición en la pista.
 * @author Diego Cobos
 * @author César Téllez
 * @since 1.0
 * @version 1.2.9
 */
public class Narrador extends Thread{

    /**
     * Almacena la primera posición del corredor.
     */
    byte pocicion1;
    /**
     * Almacena la segunda posición del corredor.
     */
    byte pocicion2;
    /**
     * Almacena la tercera posición del corredor.
     */
    byte pocicion3;
    
    /**
     * Dibuja la primera parte de la figura que refleja al corredor.
     */
    String cabeza1 = "   *   ";
    /**
     * Dibuja la segunda parte de la figura que refleja al corredor.
     */
    String cabeza2 = "  ***  ";
    /**
     * Dibuja la tercera parte de la figura que refleja al corredor.
     */
    String cabeza3 = "   *   ";
        
    /**
     * Método sobreescrito de la clase Thread que corre el hilo
     * principal y los que contenga.
     */
    @Override
    public void run(){
        try {
            Thread.sleep(3000);
            while(true){
                Thread.sleep(1000);
                FiguraEquipo1();
            }
        
        } catch (Exception e) {
        }
    }
    
    /**
     * Método que define los corredores de cada posición en la carrera.
     * @param pocicionJugador1
     * @param pocicionJugador2
     * @param pocicionJugador3 
     */
    public void Equipos( byte pocicionJugador1, byte pocicionJugador2, byte pocicionJugador3){
    
        pocicion1 = pocicionJugador1;
        pocicion2 = pocicionJugador2;
        pocicion3 = pocicionJugador3;
    }
    
    /**
     * Método que dibuja las figuras en la consola de acuerdo a su recorrido.
     */
    public  void FiguraEquipo1(){
        System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %"+pocicion3+"s ", cabeza1, cabeza1, cabeza1+"\n");
        System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %"+pocicion3+"s ", cabeza2, cabeza2, cabeza2+"\n");
        System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %"+pocicion3+"s ", cabeza3, cabeza3, cabeza3+"\n");
        pocicion1+=pocicion1;
        pocicion2-=pocicion1;
        
    }
    
    
            
        
}
