/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Defensa;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class Bombas extends Defensa implements Serializable{
    private ImageIcon bomba = new ImageIcon(getClass().getResource("/Defensa/Imagenes/Granada.png"));
    private ArrayList<ImageIcon> explosion = new ArrayList<ImageIcon>();
    private int Alcance = 80;

    public int getAlcance() {
        return Alcance;
    }

    public void setAlcance(int Alcance) {
        this.Alcance = Alcance;
    }

    public Bombas(int nivel, int vida, String nameClass, int FrecDisparo, int fuerza) {
        super(nivel, vida, nameClass, FrecDisparo, fuerza);
        CargarExplosion();
    }

    private void CargarExplosion(){
        String[] explosiones = {"/Defensa/Imagenes/Explosion1.png","/Defensa/Imagenes/Explosion2.png",
        "/Defensa/Imagenes/Explosion3.png","/Defensa/Imagenes/Explosion4.png","/Defensa/Imagenes/Explosion5.png",
        "/Defensa/Imagenes/Explosion6.png","/Defensa/Imagenes/Explosion7.png"};
        for (int i = 0; i < explosiones.length; i++) {
            ImageIcon Aux = new ImageIcon(getClass().getResource(explosiones[i]));
            explosion.add(Aux);
        } 
    }
    
    public ImageIcon getBomba() {
        return bomba;
    }

    public ArrayList<ImageIcon> getExplosion() {
        return explosion;
    }

    
}
