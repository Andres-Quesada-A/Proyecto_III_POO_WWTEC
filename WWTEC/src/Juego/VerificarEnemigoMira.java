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
public class VerificarEnemigoMira {
    
    public static int[] VerificarEnemigoEnMira(int direccion, int x, int y, int alcance, ArrayList<ThreadPueblo> torres, 
            ArrayList<ThreadPueblo> cañones, ArrayList<ThreadPueblo> aereos,  ArrayList<ThreadPueblo> mortero, 
            ThreadEdificio Casa, ArrayList<ThreadMuro> muros){
        int[] posicion = {0, 0, 0};
        //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for (int i = 0; i < torres.size(); i++){
            //Verifica en la direccion ESTE
            if (y == torres.get(i).getY() && (x - alcance >= torres.get(i).getX() + 60 && x - alcance - 30 < torres.get(i).getX() + 60) && direccion == 2){
                posicion[0] = 2; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 3; //posicion
                return posicion;
            }
            //Verifica en la direccion OESTE
            if (y == torres.get(i).getY() && (x + alcance <= torres.get(i).getX() && x + alcance + 30 > torres.get(i).getX()) && direccion == 1){
                posicion[0] = 2; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 4; //posicion
                return posicion;
            }
            //Verifica en la direccion NORTE
            if (((x <= torres.get(i).getX() && x > torres.get(i).getX() - 30) || (x >= torres.get(i).getX() + 60 && x - 30 <= torres.get(i).getX() + 60)) &&
                    y - alcance >= torres.get(i).getY() + 60 && y - alcance - 30 < torres.get(i).getY() + 60){
                posicion[0] = 2; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 1; //direccion
                return posicion;
            }
            //Verifica en la direccion SUR
            if (((x <= torres.get(i).getX() && x > torres.get(i).getX() - 30) || (x >= torres.get(i).getX() + 60 && x - 30 <= torres.get(i).getX() + 60)) &&
                    y + alcance >= torres.get(i).getY() && y + alcance + 30 < torres.get(i).getY()){
                posicion[0] = 2; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 2; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-ESTE
            if (direccion == 2 && (y - alcance >= torres.get(i).getY() + 60 && y - alcance - 30 < torres.get(i).getY() + 60) &&
                    (x - alcance >= torres.get(i).getX() + 60 && x - alcance - 30 < torres.get(i).getX() + 60)){
                posicion[0] = 2; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 5; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-OESTE
            if (direccion == 1 && (y - alcance >= torres.get(i).getY() + 60 && y - alcance - 30 < torres.get(i).getY() + 60) &&
                    (x + alcance <= torres.get(i).getX() && x + alcance + 30 > torres.get(i).getX())){
                posicion[0] = 2; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 6; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-ESTE
            if (direccion == 2 && (y + alcance <= torres.get(i).getY() && y + alcance + 30 > torres.get(i).getY()) &&
                    (x - alcance >= torres.get(i).getX() + 60 && x - alcance - 30 < torres.get(i).getX() + 60)){
                posicion[0] = 2; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 7; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-OESTE
            if (direccion == 1 && (y + alcance <= torres.get(i).getY() && y + alcance + 30 > torres.get(i).getY()) &&
                    (x + alcance <= torres.get(i).getX() && x + alcance + 30 > torres.get(i).getX())){
                posicion[0] = 2; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 8; //posicion
                return posicion;
            }
        }
        
        
        
        //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for (int i = 0; i < cañones.size(); i++){
            //Verifica en la direccion ESTE
            if (y == cañones.get(i).getY() && (x - alcance >= cañones.get(i).getX() + 30 && x - alcance - 30 < cañones.get(i).getX() + 30) && direccion == 2){
                posicion[0] = 3; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 3; //posicion
                return posicion;
            }
            //Verifica en la direccion OESTE
            if (y == cañones.get(i).getY() && (x + alcance <= cañones.get(i).getX() && x + alcance + 30 > cañones.get(i).getX()) && direccion == 1){
                posicion[0] = 3; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 4; //posicion
                return posicion;
            }
            //Verifica en la direccion NORTE
            if (((x <= cañones.get(i).getX() && x > cañones.get(i).getX() - 30) || (x >= cañones.get(i).getX() + 30 && x - 30 <= cañones.get(i).getX() + 30)) &&
                    y - alcance >= cañones.get(i).getY() + 30 && y - alcance - 30 < cañones.get(i).getY() + 30){
                posicion[0] = 3; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 1; //direccion
                return posicion;
            }
            //Verifica en la direccion SUR
            if (((x <= cañones.get(i).getX() && x > cañones.get(i).getX() - 30) || (x >= cañones.get(i).getX() + 30 && x - 30 <= cañones.get(i).getX() + 30)) &&
                    y + alcance >= cañones.get(i).getY() && y + alcance + 30 < cañones.get(i).getY()){
                posicion[0] = 3; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 2; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-ESTE
            if (direccion == 2 && (y - alcance >= cañones.get(i).getY() + 30 && y - alcance - 30 < cañones.get(i).getY() + 30) &&
                    (x - alcance >= cañones.get(i).getX() + 30 && x - alcance - 30 < cañones.get(i).getX() + 30)){
                posicion[0] = 3; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 5; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-OESTE
            if (direccion == 1 && (y - alcance >= cañones.get(i).getY() + 30 && y - alcance - 30 < cañones.get(i).getY() + 30) &&
                    (x + alcance <= cañones.get(i).getX() && x + alcance + 30 > cañones.get(i).getX())){
                posicion[0] = 3; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 6; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-ESTE
            if (direccion == 2 && (y + alcance <= cañones.get(i).getY() && y + alcance + 30 > cañones.get(i).getY()) &&
                    (x - alcance >= cañones.get(i).getX() + 30 && x - alcance - 30 < cañones.get(i).getX() + 30)){
                posicion[0] = 3; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 7; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-OESTE
            if (direccion == 1 && (y + alcance <= cañones.get(i).getY() && y + alcance + 30 > cañones.get(i).getY()) &&
                    (x + alcance <= cañones.get(i).getX() && x + alcance + 30 > cañones.get(i).getX())){
                posicion[0] = 3; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 8; //posicion
                return posicion;
            }
        }
        
        
        
        //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for (int i = 0; i < aereos.size(); i++){
            //Verifica en la direccion ESTE
            if (y == aereos.get(i).getY() && (x - alcance >= aereos.get(i).getX() + 30 && x - alcance - 30 < aereos.get(i).getX() + 30) && direccion == 2){
                posicion[0] = 4; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 3; //posicion
                return posicion;
            }
            //Verifica en la direccion OESTE
            if (y == aereos.get(i).getY() && (x + alcance <= aereos.get(i).getX() && x + alcance + 30 > aereos.get(i).getX()) && direccion == 1){
                posicion[0] = 4; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 4; //posicion
                return posicion;
            }
            //Verifica en la direccion NORTE
            if (((x <= aereos.get(i).getX() && x > aereos.get(i).getX() - 30) || (x >= aereos.get(i).getX() + 30 && x - 30 <= aereos.get(i).getX() + 30)) &&
                    y - alcance >= aereos.get(i).getY() + 30 && y - alcance - 30 < aereos.get(i).getY() + 30){
                posicion[0] = 4; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 1; //direccion
                return posicion;
            }
            //Verifica en la direccion SUR
            if (((x <= aereos.get(i).getX() && x > aereos.get(i).getX() - 30) || (x >= aereos.get(i).getX() + 30 && x - 30 <= aereos.get(i).getX() + 30)) &&
                    y + alcance >= aereos.get(i).getY() && y + alcance + 30 < aereos.get(i).getY()){
                posicion[0] = 4; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 2; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-ESTE
            if (direccion == 2 && (y - alcance >= aereos.get(i).getY() + 30 && y - alcance - 30 < aereos.get(i).getY() + 30) &&
                    (x - alcance >= aereos.get(i).getX() + 30 && x - alcance - 30 < aereos.get(i).getX() + 30)){
                posicion[0] = 4; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 5; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-OESTE
            if (direccion == 1 && (y - alcance >= aereos.get(i).getY() + 30 && y - alcance - 30 < aereos.get(i).getY() + 30) &&
                    (x + alcance <= aereos.get(i).getX() && x + alcance + 30 > aereos.get(i).getX())){
                posicion[0] = 4; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 6; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-ESTE
            if (direccion == 2 && (y + alcance <= aereos.get(i).getY() && y + alcance + 30 > aereos.get(i).getY()) &&
                    (x - alcance >= aereos.get(i).getX() + 30 && x - alcance - 30 < aereos.get(i).getX() + 30)){
                posicion[0] = 4; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 7; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-OESTE
            if (direccion == 1 && (y + alcance <= aereos.get(i).getY() && y + alcance + 30 > aereos.get(i).getY()) &&
                    (x + alcance <= aereos.get(i).getX() && x + alcance + 30 > aereos.get(i).getX())){
                posicion[0] = 4; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 8; //posicion
                return posicion;
            }
        }
        
        
        
         //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for (int i = 0; i < mortero.size(); i++){
            //Verifica en la direccion ESTE
            if (y == mortero.get(i).getY() && (x - alcance >= mortero.get(i).getX() + 30 && x - alcance - 30 < mortero.get(i).getX() + 30) && direccion == 2){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 3; //posicion
                return posicion;
            }
            //Verifica en la direccion OESTE
            if (y == mortero.get(i).getY() && (x + alcance <= mortero.get(i).getX() && x + alcance + 30 > mortero.get(i).getX()) && direccion == 1){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 4; //posicion
                return posicion;
            }
            //Verifica en la direccion NORTE
            if (((x <= mortero.get(i).getX() && x > mortero.get(i).getX() - 30) || (x >= mortero.get(i).getX() + 30 && x - 30 <= mortero.get(i).getX() + 30)) &&
                    y - alcance >= mortero.get(i).getY() + 30 && y - alcance - 30 < mortero.get(i).getY() + 30){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 1; //direccion
                return posicion;
            }
            //Verifica en la direccion SUR
            if (((x <= mortero.get(i).getX() && x > mortero.get(i).getX() - 30) || (x >= mortero.get(i).getX() + 30 && x - 30 <= mortero.get(i).getX() + 30)) &&
                    y + alcance >= mortero.get(i).getY() && y + alcance + 30 < mortero.get(i).getY()){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 2; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-ESTE
            if (direccion == 2 && (y - alcance >= mortero.get(i).getY() + 30 && y - alcance - 30 < mortero.get(i).getY() + 30) &&
                    (x - alcance >= mortero.get(i).getX() + 30 && x - alcance - 30 < mortero.get(i).getX() + 30)){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 5; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-OESTE
            if (direccion == 1 && (y - alcance >= mortero.get(i).getY() + 30 && y - alcance - 30 < mortero.get(i).getY() + 30) &&
                    (x + alcance <= mortero.get(i).getX() && x + alcance + 30 > mortero.get(i).getX())){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 6; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-ESTE
            if (direccion == 2 && (y + alcance <= mortero.get(i).getY() && y + alcance + 30 > mortero.get(i).getY()) &&
                    (x - alcance >= mortero.get(i).getX() + 30 && x - alcance - 30 < mortero.get(i).getX() + 30)){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 7; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-OESTE
            if (direccion == 1 && (y + alcance <= mortero.get(i).getY() && y + alcance + 30 > mortero.get(i).getY()) &&
                    (x + alcance <= mortero.get(i).getX() && x + alcance + 30 > mortero.get(i).getX())){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 8; //posicion
                return posicion;
            }
        }
        
        
        if (Casa != null){
            //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
           //Verifica en la direccion ESTE
           if (y == Casa.getY() && (x - alcance >= Casa.getX() + 100 && x - alcance - 30 < Casa.getX() + 100) && direccion == 2){
               posicion[0] = 6; //tipo
               posicion[1] = 0; //indice donde se encuentra
               posicion[2] = 3; //posicion
               return posicion;
           }
           //Verifica en la direccion OESTE
           if (y == Casa.getY() && (x + alcance <= Casa.getX() && x + alcance + 30 > Casa.getX()) && direccion == 1){
               posicion[0] = 6; //tipo
               posicion[1] = 0; //indice donde se encuentra
               posicion[2] = 4; //posicion
               return posicion;
           }
           //Verifica en la direccion NORTE
           if (((x <= Casa.getX() && x > Casa.getX() - 30) || (x >= Casa.getX() + 100 && x - 30 <= Casa.getX() + 100)) &&
                   y - alcance >= Casa.getY() + 100 && y - alcance - 30 < Casa.getY() + 100){
               posicion[0] = 6; //tipo
               posicion[1] = 0; //indice donde se encuentra
               posicion[2] = 1; //direccion
               return posicion;
           }
           //Verifica en la direccion SUR
           if (((x <= Casa.getX() && x > Casa.getX() - 30) || (x >= Casa.getX() + 100 && x - 30 <= Casa.getX() + 100)) &&
                   y + alcance >= Casa.getY() && y + alcance + 30 < Casa.getY()){
               posicion[0] = 6; //tipo
               posicion[1] = 0; //indice donde se encuentra
               posicion[2] = 2; //posicion
               return posicion;
           }
           //Verifica en la direccion NOR-ESTE
           if (direccion == 2 && (y - alcance >= Casa.getY() + 100 && y - alcance - 30 < Casa.getY() + 100) &&
                   (x - alcance >= Casa.getX() + 100 && x - alcance - 30 < Casa.getX() + 100)){
               posicion[0] = 6; //tipo
               posicion[1] = 0; //indice donde se encuentra
               posicion[2] = 5; //posicion
               return posicion;
           }
           //Verifica en la direccion NOR-OESTE
           if (direccion == 1 && (y - alcance >= Casa.getY() + 100 && y - alcance - 30 < Casa.getY() + 100) &&
                   (x + alcance <= Casa.getX() && x + alcance + 30 > Casa.getX())){
               posicion[0] = 6; //tipo
               posicion[1] = 0; //indice donde se encuentra
               posicion[2] = 6; //posicion
               return posicion;
           }
           //Verifica en la direccion SUR-ESTE
           if (direccion == 2 && (y + alcance <= Casa.getY() && y + alcance + 30 > Casa.getY()) &&
                   (x - alcance >= Casa.getX() + 100 && x - alcance - 30 < Casa.getX() + 100)){
               posicion[0] = 6; //tipo
               posicion[1] = 0; //indice donde se encuentra
               posicion[2] = 7; //posicion
               return posicion;
           }
           //Verifica en la direccion SUR-OESTE
           if (direccion == 1 && (y + alcance <= Casa.getY() && y + alcance + 30 > Casa.getY()) &&
                   (x + alcance <= Casa.getX() && x + alcance + 30 > Casa.getX())){
               posicion[0] = 6; //tipo
               posicion[1] = 0; //indice donde se encuentra
               posicion[2] = 8; //posicion
               return posicion;
           }
        }
        
         //bombas = 1, torres = 2; cañones = 3; aereos = 4, morteros = 5, casa = 6, muro = 7
        for (int i = 0; i < muros.size(); i++){
            //Verifica en la direccion ESTE
            if (y == muros.get(i).getY() && (x - alcance >= muros.get(i).getX() + 30 && x - alcance - 30 < muros.get(i).getX() + 30) && direccion == 2){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 3; //posicion
                return posicion;
            }
            //Verifica en la direccion OESTE
            if (y == muros.get(i).getY() && (x + alcance <= muros.get(i).getX() && x + alcance + 30 > muros.get(i).getX()) && direccion == 1){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 4; //posicion
                return posicion;
            }
            //Verifica en la direccion NORTE
            if (((x <= muros.get(i).getX() && x > muros.get(i).getX() - 30) || (x >= muros.get(i).getX() + 30 && x - 30 <= muros.get(i).getX() + 30)) &&
                    y - alcance >= muros.get(i).getY() + 30 && y - alcance - 30 < muros.get(i).getY() + 30){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 1; //direccion
                return posicion;
            }
            //Verifica en la direccion SUR
            if (((x <= muros.get(i).getX() && x > muros.get(i).getX() - 30) || (x >= muros.get(i).getX() + 30 && x - 30 <= muros.get(i).getX() + 30)) &&
                    y + alcance >= muros.get(i).getY() && y + alcance + 30 < muros.get(i).getY()){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 2; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-ESTE
            if (direccion == 2 && (y - alcance >= muros.get(i).getY() + 30 && y - alcance - 30 < muros.get(i).getY() + 30) &&
                    (x - alcance >= muros.get(i).getX() + 30 && x - alcance - 30 < muros.get(i).getX() + 30)){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 5; //posicion
                return posicion;
            }
            //Verifica en la direccion NOR-OESTE
            if (direccion == 1 && (y - alcance >= muros.get(i).getY() + 30 && y - alcance - 30 < muros.get(i).getY() + 30) &&
                    (x + alcance <= muros.get(i).getX() && x + alcance + 30 > muros.get(i).getX())){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 6; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-ESTE
            if (direccion == 2 && (y + alcance <= muros.get(i).getY() && y + alcance + 30 > muros.get(i).getY()) &&
                    (x - alcance >= muros.get(i).getX() + 30 && x - alcance - 30 < muros.get(i).getX() + 30)){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 7; //posicion
                return posicion;
            }
            //Verifica en la direccion SUR-OESTE
            if (direccion == 1 && (y + alcance <= muros.get(i).getY() && y + alcance + 30 > muros.get(i).getY()) &&
                    (x + alcance <= muros.get(i).getX() && x + alcance + 30 > muros.get(i).getX())){
                posicion[0] = 5; //tipo
                posicion[1] = i; //indice donde se encuentra
                posicion[2] = 8; //posicion
                return posicion;
            }
        }
        
        return posicion;
    }
}
