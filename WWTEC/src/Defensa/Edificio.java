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

    public Edificio(int nivel, int vida, String nameClass, int FrecDisparo) {
        super(nivel, vida, nameClass, FrecDisparo);
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
    
    public ImageIcon getEdificio(int index){
        return this.edificios.get(index);
    }
}
