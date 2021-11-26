/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoUsuario;

import Defensa.Defensa;
import Defensa.Pueblo;
import Ejercito.Ejercito;
import EquipoEjercito.EquipoEjercito;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class JuegoUsuario implements Serializable{
    private Pueblo pueblo = new Pueblo();
    private EquipoEjercito ejercito = new EquipoEjercito();
    private int nivel = 1;
    private int Dinero = 10000;
    private ArrayList<Ejercito> paraLuchar = new ArrayList<Ejercito>();
    private int campos = 20;

    public JuegoUsuario() {
    }

    public void sustituirEjercito(EquipoEjercito equipo){
        this.ejercito = equipo;
    }
    
    public void sustituirPueblo(Pueblo town){
        this.pueblo = town;
    }
    
    public Ejercito ObtenerSoldado(int index){
        return this.paraLuchar.get(index);
    }
    
    public void InsertarSoldado(Ejercito nuevo){
        paraLuchar.add(nuevo);
    }
    
    public int getLegthArray(){
        return this.paraLuchar.size();
    }
    
    public void EliminarSoldado(int index){
        paraLuchar.remove(index);
    }

    public EquipoEjercito getEjercito() {
        return ejercito;
    }

    public void setEjercito(EquipoEjercito ejercito) {
        this.ejercito = ejercito;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getDinero() {
        return Dinero;
    }

    public void setDinero(int Dinero) {
        this.Dinero = Dinero;
    }

    public int getCampos() {
        return campos;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }
    
    
}
