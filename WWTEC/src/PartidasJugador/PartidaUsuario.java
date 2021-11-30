/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PartidasJugador;

import Juego.ControladorVideoJuego;
import JuegoUsuario.JuegoUsuario;
import Threads.ThreadAviones;
import Threads.ThreadBomba;
import Threads.ThreadCamion;
import Threads.ThreadEdificio;
import Threads.ThreadMedioAlcance;
import Threads.ThreadMuro;
import Threads.ThreadPueblo;
import Threads.ThreadSoldado;
import Threads.ThreadTanque;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author andre
 */
public class PartidaUsuario implements Serializable{
    public JuegoUsuario juegoUsuario= new JuegoUsuario();
    private JLabel[] lblMuroMenor = new JLabel[56];
    private JLabel[] lblMuroMayor = new JLabel[76];
    private JLabel edificio = new JLabel();
    private ArrayList<JLabel> bombas = new ArrayList<JLabel>();
    private ArrayList<JLabel> torres = new ArrayList<JLabel>();
    private ArrayList<JLabel> cañones = new ArrayList<JLabel>();
    private ArrayList<JLabel> aereos = new ArrayList<JLabel>();
    private ArrayList<JLabel> morteros = new ArrayList<JLabel>();
    private ArrayList<JLabel> balas = new ArrayList<JLabel>();
    private ArrayList<JLabel> soldados = new ArrayList<JLabel>();
    private ArrayList<JLabel> alcanceMedio = new ArrayList<JLabel>();
    private ArrayList<JLabel> tanque = new ArrayList<JLabel>();
    private ArrayList<JLabel> carro = new ArrayList<JLabel>();
    private ArrayList<JLabel> aviones = new ArrayList<JLabel>();
    
    private ArrayList<ThreadBomba> threadBombas;
    private ArrayList<ThreadPueblo> threadTorres;
    private ArrayList<ThreadPueblo> threadCañones;
    private ArrayList<ThreadPueblo> threadAereos;
    private ArrayList<ThreadPueblo> threadMortero;
    private ArrayList<ThreadSoldado> threadContacto;
    private ArrayList<ThreadMedioAlcance> threadMedianoAlcance;
    private ArrayList<ThreadAviones> threadAviones;
    private ArrayList<ThreadTanque> threadTanques;
    private ArrayList<ThreadCamion> threadCarros;
    private ThreadEdificio threadCasa;
    private ArrayList<ThreadMuro> threadMuros;
    
    public PartidaUsuario(){
        threadBombas = new ArrayList<ThreadBomba>();
        threadTorres = new ArrayList<ThreadPueblo>();
        threadCañones = new ArrayList<ThreadPueblo>();
        threadAereos = new ArrayList<ThreadPueblo>();
        threadMortero = new ArrayList<ThreadPueblo>();
        threadContacto = new ArrayList<ThreadSoldado>();
        threadMedianoAlcance = new ArrayList<ThreadMedioAlcance>();
        threadAviones = new ArrayList<ThreadAviones>();
        threadTanques = new ArrayList<ThreadTanque>();
        threadCarros = new ArrayList<ThreadCamion>();
        threadMuros = new ArrayList<ThreadMuro>();
    }

    public JuegoUsuario getJuegoUsuario() {
        return juegoUsuario;
    }

    public void setJuegoUsuario(JuegoUsuario juegoUsuario) {
        this.juegoUsuario = juegoUsuario;
    }

    public JLabel[] getLblMuroMenor() {
        return lblMuroMenor;
    }

    public void setLblMuroMenor(JLabel[] lblMuroMenor) {
        this.lblMuroMenor = lblMuroMenor;
    }

    public JLabel[] getLblMuroMayor() {
        return lblMuroMayor;
    }

    public void setLblMuroMayor(JLabel[] lblMuroMayor) {
        this.lblMuroMayor = lblMuroMayor;
    }

    public JLabel getEdificio() {
        return edificio;
    }

    public void setEdificio(JLabel edificio) {
        this.edificio = edificio;
    }

    public ArrayList<JLabel> getBombas() {
        return bombas;
    }

    public void setBombas(ArrayList<JLabel> bombas) {
        this.bombas = bombas;
    }

    public ArrayList<JLabel> getTorres() {
        return torres;
    }

    public void setTorres(ArrayList<JLabel> torres) {
        this.torres = torres;
    }

    public ArrayList<JLabel> getCañones() {
        return cañones;
    }

    public void setCañones(ArrayList<JLabel> cañones) {
        this.cañones = cañones;
    }

    public ArrayList<JLabel> getAereos() {
        return aereos;
    }

    public void setAereos(ArrayList<JLabel> aereos) {
        this.aereos = aereos;
    }

    public ArrayList<JLabel> getMorteros() {
        return morteros;
    }

    public void setMorteros(ArrayList<JLabel> morteros) {
        this.morteros = morteros;
    }

    public ArrayList<JLabel> getBalas() {
        return balas;
    }

    public void setBalas(ArrayList<JLabel> balas) {
        this.balas = balas;
    }

    public ArrayList<JLabel> getSoldados() {
        return soldados;
    }

    public void setSoldados(ArrayList<JLabel> soldados) {
        this.soldados = soldados;
    }

    public ArrayList<JLabel> getAlcanceMedio() {
        return alcanceMedio;
    }

    public void setAlcanceMedio(ArrayList<JLabel> alcanceMedio) {
        this.alcanceMedio = alcanceMedio;
    }

    public ArrayList<JLabel> getTanque() {
        return tanque;
    }

    public void setTanque(ArrayList<JLabel> tanque) {
        this.tanque = tanque;
    }

    public ArrayList<JLabel> getCarro() {
        return carro;
    }

    public void setCarro(ArrayList<JLabel> carro) {
        this.carro = carro;
    }

    public ArrayList<JLabel> getAviones() {
        return aviones;
    }

    public void setAviones(ArrayList<JLabel> aviones) {
        this.aviones = aviones;
    }

    public ArrayList<ThreadBomba> getThreadBombas() {
        return threadBombas;
    }

    public void setThreadBombas(ArrayList<ThreadBomba> threadBombas) {
        this.threadBombas = threadBombas;
    }

    public ArrayList<ThreadPueblo> getThreadTorres() {
        return threadTorres;
    }

    public void setThreadTorres(ArrayList<ThreadPueblo> threadTorres) {
        this.threadTorres = threadTorres;
    }

    public ArrayList<ThreadPueblo> getThreadCañones() {
        return threadCañones;
    }

    public void setThreadCañones(ArrayList<ThreadPueblo> threadCañones) {
        this.threadCañones = threadCañones;
    }

    public ArrayList<ThreadPueblo> getThreadAereos() {
        return threadAereos;
    }

    public void setThreadAereos(ArrayList<ThreadPueblo> threadAereos) {
        this.threadAereos = threadAereos;
    }

    public ArrayList<ThreadPueblo> getThreadMortero() {
        return threadMortero;
    }

    public void setThreadMortero(ArrayList<ThreadPueblo> threadMortero) {
        this.threadMortero = threadMortero;
    }

    public ArrayList<ThreadSoldado> getThreadContacto() {
        return threadContacto;
    }

    public void setThreadContacto(ArrayList<ThreadSoldado> threadContacto) {
        this.threadContacto = threadContacto;
    }

    public ArrayList<ThreadMedioAlcance> getThreadMedianoAlcance() {
        return threadMedianoAlcance;
    }

    public void setThreadMedianoAlcance(ArrayList<ThreadMedioAlcance> threadMedianoAlcance) {
        this.threadMedianoAlcance = threadMedianoAlcance;
    }

    public ArrayList<ThreadAviones> getThreadAviones() {
        return threadAviones;
    }

    public void setThreadAviones(ArrayList<ThreadAviones> threadAviones) {
        this.threadAviones = threadAviones;
    }

    public ArrayList<ThreadTanque> getThreadTanques() {
        return threadTanques;
    }

    public void setThreadTanques(ArrayList<ThreadTanque> threadTanques) {
        this.threadTanques = threadTanques;
    }

    public ArrayList<ThreadCamion> getThreadCarros() {
        return threadCarros;
    }

    public void setThreadCarros(ArrayList<ThreadCamion> threadCarros) {
        this.threadCarros = threadCarros;
    }

    public ThreadEdificio getThreadCasa() {
        return threadCasa;
    }

    public void setThreadCasa(ThreadEdificio threadCasa, ControladorVideoJuego controlador) {
        threadCasa = new ThreadEdificio(controlador, 480, 260);
        this.threadCasa = threadCasa;
    }

    public ArrayList<ThreadMuro> getThreadMuros() {
        return threadMuros;
    }

    public void setThreadMuros(ArrayList<ThreadMuro> threadMuros) {
        this.threadMuros = threadMuros;
    }
    
    
}
