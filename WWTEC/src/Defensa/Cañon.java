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
public class Cañon extends Defensa implements Serializable{
    private ArrayList<ImageIcon> municion = new ArrayList<ImageIcon>();
    private ImageIcon cañon = new ImageIcon(getClass().getResource("/Defensa/Imagenes/Cañon.png"));

    public Cañon(int nivel, int vida, String nameClass, int FrecDisparo, int fuerza) {
        super(nivel, vida, nameClass, FrecDisparo, fuerza);
        municion.add( new ImageIcon(getClass().getResource("/Defensa/Imagenes/Bola.png")));
    }

    public ArrayList<ImageIcon> getMunicion() {
        return municion;
    }

    public void setMunicion(ArrayList<ImageIcon> municion) {
        this.municion = municion;
    }

    public ImageIcon getCañon() {
        return cañon;
    }

    public void setCañon(ImageIcon cañon) {
        this.cañon = cañon;
    }

    
    
}
