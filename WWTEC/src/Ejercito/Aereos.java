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
public class Aereos extends Ejercito implements Serializable{
    private String tipo;
    private ImageIcon Tipos = new ImageIcon();
    private ImageIcon Balas = new ImageIcon();
    private String PathRuido = "";
    private int modo = 0;

    public Aereos(String nombreClass, String tipo, String Nombre, int Vida, int CantidadGolpes, int nivel, int Campos, int NivelAparicion, int Costo, int Fuerza) {
        super(nombreClass, Nombre, Vida, CantidadGolpes, nivel, Campos, NivelAparicion, Costo, Fuerza);
        this.tipo = tipo;
        DecidirModo();
        CargarTipoAereo();
        CargarTipoBalas();
    }
    
    private void DecidirModo(){
        if (tipo.equalsIgnoreCase("Bombas")){
            modo = 1;
        }else if (tipo.equalsIgnoreCase("Misiles")){
            modo = 2;
        }
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void subirNivel(){
        
    }
    
    private void CargarTipoAereo(){
        switch(this.modo){
            case 1: Tipos = new ImageIcon(getClass().getResource("/Ejercito/Aereos/Aviones/avion.jpg")); break;
            case 2: Tipos = new ImageIcon(getClass().getResource("/Ejercito/Aereos/Bombarderos/Bombardero.jpg")); break;
            default: Tipos = new ImageIcon(getClass().getResource("/Ejercito/Aereos/Aviones/avion.jpg")); break;
        }
    }
    
    private void CargarTipoBalas(){
        Balas = new ImageIcon(getClass().getResource("/Ejercito/Aereos/Proyectil.jpg"));
    }
}
