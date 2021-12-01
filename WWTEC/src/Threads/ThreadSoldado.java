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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ThreadSoldado extends Thread implements Serializable{
    private static final SClip espada = new SClip("espada.wav");
    private static final SClip golpes = new SClip("golpes.wav");
    private int indice;
    private int x, y;
    private int frencuenciaDisparo;
    private int pesoGolpe;
    private ControladorVideoJuego controlador;
    private ArrayList<ImageIcon> movimiento;
    private ArrayList<ImageIcon> golpear;
    private boolean activo = true;
    private int index;
    private int direccion; //1 = norte, 2 = sur, 3 = este, 4 = oeste
    private int distancia; //Cantidad de coordenadas x para llegar al objetivo
    private int vida;

    public ThreadSoldado(int indice, int x, int y, int frencuenciaDisparo, int pesoGolpe, ControladorVideoJuego controlador, ArrayList<ImageIcon> movimiento, ArrayList<ImageIcon> golpear, int direccion, int distancia, int vida) {
        this.indice = indice;
        this.x = x;
        this.y = y;
        this.frencuenciaDisparo = frencuenciaDisparo;
        this.pesoGolpe = pesoGolpe;
        this.controlador = controlador;
        this.movimiento = movimiento;
        this.golpear = golpear;
        this.index = 0;
        this.direccion = direccion;
        this.distancia = distancia;
        this.vida = vida;
    }

    
    public void run(){
        int[] coordEnemigo = {0, 0};
        while (activo){
            coordEnemigo = this.controlador.ChoqueConEnemigo(x + distancia, y);
            if (coordEnemigo[0] != 0){ //Si debe golpear
                for (ImageIcon golpe: golpear){
                    this.controlador.CambiarLabelSoldado(indice, golpe);
                    try {
                        sleep((int)frencuenciaDisparo / golpear.size());
                    } catch (InterruptedException ex) {
                        System.out.println("Falló el thread que hace caminar al soldado");
                    }
                }
                ThreadSonido sonido = new ThreadSonido(espada);
                sonido.start();
                this.controlador.BajarVidaPueblo(coordEnemigo[0], coordEnemigo[1], pesoGolpe);
                index = 0;
            }else{
                Avanzar();
                this.controlador.CambiarLabelSoldado(indice, movimiento.get(index));
                this.controlador.MoverSoldado(indice, x, y);
                index++;
                if (index == movimiento.size())
                    index = 0;
                try {
                    sleep(60);
                } catch (InterruptedException ex) {
                    System.out.println("Falló el thread que hace caminar al soldado");
                }
            }
        }
    }

    //Mueve el personaje a la direccion correspondiente
    public void Avanzar(){
        //4 = sur, 3 = norte, 2 = este, 1 = oeste
        //direccion 1 >>>  2 <<<<
        switch(direccion){
            case 1: x+= 4; break;
            case 2: x-= 4; break;
            case 3: y--; break;
            case 4: y++; break;
        }
        if (x < 0 || x >= 1098 || y < 0 || y > 698){
            ApagarSoldado();
            return;
        }
    }
    
    public void ReducirVida(int fuerzaGolpe){
        this.vida = this.vida - fuerzaGolpe;
        if (vida <= 0){
            this.controlador.EliminarSoldado(indice);
            ApagarSoldado();
        }
    }
    
    //Detiene el ciclo que mantiene vivo al thread
    public void ApagarSoldado(){
        this.activo = false;
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
