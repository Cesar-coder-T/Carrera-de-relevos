/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicundi.carreraderelevos.vista;

import co.edu.unicundi.carreraderelevos.modelo.Corredor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    List<Corredor> info = new ArrayList<>();
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
     * Método sobreescrito de la clase Thread que corre el hilo
     * principal y los que contenga.
     */
    @Override
    public void run(){
        try {
            byte cont =1;
            Thread.sleep(5000);
            while(cont <= 15){
                FiguraEquipo1();
                FiguraEquipo2();
                FiguraEquipo3();
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                cont++;
            }
            
        }
        catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que define los corredores de cada posición en la carrera.
     * @param equipo 
     */
    public void Equipos(List<Corredor> equipo){
        info = equipo;
    }
    
    /**
     * Método que dibuja la figura del equipo 1 conforme a su posición en la carrera
     * en la consola
     */
    public  void FiguraEquipo1(){
        String cabeza1 = "   *   ";
        String cabeza2 = "  ***  ";
        String cabeza3 = "   *   ";
        try {
            for (Corredor corredor : info) {
                if(corredor.getCorredor()==1 && corredor.getNombreEquipo().equals("Diamante")){
                    pocicion1 = corredor.getPasos();
                }else if(corredor.getCorredor() ==2 && corredor.getNombreEquipo().equals("Diamante")){
                    pocicion2 = corredor.getPasos();
                }else if(corredor.getCorredor() ==3 && corredor.getNombreEquipo().equals("Diamante")){
                    pocicion3 = corredor.getPasos();
                }
            }
                Thread.sleep(1000);
                if (pocicion1 <30) {
                    pocicion2-=pocicion1;
                    System.out.println(pocicion1);
                    System.out.println("________________________________________________________________________________________________________________________________");
                    System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %30s ", cabeza1, cabeza1, cabeza1+"\n");
                    System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %30s ", cabeza2, cabeza2, cabeza2+"\n");
                    System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %30s ", cabeza3, cabeza3, cabeza3+"\n");
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    
                }else if(pocicion2 < 30){
                    
                    System.out.println(pocicion2);
                    pocicion3-=pocicion2;
                    System.out.println("________________________________________________________________________________________________________________________________");
                    System.out.printf("%30s %"+pocicion2+"s %"+pocicion3+"s ", cabeza1, cabeza1, cabeza1+"\n");
                    System.out.printf("%30s %"+pocicion2+"s %"+pocicion3+"s ", cabeza2, cabeza2, cabeza2+"\n");
                    System.out.printf("%30s %"+pocicion2+"s %"+pocicion3+"s ", cabeza3, cabeza3, cabeza3+"\n");
                    System.out.println("_________________________________________________________________________________________________________________________________");
   
                }else if(pocicion3 < 30){
                    
                    System.out.println(pocicion3);
                    System.out.println("________________________________________________________________________________________________________________________________");
                    System.out.printf("%30s %30s %"+pocicion3+"s ", cabeza1, cabeza1, cabeza1+"\n");
                    System.out.printf("%30s %30s %"+pocicion3+"s ", cabeza2, cabeza2, cabeza2+"\n");
                    System.out.printf("%30s %30s %"+pocicion3+"s ", cabeza3, cabeza3, cabeza3+"\n");
                    System.out.println("_________________________________________________________________________________________________________________________________");
  
                }
            
                
        }
        catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método que dibuja la figura del equipo 2 conforme a su posición en la carrera
     * en la consola
     */
    public  void FiguraEquipo2(){
        String cabeza1 = "   ****   ";
        String cabeza2 = "   *  *  ";
        String cabeza3 = "   ****   ";
        try {
            for (Corredor corredor : info) {
                if(corredor.getCorredor()==1 && corredor.getNombreEquipo().equals("Esmeralda")){
                    pocicion1 = corredor.getPasos();
                }else if(corredor.getCorredor() ==2 && corredor.getNombreEquipo().equals("Esmeralda")){
                    pocicion2 = corredor.getPasos();
                }else if(corredor.getCorredor() ==3 && corredor.getNombreEquipo().equals("Esmeralda")){
                    pocicion3 = corredor.getPasos();
                }
            }
                Thread.sleep(1000);
                if (pocicion1 <30) {
                    pocicion2-=pocicion1;
                    System.out.println(pocicion1);
                    System.out.println("________________________________________________________________________________________________________________________________");
                    System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %30s ", cabeza1, cabeza1, cabeza1+"\n");
                    System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %30s ", cabeza2, cabeza2, cabeza2+"\n");
                    System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %30s ", cabeza3, cabeza3, cabeza3+"\n");
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    
                }else if(pocicion2 < 30){
                    
                    System.out.println(pocicion2+ " corredor 2");
                    pocicion3-=pocicion2;
                    System.out.println("________________________________________________________________________________________________________________________________");
                    System.out.printf("%30s %"+pocicion2+"s %"+pocicion3+"s ", cabeza1, cabeza1, cabeza1+"\n");
                    System.out.printf("%30s %"+pocicion2+"s %"+pocicion3+"s ", cabeza2, cabeza2, cabeza2+"\n");
                    System.out.printf("%30s %"+pocicion2+"s %"+pocicion3+"s ", cabeza3, cabeza3, cabeza3+"\n");
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    pocicion2-= pocicion1;
                }else if(pocicion3 < 30){
                    
                    System.out.println(pocicion3);
                    System.out.println("________________________________________________________________________________________________________________________________");
                    System.out.printf("%30s %30s %"+pocicion3+"s ", cabeza1, cabeza1, cabeza1+"\n");
                    System.out.printf("%30s %30s %"+pocicion3+"s ", cabeza2, cabeza2, cabeza2+"\n");
                    System.out.printf("%30s %30s %"+pocicion3+"s ", cabeza3, cabeza3, cabeza3+"\n");
                    System.out.println("_________________________________________________________________________________________________________________________________");
  
                }
            
                
        }
        catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Método que dibuja la figura del equipo 3 conforme a su posición en la carrera
     * en la consola
     */
    public  void FiguraEquipo3(){
        String cabeza1 = "***  ***";
        String cabeza2 = "  ***  ";
        String cabeza3 = "***  ***";
        try {
            for (Corredor corredor : info) {
                if(corredor.getCorredor()==1 && corredor.getNombreEquipo().equals("Ruby")){
                    pocicion1 = corredor.getPasos();
                }else if(corredor.getCorredor() ==2 && corredor.getNombreEquipo().equals("Ruby")){
                    pocicion2 = corredor.getPasos();
                }else if(corredor.getCorredor() ==3 && corredor.getNombreEquipo().equals("Ruby")){
                    pocicion3 = corredor.getPasos();
                }
            }
                Thread.sleep(1000);
                if (pocicion1 <30) {
                    pocicion2-=pocicion1;
                    System.out.println(pocicion1);
                    
                    System.out.println("________________________________________________________________________________________________________________________________");
                    System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %30s ", cabeza1, cabeza1, cabeza1+"\n");
                    System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %30s ", cabeza2, cabeza2, cabeza2+"\n");
                    System.out.printf("%"+pocicion1+"s %"+pocicion2+"s %30s ", cabeza3, cabeza3, cabeza3+"\n");
                    System.out.println("_________________________________________________________________________________________________________________________________");
                }else if(pocicion2 < 30){
                    System.out.println(pocicion2);
                    pocicion3-=pocicion2;
                    System.out.println("________________________________________________________________________________________________________________________________");
                    System.out.printf("%30s %"+pocicion2+"s %"+pocicion3+"s ", cabeza1, cabeza1, cabeza1+"\n");
                    System.out.printf("%30s %"+pocicion2+"s %"+pocicion3+"s ", cabeza2, cabeza2, cabeza2+"\n");
                    System.out.printf("%30s %"+pocicion2+"s %"+pocicion3+"s ", cabeza3, cabeza3, cabeza3+"\n");
                    System.out.println("_________________________________________________________________________________________________________________________________");
                    pocicion2-= pocicion1;
                }else if(pocicion3 < 30){
                    System.out.println(pocicion1);
                    System.out.println("________________________________________________________________________________________________________________________________");
                    System.out.printf("%30s %30s %"+pocicion3+"s ", cabeza1, cabeza1, cabeza1+"\n");
                    System.out.printf("%30s %30s %"+pocicion3+"s ", cabeza2, cabeza2, cabeza2+"\n");
                    System.out.printf("%30s %30s %"+pocicion3+"s ", cabeza3, cabeza3, cabeza3+"\n");
                    System.out.println("_________________________________________________________________________________________________________________________________");
  
                }
        }
        catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
            
        
}
