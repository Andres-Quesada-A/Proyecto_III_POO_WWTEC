/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sonido;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andre
 */
public class ThreadSonido extends Thread{
    private SClip sonido;
    
    public ThreadSonido(SClip clip){
        this.sonido = clip;
    }
    
    public void run(){
//        sonido.play();
//        while(true){
//            try {
//                sleep(2000);
//            } catch (InterruptedException ex) {
//                System.out.println("Sleep");
//            }
//            break;
//            
//        }
    }
}
