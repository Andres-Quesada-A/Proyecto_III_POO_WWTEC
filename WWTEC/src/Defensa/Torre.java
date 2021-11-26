/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Defensa;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class Torre extends Defensa implements Serializable{
    private ImageIcon municion = new ImageIcon(getClass().getResource("/Defensa/Imagenes/Bala.png"));
    private ImageIcon Torre = new ImageIcon(getClass().getResource("/Defensa/Imagenes/Torre.png"));

    public Torre(int nivel, int vida, String nameClass, int FrecDisparo) {
        super(nivel, vida, nameClass, FrecDisparo);
    }

    public ImageIcon getMunicion() {
        return municion;
    }

    public ImageIcon getTorre() {
        return Torre;
    }
    
    
}
