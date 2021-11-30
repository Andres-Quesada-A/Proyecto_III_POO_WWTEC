/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Threads.ThreadAviones;
import Threads.ThreadCamion;
import Threads.ThreadMedioAlcance;
import Threads.ThreadSoldado;
import Threads.ThreadTanque;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class VerificarAtaque {
    
    private static int ANCHO = 1098;
    private static int LARGO = 698;
    
    public static int VerificarPosibleAtaque(int x, int y, int TipoDefensa,ArrayList<ThreadAviones> aviones,ArrayList<ThreadSoldado> contacto,ArrayList<ThreadMedioAlcance> medianoAlcance,ArrayList<ThreadTanque> tanques,ArrayList<ThreadCamion> carros){
       //Tipo Defensa[1 = bomba, 2 = torres, 3 = cañones, 4 = aereos, 5 = morteros
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //ESTE
        int AuxX = x;
        int AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 3;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 3;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 3;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 3;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 3;
                }
            }
            AuxX--;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //OESTE
        AuxX = x;
        AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 4;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 4;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 4;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 4;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 4;
                }
            }
            AuxX++;
        }
       
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //NORTE
        AuxX = x;
        AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 1;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 1;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 1;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 1;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 1;
                }
            }
            AuxY--;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //SUR
        AuxX = x;
        AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 2;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 2;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 2;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 2;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 2;
                }
            }
            AuxY++;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //ESTE
        AuxX = x;
        AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 3;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 3;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 3;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 3;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 3;
                }
            }
            AuxX--;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //OESTE
        AuxX = x;
        AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 4;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 4;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 4;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 4;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 4;
                }
            }
            AuxX++;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //NOR-ESTE
        AuxX = x;
        AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 5;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 5;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 5;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 5;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 5;
                }
            }
            AuxY--;
            AuxX--;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //NOR-OESTE
        AuxX = x;
        AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 6;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 6;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 6;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 6;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 6;
                }
            }
            AuxY--;
            AuxX++;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //Sur-ESTE
        AuxX = x;
        AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 7;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 7;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 7;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 7;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 7;
                }
            }
            AuxY++;
            AuxX--;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //Sur-OESTE
        AuxX = x;
        AuxY = y;
        while (AuxX < ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY < LARGO){
            if (TipoDefensa == 4){
                for (ThreadAviones avion : aviones) {
                    if (AuxX >= avion.getX() && AuxX < (avion.getX() + 60) && AuxY >= avion.getY() && AuxY < (avion.getY() + 60))
                        return 8;
                }
            }else{
                for (ThreadSoldado contact: contacto){
                    if (AuxX >= contact.getX() && AuxX < (contact.getX() + 30) && AuxY >= contact.getY() && AuxY < (contact.getY() + 30))
                        return 8;
                }
                for (ThreadMedioAlcance MidAlcance: medianoAlcance){
                    if (AuxX >= MidAlcance.getX() && AuxX < (MidAlcance.getX() + 30) && AuxY >= MidAlcance.getY() && AuxY < (MidAlcance.getY() + 30))
                        return 8;
                }
                for (ThreadTanque tanque: tanques){
                    if (AuxX >= tanque.getX() && AuxX < (tanque.getX() + 90) && AuxY >= tanque.getY() && AuxY < (tanque.getY() + 60))
                        return 8;
                }
                for (ThreadCamion carro: carros){
                    if (AuxX >= carro.getX() && AuxX < (carro.getX() + 100) && AuxY >= carro.getY() && AuxY < (carro.getY() + 60))
                        return 8;
                }
            }
            AuxY++;
            AuxX++;
        }
        return 0;
    }
}
