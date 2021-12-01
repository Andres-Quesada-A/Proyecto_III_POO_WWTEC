/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Defensa.Defensa;
import DistribuccioPueblo.DistribucionPueblo;
import DistribuccioPueblo.LocalizarMuro;
import Ejercito.Aereos;
import Ejercito.AlcanceMedio;
import Ejercito.Ejercito;
import EquipoEjercito.EquipoEjercito;
import FilesManagers.FileManager;
import FilesManagers.Serealizar_Deserializar_Objeto;
import PartidasJugador.PartidaUsuario;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author andre
 */
public class ModeloVideoJuego {
    private LocalizarMuro distribuccionMuro;
    private DistribucionPueblo DistribuccionPueblo;
    private String PATH = "";

    public ModeloVideoJuego() {
        distribuccionMuro = new LocalizarMuro();
        DistribuccionPueblo = new DistribucionPueblo();
    }
    
    public void PasarAlSiguienteNivel(PartidaUsuario partidaUsuario){
        Random r = new Random();
        int bienes = partidaUsuario.juegoUsuario.getDinero();
        bienes = bienes + (bienes / 100 * (100 + r.nextInt(151)));
        
        partidaUsuario.juegoUsuario.setDinero(bienes);
        int nivel = partidaUsuario.juegoUsuario.getNivel();
        partidaUsuario.juegoUsuario.setNivel(nivel + 1);
        int espacios = partidaUsuario.juegoUsuario.getCampos();
        partidaUsuario.juegoUsuario.setCampos(espacios + 5);
        
        ArrayList<Defensa> pueblo = new ArrayList<Defensa>();
        pueblo = partidaUsuario.juegoUsuario.getPueblo().getEquipoPueblo();
        int mejoramiento = 0; //Mejoramiento para los atributos del pueblo
        mejoramiento = 50 + r.nextInt(51);
        int vida = 0, fuerza = 0;
        for (Defensa pieza : pueblo){
            pieza.AumentarNivel(mejoramiento);
        }
        //se guarda nuevamente la configuracion del pueblo con las mejoras
        partidaUsuario.juegoUsuario.getPueblo().setEquipoPueblo(pueblo);
        
        EquipoEjercito equipo = new EquipoEjercito();
        equipo = partidaUsuario.juegoUsuario.getEjercito();
        AlcanceMedio midAlcance = new AlcanceMedio("Alcance medio", "Arma", "nombre", 1,1,1,1,1,1,1);
        Aereos aereo = new Aereos("Aéreos","Arma", "nombre", 1,1,1,1,1,1,1);
        for (int i = 0; i < equipo.getLegthArray(); i++){
            if (equipo.GetUsuario(i).getNombreClase().equalsIgnoreCase("Aéreos") && equipo.GetUsuario(i).getNivelAparicion() < nivel){
                equipo.GetUsuario(i).Mejorar(mejoramiento);
            }else if (equipo.GetUsuario(i).getNombreClase().equalsIgnoreCase("Alcance medio") && equipo.GetUsuario(i).getNivelAparicion() < nivel){
                equipo.GetUsuario(i).Mejorar(mejoramiento);
            }
        }
        
        //Guardamos el nuevo equipo
        partidaUsuario.juegoUsuario.setEjercito(equipo);
        GuardarSiguientePartida(partidaUsuario, nivel);
        
    }
    
    private void GuardarSiguientePartida(PartidaUsuario partidaUsuario, int nivel){
        String PathAux = "";
        String PorGuardar = "";
        String[] partes = PATH.split("_");
        PathAux = partes[0] + "_" + partes[1] +"_" + partes[2] + "_" + nivel + ".dat";
        PorGuardar = partes[0] + "_" + partes[1] +"_" + partes[2] + "_" + nivel;
        
        FileManager file = new FileManager();
        file.createFile("HistorialPartidas.txt");
        file.writeToFile("HistorialPartidas.txt", PorGuardar);
        
        //Guardamos todos los cambios
        FileManager file2 = new FileManager();
        file2.createFile(PathAux);
        Serealizar_Deserializar_Objeto.serializarObjeto(PathAux, partidaUsuario);
    }
    
    public PartidaUsuario DeserealizarPartida(String PATH){
        this.PATH = PATH;
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
