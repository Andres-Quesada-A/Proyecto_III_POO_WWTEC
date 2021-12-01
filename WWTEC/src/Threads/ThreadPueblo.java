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
public class ThreadPueblo extends Thread implements Serializable{
    private static final SClip cañon = new SClip("Cañon.wav");
    private int indice;
    private int x, y;
    private int frencuenciaDisparo;
    private int pesoGolpe;
    private ControladorVideoJuego controlador;
    private ArrayList<ImageIcon> municion;
    private int TipoDefensa; //1= bomba, 2 = torres, 3 = cañones, 4 = aereos, 5 = morteros
    private int vida;
    private boolean funcionar = true;

    public ThreadPueblo(int indice, int x, int y, double frencuenciaDisparo, int pesoGolpe, ControladorVideoJuego controlador, ArrayList<ImageIcon> municion, int tipo, int vida) {
        this.indice = indice;
        this.x = x;
        this.y = y;
        this.frencuenciaDisparo = (int)frencuenciaDisparo * 1000;
        this.pesoGolpe = pesoGolpe;
        this.controlador = controlador;
        this.municion = municion;
        this.TipoDefensa = tipo;
        this.vida = vida;
    }
    
    public void run(){
        int direccion;
        while (funcionar){
            direccion = this.controlador.RealizarDisparoPueblo(indice, x, y, TipoDefensa);
            if (direccion > 0){
                if (municion.size() > 1){
                    this.controlador.RealizarDisparo(x, y, pesoGolpe, direccion, municion.get(direccion - 1), 2);
                }else{
                    this.controlador.RealizarDisparo(x, y, pesoGolpe, direccion, municion.get(0), 2);
                    ThreadSonido sonido = new ThreadSonido(cañon);
                    sonido.start();
                }
                try {
                    sleep(frencuenciaDisparo);
                } catch (InterruptedException ex) {
                    System.out.println("Interrupcion del thread bomba");
                }
            }
        }
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
    
    public void ApagarFuncionamiento(){
        this.funcionar = false;
    }
    
    public void ReducirVida(int golpe){
        this.vida = vida - golpe;
        if(vida <= 0){
            this.controlador.EliminarComponentePueblo(TipoDefensa, indice);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int GetIndice(){
        return this.indice;
    }
}
