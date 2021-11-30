/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Threads.ThreadAviones;
import Threads.ThreadCamion;
import Threads.ThreadEdificio;
import Threads.ThreadMedioAlcance;
import Threads.ThreadMuro;
import Threads.ThreadPueblo;
import Threads.ThreadSoldado;
import Threads.ThreadTanque;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class VerificarChoqueMunicion {
    
    //Recibe la ubicacion de la bala
    public static int[] choqueConSoldados(int x, int y, ArrayList<ThreadSoldado> contacto, int direccion){
        int[] soldier = {0 ,0};
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        for (int i = 0; i < contacto.size(); i ++){
            //NORTE
            if (direccion == 1 && (contacto.get(i).getY() + 30 >= y && contacto.get(i).getY() + 30 < y + 30) &&
            ((x - 10 < contacto.get(i).getX() && x + 30 > contacto.get(i).getX()) || (x + 10 > contacto.get(i).getX() && x < contacto.get(i).getX() + 30))){
                soldier[0] = 1;
                soldier[1] = i;
                return soldier;
            }
            //SUR
            if (direccion == 2 && (contacto.get(i).getY() >= y && contacto.get(i).getY() < y + 30) && 
            ((x - 10 < contacto.get(i).getX() && x + 30 > contacto.get(i).getX()) || (x + 10 > contacto.get(i).getX() && x < contacto.get(i).getX() + 30))){
                soldier[0] = 1;
                soldier[1] = i;
                return soldier;
            }
            //ESTE
            if (direccion == 3 && (y == contacto.get(i).getY()) && (x >= contacto.get(i).getX() + 30 && x - 30 < contacto.get(i).getX() + 30)){
                soldier[0] = 1;
                soldier[1] = i;
                return soldier;
            }
            //OESTE
            if (direccion == 4 && (y == contacto.get(i).getY()) && x <= contacto.get(i).getX() && x + 30 > contacto.get(i).getX()){
                soldier[0] = 1;
                soldier[1] = i;
                return soldier;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= contacto.get(i).getX() + 30 && x - 30 < contacto.get(i).getX() + 30) &&
                    contacto.get(i).getY() + 30 > y && contacto.get(i).getY() + 30 < y + 30){
                soldier[0] = 1;
                soldier[1] = i;
                return soldier;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= contacto.get(i).getX() && x + 30 > contacto.get(i).getX() && 
                    contacto.get(i).getY() + 30 > y && contacto.get(i).getY() + 30 < y + 30){
                soldier[0] = 1;
                soldier[1] = i;
                return soldier;
            }
            //SUR-ESTE
            if (direccion == 7 && contacto.get(i).getY() >= y && contacto.get(i).getY() < y + 30 &&
                    x >= contacto.get(i).getX() + 30 && x - 30 < contacto.get(i).getX() + 30){
                soldier[0] = 1;
                soldier[1] = i;
                return soldier;
            }
            //SUR-OESTE
            if (direccion == 8 && contacto.get(i).getY() >= y && contacto.get(i).getY() < y + 30 &&
                   x <= contacto.get(i).getX() && x + 30 > contacto.get(i).getX()){
                soldier[0] = 1;
                soldier[1] = i;
                return soldier;
            }
        }
        return soldier;
    }
    
    //Recibe la ubicacion de la bala
    public static int[] choqueAlcanceMedio(int x, int y, ArrayList<ThreadMedioAlcance> medianoAlcance, int direccion){
        int[] AlcanceMid = {0 ,0};
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        for (int i = 0; i < medianoAlcance.size(); i ++){
            //NORTE
            if (direccion == 1 && (medianoAlcance.get(i).getY() + 30 >= y && medianoAlcance.get(i).getY() + 30 < y + 30) &&
            ((x - 10 < medianoAlcance.get(i).getX() && x + 30 > medianoAlcance.get(i).getX()) || (x + 10 > medianoAlcance.get(i).getX() && x < medianoAlcance.get(i).getX() + 30))){
                AlcanceMid[0] = 2;
                AlcanceMid[1] = i;
                return AlcanceMid;
            }
            //SUR
            if (direccion == 2 && (medianoAlcance.get(i).getY() >= y && medianoAlcance.get(i).getY() < y + 30) && 
            ((x - 10 < medianoAlcance.get(i).getX() && x + 30 > medianoAlcance.get(i).getX()) || (x + 10 > medianoAlcance.get(i).getX() && x < medianoAlcance.get(i).getX() + 30))){
                AlcanceMid[0] = 2;
                AlcanceMid[1] = i;
                return AlcanceMid;
            }
            //ESTE
            if (direccion == 3 && (y == medianoAlcance.get(i).getY()) && (x >= medianoAlcance.get(i).getX() + 30 && x - 30 < medianoAlcance.get(i).getX() + 30)){
                AlcanceMid[0] = 2;
                AlcanceMid[1] = i;
                return AlcanceMid;
            }
            //OESTE
            if (direccion == 4 && (y == medianoAlcance.get(i).getY()) && x <= medianoAlcance.get(i).getX() && x + 30 > medianoAlcance.get(i).getX()){
                AlcanceMid[0] = 2;
                AlcanceMid[1] = i;
                return AlcanceMid;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= medianoAlcance.get(i).getX() + 30 && x - 30 < medianoAlcance.get(i).getX() + 30) &&
                    medianoAlcance.get(i).getY() + 30 > y && medianoAlcance.get(i).getY() + 30 < y + 30){
                AlcanceMid[0] = 2;
                AlcanceMid[1] = i;
                return AlcanceMid;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= medianoAlcance.get(i).getX() && x + 30 > medianoAlcance.get(i).getX() && 
                    medianoAlcance.get(i).getY() + 30 > y && medianoAlcance.get(i).getY() + 30 < y + 30){
                AlcanceMid[0] = 2;
                AlcanceMid[1] = i;
                return AlcanceMid;
            }
            //SUR-ESTE
            if (direccion == 7 && medianoAlcance.get(i).getY() >= y && medianoAlcance.get(i).getY() < y + 30 &&
                    x >= medianoAlcance.get(i).getX() + 30 && x - 30 < medianoAlcance.get(i).getX() + 30){
                AlcanceMid[0] = 2;
                AlcanceMid[1] = i;
                return AlcanceMid;
            }
            //SUR-OESTE
            if (direccion == 8 && medianoAlcance.get(i).getY() >= y && medianoAlcance.get(i).getY() < y + 30 &&
                   x <= medianoAlcance.get(i).getX() && x + 30 > medianoAlcance.get(i).getX()){
                AlcanceMid[0] = 2;
                AlcanceMid[1] = i;
                return AlcanceMid;
            }
        }
        return AlcanceMid;
    }
    
    //Recibe la ubicacion de la bala
    public static int[] choqueAviones(int x, int y, ArrayList<ThreadAviones> aviones, int direccion){
        int[] avion = {0 ,0};
        for (int i = 0; i < aviones.size(); i ++){
            //NORTE
            if (direccion == 1 && (aviones.get(i).getY() + 60 >= y && aviones.get(i).getY() + 60 < y + 30) &&
            ((x - 10 < aviones.get(i).getX() && x + 30 > aviones.get(i).getX()) || (x + 10 > aviones.get(i).getX() && x < aviones.get(i).getX() + 80))){
                avion[0] = 5;
                avion[1] = i;
                return avion;
            }
            //SUR
            if (direccion == 2 && (aviones.get(i).getY() >= y && aviones.get(i).getY() < y + 30) && 
            ((x - 10 < aviones.get(i).getX() && x + 30 > aviones.get(i).getX()) || (x + 10 > aviones.get(i).getX() && x < aviones.get(i).getX() + 80))){
                avion[0] = 5;
                avion[1] = i;
                return avion;
            }
            //ESTE
            if (direccion == 3 && (y == aviones.get(i).getY()) && (x >= aviones.get(i).getX() + 80 && x - 30 < aviones.get(i).getX() + 80)){
                avion[0] = 5;
                avion[1] = i;
                return avion;
            }
            //OESTE
            if (direccion == 4 && (y == aviones.get(i).getY()) && x <= aviones.get(i).getX() && x + 30 > aviones.get(i).getX()){
                avion[0] = 5;
                avion[1] = i;
                return avion;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= aviones.get(i).getX() + 80 && x - 30 < aviones.get(i).getX() + 80) &&
                    aviones.get(i).getY() + 60 > y && aviones.get(i).getY() + 60 < y + 30){
                avion[0] = 5;
                avion[1] = i;
                return avion;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= aviones.get(i).getX() && x + 30 > aviones.get(i).getX() && aviones.get(i).getY() + 60 > y && aviones.get(i).getY() + 60 < y + 30){
                avion[0] = 5;
                avion[1] = i;
                return avion;
            }
            //SUR-ESTE
            if (direccion == 7 && aviones.get(i).getY() >= y && aviones.get(i).getY() < y + 30 &&
                    x >= aviones.get(i).getX() + 80 && x - 30 < aviones.get(i).getX() + 80){
                avion[0] = 5;
                avion[1] = i;
                return avion;
            }
            //SUR-OESTE
            if (direccion == 8 && aviones.get(i).getY() >= y && aviones.get(i).getY() < y + 30 &&
                   x <= aviones.get(i).getX() && x + 30 > aviones.get(i).getX()){
                avion[0] = 5;
                avion[1] = i;
                return avion;
            }
        }
        return avion;
    }
    
    //Recibe la ubicacion de la bala
    public static int[] choqueTanque(int x, int y, ArrayList<ThreadTanque> tanques, int direccion){
        int [] tanque = {0,0};
        for (int i = 0; i < tanques.size(); i ++){
            //NORTE
            if (direccion == 1 && (tanques.get(i).getY() + 60 >= y && tanques.get(i).getY() + 60 < y + 30) &&
            ((x - 10 < tanques.get(i).getX() && x + 30 > tanques.get(i).getX()) || (x + 10 > tanques.get(i).getX() && x < tanques.get(i).getX() + 110))){
                tanque[0] = 4;
                tanque[1] = i;
                return tanque;
            }
            //SUR
            if (direccion == 2 && (tanques.get(i).getY() >= y && tanques.get(i).getY() < y + 30) && 
            ((x - 10 < tanques.get(i).getX() && x + 30 > tanques.get(i).getX()) || (x + 10 > tanques.get(i).getX() && x < tanques.get(i).getX() + 110))){
                tanque[0] = 4;
                tanque[1] = i;
                return tanque;
            }
            //ESTE
            if (direccion == 3 && (y == tanques.get(i).getY()) && (x >= tanques.get(i).getX() + 110 && x - 30 < tanques.get(i).getX() + 110)){
                tanque[0] = 4;
                tanque[1] = i;
                return tanque;
            }
            //OESTE
            if (direccion == 4 && (y == tanques.get(i).getY()) && x <= tanques.get(i).getX() && x + 30 > tanques.get(i).getX()){
                tanque[0] = 4;
                tanque[1] = i;
                return tanque;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= tanques.get(i).getX() + 110 && x - 30 < tanques.get(i).getX() + 110) &&
                    tanques.get(i).getY() + 60 > y && tanques.get(i).getY() + 60 < y + 30){
                tanque[0] = 4;
                tanque[1] = i;
                return tanque;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= tanques.get(i).getX() && x + 30 > tanques.get(i).getX() && tanques.get(i).getY() + 60 > y && tanques.get(i).getY() + 60 < y + 30){
                tanque[0] = 4;
                tanque[1] = i;
                return tanque;
            }
            //SUR-ESTE
            if (direccion == 7 && tanques.get(i).getY() >= y && tanques.get(i).getY() < y + 30 &&
                    x >= tanques.get(i).getX() + 110 && x - 30 < tanques.get(i).getX() + 110){
                tanque[0] = 4;
                tanque[1] = i;
                return tanque;
            }
            //SUR-OESTE
            if (direccion == 8 && tanques.get(i).getY() >= y && tanques.get(i).getY() < y + 30 &&
                   x <= tanques.get(i).getX() && x + 30 > tanques.get(i).getX()){
                tanque[0] = 4;
                tanque[1] = i;
                return tanque;
            }
        }
        return tanque;
    }
    
    //Recibe la ubicacion de la bala
    public static int[] choqueCamion(int x, int y, ArrayList<ThreadCamion> carros, int direccion){
        int[] camion = {0,0};
        for (int i = 0; i < carros.size(); i ++){
            //NORTE
            if (direccion == 1 && (carros.get(i).getY() + 60 >= y && carros.get(i).getY() + 60 < y + 30) &&
            ((x - 10 < carros.get(i).getX() && x + 30 > carros.get(i).getX()) || (x + 10 > carros.get(i).getX() && x < carros.get(i).getX() + 100))){
                camion[0] = 3;
                camion[1] = i;
                return camion;
            }
            //SUR
            if (direccion == 2 && (carros.get(i).getY() >= y && carros.get(i).getY() < y + 30) && 
            ((x - 10 < carros.get(i).getX() && x + 30 > carros.get(i).getX()) || (x + 10 > carros.get(i).getX() && x < carros.get(i).getX() + 100))){
                camion[0] = 3;
                camion[1] = i;
                return camion;
            }
            //ESTE
            if (direccion == 3 && (y == carros.get(i).getY()) && (x >= carros.get(i).getX() + 100 && x - 30 < carros.get(i).getX() + 100)){
                camion[0] = 3;
                camion[1] = i;
                return camion;
            }
            //OESTE
            if (direccion == 4 && (y == carros.get(i).getY()) && x <= carros.get(i).getX() && x + 30 > carros.get(i).getX()){
                camion[0] = 3;
                camion[1] = i;
                return camion;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= carros.get(i).getX() + 100 && x - 30 < carros.get(i).getX() + 100) &&
                    carros.get(i).getY() + 60 > y && carros.get(i).getY() + 60 < y + 30){
                camion[0] = 3;
                camion[1] = i;
                return camion;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= carros.get(i).getX() && x + 30 > carros.get(i).getX() && carros.get(i).getY() + 60 > y && carros.get(i).getY() + 60 < y + 30){
                camion[0] = 3;
                camion[1] = i;
                return camion;
            }
            //SUR-ESTE
            if (direccion == 7 && carros.get(i).getY() >= y && carros.get(i).getY() < y + 30 &&
                    x >= carros.get(i).getX() + 100 && x - 30 < carros.get(i).getX() + 100){
                camion[0] = 3;
                camion[1] = i;
                return camion;
            }
            //SUR-OESTE
            if (direccion == 8 && carros.get(i).getY() >= y && carros.get(i).getY() < y + 30 &&
                   x <= carros.get(i).getX() && x + 30 > carros.get(i).getX()){
                camion[0] = 3;
                camion[1] = i;
                return camion;
            }
        }
        return camion;
    }
    
    public static int[] choqueTorres(int x, int y, ArrayList<ThreadPueblo> torres, int direccion){
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        int[] torre = {0, 0};
        for (int i = 0; i < torres.size(); i ++){
            //NORTE
            if (direccion == 1 && (torres.get(i).getY() + 60 >= y && torres.get(i).getY() + 60 < y + 30) &&
            ((x - 10 < torres.get(i).getX() && x + 30 > torres.get(i).getX()) || (x + 10 > torres.get(i).getX() && x < torres.get(i).getX() + 60))){
                torre[0] = 6;
                torre[1] = i;
                return torre;
            }
            //SUR
            if (direccion == 2 && (torres.get(i).getY() >= y && torres.get(i).getY() < y + 30) && 
            ((x - 10 < torres.get(i).getX() && x + 30 > torres.get(i).getX()) || (x + 10 > torres.get(i).getX() && x < torres.get(i).getX() + 60))){
                torre[0] = 6;
                torre[1] = i;
                return torre;
            }
            //ESTE
            if (direccion == 3 && (y == torres.get(i).getY()) && (x >= torres.get(i).getX() + 60 && x - 30 < torres.get(i).getX() + 60)){
                torre[0] = 6;
                torre[1] = i;
                return torre;
            }
            //OESTE
            if (direccion == 4 && (y == torres.get(i).getY()) && x <= torres.get(i).getX() && x + 30 > torres.get(i).getX()){
                torre[0] = 6;
                torre[1] = i;
                return torre;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= torres.get(i).getX() + 60 && x - 30 < torres.get(i).getX() + 60) &&
                    torres.get(i).getY() + 60 > y && torres.get(i).getY() + 60 < y + 30){
                torre[0] = 6;
                torre[1] = i;
                return torre;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= torres.get(i).getX() && x + 30 > torres.get(i).getX() && torres.get(i).getY() + 60 > y && torres.get(i).getY() + 60 < y + 30){
                torre[0] = 6;
                torre[1] = i;
                return torre;
            }
            //SUR-ESTE
            if (direccion == 7 && torres.get(i).getY() >= y && torres.get(i).getY() < y + 30 &&
                    x >= torres.get(i).getX() + 60 && x - 30 < torres.get(i).getX() + 60){
                torre[0] = 6;
                torre[1] = i;
                return torre;
            }
            //SUR-OESTE
            if (direccion == 8 && torres.get(i).getY() >= y && torres.get(i).getY() < y + 30 &&
                   x <= torres.get(i).getX() && x + 30 > torres.get(i).getX()){
                torre[0] = 6;
                torre[1] = i;
                return torre;
            }
        }
        return torre;
    }
    
    
    public static int[] choqueCañones(int x, int y, ArrayList<ThreadPueblo> cañones, int direccion){
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        int[] cañon = {0, 0};
        for (int i = 0; i < cañones.size(); i ++){
            //NORTE
            if (direccion == 1 && (cañones.get(i).getY() + 30 >= y && cañones.get(i).getY() + 30 < y + 30) &&
            ((x - 10 < cañones.get(i).getX() && x + 30 > cañones.get(i).getX()) || (x + 10 > cañones.get(i).getX() && x < cañones.get(i).getX() + 30))){
                cañon[0] = 7;
                cañon[1] = i;
                return cañon;
            }
            //SUR
            if (direccion == 2 && (cañones.get(i).getY() >= y && cañones.get(i).getY() < y + 30) && 
            ((x - 10 < cañones.get(i).getX() && x + 30 > cañones.get(i).getX()) || (x + 10 > cañones.get(i).getX() && x < cañones.get(i).getX() + 30))){
                cañon[0] = 7;
                cañon[1] = i;
                return cañon;
            }
            //ESTE
            if (direccion == 3 && (y == cañones.get(i).getY()) && (x >= cañones.get(i).getX() + 30 && x - 30 < cañones.get(i).getX() + 30)){
                cañon[0] = 7;
                cañon[1] = i;
                return cañon;
            }
            //OESTE
            if (direccion == 4 && (y == cañones.get(i).getY()) && x <= cañones.get(i).getX() && x + 30 > cañones.get(i).getX()){
                cañon[0] = 7;
                cañon[1] = i;
                return cañon;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= cañones.get(i).getX() + 30 && x - 30 < cañones.get(i).getX() + 30) &&
                    cañones.get(i).getY() + 30 > y && cañones.get(i).getY() + 30 < y + 30){
                cañon[0] = 7;
                cañon[1] = i;
                return cañon;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= cañones.get(i).getX() && x + 30 > cañones.get(i).getX() && cañones.get(i).getY() + 30 > y && cañones.get(i).getY() + 30 < y + 30){
                cañon[0] = 7;
                cañon[1] = i;
                return cañon;
            }
            //SUR-ESTE
            if (direccion == 7 && cañones.get(i).getY() >= y && cañones.get(i).getY() < y + 30 &&
                    x >= cañones.get(i).getX() + 30 && x - 30 < cañones.get(i).getX() + 30){
                cañon[0] = 7;
                cañon[1] = i;
                return cañon;
            }
            //SUR-OESTE
            if (direccion == 8 && cañones.get(i).getY() >= y && cañones.get(i).getY() < y + 30 &&
                   x <= cañones.get(i).getX() && x + 30 > cañones.get(i).getX()){
                cañon[0] = 7;
                cañon[1] = i;
                return cañon;
            }
        }
        return cañon;
    }
    
    
    public static int[] choqueAereos(int x, int y, ArrayList<ThreadPueblo> aereos, int direccion){
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        int[] aereo = {0, 0};
        for (int i = 0; i < aereos.size(); i ++){
            //NORTE
            if (direccion == 1 && (aereos.get(i).getY() + 30 >= y && aereos.get(i).getY() + 30 < y + 30) &&
            ((x - 10 < aereos.get(i).getX() && x + 30 > aereos.get(i).getX()) || (x + 10 > aereos.get(i).getX() && x < aereos.get(i).getX() + 30))){
                aereo[0] = 8;
                aereo[1] = i;
                return aereo;
            }
            //SUR
            if (direccion == 2 && (aereos.get(i).getY() >= y && aereos.get(i).getY() < y + 30) && 
            ((x - 10 < aereos.get(i).getX() && x + 30 > aereos.get(i).getX()) || (x + 10 > aereos.get(i).getX() && x < aereos.get(i).getX() + 30))){
                aereo[0] = 8;
                aereo[1] = i;
                return aereo;
            }
            //ESTE
            if (direccion == 3 && (y == aereos.get(i).getY()) && (x >= aereos.get(i).getX() + 30 && x - 30 < aereos.get(i).getX() + 30)){
                aereo[0] = 8;
                aereo[1] = i;
                return aereo;
            }
            //OESTE
            if (direccion == 4 && (y == aereos.get(i).getY()) && x <= aereos.get(i).getX() && x + 30 > aereos.get(i).getX()){
                aereo[0] = 8;
                aereo[1] = i;
                return aereo;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= aereos.get(i).getX() + 30 && x - 30 < aereos.get(i).getX() + 30) &&
                    aereos.get(i).getY() + 30 > y && aereos.get(i).getY() + 30 < y + 30){
                aereo[0] = 8;
                aereo[1] = i;
                return aereo;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= aereos.get(i).getX() && x + 30 > aereos.get(i).getX() && aereos.get(i).getY() + 30 > y && aereos.get(i).getY() + 30 < y + 30){
                aereo[0] = 8;
                aereo[1] = i;
                return aereo;
            }
            //SUR-ESTE
            if (direccion == 7 && aereos.get(i).getY() >= y && aereos.get(i).getY() < y + 30 &&
                    x >= aereos.get(i).getX() + 30 && x - 30 < aereos.get(i).getX() + 30){
                aereo[0] = 8;
                aereo[1] = i;
                return aereo;
            }
            //SUR-OESTE
            if (direccion == 8 && aereos.get(i).getY() >= y && aereos.get(i).getY() < y + 30 &&
                   x <= aereos.get(i).getX() && x + 30 > aereos.get(i).getX()){
                aereo[0] = 8;
                aereo[1] = i;
                return aereo;
            }
        }
        return aereo;
    }
    
    
    public static int[] choqueMorteros(int x, int y, ArrayList<ThreadPueblo> morteros, int direccion){
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        int[] mortero = {0, 0};
        for (int i = 0; i < morteros.size(); i ++){
            //NORTE
            if (direccion == 1 && (morteros.get(i).getY() + 30 >= y && morteros.get(i).getY() + 30 < y + 30) &&
            ((x - 10 < morteros.get(i).getX() && x + 30 > morteros.get(i).getX()) || (x + 10 > morteros.get(i).getX() && x < morteros.get(i).getX() + 30))){
                mortero[0] = 9;
                mortero[1] = i;
                return mortero;
            }
            //SUR
            if (direccion == 2 && (morteros.get(i).getY() >= y && morteros.get(i).getY() < y + 30) && 
            ((x - 10 < morteros.get(i).getX() && x + 30 > morteros.get(i).getX()) || (x + 10 > morteros.get(i).getX() && x < morteros.get(i).getX() + 30))){
                mortero[0] = 9;
                mortero[1] = i;
                return mortero;
            }
            //ESTE
            if (direccion == 3 && (y == morteros.get(i).getY()) && (x >= morteros.get(i).getX() + 30 && x - 30 < morteros.get(i).getX() + 30)){
                mortero[0] = 9;
                mortero[1] = i;
                return mortero;
            }
            //OESTE
            if (direccion == 4 && (y == morteros.get(i).getY()) && x <= morteros.get(i).getX() && x + 30 > morteros.get(i).getX()){
                mortero[0] = 9;
                mortero[1] = i;
                return mortero;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= morteros.get(i).getX() + 30 && x - 30 < morteros.get(i).getX() + 30) &&
                    morteros.get(i).getY() + 30 > y && morteros.get(i).getY() + 30 < y + 30){
                mortero[0] = 9;
                mortero[1] = i;
                return mortero;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= morteros.get(i).getX() && x + 30 > morteros.get(i).getX() && morteros.get(i).getY() + 30 > y && morteros.get(i).getY() + 30 < y + 30){
                mortero[0] = 9;
                mortero[1] = i;
                return mortero;
            }
            //SUR-ESTE
            if (direccion == 7 && morteros.get(i).getY() >= y && morteros.get(i).getY() < y + 30 &&
                    x >= morteros.get(i).getX() + 30 && x - 30 < morteros.get(i).getX() + 30){
                mortero[0] = 9;
                mortero[1] = i;
                return mortero;
            }
            //SUR-OESTE
            if (direccion == 8 && morteros.get(i).getY() >= y && morteros.get(i).getY() < y + 30 &&
                   x <= morteros.get(i).getX() && x + 30 > morteros.get(i).getX()){
                mortero[0] = 9;
                mortero[1] = i;
                return mortero;
            }
        }
        return mortero;
    }
    
    
    public static int[] choqueEdificio(int x, int y, ThreadEdificio edificio, int direccion){
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        int[] casa = {0, 0};
        if (edificio != null){
            //NORTE
            if (direccion == 1 && (edificio.getY() + 100 >= y && edificio.getY() + 100 < y + 30) &&
            ((x - 10 < edificio.getX() && x + 30 > edificio.getX()) || (x + 10 > edificio.getX() && x < edificio.getX() + 100))){
                casa[0] = 10;
                casa[1] = 0;
                return casa;
            }
            //SUR
            if (direccion == 2 && (edificio.getY() >= y && edificio.getY() < y + 30) && 
            ((x - 10 < edificio.getX() && x + 30 > edificio.getX()) || (x + 10 > edificio.getX() && x < edificio.getX() + 100))){
                casa[0] = 10;
                casa[1] = 0;
                return casa;
            }
            //ESTE
            if (direccion == 3 && (y == edificio.getY()) && (x >= edificio.getX() + 100 && x - 30 < edificio.getX() + 100)){
                casa[0] = 10;
                casa[1] = 0;
                return casa;
            }
            //OESTE
            if (direccion == 4 && (y == edificio.getY()) && x <= edificio.getX() && x + 30 > edificio.getX()){
                casa[0] = 10;
                casa[1] = 0;
                return casa;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= edificio.getX() + 100 && x - 30 < edificio.getX() + 100) &&
                    edificio.getY() + 100 > y && edificio.getY() + 100 < y + 30){
                casa[0] = 10;
                casa[1] = 0;
                return casa;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= edificio.getX() && x + 30 > edificio.getX() && edificio.getY() + 100 > y && 
                    edificio.getY() + 100 < y + 30){
                casa[0] = 10;
                casa[1] = 0;
                return casa;
            }
            //SUR-ESTE
            if (direccion == 7 && edificio.getY() >= y && edificio.getY() < y + 30 &&
                    x >= edificio.getX() + 100 && x - 30 < edificio.getX() + 100){
                casa[0] = 10;
                casa[1] = 0;
                return casa;
            }
            //SUR-OESTE
            if (direccion == 8 && edificio.getY() >= y && edificio.getY() < y + 30 &&
                   x <= edificio.getX() && x + 30 > edificio.getX()){
                casa[0] = 10;
                casa[1] = 0;
                return casa;
            }
        }
        return casa;
    }
    
    
    
    public static int[] choqueMuros(int x, int y, ArrayList<ThreadMuro> muros, int direccion){
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        int[] muro = {0, 0};
        for (int i = 0; i < muros.size(); i ++){
            //NORTE
            if (direccion == 1 && (muros.get(i).getY() + 30 >= y && muros.get(i).getY() + 30 < y + 30) &&
            ((x - 10 < muros.get(i).getX() && x + 30 > muros.get(i).getX()) || (x + 10 > muros.get(i).getX() && x < muros.get(i).getX() + 30))){
                muro[0] = 11;
                muro[1] = i;
                return muro;
            }
            //SUR
            if (direccion == 2 && (muros.get(i).getY() >= y && muros.get(i).getY() < y + 30) && 
            ((x - 10 < muros.get(i).getX() && x + 30 > muros.get(i).getX()) || (x + 10 > muros.get(i).getX() && x < muros.get(i).getX() + 30))){
                muro[0] = 11;
                muro[1] = i;
                return muro;
            }
            //ESTE
            if (direccion == 3 && (y == muros.get(i).getY()) && (x >= muros.get(i).getX() + 30 && x - 30 < muros.get(i).getX() + 30)){
                muro[0] = 11;
                muro[1] = i;
                return muro;
            }
            //OESTE
            if (direccion == 4 && (y == muros.get(i).getY()) && x <= muros.get(i).getX() && x + 30 > muros.get(i).getX()){
                muro[0] = 11;
                muro[1] = i;
                return muro;
            }
            //NOR-ESTE
            if (direccion == 5 && (x >= muros.get(i).getX() + 30 && x - 30 < muros.get(i).getX() + 30) &&
                    muros.get(i).getY() + 30 > y && muros.get(i).getY() + 30 < y + 30){
                muro[0] = 11;
                muro[1] = i;
                return muro;
            }
            //NOR-OESTE
            if (direccion == 6 && x <= muros.get(i).getX() && x + 30 > muros.get(i).getX() && muros.get(i).getY() + 30 > y && muros.get(i).getY() + 30 < y + 30){
                muro[0] = 11;
                muro[1] = i;
                return muro;
            }
            //SUR-ESTE
            if (direccion == 7 && muros.get(i).getY() >= y && muros.get(i).getY() < y + 30 &&
                    x >= muros.get(i).getX() + 30 && x - 30 < muros.get(i).getX() + 30){
                muro[0] = 11;
                muro[1] = i;
                return muro;
            }
            //SUR-OESTE
            if (direccion == 8 && muros.get(i).getY() >= y && muros.get(i).getY() < y + 30 &&
                   x <= muros.get(i).getX() && x + 30 > muros.get(i).getX()){
                muro[0] = 11;
                muro[1] = i;
                return muro;
            }
        }
        return muro;
    }
}
