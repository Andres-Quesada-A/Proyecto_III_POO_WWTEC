/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Threads.ThreadEdificio;
import Threads.ThreadMuro;
import Threads.ThreadPueblo;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class VerificarEnemigoEnMira {
    private static int ANCHO = 1098;
    private static int LARGO = 698;
    
    //direccion 1 >>>  2 <<<<

    public static int VerificarEnemigoMira(int x, int y, int direccion, ArrayList<ThreadPueblo> torres, ArrayList<ThreadPueblo> cañones,
    ArrayList<ThreadPueblo> aereos, ArrayList<ThreadPueblo> morteros, ThreadEdificio casa, ArrayList<ThreadMuro> muros){
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //ESTE
        int AuxX = x;
        int AuxY = y;
        while (AuxX <= ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY <= LARGO){
            for (ThreadPueblo torre : torres){
                if (torre.getY() <= AuxY && torre.getY() + 60 > AuxY && torre.getX() == AuxX && direccion == 2){
                    return 3;
                }
            }
            for (ThreadPueblo cañon : cañones){
                if (cañon.getY() == AuxY && cañon.getY() + 30 > AuxY && cañon.getX() == AuxX && direccion == 2){
                    return 3;
                }
            }
            for (ThreadPueblo aereo : aereos){
                if (aereo.getY() == AuxY && aereo.getY() + 30 > AuxY && aereo.getX() == AuxX && direccion == 2){
                    return 3;
                }
            }
            for (ThreadPueblo mortero : morteros){
                if (mortero.getY() == AuxY && mortero.getY() + 30 > AuxY && mortero.getX() == AuxX && direccion == 2){
                    return 3;
                }
            }
            if (casa != null){
                if (casa.getY() <= AuxY && casa.getY() + 100 < AuxY && AuxX == casa.getY() && direccion == 2)
                    return 3;
            }
            for (ThreadMuro muro : muros){
                if (muro.getY() == AuxY && muro.getY() + 30 > AuxY && muro.getX() == AuxX && direccion == 2){
                    return 3;
                }
            }
            AuxX--;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //OESTE
        AuxX = x;
        AuxY = y;
        while (AuxX <= ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY <= LARGO){
            for (ThreadPueblo torre : torres){
                if (torre.getY() <= AuxY && torre.getY() + 60 > AuxY && torre.getX() == AuxX && direccion == 1){
                    return 4;
                }
            }
            for (ThreadPueblo cañon : cañones){
                if (cañon.getY() == AuxY && cañon.getY() + 30 > AuxY && cañon.getX() == AuxX && direccion == 1){
                    return 4;
                }
            }
            for (ThreadPueblo aereo : aereos){
                if (aereo.getY() == AuxY && aereo.getY() + 30 > AuxY && aereo.getX() == AuxX && direccion == 1){
                    return 4;
                }
            }
            for (ThreadPueblo mortero : morteros){
                if (mortero.getY() == AuxY && mortero.getY() + 30 > AuxY && mortero.getX() == AuxX && direccion == 1){
                    return 4;
                }
            }
            if (casa != null){
                if (casa.getY() <= AuxY && casa.getY() + 100 < AuxY && AuxX == casa.getY() && direccion == 1)
                    return 4;
            }
            for (ThreadMuro muro : muros){
                if (muro.getY() == AuxY && muro.getY() + 30 > AuxY && muro.getX() == AuxX && direccion == 1){
                    return 4;
                }
            }
            AuxX++;
        }
        
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //NORTE
        AuxX = x;
        AuxY = y;
        while (AuxX <= ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY <= LARGO){
            for (ThreadPueblo torre : torres){
                if (torre.getY() == AuxY && ((torre.getX() <= AuxX && torre.getX() > AuxX && direccion == 1) ||
                        (torre.getX() + 60 <= AuxX && torre.getX() + 60 > AuxX-30 && direccion == 2)) ){
                    return 1;
                }
            }
            for (ThreadPueblo cañon : cañones){
                if (cañon.getY() == AuxY && ((cañon.getX() <= AuxX && cañon.getX() > AuxX && direccion == 1) ||
                        (cañon.getX() + 30 <= AuxX && cañon.getX() + 30 > AuxX-30 && direccion == 2))){
                    return 1;
                }
            }
            for (ThreadPueblo aereo : aereos){
                if (aereo.getY() == AuxY && ((aereo.getX() <= AuxX && aereo.getX() > AuxX && direccion == 1) ||
                        (aereo.getX() + 30 <= AuxX && aereo.getX() + 30 > AuxX-30 && direccion == 2))){
                    return 1;
                }
            }
            for (ThreadPueblo mortero : morteros){
                if (mortero.getY() == AuxY && ((mortero.getX() <= AuxX && mortero.getX() > AuxX && direccion == 1) ||
                        (mortero.getX() + 30 <= AuxX && mortero.getX() + 30 > AuxX-30 && direccion == 2))){
                    return 1;
                }
            }
            if (casa != null){
                if (casa.getY() == AuxY && ((casa.getX() <= AuxX && casa.getX() > AuxX && direccion == 1) ||
                            (casa.getX() + 100 <= AuxX && casa.getX() + 100 > AuxX-30 && direccion == 2)) )
                    return 4;
            }
            for (ThreadMuro muro : muros){
                if (muro.getY() == AuxY && ((muro.getX() <= AuxX && muro.getX() > AuxX && direccion == 1) ||
                        (muro.getX() + 30 <= AuxX && muro.getX() + 30 > AuxX-30 && direccion == 2))){
                    return 1;
                }
            }
            AuxY--;
        }
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //SUR
        AuxX = x;
        AuxY = y;
        while (AuxX <= ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY <= LARGO){
            for (ThreadPueblo torre : torres){
                if (torre.getY() == AuxY && ((torre.getX() <= AuxX && torre.getX() > AuxX && direccion == 1) ||
                        (torre.getX() + 60 <= AuxX && torre.getX() + 60 > AuxX-30 && direccion == 2)) ){
                    return 2;
                }
            }
            for (ThreadPueblo cañon : cañones){
                if (cañon.getY() == AuxY && ((cañon.getX() <= AuxX && cañon.getX() > AuxX && direccion == 1) ||
                        (cañon.getX() + 30 <= AuxX && cañon.getX() + 30 > AuxX-30 && direccion == 2))){
                    return 2;
                }
            }
            for (ThreadPueblo aereo : aereos){
                if (aereo.getY() == AuxY && ((aereo.getX() <= AuxX && aereo.getX() > AuxX && direccion == 1) ||
                        (aereo.getX() + 30 <= AuxX && aereo.getX() + 30 > AuxX-30 && direccion == 2))){
                    return 2;
                }
            }
            for (ThreadPueblo mortero : morteros){
                if (mortero.getY() == AuxY && ((mortero.getX() <= AuxX && mortero.getX() > AuxX && direccion == 1) ||
                        (mortero.getX() + 30 <= AuxX && mortero.getX() + 30 > AuxX-30 && direccion == 2))){
                    return 2;
                }
            }
            if (casa != null){
                if (casa.getY() == AuxY && ((casa.getX() <= AuxX && casa.getX() > AuxX && direccion == 1) ||
                            (casa.getX() + 100 <= AuxX && casa.getX() + 100 > AuxX-30 && direccion == 2)) )
                    return 4;
            }
            for (ThreadMuro muro : muros){
                if (muro.getY() == AuxY && ((muro.getX() <= AuxX && muro.getX() > AuxX && direccion == 1) ||
                        (muro.getX() + 30 <= AuxX && muro.getX() + 30 > AuxX-30 && direccion == 2))){
                    return 2;
                }
            }
            AuxY++;
        }
        
        
        
        //1 = norte, 2 = sur, 3 = este, 4 = oeste, 5 = nor-este, 6= nor-oeste, 7 = sur-este, 8 = sur-oeste
        //NOR-ESTE
        AuxX = x;
        AuxY = y;
        while (AuxX <= ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY <= LARGO){
            for (ThreadPueblo torre : torres){
                if (torre.getX() >= AuxX + 60 && torre.getX() - 3 < AuxX + 60 && torre.getY() >= AuxY && torre.getY() < AuxY + 60 && direccion == 2){
                    return 5;
                }
            }
            for (ThreadPueblo cañon : cañones){
                if (cañon.getX() >= AuxX + 30 && cañon.getX() - 3 < AuxX + 30 && cañon.getY() >= AuxY && cañon.getY() < AuxY + 30 && direccion == 2){
                    return 5;
                }
            }
            for (ThreadPueblo aereo : aereos){
                if (aereo.getX() >= AuxX + 30 && aereo.getX() - 3 < AuxX + 30 && aereo.getY() >= AuxY && aereo.getY() < AuxY + 30 && direccion == 2){
                    return 5;
                }
            }
            for (ThreadPueblo mortero : morteros){
                if (mortero.getX() >= AuxX + 30 && mortero.getX() - 3 < AuxX + 30 && mortero.getY() >= AuxY && mortero.getY() < AuxY + 30 && direccion == 2){
                    return 5;
                }
            }
            if (casa != null){
                if (casa.getX() >= AuxX + 100 && casa.getX() - 3 < AuxX + 100 && casa.getY() >= AuxY && casa.getY() < AuxY + 100 && direccion == 2)
                    return 5;
            }
            for (ThreadMuro muro : muros){
                if (muro.getX() >= AuxX + 30 && muro.getX() - 3 < AuxX + 30 && muro.getY() >= AuxY && muro.getY() < AuxY + 30 && direccion == 2){
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
        while (AuxX <= ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY <= LARGO){
            for (ThreadPueblo torre : torres){
                if (torre.getX() <= AuxX && torre.getX() + 30 > AuxX && torre.getY() >= AuxY && torre.getY() < AuxY + 60 && direccion == 1){
                    return 6;
                }
            }
            for (ThreadPueblo cañon : cañones){
                if (cañon.getX() <= AuxX && cañon.getX() + 30 > AuxX && cañon.getY() >= AuxY && cañon.getY() < AuxY + 30 && direccion == 1){
                    return 6;
                }
            }
            for (ThreadPueblo aereo : aereos){
                if (aereo.getX() <= AuxX && aereo.getX() + 30 > AuxX && aereo.getY() >= AuxY && aereo.getY() < AuxY + 30 && direccion == 1){
                    return 6;
                }
            }
            for (ThreadPueblo mortero : morteros){
                if (mortero.getX() <= AuxX && mortero.getX() + 30 > AuxX && mortero.getY() >= AuxY && mortero.getY() < AuxY + 30 && direccion == 1){
                    return 6;
                }
            }
            if (casa != null){
                if (casa.getX() <= AuxX && casa.getX() + 30 > AuxX && casa.getY() >= AuxY && casa.getY() < AuxY + 100 && direccion == 1)
                    return 6;
            }
            for (ThreadMuro muro : muros){
                if (muro.getX() <= AuxX && muro.getX() + 30 > AuxX && muro.getY() >= AuxY && muro.getY() < AuxY + 30 && direccion == 1){
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
        while (AuxX <= ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY <= LARGO){
            for (ThreadPueblo torre : torres){
                if (torre.getX() >= AuxX + 60 && torre.getX() - 30 < AuxX + 60 && torre.getY() > AuxY && torre.getY() < AuxY + 60 && direccion == 2){
                    return 7;
                }
            }
            for (ThreadPueblo cañon : cañones){
                if (cañon.getX() >= AuxX + 30 && cañon.getX() - 30 < AuxX + 30 && cañon.getY() > AuxY && cañon.getY() < AuxY + 30 && direccion == 2){
                    return 7;
                }
            }
            for (ThreadPueblo aereo : aereos){
                if (aereo.getX() >= AuxX + 30 && aereo.getX() - 30 < AuxX + 30 && aereo.getY() > AuxY && aereo.getY() < AuxY + 30 && direccion == 2){
                    return 7;
                }
            }
            for (ThreadPueblo mortero : morteros){
                if (mortero.getX() >= AuxX + 30 && mortero.getX() - 30 < AuxX + 30 && mortero.getY() > AuxY && mortero.getY() < AuxY + 30 && direccion == 2){
                    return 7;
                }
            }
            if (casa != null){
                if (casa.getX() >= AuxX + 100 && casa.getX() - 30 < AuxX + 100 && casa.getY() > AuxY && casa.getY() < AuxY + 100 && direccion == 2)
                    return 7;
            }
            for (ThreadMuro muro : muros){
                if (muro.getX() >= AuxX + 30 && muro.getX() - 30 < AuxX + 30 && muro.getY() > AuxY && muro.getY() < AuxY + 30 && direccion == 2){
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
        while (AuxX <= ANCHO && AuxX >= 0 && AuxY >= 0 && AuxY <= LARGO){
            for (ThreadPueblo torre : torres){
                if (torre.getX() <= AuxX && torre.getX() + 30 > AuxX && torre.getY() >= AuxY && torre.getY() < AuxY + 60 && direccion == 1){
                    return 8;
                }
            }
            for (ThreadPueblo cañon : cañones){
                if (cañon.getX() <= AuxX && cañon.getX() + 30 > AuxX && cañon.getY() >= AuxY && cañon.getY() < AuxY + 30 && direccion == 1){
                    return 8;
                }
            }
            for (ThreadPueblo aereo : aereos){
                if (aereo.getX() <= AuxX && aereo.getX() + 30 > AuxX && aereo.getY() >= AuxY && aereo.getY() < AuxY + 30 && direccion == 1){
                    return 8;
                }
            }
            for (ThreadPueblo mortero : morteros){
                if (mortero.getX() <= AuxX && mortero.getX() + 30 > AuxX && mortero.getY() >= AuxY && mortero.getY() < AuxY + 30 && direccion == 1){
                    return 8;
                }
            }
            if (casa != null){
                if (casa.getX() <= AuxX && casa.getX() + 30 > AuxX && casa.getY() >= AuxY && casa.getY() < AuxY + 100 && direccion == 1)
                    return 8;
            }
            for (ThreadMuro muro : muros){
                if (muro.getX() <= AuxX && muro.getX() + 30 > AuxX && muro.getY() >= AuxY && muro.getY() < AuxY + 30 && direccion == 1){
                    return 8;
                }
            }
            AuxY++;
            AuxX++;
        }
        return 0;
    }
}
