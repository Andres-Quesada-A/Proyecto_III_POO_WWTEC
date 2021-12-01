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
public class ThreadAviones extends Thread implements Serializable{
    private static final SClip misil = new SClip("misil.wav");
    private int indice;
    private int x, y;
    private int frencuenciaDisparo;
    private int pesoGolpe;
    private ControladorVideoJuego controlador;
    private int vida;
    private ImageIcon image;
    private ArrayList<ImageIcon> Municion;
    private int direccion; //direccion 1 >>>  2 <<<<
    private boolean Estado = true;

    public ThreadAviones(int indice, int x, int y, int frencuenciaDisparo, int pesoGolpe, ControladorVideoJuego controlador, int vida, ImageIcon image, ArrayList<ImageIcon> Municion, int direccion) {
        this.indice = indice;
        this.x = x;
        this.y = y;
        this.frencuenciaDisparo = frencuenciaDisparo;
        this.pesoGolpe = pesoGolpe;
        this.controlador = controlador;
        this.vida = vida;
        this.image = image;
        this.Municion = Municion;
        this.direccion = direccion;
    }
    
    
    
    public void run(){
        int address = 0;
        while (Estado){
            address = this.controlador.IdentificarEnemigo(x, y, direccion);
            if (address != 0){
                //1: es del ejercito y ataca al pueblo///2: es del pueblo y ataca al ejercito
                this.controlador.RealizarDisparo(x, y, pesoGolpe, address, Municion.get(address - 1), 1);
                ThreadSonido sonido = new ThreadSonido(misil);
                sonido.start();
                try {
                    sleep(frencuenciaDisparo);
                } catch (InterruptedException ex) {
                    System.out.println("Sleep de los aviones");
                }
            }else{
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    System.out.println("Sleep de los aviones");
                }
            }
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
    
    public void ReducirVida(int fuerzaGolpe){
        this.vida = this.vida - fuerzaGolpe;
        if (vida <= 0){
            this.controlador.EliminarAvion(indice);
            ApagarAvion();
        }
    }
    
    //Detiene el ciclo que mantiene vivo al thread
    public void ApagarAvion(){
        this.Estado = false;
    }
    
    public int GetIndice(){
        return this.indice;
    }
}
