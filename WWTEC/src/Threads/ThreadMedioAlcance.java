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
public class ThreadMedioAlcance extends Thread implements Serializable{
    private static final SClip disparopueblo = new SClip("disparopueblo.wav");
    private int vida;
    private int x, y;
    private int FuerzaGolpe;
    private int indice;
    private boolean Estado = true;
    private int frencuenciaDisparo;
    private int pesoGolpe;
    private ControladorVideoJuego controlador;
    private ArrayList<ImageIcon> movimiento;
    private ArrayList<ImageIcon> Disparo;
    private ArrayList<ImageIcon> Municiones;
    private boolean activo = true;
    private int index;
    private int direccion; //1 = norte, 2 = sur, 3 = este, 4 = oeste
    private int distancia; //Cantidad de coordenadas x para llegar al objetivo

    public ThreadMedioAlcance(int vida, int x, int y, int indice, int frencuenciaDisparo, 
            int pesoGolpe, ControladorVideoJuego controlador, ArrayList<ImageIcon> movimiento, ArrayList<ImageIcon> municiones, 
            int direccion, int distancia, ArrayList<ImageIcon> disparo) {
        this.vida = vida;
        this.x = x;
        this.y = y;
        this.indice = indice;
        this.frencuenciaDisparo = frencuenciaDisparo;
        this.pesoGolpe = pesoGolpe;
        this.controlador = controlador;
        this.movimiento = movimiento;
        this.Municiones = municiones;
        this.index = 0;
        this.direccion = direccion; //direccion 1 >>>  2 <<<<
        this.distancia = distancia;
        this.Disparo = disparo;
    }
    
    public void run(){
        int[] coordEnemigo = {0, 0, 0};
        while (activo){
            coordEnemigo = this.controlador.EnemigoEnMira(x, y, distancia, direccion);
            if (coordEnemigo[0] != 0){ //Si debe golpear
                if (Disparo.size() > 1){
                    for (ImageIcon golpe: Disparo){
                        this.controlador.CambiarLabelSoldado(indice, golpe);
                        try {
                            sleep((int)frencuenciaDisparo / Disparo.size());
                        } catch (InterruptedException ex) {
                            System.out.println("Falló el thread que hace caminar al soldado");
                        }
                    }
                }else{
                    this.controlador.CambiarLabelSoldado(indice, Disparo.get(0));
                        try {
                            sleep((int)frencuenciaDisparo / Disparo.size());
                        } catch (InterruptedException ex) {
                            System.out.println("Falló el thread que hace caminar al soldado");
                        }
                }
                ThreadSonido sonido = new ThreadSonido(disparopueblo);
                sonido.start();
                this.controlador.RealizarDisparo(x, y, pesoGolpe, (coordEnemigo[2] - 1), Municiones.get(coordEnemigo[2]), 1);
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
            this.controlador.EliminarMedioAlcance(indice);
            ApagarSoldado();
        }
    }
    
    //Detiene el ciclo que mantiene vivo al thread
    public void ApagarSoldado(){
        this.activo = false;
    }
    
    public int GetIndice(){
        return this.indice;
    }
}
