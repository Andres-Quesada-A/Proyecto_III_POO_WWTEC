/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Juego.ControladorVideoJuego;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ThreadTanque extends Thread implements Serializable{
    private int indice;
    private int x, y;
    private int frencuenciaDisparo;
    private int pesoGolpe;
    private ControladorVideoJuego controlador;
    private ImageIcon imagen;
    private ArrayList<ImageIcon> Municion;
    private int vida;
    private boolean Estado = true;
    private int direccion;

    public ThreadTanque(int indice, int x, int y, int frencuenciaDisparo, int pesoGolpe, ControladorVideoJuego controlador, ImageIcon imagen, ArrayList<ImageIcon> Municion, int vida, int direccion) {
        this.indice = indice;
        this.x = x;
        this.y = y;
        this.frencuenciaDisparo = frencuenciaDisparo;
        this.pesoGolpe = pesoGolpe;
        this.controlador = controlador;
        this.imagen = imagen;
        this.Municion = Municion;
        this.vida = vida;
        this.direccion = direccion;
    }
    
    
    
    public void run(){
        int address = 0;
        while (true){
            address = this.controlador.IdentificarEnemigo(x, y, direccion);
            if (address != 0){
                //1: es del ejercito y ataca al pueblo///2: es del pueblo y ataca al ejercito
                this.controlador.RealizarDisparo(x, y, pesoGolpe, address, Municion.get(address - 1), 1);
                try {
                    sleep(frencuenciaDisparo);
                } catch (InterruptedException ex) {
                    System.out.println("Sleep de los tanques");
                }
            }else{
                try {
                    sleep(100);
                } catch (InterruptedException ex) {
                    System.out.println("Sleep de los tanques");
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
            this.controlador.EliminarTanque(indice);
            ApagarTanque();
        }
    }
    
    //Detiene el ciclo que mantiene vivo al thread
    public void ApagarTanque(){
        this.Estado = false;
    }
    
    public int GetIndice(){
        return this.indice;
    }
}
