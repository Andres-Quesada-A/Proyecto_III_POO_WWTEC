/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Progreso;

import DistribuccioPueblo.DistribuccionEjercito;
import DistribuccioPueblo.DistribucionPueblo;
import DistribuccioPueblo.LocalizarMuro;
import Ejercito.Ejercito;
import FilesManagers.FileManager;
import FilesManagers.Serealizar_Deserializar_Objeto;
import JuegoUsuario.JuegoUsuario;
import PartidasJugador.PartidaUsuario;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class ModeloProgreso {
    
    public static int ObtenerNivel(String user, String password){
        FileManager file = new FileManager();
        file.createFile("HistorialPartidas.txt");
        String Historial = file.readFile("HistorialPartidas.txt");
        String [] partidas = Historial.split("\n");
        String PathDefinitivo = "";
        int mayor = 0;
        
        for (int i = 0; i < partidas.length; i++){
            String[] partes = partidas[i].split("_");
            if (partes[0].equalsIgnoreCase(user) && partes[1].equalsIgnoreCase(password)){
                //user_password_Nivel_#
                if (Integer.parseInt(partes[3]) > mayor){
                    mayor = Integer.parseInt(partes[3]);
                    PathDefinitivo = partidas[i];
                }
            }
        }
        String[] numeros = PathDefinitivo.split("_");
        
        return Integer.parseInt(numeros[3]);
    }
    
    public static String CrearDistribucciones(int nivel, String user, String password){
        String numero = Integer.toString(nivel);
        String PATH = user + "_" + password + "_" + "Nivel_" + numero + ".dat";
        System.out.println("PATH para crear distribucciones: " + PATH);
        
        PartidaUsuario recuperado =  new PartidaUsuario();
        recuperado = Serealizar_Deserializar_Objeto.deserializarObjeto(PATH, PartidaUsuario.class);
        if (recuperado == null){
            System.out.println("El valor recuperado es nulo (en CrearDistribucciones");
        }
        
        System.out.println("Tenia contenido para crear las distribucciones");
        DistribucionPueblo distribuccionPueblo = new DistribucionPueblo();
        LocalizarMuro distribuccionMuro = new LocalizarMuro();
        DistribuccionEjercito distribuccionEjercito = new DistribuccionEjercito();
        ArrayList<Ejercito> paraLuchar = new ArrayList<Ejercito>();
        paraLuchar = recuperado.juegoUsuario.getParaLuchar();
        System.out.println("Todo bien recuperando los datos");
        
        int cantidadAviones = 0;
        int cantidadTanques = 0;
        int cantidadCamiones = 0;
        int cantidadContacto = 0;
        int cantidadMidAlcance = 0;
        
        
        for (Ejercito miembro : paraLuchar){
            System.out.println("Para luchar " + miembro.getNombreClase());
            if (miembro.getNombreClase().equalsIgnoreCase("Soldados de contacto")){
                cantidadContacto++;
            }else if (miembro.getNombreClase().equalsIgnoreCase("Alcance medio")){
                cantidadMidAlcance++;
            }else if (miembro.getNombreClase().equalsIgnoreCase("Aéreos")){
                cantidadAviones++;
            }else if (miembro.getNombreClase().equalsIgnoreCase("Impacto")){
                cantidadCamiones++;
            }else if (miembro.getNombreClase().equalsIgnoreCase("Choque")){
                cantidadTanques++;
            }
        }
        
        
        if (nivel > 10){
            nivel = 10;
        }
        
        System.out.println("Comienza a obtener las distribucciones");
        recuperado.juegoUsuario.setDistribuccionMuro(distribuccionMuro.GetDistribuccion(nivel));
        System.out.println("Obtiene distribuccion de muros");
        recuperado.juegoUsuario.setDistribuccionBombas(distribuccionPueblo.GetBombas(nivel));
        System.out.println("Obtiene la distribuccion de bombas");
        recuperado.juegoUsuario.setDistribuccionTorres(distribuccionPueblo.GetTorres(nivel));
        System.out.println("Obtienen la distribuccion de torres");
        recuperado.juegoUsuario.setDistribuccionCañones(distribuccionPueblo.GetCañones(nivel));
        System.out.println("Obtiene la distribuccion de cañones");
        recuperado.juegoUsuario.setDistribuccionAereos(distribuccionPueblo.GetAereos(nivel));
        System.out.println("Obtiene la distribuccion de aereos");
        recuperado.juegoUsuario.setDistribuccionMorteros(distribuccionPueblo.GetMorteros(nivel));
        System.out.println("Obtiene la distribuccion de morteros");
        recuperado.juegoUsuario.setDistribuccionAviones(distribuccionEjercito.GetAviones(cantidadAviones, nivel));
        System.out.println("Obtiene la distribuccion de aviones");
        recuperado.juegoUsuario.setDistribuccionTanques(distribuccionEjercito.GetTanques(cantidadTanques, nivel));
        System.out.println("Obtiene la distribuccion de tanques");
        recuperado.juegoUsuario.setDistribuccionCamion(distribuccionEjercito.GetCamion(cantidadCamiones, nivel));
        System.out.println("Obtiene la distribuccion del camion");
        recuperado.juegoUsuario.setDistribuccionContacto(distribuccionEjercito.GetContacto(cantidadContacto, nivel));
        System.out.println("Obtiene la distribuccion cotacto");
        recuperado.juegoUsuario.setDistribuccionAlcanceMedio(distribuccionEjercito.GetAlcanceMedio(cantidadMidAlcance, nivel));
        System.out.println("Termina de obtener las distribucciones");
        
        Serealizar_Deserializar_Objeto.serializarObjeto(PATH, recuperado);
        return PATH;
    }
}
