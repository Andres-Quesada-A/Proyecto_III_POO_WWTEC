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
public class Muro extends Defensa implements Serializable{
    private ImageIcon muro = new ImageIcon(getClass().getResource("/Defensa/Imagenes/Muro.jpg"));

    public Muro(int nivel, int vida, String nameClass, int FrecDisparo) {
        super(nivel, vida, nameClass, FrecDisparo);
    }

    public ImageIcon getMuro() {
        return muro;
    }
    
    
}
