/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Juego.ControladorVideoJuego;
import java.io.Serializable;

/**
 *
 * @author andre
 */
public class ThreadMuro extends Thread implements Serializable{
    private int x, y;
    private int vida;
    private boolean Estado = true;
    private ControladorVideoJuego controlador;
    private int indice;

    public ThreadMuro(int x, int y, int vida, ControladorVideoJuego controlador, int indice) {
        this.x = x;
        this.y = y;
        this.vida = vida;
        this.controlador = controlador;
        this.indice = indice;
    }
    
    
    
    public void run(){
        while(Estado){
            
        }
    }
        
    public void ReducirVida(int fuerzaGolpe){
        this.vida = this.vida - fuerzaGolpe;
        if (vida <= 0){
            this.controlador.EliminarMuro(indice);
            ApagarMuro();
        }
    }
    
    //Detiene el ciclo que mantiene vivo al thread
    public void ApagarMuro(){
        this.Estado = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getIndice() {
        return indice;
    }
    
    
}
