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
public class DistribuccionEjercito {
    
    public ArrayList<Integer> GetAviones(int cantidad, int nivel){
        ArrayList<Integer> aviones = new ArrayList<Integer>();
        int[] coordenadas = {0, 173,0,390,1000,173,1000,173};
        int[] Coordenadas = {0,205,0,422,1000,205,1000,422};
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
                aviones.add(coordenadas[posicion * 2]);
                aviones.add(coordenadas[(posicion * 2) + 1]);
            }else{
                aviones.add(Coordenadas[posicion * 2]);
                aviones.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return aviones;
    }
    
    
    public ArrayList<Integer> GetTanques(int cantidad, int nivel){
        ArrayList<Integer> tanques = new ArrayList<Integer>();
        int[] coordenadas = {0,111,0,452,1000,111,1000,452};
        int[] Coordenadas = {0,112,0,546,1000,112,1000,546};
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
                tanques.add(coordenadas[posicion * 2]);
                tanques.add(coordenadas[(posicion * 2) + 1]);
            }else{
                tanques.add(Coordenadas[posicion * 2]);
                tanques.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return tanques;
    }
    
    
    public ArrayList<Integer> GetCamion(int cantidad, int nivel){
        ArrayList<Integer> camiones = new ArrayList<Integer>();
        int[] coordenadas = {0,49,0,512,1000,49,1000,512};
        int[] Coordenadas = {0,50,0,608,1000,50,1000,608};
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
                camiones.add(coordenadas[posicion * 2]);
                camiones.add(coordenadas[(posicion * 2) + 1]);
            }else{
                camiones.add(Coordenadas[posicion * 2]);
                camiones.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return camiones;
    }
    
    
    public ArrayList<Integer> GetContacto(int cantidad, int nivel){
        ArrayList<Integer> contacto = new ArrayList<Integer>();
        int[] coordenadas = {0,328,0,359,1000,328,1000,359,1000,297};
        int[] Coordenadas = {0,174,0,267,0,360,0,484,1000,174,1000,267,1000,360,1000,484};
        ArrayList<Integer> registro = new ArrayList<Integer>();
        boolean estado;
        int posicion = 0;
        Random r = new Random();
        if (nivel < 6){
            for (int i = 0; i < cantidad; i++){
                estado = true;
                while (estado){
                    posicion = r.nextInt(5);
                    int k;
                    for (k = 0; k < registro.size(); k++){
                        if (registro.get(k) == posicion)
                            k = registro.size() + 5;
                    }
                    if (k == registro.size()){
                        registro.add(posicion);
                        estado = false;
                    }
                }
                contacto.add(coordenadas[posicion * 2]);
                contacto.add(coordenadas[(posicion * 2) + 1]);
            }
        }else{
            for (int i = 0; i < cantidad; i++){
                estado = true;
                while (estado){
                    posicion = r.nextInt(8);
                    int k;
                    for (k = 0; k < registro.size(); k++){
                        if (registro.get(k) == posicion)
                            k = registro.size() + 5;
                    }
                    if (k == registro.size()){
                        registro.add(posicion);
                        estado = false;
                    }
                }
                contacto.add(Coordenadas[posicion * 2]);
                contacto.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return contacto;
    }
    
    
    public ArrayList<Integer> GetAlcanceMedio(int cantidad, int nivel){
        ArrayList<Integer> AlcanceMedio = new ArrayList<Integer>();
        int[] coordenadas = {0,235,0,266,0,297,1000,266,1000,235};
        int[] Coordenadas = {0,298,0,329,0,391,0,515,1000,298,1000,329,1000,391,1000,515};
        ArrayList<Integer> registro = new ArrayList<Integer>();
        boolean estado;
        int posicion = 0;
        Random r = new Random();
        if (nivel < 6){
            for (int i = 0; i < cantidad; i++){
                estado = true;
                while (estado){
                    posicion = r.nextInt(5);
                    int k;
                    for (k = 0; k < registro.size(); k++){
                        if (registro.get(k) == posicion)
                            k = registro.size() + 5;
                    }
                    if (k == registro.size()){
                        registro.add(posicion);
                        estado = false;
                    }
                }
                AlcanceMedio.add(coordenadas[posicion * 2]);
                AlcanceMedio.add(coordenadas[(posicion * 2) + 1]);
            }
        }else{
            for (int i = 0; i < cantidad; i++){
                estado = true;
                while (estado){
                    posicion = r.nextInt(8);
                    int k;
                    for (k = 0; k < registro.size(); k++){
                        if (registro.get(k) == posicion)
                            k = registro.size() + 5;
                    }
                    if (k == registro.size()){
                        registro.add(posicion);
                        estado = false;
                    }
                }
                AlcanceMedio.add(Coordenadas[posicion * 2]);
                AlcanceMedio.add(Coordenadas[(posicion * 2) + 1]);
            }
        }
        return AlcanceMedio;
    }
}
