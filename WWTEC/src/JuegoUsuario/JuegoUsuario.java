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
    private double porcentaje = 0;
    private int nivel = 1;
    private int Dinero = 10000;
    private ArrayList<Ejercito> paraLuchar = new ArrayList<Ejercito>();
    private int campos = 20;
    private ArrayList<Integer> DistribuccionMuro = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionBombas = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionTorres = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionCañones = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionAereos = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionMorteros = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionAviones = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionTanques = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionCamion = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionContacto = new ArrayList<Integer>();
    private ArrayList<Integer> DistribuccionAlcanceMedio = new ArrayList<Integer>();
    
    
    public JuegoUsuario() {
    }

    public Pueblo getPueblo() {
        return pueblo;
    }

    public void setPueblo(Pueblo pueblo) {
        this.pueblo = pueblo;
    }

    public ArrayList<Ejercito> getParaLuchar() {
        return paraLuchar;
    }

    public void setParaLuchar(ArrayList<Ejercito> paraLuchar) {
        this.paraLuchar = paraLuchar;
    }

    public ArrayList<Integer> getDistribuccionMuro() {
        return DistribuccionMuro;
    }

    public void setDistribuccionMuro(ArrayList<Integer> DistribuccionMuro) {
        this.DistribuccionMuro = DistribuccionMuro;
    }

    public ArrayList<Integer> getDistribuccionBombas() {
        return DistribuccionBombas;
    }

    public void setDistribuccionBombas(ArrayList<Integer> DistribuccionBombas) {
        this.DistribuccionBombas = DistribuccionBombas;
    }

    public ArrayList<Integer> getDistribuccionTorres() {
        return DistribuccionTorres;
    }

    public void setDistribuccionTorres(ArrayList<Integer> DistribuccionTorres) {
        this.DistribuccionTorres = DistribuccionTorres;
    }

    public ArrayList<Integer> getDistribuccionCañones() {
        return DistribuccionCañones;
    }

    public void setDistribuccionCañones(ArrayList<Integer> DistribuccionCañones) {
        this.DistribuccionCañones = DistribuccionCañones;
    }

    public ArrayList<Integer> getDistribuccionAereos() {
        return DistribuccionAereos;
    }

    public void setDistribuccionAereos(ArrayList<Integer> DistribuccionAereos) {
        this.DistribuccionAereos = DistribuccionAereos;
    }

    public ArrayList<Integer> getDistribuccionMorteros() {
        return DistribuccionMorteros;
    }

    public void setDistribuccionMorteros(ArrayList<Integer> DistribuccionMorteros) {
        this.DistribuccionMorteros = DistribuccionMorteros;
    }

    public ArrayList<Integer> getDistribuccionAviones() {
        return DistribuccionAviones;
    }

    public void setDistribuccionAviones(ArrayList<Integer> DistribuccionAviones) {
        this.DistribuccionAviones = DistribuccionAviones;
    }

    public ArrayList<Integer> getDistribuccionTanques() {
        return DistribuccionTanques;
    }

    public void setDistribuccionTanques(ArrayList<Integer> DistribuccionTanques) {
        this.DistribuccionTanques = DistribuccionTanques;
    }

    public ArrayList<Integer> getDistribuccionCamion() {
        return DistribuccionCamion;
    }

    public void setDistribuccionCamion(ArrayList<Integer> DistribuccionCamion) {
        this.DistribuccionCamion = DistribuccionCamion;
    }

    public ArrayList<Integer> getDistribuccionContacto() {
        return DistribuccionContacto;
    }

    public void setDistribuccionContacto(ArrayList<Integer> DistribuccionContacto) {
        this.DistribuccionContacto = DistribuccionContacto;
    }

    public ArrayList<Integer> getDistribuccionAlcanceMedio() {
        return DistribuccionAlcanceMedio;
    }

    public void setDistribuccionAlcanceMedio(ArrayList<Integer> DistribuccionAlcanceMedio) {
        this.DistribuccionAlcanceMedio = DistribuccionAlcanceMedio;
    }

    
    
    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
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
