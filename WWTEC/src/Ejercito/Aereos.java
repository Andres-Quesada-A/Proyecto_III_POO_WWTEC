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
    private ArrayList<ImageIcon> Tipos = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> Balas = new ArrayList<ImageIcon>();
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
    
    private void CargarAviones(){
        Tipos.add(new ImageIcon(getClass().getResource("/Ejercito/Aereos/Aviones/avionR.png")));
        Tipos.add(new ImageIcon(getClass().getResource("/Ejercito/Aereos/Aviones/avionL.png")));
    }
    
    private void CargarBombarderos(){
        Tipos.add(new ImageIcon(getClass().getResource("/Ejercito/Aereos/Bombarderos/BombarderoR.png")));
        Tipos.add(new ImageIcon(getClass().getResource("/Ejercito/Aereos/Bombarderos/BombarderoL.png")));
    }
    
    private void CargarTipoAereo(){
        switch(this.modo){
            case 1: CargarAviones(); break;
            case 2: CargarBombarderos(); break;
            default: CargarAviones(); break;
        }
    }
    
    public ImageIcon getMovimientoLeft(){
        return Tipos.get(1);
    }
    
    public ImageIcon getMovimientoRight(){
        return Tipos.get(0);
    }
    
    private void CargarTipoBalas(){
        String[] direcciones = {"/Ejercito/Aereos/misilUP.png","/Ejercito/Aereos/misilDOWN.png","/Ejercito/Aereos/misilL.png",
        "/Ejercito/Aereos/misilR.png","/Ejercito/Aereos/misilR.png","/Ejercito/Aereos/misilNE.png","/Ejercito/Aereos/misilNO.png",
        "/Ejercito/Aereos/misilSE.png","/Ejercito/Aereos/misilSO.png"};
        for (int i = 0; i < direcciones.length; i++){
            Balas.add(new ImageIcon(getClass().getResource(direcciones[i])));
        }
    }

    public ArrayList<ImageIcon> getTipos() {
        return Tipos;
    }

    public ArrayList<ImageIcon> getBalas() {
        return Balas;
    }
    
    
}
