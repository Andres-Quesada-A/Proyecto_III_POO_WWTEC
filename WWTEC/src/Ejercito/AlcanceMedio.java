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
    private ArrayList<ImageIcon> MovimientoR = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> MovimientoL = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> DispararR = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> DispararL = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> Municion = new ArrayList<ImageIcon>();
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
        String[] ArqueroL = {"/Ejercito/MedianoAlcance/Flechas/Caminar1L.png", "/Ejercito/MedianoAlcance/Flechas/Caminar2L.png",
        "/Ejercito/MedianoAlcance/Flechas/Caminar3L.png","/Ejercito/MedianoAlcance/Flechas/Caminar4L.png","/Ejercito/MedianoAlcance/Flechas/Caminar5L.png",
        "/Ejercito/MedianoAlcance/Flechas/Caminar6L.png","/Ejercito/MedianoAlcance/Flechas/Caminar7L.png","/Ejercito/MedianoAlcance/Flechas/Caminar8L.png",
        "/Ejercito/MedianoAlcance/Flechas/Caminar9L.png","/Ejercito/MedianoAlcance/Flechas/Caminar10L.png","/Ejercito/MedianoAlcance/Flechas/Caminar11L.png"};
        String[] PistoleroL = {"/Ejercito/MedianoAlcance/Pistola/Caminar1L.png","/Ejercito/MedianoAlcance/Pistola/Caminar2L.png",
        "/Ejercito/MedianoAlcance/Pistola/Caminar3L.png","/Ejercito/MedianoAlcance/Pistola/Caminar4L.png","/Ejercito/MedianoAlcance/Pistola/Caminar5L.png",
        "/Ejercito/MedianoAlcance/Pistola/Caminar6L.png","/Ejercito/MedianoAlcance/Pistola/Caminar7L.png","/Ejercito/MedianoAlcance/Pistola/Caminar8L.png",
        "/Ejercito/MedianoAlcance/Pistola/Caminar9L.png","/Ejercito/MedianoAlcance/Pistola/Caminar10L.png","/Ejercito/MedianoAlcance/Pistola/Caminar11L.png"};
        String[] MetralletaL = {"/Ejercito/MedianoAlcance/Metralleta/Caminar1L.png","/Ejercito/MedianoAlcance/Metralleta/Caminar2L.png",
        "/Ejercito/MedianoAlcance/Metralleta/Caminar3L.png","/Ejercito/MedianoAlcance/Metralleta/Caminar4L.png","/Ejercito/MedianoAlcance/Metralleta/Caminar5L.png",
        "/Ejercito/MedianoAlcance/Metralleta/Caminar6L.png","/Ejercito/MedianoAlcance/Metralleta/Caminar7L.png","/Ejercito/MedianoAlcance/Metralleta/Caminar8L.png",
        "/Ejercito/MedianoAlcance/Metralleta/Caminar9L.png","/Ejercito/MedianoAlcance/Metralleta/Caminar10L.png","/Ejercito/MedianoAlcance/Metralleta/Caminar11L.png"};
        String[] ImagenesIcons;
        switch(this.modo){
            case 1: ImagenesIcons = ArqueroL; break;
            case 2: ImagenesIcons = PistoleroL; break;
            case 3: ImagenesIcons = MetralletaL; break;
            default: ImagenesIcons = ArqueroL; break;
        }
        
        for (int i = 0; i < ImagenesIcons.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcons[i]));
            MovimientoL.add(personaje);
        }   
        
        
        String[] ArqueroR = {"/Ejercito/MedianoAlcance/Flechas/Caminar1R.png", "/Ejercito/MedianoAlcance/Flechas/Caminar2R.png",
        "/Ejercito/MedianoAlcance/Flechas/Caminar3R.png","/Ejercito/MedianoAlcance/Flechas/Caminar4R.png","/Ejercito/MedianoAlcance/Flechas/Caminar5R.png",
        "/Ejercito/MedianoAlcance/Flechas/Caminar6R.png","/Ejercito/MedianoAlcance/Flechas/Caminar7R.png","/Ejercito/MedianoAlcance/Flechas/Caminar8R.png",
        "/Ejercito/MedianoAlcance/Flechas/Caminar9R.png","/Ejercito/MedianoAlcance/Flechas/Caminar10R.png","/Ejercito/MedianoAlcance/Flechas/Caminar11R.png"};
        String[] PistoleroR = {"/Ejercito/MedianoAlcance/Pistola/Caminar1R.png","/Ejercito/MedianoAlcance/Pistola/Caminar2R.png",
        "/Ejercito/MedianoAlcance/Pistola/Caminar3R.png","/Ejercito/MedianoAlcance/Pistola/Caminar4R.png","/Ejercito/MedianoAlcance/Pistola/Caminar5R.png",
        "/Ejercito/MedianoAlcance/Pistola/Caminar6R.png","/Ejercito/MedianoAlcance/Pistola/Caminar7R.png","/Ejercito/MedianoAlcance/Pistola/Caminar8R.png",
        "/Ejercito/MedianoAlcance/Pistola/Caminar9R.png","/Ejercito/MedianoAlcance/Pistola/Caminar10R.png","/Ejercito/MedianoAlcance/Pistola/Caminar11R.png"};
        String[] MetralletaR = {"/Ejercito/MedianoAlcance/Metralleta/Caminar1R.png","/Ejercito/MedianoAlcance/Metralleta/Caminar2R.png",
        "/Ejercito/MedianoAlcance/Metralleta/Caminar3R.png","/Ejercito/MedianoAlcance/Metralleta/Caminar4R.png","/Ejercito/MedianoAlcance/Metralleta/Caminar5R.png",
        "/Ejercito/MedianoAlcance/Metralleta/Caminar6R.png","/Ejercito/MedianoAlcance/Metralleta/Caminar7R.png","/Ejercito/MedianoAlcance/Metralleta/Caminar8R.png",
        "/Ejercito/MedianoAlcance/Metralleta/Caminar9R.png","/Ejercito/MedianoAlcance/Metralleta/Caminar10R.png","/Ejercito/MedianoAlcance/Metralleta/Caminar11R.png"};
        switch(this.modo){
            case 1: ImagenesIcons = ArqueroR; break;
            case 2: ImagenesIcons = PistoleroR; break;
            case 3: ImagenesIcons = MetralletaR; break;
            default: ImagenesIcons = ArqueroR; break;
        }
        
        for (int i = 0; i < ImagenesIcons.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcons[i]));
            MovimientoR.add(personaje);
        }
    }
    
    private void CargarImagenesDisparo(){
        String[] LanzarFlechaR = {"/Ejercito/MedianoAlcance/Flechas/Disparo1R.png","/Ejercito/MedianoAlcance/Flechas/Disparo2R.png",
        "/Ejercito/MedianoAlcance/Flechas/Disparo3R.png","/Ejercito/MedianoAlcance/Flechas/Disparo4R.png"};
        String[] DisparoPistolaR = {"/Ejercito/MedianoAlcance/Pistola/DisparoR.png"};
        String[] DisparoMetralletaR = {"/Ejercito/MedianoAlcance/Metralleta/DisparoR.png"};
        String[] ImagenesIcon;
        switch(this.modo){
            case 1: ImagenesIcon = LanzarFlechaR; break;
            case 2: ImagenesIcon = DisparoPistolaR; break;
            case 3: ImagenesIcon = DisparoMetralletaR; break;
            default: ImagenesIcon = LanzarFlechaR; break;
        }
        for (int i = 0; i < ImagenesIcon.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcon[i]));
            DispararR.add(personaje);
        } 
        
        String[] LanzarFlechaL = {"/Ejercito/MedianoAlcance/Flechas/Disparo1L.png","/Ejercito/MedianoAlcance/Flechas/Disparo2L.png",
        "/Ejercito/MedianoAlcance/Flechas/Disparo3L.png","/Ejercito/MedianoAlcance/Flechas/Disparo4L.png"};
        String[] DisparoPistolaL = {"/Ejercito/MedianoAlcance/Pistola/DisparoL.png"};
        String[] DisparoMetralletaL = {"/Ejercito/MedianoAlcance/Metralleta/DisparoL.png"};
        switch(this.modo){
            case 1: ImagenesIcon = LanzarFlechaL; break;
            case 2: ImagenesIcon = DisparoPistolaL; break;
            case 3: ImagenesIcon = DisparoMetralletaL; break;
            default: ImagenesIcon = LanzarFlechaL; break;
        }
        for (int i = 0; i < ImagenesIcon.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcon[i]));
            DispararL.add(personaje);
        }
    }
    
    private void CargarFlechas(){
        //Municion = new ImageIcon(getClass().getResource("/Ejercito/MedianoAlcance/Flechas/Flecha.png"))
        String[] Flechas = {"/Ejercito/MedianoAlcance/Flechas/FlechaUP.png", "/Ejercito/MedianoAlcance/Flechas/FlechaDOWN.png",
        "/Ejercito/MedianoAlcance/Flechas/FlechaL.png", "/Ejercito/MedianoAlcance/Flechas/FlechaR.png", "/Ejercito/MedianoAlcance/Flechas/FlechaNE.png",
        "/Ejercito/MedianoAlcance/Flechas/FlechaNO.png", "/Ejercito/MedianoAlcance/Flechas/FlechaSE.png", "/Ejercito/MedianoAlcance/Flechas/FlechaSO.png"};
        for (int i = 0; i < Flechas.length; i++){
            Municion.add(new ImageIcon(getClass().getResource(Flechas[i])));
        }
    }
    
    private void CargarBala(){
        //Municion = new ImageIcon(getClass().getResource("/Ejercito/MedianoAlcance/Pistola/Bala.png"))
        String[] Flechas = {"/Ejercito/MedianoAlcance/Pistola/balaUP.png","/Ejercito/MedianoAlcance/Pistola/balaDOWN.png",
        "/Ejercito/MedianoAlcance/Pistola/BalaL.png","/Ejercito/MedianoAlcance/Pistola/BalaR.png","/Ejercito/MedianoAlcance/Pistola/balaNE.png",
        "/Ejercito/MedianoAlcance/Pistola/balaNO.png","/Ejercito/MedianoAlcance/Pistola/balaSE.png","/Ejercito/MedianoAlcance/Pistola/balaSO.png"};
        for (int i = 0; i < Flechas.length; i++){
            Municion.add(new ImageIcon(getClass().getResource(Flechas[i])));
        }
    }
    
    private void CargarMunicion(){
        switch(this.modo){
            case 1: CargarFlechas(); break;
            case 2: CargarBala(); break;
            case 3: CargarBala(); break;
            default: CargarFlechas(); break;
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

    public ArrayList<ImageIcon> getMovimientoR() {
        return MovimientoR;
    }

    public ArrayList<ImageIcon> getMovimientoL() {
        return MovimientoL;
    }

    public ArrayList<ImageIcon> getDispararR() {
        return DispararR;
    }

    public ArrayList<ImageIcon> getDispararL() {
        return DispararL;
    }

    public ArrayList<ImageIcon> getMunicion() {
        return Municion;
    }
    
    
}
