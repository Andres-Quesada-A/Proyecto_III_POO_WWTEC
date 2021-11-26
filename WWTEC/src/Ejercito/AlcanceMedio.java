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
public class AlcanceMedio extends Ejercito implements Serializable{
    private String Arma;
    private int Limite;
    private ArrayList<ImageIcon> Movimiento = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> Disparar= new ArrayList<ImageIcon>();
    private ImageIcon Municion = new ImageIcon();
    private int modo = 0;

    public AlcanceMedio(String tipo, String Arma, String Nombre, int Vida, int CantidadGolpes, int nivel, int Campos, int NivelAparicion, int Costo, int Fuerza) {
        super(tipo ,Nombre, Vida, CantidadGolpes, nivel, Campos, NivelAparicion, Costo, Fuerza);
        this.Arma = Arma;
        DecidirModo();
    }
    
    private void DecidirModo(){
        if (Arma.equalsIgnoreCase("Flechas")){
            modo = 1;
        }else if (Arma.equalsIgnoreCase("Pistola")){
            modo = 2;
        }else if (Arma.equalsIgnoreCase("Fusiles")){
            modo = 3;
        }else if (Arma.equalsIgnoreCase("Rifles")){
            modo = 3;
        }else if (Arma.equalsIgnoreCase("Metralleta")){
            modo = 3;
        }
        CargarImagenesMovimiento();
        CargarImagenesDisparo();
        CargarMunicion();
    }
    
    private void CargarImagenesMovimiento(){
        String[] Arquero = {"/Ejercito/MedianoAlcance/Flechas/Caminar1.jpg", "/Ejercito/MedianoAlcance/Flechas/Caminar2.jpg",
        "/Ejercito/MedianoAlcance/Flechas/Caminar3.jpg","/Ejercito/MedianoAlcance/Flechas/Caminar4.jpg","/Ejercito/MedianoAlcance/Flechas/Caminar5.jpg",
        "/Ejercito/MedianoAlcance/Flechas/Caminar6.jpg","/Ejercito/MedianoAlcance/Flechas/Caminar7.jpg","/Ejercito/MedianoAlcance/Flechas/Caminar8.jpg",
        "/Ejercito/MedianoAlcance/Flechas/Caminar9.jpg","/Ejercito/MedianoAlcance/Flechas/Caminar10.jpg","/Ejercito/MedianoAlcance/Flechas/Caminar11.jpg"};
        String[] Pistolero = {"/Ejercito/MedianoAlcance/Pistola/Caminar1.jpg","/Ejercito/MedianoAlcance/Pistola/Caminar2.jpg",
        "/Ejercito/MedianoAlcance/Pistola/Caminar3.jpg","/Ejercito/MedianoAlcance/Pistola/Caminar4.jpg","/Ejercito/MedianoAlcance/Pistola/Caminar5.jpg",
        "/Ejercito/MedianoAlcance/Pistola/Caminar6.jpg","/Ejercito/MedianoAlcance/Pistola/Caminar7.jpg","/Ejercito/MedianoAlcance/Pistola/Caminar8.jpg",
        "/Ejercito/MedianoAlcance/Pistola/Caminar9.jpg","/Ejercito/MedianoAlcance/Pistola/Caminar10.jpg","/Ejercito/MedianoAlcance/Pistola/Caminar11.jpg"};
        String[] Metralleta = {"/Ejercito/MedianoAlcance/Metralleta/Caminar1.jpg","/Ejercito/MedianoAlcance/Metralleta/Caminar2.jpg",
        "/Ejercito/MedianoAlcance/Metralleta/Caminar3.jpg","/Ejercito/MedianoAlcance/Metralleta/Caminar4.jpg","/Ejercito/MedianoAlcance/Metralleta/Caminar5.jpg",
        "/Ejercito/MedianoAlcance/Metralleta/Caminar6.jpg","/Ejercito/MedianoAlcance/Metralleta/Caminar7.jpg","/Ejercito/MedianoAlcance/Metralleta/Caminar8.jpg",
        "/Ejercito/MedianoAlcance/Metralleta/Caminar9.jpg","/Ejercito/MedianoAlcance/Metralleta/Caminar10.jpg","/Ejercito/MedianoAlcance/Metralleta/Caminar11.jpg"};
        String[] ImagenesIcons;
        switch(this.modo){
            case 1: ImagenesIcons = Arquero; break;
            case 2: ImagenesIcons = Pistolero; break;
            case 3: ImagenesIcons = Metralleta; break;
            default: ImagenesIcons = Arquero; break;
        }
        
        for (int i = 0; i < ImagenesIcons.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcons[i]));
            Movimiento.add(personaje);
        }      
    }
    
    private void CargarImagenesDisparo(){
        String[] LanzarFlecha = {"/Ejercito/MedianoAlcance/Flechas/Disparo1.jpg","/Ejercito/MedianoAlcance/Flechas/Disparo2.jpg",
        "/Ejercito/MedianoAlcance/Flechas/Disparo3.jpg","/Ejercito/MedianoAlcance/Flechas/Disparo4.jpg"};
        String[] DisparoPistola = {"/Ejercito/MedianoAlcance/Pistola/Disparo.jpg"};
        String[] DisparoMetralleta = {"/Ejercito/MedianoAlcance/Metralleta/Disparo.jpg"};
        String[] ImagenesIcon;
        switch(this.modo){
            case 1: ImagenesIcon = LanzarFlecha; break;
            case 2: ImagenesIcon = DisparoPistola; break;
            case 3: ImagenesIcon = DisparoMetralleta; break;
            default: ImagenesIcon = LanzarFlecha; break;
        }
        for (int i = 0; i < ImagenesIcon.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcon[i]));
            Disparar.add(personaje);
        } 
    }
    
    private void CargarMunicion(){
        switch(this.modo){
            case 1: Municion = new ImageIcon(getClass().getResource("/Ejercito/MedianoAlcance/Flechas/Flecha.jpg")); break;
            case 2: Municion = new ImageIcon(getClass().getResource("/Ejercito/MedianoAlcance/Pistola/Bala.jpg")); break;
            case 3: Municion = new ImageIcon(getClass().getResource("/Ejercito/MedianoAlcance/Metralleta/Bala.jpg")); break;
            default: Municion = new ImageIcon(getClass().getResource("/Ejercito/MedianoAlcance/Flechas/Flecha.jpg")); break;
        }
    }
    
    public String getArma() {
        return Arma;
    }

    public void setArma(String Arma) {
        this.Arma = Arma;
    }
    
    public void subirNivel(){
        
    }
}
