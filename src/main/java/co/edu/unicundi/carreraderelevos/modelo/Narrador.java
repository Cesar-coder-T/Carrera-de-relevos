/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class Narrador extends Thread{

    byte pocicion1;
    byte pocicion2;
    byte pocicion3;
    
        String cabeza1 = "   *   ";
        String cabeza2 = "  ***  ";
        String cabeza3 = "   *   ";
        
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
    
    public void Equipos( byte pocicionJugador1, byte pocicionJugador2, byte pocicionJugador3){
    
        pocicion1 = pocicionJugador1;
        pocicion2 = pocicionJugador2;
        pocicion3 = pocicionJugador3;
    }
    
    public  void FiguraEquipo1(){
        System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %"+pocicion3+"s ", cabeza1, cabeza1, cabeza1+"\n");
        System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %"+pocicion3+"s ", cabeza2, cabeza2, cabeza2+"\n");
        System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %"+pocicion3+"s ", cabeza3, cabeza3, cabeza3+"\n");
        pocicion1+=pocicion1;
        pocicion2-=pocicion1;
        
    }
    
    
            
        
}
