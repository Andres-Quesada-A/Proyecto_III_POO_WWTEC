/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DistribuccioPueblo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author andre
 */
public class DistribucionPueblo {

    public DistribucionPueblo() {
    }
    
    public ArrayList<Integer> GetBombas(int nivel){
        int cantidad = 0;
        switch(nivel){
            case 1: cantidad = 1; break;
            case 2: cantidad = 2; break;
            case 3: cantidad = 3; break;
            case 4: cantidad = 4; break;
            case 5: cantidad = 5; break;
            case 6: cantidad = 6; break;
            case 7: cantidad = 7; break;
            case 8: cantidad = 8; break;
            case 9: cantidad = 9; break;
            default: cantidad = 10; break;
        }
        int[] coordenadas = {393, 173, 393, 297, 393, 421, 455, 235, 455, 359, 517, 173, 517, 421, 579, 235, 579, 359, 641, 173, 641, 297, 641, 421};
        int[] Coordenadas = {261,174,261,298,261,422,261,515,447,112,447,546,571,112,571,546,788,174,788,298,788,422};
        ArrayList<Integer> posiciones =  new ArrayList<Integer>();
        ArrayList<Integer> registro = new ArrayList<Integer>();
        boolean estado;
        int posicion = 0;
        Random r = new Random();
        for (int i = 0; i < cantidad; i++){
            estado = true;
            while (estado){
                posicion = r.nextInt(10);
                int k;
                for (k = 0; k < registro.size(); k++){
                    if (registro.get(k) == posicion){
                        k = registro.size() + 5;
                    }
                }
                if (k == registro.size()){
                    registro.add(posicion);
                    estado = false;
                }
            }
            if (nivel < 6){
                posiciones.add(coordenadas[posicion * 2]);
                posiciones.add(coordenadas[(posicion * 2) + 1]);
            }else{
                posiciones.add(Coordenadas[posicion * 2]);
                posiciones.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return posiciones;
    }
    
    public ArrayList<Integer> GetTorres(int nivel){
        int cantidad = 0;
        switch(nivel){
            case 1: cantidad = 1; break;
            case 2: cantidad = 1; break;
            case 3: cantidad = 2; break;
            case 4: cantidad = 2; break;
            case 5: cantidad = 4; break;
            case 6: cantidad = 4; break;
            case 7: cantidad = 5; break;
            case 8: cantidad = 6; break;
            case 9: cantidad = 7; break;
            default: cantidad = 8; break;
        }
        int[] coordenadas = {331,111,331,421,424,111,424,421,548,111,548,421,672,111,672,421};
        int[] Coordenadas = {292,112,292,360,292,546,509,112,509,546,726,112,726,360,726,546};
        ArrayList<Integer> posiciones =  new ArrayList<Integer>();
        ArrayList<Integer> registro = new ArrayList<Integer>();
        boolean estado;
        int posicion = 0;
        Random r = new Random();
        for (int i = 0; i < cantidad; i++){
            estado = true;
            while (estado){
                posicion = r.nextInt(8);
                int k;
                for (k = 0; k < registro.size(); k++){
                    if (registro.get(k) == posicion){
                        k = registro.size() + 5;
                    }
                }
                if (k == registro.size()){
                    registro.add(posicion);
                    estado = false;
                }
            }
            if (nivel < 6){
                posiciones.add(coordenadas[posicion * 2]);
                posiciones.add(coordenadas[(posicion * 2) + 1]);
            }else{
                posiciones.add(Coordenadas[posicion * 2]);
                posiciones.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return posiciones;
    }
    
    public ArrayList<Integer> GetCañones(int nivel){
        int cantidad = 0;
        switch(nivel){
            case 1: cantidad = 1; break;
            case 2: cantidad = 1; break;
            case 3: cantidad = 2; break;
            case 4: cantidad = 2; break;
            case 5: cantidad = 4; break;
            case 6: cantidad = 4; break;
            case 7: cantidad = 5; break;
            case 8: cantidad = 6; break;
            case 9: cantidad = 7; break;
            default: cantidad = 8; break;
        }
        int[] coordenadas = {362,297,393,111,393,452,455,297,579,297,610,111,610,452,672,297};
        int[] Coordenadas = {323,174,323,267,323,453,323,515,695,174,695,267,695,453,695,512};
        ArrayList<Integer> posiciones =  new ArrayList<Integer>();
        ArrayList<Integer> registro = new ArrayList<Integer>();
        boolean estado;
        int posicion = 0;
        Random r = new Random();
        for (int i = 0; i < cantidad; i++){
            estado = true;
            while (estado){
                posicion = r.nextInt(8);
                int k;
                for (k = 0; k < registro.size(); k++){
                    if (registro.get(k) == posicion){
                        k = registro.size() + 5;
                    }
                }
                if (k == registro.size()){
                    registro.add(posicion);
                    estado = false;
                }
            }
            if (nivel < 6){
                posiciones.add(coordenadas[posicion * 2]);
                posiciones.add(coordenadas[(posicion * 2) + 1]);
            }else{
                posiciones.add(Coordenadas[posicion * 2]);
                posiciones.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return posiciones;
    }
     
    public ArrayList<Integer> GetAereos(int nivel){
        int cantidad = 0;
        switch(nivel){
            case 1: cantidad = 1; break;
            case 2: cantidad = 1; break;
            case 3: cantidad = 2; break;
            case 4: cantidad = 2; break;
            case 5: cantidad = 2; break;
            case 6: cantidad = 3; break;
            case 7: cantidad = 3; break;
            case 8: cantidad = 3; break;
            case 9: cantidad = 4; break;
            default: cantidad = 4; break;
        }
        int[] coordenadas = {455,173,455,390,579,173,579,390};
        int[] Coordenadas = {385,205,385,422,633,205,633,422};
        ArrayList<Integer> posiciones =  new ArrayList<Integer>();
        ArrayList<Integer> registro = new ArrayList<Integer>();
        boolean estado;
        int posicion = 0;
        Random r = new Random();
        for (int i = 0; i < cantidad; i++){
            estado = true;
            while (estado){
                posicion = r.nextInt(4);
                int k;
                for (k = 0; k < registro.size(); k++){
                    if (registro.get(k) == posicion){
                        k = registro.size() + 5;
                    }
                }
                if (k == registro.size()){
                    registro.add(posicion);
                    estado = false;
                }
            }
            if (nivel < 6){
                posiciones.add(coordenadas[posicion * 2]);
                posiciones.add(coordenadas[(posicion * 2) + 1]);
            }else{
                posiciones.add(Coordenadas[posicion * 2]);
                posiciones.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return posiciones;
    }
    
    public ArrayList<Integer> GetMorteros(int nivel){
        int cantidad = 0;
        switch(nivel){
            case 1: cantidad = 1; break;
            case 2: cantidad = 1; break;
            case 3: cantidad = 2; break;
            case 4: cantidad = 2; break;
            case 5: cantidad = 2; break;
            case 6: cantidad = 3; break;
            case 7: cantidad = 3; break;
            case 8: cantidad = 3; break;
            case 9: cantidad = 4; break;
            default: cantidad = 4; break;
        }
        int[] coordenadas = {362,204,362,359,672,204,672,359};
        int[] Coordenadas = {416,267,540,205,540,453,664,329};
        ArrayList<Integer> posiciones =  new ArrayList<Integer>();
        ArrayList<Integer> registro = new ArrayList<Integer>();
        boolean estado;
        int posicion = 0;
        Random r = new Random();
        for (int i = 0; i < cantidad; i++){
            estado = true;
            while (estado){
                posicion = r.nextInt(4);
                int k;
                for (k = 0; k < registro.size(); k++){
                    if (registro.get(k) == posicion){
                        k = registro.size() + 5;
                    }
                }
                if (k == registro.size()){
                    registro.add(posicion);
                    estado = false;
                }
            }
            if (nivel < 6){
                posiciones.add(coordenadas[posicion * 2]);
                posiciones.add(coordenadas[(posicion * 2) + 1]);
            }else{
                posiciones.add(Coordenadas[posicion * 2]);
                posiciones.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return posiciones;
    }
    
}
