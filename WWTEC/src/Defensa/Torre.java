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
public class Torre extends Defensa implements Serializable{
    private ArrayList<ImageIcon> municion = new ArrayList<ImageIcon>();
    private ImageIcon Torre = new ImageIcon(getClass().getResource("/Defensa/Imagenes/Torre.png"));

    public Torre(int nivel, int vida, String nameClass, int FrecDisparo, int fuerza) {
        super(nivel, vida, nameClass, FrecDisparo, fuerza);
        CargarMunicion();
    }

    private void CargarMunicion(){
        String[] direcciones = {"/Defensa/Imagenes/balaUP.png","/Defensa/Imagenes/balaDOWN.png","/Defensa/Imagenes/balaL.png",
        "/Defensa/Imagenes/balaR.png","/Defensa/Imagenes/balaNE.png","/Defensa/Imagenes/balaNO.png","/Defensa/Imagenes/balaSE.png",
        "/Defensa/Imagenes/balaSO.png"};
        for (int i = 0; i < direcciones.length; i++){
            municion.add(new ImageIcon(getClass().getResource(direcciones[i])));
        }
    }
    
    public ArrayList<ImageIcon> getMunicion() {
        return municion;
    }

    public ImageIcon getTorre() {
        return Torre;
    }
    
    
}
