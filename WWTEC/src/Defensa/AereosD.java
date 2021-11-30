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
public class AereosD extends Defensa implements Serializable{
    private ArrayList<ImageIcon> municion = new ArrayList<ImageIcon>();
    private ImageIcon aereo = new ImageIcon(getClass().getResource("/Defensa/Imagenes/Aereos.png"));

    public AereosD(int nivel, int vida, String nameClass, int FrecDisparo, int fuerza) {
        super(nivel, vida, nameClass, FrecDisparo, fuerza);
    }

    private void CargarMuniciones(){
        municion.add(new ImageIcon(getClass().getResource("/Defensa/Imagenes/misilUP.png")));       
        municion.add(new ImageIcon(getClass().getResource("/Defensa/Imagenes/misilDOWN.png")));   
        municion.add(new ImageIcon(getClass().getResource("/Defensa/Imagenes/misilL.png")));   
        municion.add(new ImageIcon(getClass().getResource("/Defensa/Imagenes/misilR.png")));   
        municion.add(new ImageIcon(getClass().getResource("/Defensa/Imagenes/misilNE.png")));   
        municion.add(new ImageIcon(getClass().getResource("/Defensa/Imagenes/misilNO.png")));   
        municion.add(new ImageIcon(getClass().getResource("/Defensa/Imagenes/misilSE.png")));   
        municion.add(new ImageIcon(getClass().getResource("/Defensa/Imagenes/misilSO.png"))); 
    }
    
    public ArrayList<ImageIcon> getMunicion() {
        return municion;
    }

    public ImageIcon getAereo() {
        return aereo;
    }
}
