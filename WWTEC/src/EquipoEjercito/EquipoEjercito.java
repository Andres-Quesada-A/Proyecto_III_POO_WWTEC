    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EquipoEjercito;

import Ejercito.Ejercito;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class EquipoEjercito implements Serializable{
    private ArrayList<Ejercito> MiembrosEjercito;

    public EquipoEjercito() {
        this.MiembrosEjercito = new ArrayList<Ejercito>();
    }
    
    public void insertarMiembro(Ejercito miembro){
        this.MiembrosEjercito.add(miembro);
    }
    
    public Ejercito GetUsuario(int index){
        return MiembrosEjercito.get(index);
    }
    
    public int getLegthArray(){
        return this.MiembrosEjercito.size();
    }
    
    public void EstablecerEquipo(ArrayList<Ejercito> miembros){
        this.MiembrosEjercito = miembros;
    }
    
    
    /*
    int[] Atributos = {Vida, CantidadGolpe, Nivel, Campos, NivelAparicion,Costo, FuerzaGolpe};
    */
    public void ActualizarDatos(int index, String tipo, String nombre, String arma, int[] atributos){
        MiembrosEjercito.get(index).setNombre(nombre);
        MiembrosEjercito.get(index).setVida(atributos[0]);
        MiembrosEjercito.get(index).setCantidadGolpes(atributos[1]);
        MiembrosEjercito.get(index).setNivel(atributos[2]);
        MiembrosEjercito.get(index).setCampos(atributos[3]);
        MiembrosEjercito.get(index).setNivelAparicion(atributos[4]);
        MiembrosEjercito.get(index).setCosto(atributos[5]);
        MiembrosEjercito.get(index).setFuerza(atributos[6]);
    }
    
    public void EliminarSoldado(int index){
        MiembrosEjercito.remove(index);
    }
}
