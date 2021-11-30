/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

/**
 *
 * @author andre
 */
public class Porcentajes {
    private double[] porcentajes = new double[7];
    
    private void primerNivel(){
        porcentajes[0] = 1; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 70; //Edificio
    }
    
    private void segundoNivel(){
        porcentajes[0] = 1; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 64; //Edificio
    }
    
    private void tercerNivel(){
        porcentajes[0] = 1; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 54; //Edificio
    }
    
    private void cuartoNivel(){
        porcentajes[0] = 1; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 48; //Edificio
    }
    
    private void quintoNivel(){
        porcentajes[0] = 1; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 38; //Edificio
    }
    
    private void sextoNivel(){
        porcentajes[0] = 1; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 30; //Edificio
    }
    
    private void septimoNivel(){
        porcentajes[0] = 1; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 22; //Edificio
    }
    
    private void octavoNivel(){
        porcentajes[0] = 0.5; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 44; //Edificio
    }
    
    private void novenoNivel(){
        porcentajes[0] = 0.5; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 36; //Edificio
    }
    
    private void diezNivel(){
        porcentajes[0] = 0.5; //Muro
        porcentajes[1] = 1; //Bombas
        porcentajes[2] = 1; // torres
        porcentajes[3] = 1; //Cañones
        porcentajes[4] = 1; //Aereos
        porcentajes[5] = 1; //Morteros
        porcentajes[6] = 31; //Edificio
    }
    
    public double[] obtenerPorcentajes(int level){
        if (level == 1){
            primerNivel();
            return porcentajes;
        }else if (level == 2){
            segundoNivel();
            return porcentajes;
        }else if (level == 3){
            tercerNivel();
            return porcentajes;
        }else if (level == 4){
            cuartoNivel();
            return porcentajes;
        }else if (level == 5){
            quintoNivel();
            return porcentajes;
        }else if (level == 6){
            sextoNivel();
            return porcentajes;
        }else if (level == 7){
            septimoNivel();
            return porcentajes;
        }else if (level == 8){
            octavoNivel();
            return porcentajes;
        }else if (level == 9){
            novenoNivel();
            return porcentajes;
        }else if (level >= 10){
            diezNivel();
            return porcentajes;
        }
        return porcentajes;
            
    }
}
