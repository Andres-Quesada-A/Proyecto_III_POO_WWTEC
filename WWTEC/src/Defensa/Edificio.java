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
public class Edificio extends Defensa implements Serializable{
    private ArrayList<ImageIcon> edificios = new ArrayList<ImageIcon>();
    private int x = 480;
    private int y = 260;

    public Edificio(int nivel, int vida, String nameClass, int FrecDisparo, int fuerza) {
        super(nivel, vida, nameClass, FrecDisparo, fuerza);
        CargarEdificios();
    }
    
    private void CargarEdificios(){
        String[] URLEdificios = {"/Defensa/Imagenes/Edificio.png","/Defensa/Imagenes/Edificio2.png",
        "/Defensa/Imagenes/Edificio3.png"};
        for (int i = 0; i < URLEdificios.length; i++) {
            ImageIcon Aux = new ImageIcon(getClass().getResource(URLEdificios[i]));
            edificios.add(Aux);
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
    
    public ImageIcon getEdificio(int index){
        return this.edificios.get(index);
    }
}
