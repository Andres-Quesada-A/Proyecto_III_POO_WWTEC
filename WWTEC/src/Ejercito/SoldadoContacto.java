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
public class SoldadoContacto extends Ejercito implements Serializable{
    private String Arma;
    private String RuidoPath = "";
    private int limite;
    private ArrayList<ImageIcon> MovimientoL = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> DestruirL = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> MovimientoR = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> DestruirR = new ArrayList<ImageIcon>();
    private int modo = 0;

    public SoldadoContacto(String tipo, String Arma, String Nombre, int Vida, int CantidadGolpes, int nivel, int Campos, int NivelAparicion, int Costo, int Fuerza) {
        super(tipo, Nombre, Vida, CantidadGolpes, nivel, Campos, NivelAparicion, Costo, Fuerza);
        this.Arma = Arma;
        DecidirModo();
        CargarImagenesMovimiento();
        CargarImagenesDestruir();
    }
    
    private void DecidirModo(){
        if (Arma.equalsIgnoreCase("Espadas")){
            modo = 1;
        }else if (Arma.equalsIgnoreCase("Navajas")){
            modo = 1;
        }else if (Arma.equalsIgnoreCase("Cuchillos")){
            modo = 1;
        }else if (Arma.equalsIgnoreCase("Manos")){
            modo = 2;
        }
    }
   
    private void CargarImagenesMovimiento(){
        String[] EspadasL = {"/Ejercito/SoldadoDeContacto/Espadas/Caminar1L.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar2L.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar3L.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar4L.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar5L.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar6L.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar7L.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar8L.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar9L.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar10L.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar11L.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar12L.png"};
        String[] ManosL = {"/Ejercito/SoldadoDeContacto/Manos/Caminar1L.png","/Ejercito/SoldadoDeContacto/Manos/Caminar2L.png",
        "/Ejercito/SoldadoDeContacto/Manos/Caminar3L.png","/Ejercito/SoldadoDeContacto/Manos/Caminar4L.png","/Ejercito/SoldadoDeContacto/Manos/Caminar5L.png",
        "/Ejercito/SoldadoDeContacto/Manos/Caminar6L.png","/Ejercito/SoldadoDeContacto/Manos/Caminar7L.png","/Ejercito/SoldadoDeContacto/Manos/Caminar8L.png",
        "/Ejercito/SoldadoDeContacto/Manos/Caminar9L.png","/Ejercito/SoldadoDeContacto/Manos/Caminar10L.png","/Ejercito/SoldadoDeContacto/Manos/Caminar11L.png"};
        String[] ImagenesIcons;
        switch(this.modo){
            case 1: ImagenesIcons = EspadasL; break;
            case 2: ImagenesIcons = ManosL; break;
            default: ImagenesIcons = EspadasL; break;
        }
        
        for (int i = 0; i < ImagenesIcons.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcons[i]));
            MovimientoL.add(personaje);
        } 
        
        String[] EspadasR = {"/Ejercito/SoldadoDeContacto/Espadas/Caminar1R.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar2R.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar3R.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar4R.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar5R.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar6R.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar7R.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar8R.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar9R.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar10R.png","/Ejercito/SoldadoDeContacto/Espadas/Caminar11R.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar12R.png"};
        String[] ManosR = {"/Ejercito/SoldadoDeContacto/Manos/Caminar1R.png","/Ejercito/SoldadoDeContacto/Manos/Caminar2R.png",
        "/Ejercito/SoldadoDeContacto/Manos/Caminar3R.png","/Ejercito/SoldadoDeContacto/Manos/Caminar4R.png","/Ejercito/SoldadoDeContacto/Manos/Caminar5R.png",
        "/Ejercito/SoldadoDeContacto/Manos/Caminar6R.png","/Ejercito/SoldadoDeContacto/Manos/Caminar7R.png","/Ejercito/SoldadoDeContacto/Manos/Caminar8R.png",
        "/Ejercito/SoldadoDeContacto/Manos/Caminar9R.png","/Ejercito/SoldadoDeContacto/Manos/Caminar10R.png","/Ejercito/SoldadoDeContacto/Manos/Caminar11R.png"};

        switch(this.modo){
            case 1: ImagenesIcons = EspadasR; break;
            case 2: ImagenesIcons = ManosR; break;
            default: ImagenesIcons = EspadasR; break;
        }
        
        for (int i = 0; i < ImagenesIcons.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcons[i]));
            MovimientoR.add(personaje);
        } 
    }
    
    private void CargarImagenesDestruir(){
        String[] MoverEspadaL = {"/Ejercito/SoldadoDeContacto/Espadas/Golpear1L.png","/Ejercito/SoldadoDeContacto/Espadas/Golpear2L.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Golpear3L.png","/Ejercito/SoldadoDeContacto/Espadas/Golpear4L.png","/Ejercito/SoldadoDeContacto/Espadas/Golpear5L.png"};
        String[] GolpearL = {"/Ejercito/SoldadoDeContacto/Manos/Golpear1L.png","/Ejercito/SoldadoDeContacto/Manos/Golpear2L.png",
        "/Ejercito/SoldadoDeContacto/Manos/Golpear3L.png","/Ejercito/SoldadoDeContacto/Manos/Golpear4L.png","/Ejercito/SoldadoDeContacto/Manos/Golpear5L.png",
        "/Ejercito/SoldadoDeContacto/Manos/Golpear6L.png","/Ejercito/SoldadoDeContacto/Manos/Golpear7L.png","/Ejercito/SoldadoDeContacto/Manos/Golpear8L.png",
        "/Ejercito/SoldadoDeContacto/Manos/Golpear9L.png"};
        String[] ImagenesIcon;
        switch(this.modo){
            case 1: ImagenesIcon = MoverEspadaL; break;
            case 2: ImagenesIcon = GolpearL; break;
            default: ImagenesIcon = MoverEspadaL; break;
        }
        
        for (int i = 0; i < ImagenesIcon.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcon[i]));
            DestruirL.add(personaje);
        }
        
        String[] MoverEspadaR = {"/Ejercito/SoldadoDeContacto/Espadas/Golpear1R.png","/Ejercito/SoldadoDeContacto/Espadas/Golpear2R.png",
        "/Ejercito/SoldadoDeContacto/Espadas/Golpear3.png","/Ejercito/SoldadoDeContacto/Espadas/Golpear4R.png","/Ejercito/SoldadoDeContacto/Espadas/Golpear5R.png"};
        String[] GolpearR = {"/Ejercito/SoldadoDeContacto/Manos/Golpear1R.png","/Ejercito/SoldadoDeContacto/Manos/Golpear2R.png",
        "/Ejercito/SoldadoDeContacto/Manos/Golpear3R.png","/Ejercito/SoldadoDeContacto/Manos/Golpear4R.png","/Ejercito/SoldadoDeContacto/Manos/Golpear5R.png",
        "/Ejercito/SoldadoDeContacto/Manos/Golpear6R.png","/Ejercito/SoldadoDeContacto/Manos/Golpear7R.png","/Ejercito/SoldadoDeContacto/Manos/Golpear8R.png",
        "/Ejercito/SoldadoDeContacto/Manos/Golpear9R.png"};
        switch(this.modo){
            case 1: ImagenesIcon = MoverEspadaR; break;
            case 2: ImagenesIcon = GolpearR; break;
            default: ImagenesIcon = MoverEspadaR; break;
        }
        
        for (int i = 0; i < ImagenesIcon.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcon[i]));
            DestruirR.add(personaje);
        }
    }
    
    public void subirNivel(){
        
    }

    public String getArma() {
        return Arma;
    }

    public void setArma(String Arma) {
        this.Arma = Arma;
    }

    public ArrayList<ImageIcon> getMovimientoL() {
        return MovimientoL;
    }

    public ArrayList<ImageIcon> getDestruirL() {
        return DestruirL;
    }

    public ArrayList<ImageIcon> getMovimientoR() {
        return MovimientoR;
    }

    public ArrayList<ImageIcon> getDestruirR() {
        return DestruirR;
    }
    
    
}
