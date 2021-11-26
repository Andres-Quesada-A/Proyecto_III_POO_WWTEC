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
    private ArrayList<ImageIcon> Movimiento = new ArrayList<ImageIcon>();
    private ArrayList<ImageIcon> Destruir = new ArrayList<ImageIcon>();
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
        String[] Espadas = {"/Ejercito/SoldadoDeContacto/Espadas/Caminar1.jpg","/Ejercito/SoldadoDeContacto/Espadas/Caminar2.jpg",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar3.jpg","/Ejercito/SoldadoDeContacto/Espadas/Caminar4.jpg","/Ejercito/SoldadoDeContacto/Espadas/Caminar5.jpg",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar6.jpg","/Ejercito/SoldadoDeContacto/Espadas/Caminar7.jpg","/Ejercito/SoldadoDeContacto/Espadas/Caminar8.jpg",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar9.jpg","/Ejercito/SoldadoDeContacto/Espadas/Caminar10.jpg","/Ejercito/SoldadoDeContacto/Espadas/Caminar11.jpg",
        "/Ejercito/SoldadoDeContacto/Espadas/Caminar12.jpg"};
        String[] Manos = {"/Ejercito/SoldadoDeContacto/Manos/Caminar1.jpg","/Ejercito/SoldadoDeContacto/Manos/Caminar2.jpg",
        "/Ejercito/SoldadoDeContacto/Manos/Caminar3.jpg","/Ejercito/SoldadoDeContacto/Manos/Caminar4.jpg","/Ejercito/SoldadoDeContacto/Manos/Caminar5.jpg",
        "/Ejercito/SoldadoDeContacto/Manos/Caminar6.jpg","/Ejercito/SoldadoDeContacto/Manos/Caminar7.jpg","/Ejercito/SoldadoDeContacto/Manos/Caminar8.jpg",
        "/Ejercito/SoldadoDeContacto/Manos/Caminar9.jpg","/Ejercito/SoldadoDeContacto/Manos/Caminar10.jpg","/Ejercito/SoldadoDeContacto/Manos/Caminar11.jpg"};
        String[] ImagenesIcons;
        switch(this.modo){
            case 1: ImagenesIcons = Espadas; break;
            case 2: ImagenesIcons = Manos; break;
            default: ImagenesIcons = Espadas; break;
        }
        
        for (int i = 0; i < ImagenesIcons.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcons[i]));
            Movimiento.add(personaje);
        } 
    }
    
    private void CargarImagenesDestruir(){
        String[] MoverEspada = {"/Ejercito/SoldadoDeContacto/Espadas/Golpear1.jpg","/Ejercito/SoldadoDeContacto/Espadas/Golpear2.jpg",
        "/Ejercito/SoldadoDeContacto/Espadas/Golpear3.jpg","/Ejercito/SoldadoDeContacto/Espadas/Golpear4.jpg","/Ejercito/SoldadoDeContacto/Espadas/Golpear5.jpg"};
        String[] Golpear = {"/Ejercito/SoldadoDeContacto/Manos/Golpear1.jpg","/Ejercito/SoldadoDeContacto/Manos/Golpear2.jpg",
        "/Ejercito/SoldadoDeContacto/Manos/Golpear3.jpg","/Ejercito/SoldadoDeContacto/Manos/Golpear4.jpg","/Ejercito/SoldadoDeContacto/Manos/Golpear5.jpg",
        "/Ejercito/SoldadoDeContacto/Manos/Golpear6.jpg","/Ejercito/SoldadoDeContacto/Manos/Golpear7.jpg","/Ejercito/SoldadoDeContacto/Manos/Golpear8.jpg",
        "/Ejercito/SoldadoDeContacto/Manos/Golpear9.jpg"};
        String[] ImagenesIcon;
        switch(this.modo){
            case 1: ImagenesIcon = MoverEspada; break;
            case 2: ImagenesIcon = Golpear; break;
            default: ImagenesIcon = MoverEspada; break;
        }
        
        for (int i = 0; i < ImagenesIcon.length; i++) {
            ImageIcon personaje = new ImageIcon(getClass().getResource(ImagenesIcon[i]));
            Destruir.add(personaje);
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
    
    
}
