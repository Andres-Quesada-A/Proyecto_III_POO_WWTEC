/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sonido;
/**
 *
 * @author andre
 */
public class Prueba {
    private static final SClip cañon = new SClip("Cañon.wav");
    private static final SClip bomba = new SClip("bomba.wav");
    private static final SClip disparopueblo = new SClip("disparopueblo.wav");
    private static final SClip espada = new SClip("espada.wav");
    private static final SClip golpes = new SClip("golpes.wav");
    private static final SClip misil = new SClip("misil.wav");
    private static final SClip motorCarro = new SClip("motorCarro.wav");
    
    
    
    public static void main(String[] args) {
        ThreadSonido sonido = new ThreadSonido(cañon);
        sonido.start();
        
    }
}
