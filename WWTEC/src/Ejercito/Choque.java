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
public class Choque extends Ejercito implements Serializable{
    private String Arma;
    private int Limite;
    private ArrayList<ImageIcon> Movimiento = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> Disparar = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> Municion = new ArrayList<ImageIcon>();

    public Choque(String nameClass, String Arma, String Nombre, int Vida, int CantidadGolpes, int nivel, int Campos, int NivelAparicion, int Costo, int Fuerza) {
        super(nameClass, Nombre, Vida, CantidadGolpes, nivel, Campos, NivelAparicion, Costo, Fuerza);
        this.Arma = Arma;
        CargarImagenesMove();
        CargarGolpe();
        CargarMunicion();
    }
    
    private void CargarImagenesMove(){
        Movimiento.add(new ImageIcon(getClass().getResource("/Ejercito/Choque/tanqueL.png")));
        Movimiento.add(new ImageIcon(getClass().getResource("/Ejercito/Choque/tanqueR.png")));
    }   
    
    private void CargarGolpe(){
        Disparar.add(new ImageIcon(getClass().getResource("/Ejercito/Choque/tanqueL.png")));
        Disparar.add(new ImageIcon(getClass().getResource("/Ejercito/Choque/tanqueR.png")));
    }
    
    private void CargarMunicion(){
        String[] direcciones = {"/Ejercito/Choque/misilUP.png","/Ejercito/Choque/misilDOWN.png","/Ejercito/Choque/misilL.png",
        "/Ejercito/Choque/misilR.png","/Ejercito/Choque/misilNE.png","/Ejercito/Choque/misilNO.png","/Ejercito/Choque/misilSE.png",
        "/Ejercito/Choque/misilSO.png"};
        for(int i = 0; i < direcciones.length; i++){
            Municion.add(new ImageIcon(getClass().getResource(direcciones[i])));
        }
    }

    public ImageIcon getMovimientoLeft(){
        return Movimiento.get(0);
    }
    
    public ImageIcon getMovimientoRight(){
        return Movimiento.get(1);
    }
    
    public String getArma() {
        return Arma;
    }

    public void setArma(String Arma) {
        this.Arma = Arma;
    }

    public ArrayList<ImageIcon> getMovimiento() {
        return Movimiento;
    }

    public ArrayList<ImageIcon> getDisparar() {
        return Disparar;
    }

    public ArrayList<ImageIcon> getMunicion() {
        return Municion;
    }
    
    
}
