/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercito;

import java.io.Serializable;

/**
 *
 * @author andre
 */
public class Ejercito implements Serializable{
    private String Nombre;
    private int Vida;
    private int CantidadGolpes;
    private int nivel;
    private int Campos;
    private int NivelAparicion;
    private int Costo;
    private int Fuerza;
    private String tipo;

    public Ejercito(String tipo, String Nombre, int Vida, int CantidadGolpes, int nivel, int Campos, int NivelAparicion, int Costo, int Fuerza) {
        this.tipo =  tipo;
        this.Nombre = Nombre;
        this.Vida = Vida;
        this.CantidadGolpes = CantidadGolpes;
        this.nivel = nivel;
        this.Campos = Campos;
        this.NivelAparicion = NivelAparicion;
        this.Costo = Costo;
        this.Fuerza = Fuerza;
    }

    public String getNombreClase(){
        return this.tipo;
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }

    public int getCantidadGolpes() {
        return CantidadGolpes;
    }

    public void setCantidadGolpes(int CantidadGolpes) {
        this.CantidadGolpes = CantidadGolpes;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCampos() {
        return Campos;
    }

    public void setCampos(int Campos) {
        this.Campos = Campos;
    }

    public int getNivelAparicion() {
        return NivelAparicion;
    }

    public void setNivelAparicion(int NivelAparicion) {
        this.NivelAparicion = NivelAparicion;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int Costo) {
        this.Costo = Costo;
    }

    public int getFuerza() {
        return Fuerza;
    }

    public void setFuerza(int Fuerza) {
        this.Fuerza = Fuerza;
    }
    
    
}
