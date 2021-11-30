/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Threads.ThreadBomba;
import Threads.ThreadEdificio;
import Threads.ThreadMuro;
import Threads.ThreadPueblo;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class VerificarCercanoPueblo {
    public static int[] VerificarCercano(ArrayList<ThreadBomba> bombas,ArrayList<ThreadPueblo> torres,ArrayList<ThreadPueblo> cañones,
            ArrayList<ThreadPueblo> aereos,ArrayList<ThreadPueblo> morteros,int x,int y, ThreadEdificio casa, ArrayList<ThreadMuro> muros){
        //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        int[] proximo = {0,0};
        for(int i = 0; i < bombas.size(); i++){
            if (x <= bombas.get(i).getX() && (x + 10) > bombas.get(i).getX() && y == bombas.get(i).getY()){
                proximo[0] = 1;
                proximo[1] = i;
                return proximo;
            }else if (x > bombas.get(i).getX() && (x - 36) <= bombas.get(i).getX() && y == bombas.get(i).getY()){
                proximo[0] = 1;
                proximo[1] = i;
                return proximo;
            }
                
        }
        
        //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for(int i = 0; i < torres.size(); i++){
            if (x <= torres.get(i).getX() && (x + 10) > torres.get(i).getX() && y <= torres.get(i).getY() && y >= torres.get(i).getY() + 31){
                proximo[0] = 2;
                proximo[1] = i;
                return proximo;
            }else if (x > torres.get(i).getX() && (x - 36) <= torres.get(i).getX() &&  y <= torres.get(i).getY() && y >= torres.get(i).getY() + 31){
                proximo[0] = 2;
                proximo[1] = i;
                return proximo;
            }
                
        }
        //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for(int i = 0; i < cañones.size(); i++){
            if (x <= cañones.get(i).getX() && (x + 10) > cañones.get(i).getX() &&y == cañones.get(i).getY()){
                proximo[0] = 3;
                proximo[1] = i;
                return proximo;
            }else if (x > cañones.get(i).getX() && (x - 36) <= cañones.get(i).getX() &&  y == cañones.get(i).getY()){
                proximo[0] = 3;
                proximo[1] = i;
                return proximo;
            }
                
        }
        
        //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for(int i = 0; i < aereos.size(); i++){
            if (x <= aereos.get(i).getX() && (x + 10) > aereos.get(i).getX() &&y == aereos.get(i).getY()){
                proximo[0] = 4;
                proximo[1] = i;
                return proximo;
            }else if (x > aereos.get(i).getX() && (x - 36) <= aereos.get(i).getX() &&  y == aereos.get(i).getY()){
                proximo[0] = 4;
                proximo[1] = i;
                return proximo;
            }
                
        }
        
        //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for(int i = 0; i < morteros.size(); i++){
            if (x <= morteros.get(i).getX() && (x + 10) > morteros.get(i).getX() &&y == morteros.get(i).getY()){
                proximo[0] = 5;
                proximo[1] = i;
                return proximo;
            }else if (x > morteros.get(i).getX() && (x - 36) <= morteros.get(i).getX() &&  y == morteros.get(i).getY()){
                proximo[0] = 5;
                proximo[1] = i;
                return proximo;
            }
                
        }
        
        if (casa != null){
            //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
            if (((casa.getX() >= x && x >= casa.getX() - 10) || (casa.getX() + 100 <= x && casa.getX() + 110 >= x)) && y >= casa.getY() && y <= casa.getY() + 70){
                proximo[0] = 6;
                proximo[1] = 0;
                return proximo;
            }
        }
        
        //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for(int i = 0; i < muros.size(); i++){
            if (((x <= muros.get(i).getX() && x >= muros.get(i).getX() - 10) || (x >= muros.get(i).getX() + 31 && x - 10 <= muros.get(i).getX())) && y == muros.get(i).getY() ){
                proximo[0] = 7;
                proximo[1] = i;
                return proximo;
            }
        }
        return proximo;
    }
}
