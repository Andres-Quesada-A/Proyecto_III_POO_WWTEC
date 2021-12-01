/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Juego.ControladorVideoJuego;
import Sonido.SClip;
import Sonido.ThreadSonido;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ThreadBomba extends Thread implements Serializable{
    private static final SClip bomba = new SClip("bomba.wav");
    private int x, y;
    private int indice;
    private ArrayList<ImageIcon> explosion;
    private ControladorVideoJuego controlador;
    private int alcance;
    private boolean Estado = true;

    public ThreadBomba(int x, int y, int indice, ArrayList<ImageIcon> explosion, ControladorVideoJuego controlador, int alcance) {
        this.x = x;
        this.y = y;
        this.indice = indice;
        this.explosion = explosion;
        this.controlador = controlador;
        this.alcance = alcance;
    }
    
    public void run(){
        while (Estado){
            if (!this.controlador.explotarBomba(indice, x, y)){
                ThreadSonido sonido = new ThreadSonido(bomba);
                sonido.start();
                for (int i = 0; i < explosion.size(); i++){
                    this.controlador.CambiarLabelBomba(indice, explosion.get(i));
                    try {
                        sleep(80);
                    } catch (InterruptedException ex) {
                        System.out.println("Interrupcion del thread bomba");
                    }
                }
                this.controlador.EliminarBomba(indice);
                this.controlador.ReducirVidaejercito(x, y, alcance);
                while(true){
                    try {
                        sleep(2000);
                    } catch (InterruptedException ex) {
                        System.out.println("Pausa");
                    }
                }
            }
        }
    }
    
    
    public void ApagarBomba(){
        this.Estado = false;
    }
    
    public int getIndice(){
        return this.indice;
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
    
    public int GetIndice(){
        return this.indice;
    }
}
