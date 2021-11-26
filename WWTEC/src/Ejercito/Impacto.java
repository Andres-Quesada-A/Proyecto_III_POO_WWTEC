/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercito;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class Impacto extends Ejercito implements Serializable{
    private String Arma;
    private String RuidoPath = "";
    private int Limite;
    private ImageIcon Movimiento = new ImageIcon();

    public Impacto(String nameClass,String Arma, String Nombre, int Vida, int CantidadGolpes, int nivel, int Campos, int NivelAparicion, int Costo, int Fuerza) {
        super(nameClass, Nombre, Vida, CantidadGolpes, nivel, Campos, NivelAparicion, Costo, Fuerza);
        this.Arma = Arma;
        CargarImagenMove();
    }
    
    private void CargarImagenMove(){
        Movimiento = new ImageIcon(getClass().getResource("/Ejercito/Impacto/camion.jpg"));
    }

    public String getArma() {
        return Arma;
    }

    public void setArma(String Arma) {
        this.Arma = Arma;
    }
}
