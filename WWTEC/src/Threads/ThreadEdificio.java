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
public class ThreadEdificio extends Thread implements Serializable{
    private int x, y;
    private int vida;
    private boolean funcionar = true;
    private ControladorVideoJuego controlador;

    public ThreadEdificio(ControladorVideoJuego controlador, int x, int y) {
        this.controlador = controlador;
        this.x = x;
        this.y = y;
    }

    public void run(){
        while(funcionar){
            
        }
    }
    
    public void BajarVida(int FuerzaGolpe){
        this.vida = this.vida - FuerzaGolpe;
        if (vida <= 0){
            this.controlador.EliminarCasa();
            ApagarThread();
        }
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void ApagarThread(){
        this.funcionar = false;
    }

    public int getVida() {
        return vida;
    }
    
    
}
