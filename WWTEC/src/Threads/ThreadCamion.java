/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Juego.ControladorVideoJuego;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ThreadCamion extends Thread implements Serializable{
    private int indice;
    private int x, y;
    private int frencuenciaDisparo;
    private int pesoGolpe;
    private ControladorVideoJuego controlador;
    private int vida;
    private ImageIcon imagen;
    private boolean Estado = true;
    private int direccion;
    private int distancia;

    public ThreadCamion(int indice, int x, int y, int frencuenciaDisparo, int pesoGolpe, ControladorVideoJuego controlador, int vida, ImageIcon imagen, int direccion, int distancia) {
        this.indice = indice;
        this.x = x;
        this.y = y;
        this.frencuenciaDisparo = frencuenciaDisparo;
        this.pesoGolpe = pesoGolpe;
        this.controlador = controlador;
        this.vida = vida;
        this.imagen = imagen;
        this.direccion = direccion;
        this.distancia = distancia;
    }

    
    
    
    public void run(){
        int[] coordEnemigo = {0, 0};
        while (Estado){
            coordEnemigo = this.controlador.ChoqueConEnemigo(x + distancia, y);
            if (coordEnemigo[0] != 0){ //Si debe golpear
                try {
                        sleep(frencuenciaDisparo);
                    } catch (InterruptedException ex) {
                        System.out.println("Falló el thread que hace golpear con el carro");
                    }
                this.controlador.BajarVidaPueblo(coordEnemigo[0], coordEnemigo[1], pesoGolpe);
            }else{
                Avanzar();
                this.controlador.MoverSoldado(indice, x, y);
                try {
                    sleep(30);
                } catch (InterruptedException ex) {
                    System.out.println("Falló el thread que hace avanzar al carro");
                }
            }
        }
    }

     //Mueve el personaje a la direccion correspondiente
    public void Avanzar(){
        //4 = sur, 3 = norte, 2 = este, 1 = oeste
        //direccion 1 >>>  2 <<<<
        switch(direccion){
            case 1: x++; break;
            case 2: x--; break;
            case 3: y++; break;
            case 4: y--; break;
        }
        if (x < 0 || x >= 1098 || y < 0 || y > 698){
            ApagarCamion();
            return;
        }
    }
    
    public void ReducirVida(int fuerzaGolpe){
        this.vida = this.vida - fuerzaGolpe;
        if (vida <= 0){
            this.controlador.EliminarCamion(indice);
            ApagarCamion();
        }
    }
    
    public void ApagarCamion(){
        this.Estado = false;
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
