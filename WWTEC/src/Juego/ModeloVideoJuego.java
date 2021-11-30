/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import DistribuccioPueblo.DistribucionPueblo;
import DistribuccioPueblo.LocalizarMuro;
import FilesManagers.Serealizar_Deserializar_Objeto;
import PartidasJugador.PartidaUsuario;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class ModeloVideoJuego {
    private LocalizarMuro distribuccionMuro;
    private DistribucionPueblo DistribuccionPueblo;

    public ModeloVideoJuego() {
        distribuccionMuro = new LocalizarMuro();
        DistribuccionPueblo = new DistribucionPueblo();
    }
    
    public PartidaUsuario DeserealizarPartida(String PATH){
        PartidaUsuario recuperado = new PartidaUsuario();
        recuperado = Serealizar_Deserializar_Objeto.deserializarObjeto(PATH, PartidaUsuario.class);
        return recuperado;
    }
    
    public ArrayList<Integer> ObtenerBombas(int level){
        ArrayList<Integer> bombas = new ArrayList<Integer>();
        bombas = DistribuccionPueblo.GetBombas(level);
        return bombas;
    }
    
    public ArrayList<Integer> ObtenerTorres(int level){
        ArrayList<Integer> torres = new ArrayList<Integer>();
        torres = DistribuccionPueblo.GetTorres(level);
        return torres;
    }
    
    public ArrayList<Integer> ObtenerCañones(int level){
        ArrayList<Integer> cañones = new ArrayList<Integer>();
        cañones = DistribuccionPueblo.GetCañones(level);
        return cañones;
    }
    
    public ArrayList<Integer> ObtenerAereos(int level){
        ArrayList<Integer> aereos = new ArrayList<Integer>();
        aereos = DistribuccionPueblo.GetAereos(level);
        return aereos;
    }
    
    public ArrayList<Integer> ObtenerMorteros(int level){
        ArrayList<Integer> morteros = new ArrayList<Integer>();
        morteros = DistribuccionPueblo.GetMorteros(level);
        return morteros;
    }
}
