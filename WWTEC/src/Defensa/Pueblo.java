/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Defensa;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Pueblo implements Serializable {
    private ArrayList<Defensa> equipoPueblo; //Contiene todos los componentes del pueblo
    private int bienes = 0; //el dinero que se puede recaudar de un pueblo
    
    public Pueblo() {
        this.equipoPueblo = new ArrayList<Defensa>();
    }

    public ArrayList<Defensa> getEquipoPueblo() {
        return equipoPueblo;
    }

    public void setEquipoPueblo(ArrayList<Defensa> equipoPueblo) {
        this.equipoPueblo = equipoPueblo;
    }
    
    //Se ingresa un nuevo objeto que se utilizará en el pueblo, preferiblemente que solo sea
    //un objeto de una clase correspondiente
    public void insertarMiembro(Defensa nuevo){
        this.equipoPueblo.add(nuevo);
    }
    
    public Defensa GetUsuario(int index){
        return equipoPueblo.get(index);
    }
    
    public int getLegthArray(){
        return this.equipoPueblo.size();
    }
    
    public void EstablecerEquipo(ArrayList<Defensa> miembros){
        this.equipoPueblo = miembros;
    }

    public int getBienes() {
        return bienes;
    }

    public void setBienes(int bienes) {
        this.bienes = bienes;
    }
    
    //con base al indice dado, se modifica los atributos del objeto que se encuentre en ese indice
    public void ActualizarDatos(int index, int vida, int disparos){
        equipoPueblo.get(index).setFrecuenciaDisparo(disparos);
        equipoPueblo.get(index).setVida(vida);
    }
    
    public void EliminarSoldado(int index){
        equipoPueblo.remove(index);
    }
}
