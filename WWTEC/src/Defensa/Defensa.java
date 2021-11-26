/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Defensa;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class Defensa implements Serializable{
    private int nivel;
    private int vida;
    private String nameClass;
    private int FrecuenciaDisparo;

    public Defensa(int nivel, int vida, String nameClass, int FrecDisparo) {
        this.nivel = nivel;
        this.vida = vida;
        this.nameClass = nameClass;
        this.FrecuenciaDisparo = FrecDisparo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    
    //Se utilzará cuando se avance de nivel dentro del juego... 
    public void AumentarNivel(){
        
    }

    public int getFrecuenciaDisparo() {
        return FrecuenciaDisparo;
    }

    public void setFrecuenciaDisparo(int FrecuenciaDisparo) {
        this.FrecuenciaDisparo = FrecuenciaDisparo;
    }
    
    
}
