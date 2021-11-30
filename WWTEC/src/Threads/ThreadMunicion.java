/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads;

import Juego.ControladorVideoJuego;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ThreadMunicion extends Thread{
    private int direccion; //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
    private int x, y;
    private int indice;
    private int PesoGolpe;
    private int modo; //1: es del ejercito y ataca al pueblo///2: es del pueblo y ataca al ejercito
    private ControladorVideoJuego controlador;
    private boolean Estado = true;

    public ThreadMunicion(int direccion, int x, int y, int indice, int PesoGolpe, int modo, ControladorVideoJuego controlador) {
        this.direccion = direccion;
        this.x = x;
        this.y = y;
        this.indice = indice;
        this.PesoGolpe = PesoGolpe;
        this.modo = modo;
        this.controlador = controlador;
    }

    
    
    public void run(){
        int[] coordenadas = {0, 0}; //Para saber el indice el contricante y el numero de grupo que pertenece
        while(Estado){
            coordenadas = this.controlador.ChoqueMunicion(indice, modo, x, y, direccion);
            if (coordenadas[0] == 0){
                Moverse();
                this.controlador.moverMunicion(indice, x, y);
                if (x == 0 || y == 0 || y == 1098 || x == 698){
                    this.controlador.EliminarMunicion(indice);
                    break;
                }
                try {
                    sleep(8);
                } catch (InterruptedException ex) {
                    System.out.println("Interrupcion del thread municion");
                }
            }else{
                this.controlador.BajarVidaMunicion(indice, coordenadas[0], coordenadas[1], PesoGolpe);
                ApargarMunicion();
                //Llamar a destruir la municion y 
                while(true){
                    try {
                        sleep(2000);
                    } catch (InterruptedException ex) {
                        System.out.println("Interrupcion del thread municion");
                    } 
                }
            }
        }
    }
    
    public void ApargarMunicion(){
        this.Estado = false;
    }
    
    private void Moverse(){
        switch(direccion){
            case 1: y++; break;
            case 2: y--; break;
            case 3: x--; break;
            case 4: x++; break;
            case 5: x--; y--; break;
            case 6: x++; y--; break;
            case 7: x--; y++; break;
            case 8: x++; y++; break;
        }
    }
    
    public int GetIndice(){
        return this.indice;
    }
}
