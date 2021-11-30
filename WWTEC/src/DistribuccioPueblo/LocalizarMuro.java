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
public class LocalizarMuro {
    
    
    public ArrayList<Integer> GetDistribuccion(int nivel){
        if (nivel == 1){
            return distribuccionNivel1();
        }else if (nivel == 2){
            return distribuccionNivel2();
        }else if (nivel == 3){
            return distribuccionNivel3();
        }else if (nivel == 4){
            return distribuccionNivel4();
        }else if (nivel == 5){
            return distribuccionNivel5();
        }else if (nivel == 6){
            return distribuccionNivel6();
        }else if (nivel == 7){
            return distribuccionNivel7();
        }else if (nivel == 8){
            return distribuccionNivel8();
        }else if (nivel == 9){
            return distribuccionNivel9();
        }else if (nivel >= 10){
            return distribuccionNivel10();
        }
        return distribuccionNivel1();
    }
  
    private ArrayList<Integer> distribuccionNivel10 (){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 76; i++){
                if (i >= 63 && i <= 68){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 76; i++){
                if (i == 10 || i == 22 || i == 34 || i == 46 || i == 62 || i == 74){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 76; i++){
                if (i == 9 || i == 10 || i == 47 || i == 48 || i == 66 || i == 67){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 76; i++){
                if (i == 0 || i == 1 || i == 75 || i == 37 || i == 38 || i == 39){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }
        return distribuccion;
    }
    
    private ArrayList<Integer> distribuccionNivel9 (){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 76; i++){
                if (i == 5 || i == 10 || i == 17 || i == 28 || i == 29 || i == 41 || i == 47 || i == 52 || i == 64 || i == 65 || i == 70){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 76; i++){
                if (i == 7 || i == 8 || i == 11 || i == 27 || i == 30 || i == 45 || i == 47 || i == 48 || i == 64 || i == 65 || i == 67){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 76; i++){
                if (i == 14 || i == 15 || i == 22 || i == 30 || i == 31 || i == 46 || i == 47 || i == 62 || i == 63 || i == 70 || i == 75){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 76; i++){
                if (i == 1 || i == 12 || i == 14 || i == 25 || i == 26 || i == 38 || i == 40 || i == 51 || i == 52 || i == 64 || i == 65){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }
        return distribuccion;
    }
    
    private ArrayList<Integer> distribuccionNivel8 (){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 76; i++){
                if (i == 1 || i == 2 || i == 9 || i == 10 || i == 17 || i == 18 || i == 28 || i == 29 || i == 39 || i == 40 || i == 47){
                    distribuccion.add(0);
                }else if (i == 48 || i == 55 || i == 56 || i == 66 || i == 67){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 76; i++){
                if (i == 0 || i == 1 || i == 9 || i == 10 || (i >= 18 && i <= 20) || (i >= 37 && i <= 39) || i == 47 || i == 48 || (i >= 56 && i <= 58) || i == 75){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 76; i++){
                if ((i >= 8 && i <= 11) || (i >= 26 && i <= 31) || (i >= 46 && i <= 49) || i == 66 || i == 67){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 76; i++){
                if ((i >= 6 && i <= 13) || (i >= 44 && i <= 51)){
                    distribuccion.add(0);
                }else{
                    distribuccion.add(1);
                }
            }
        }
        return distribuccion;
    }
    
    private ArrayList<Integer> distribuccionNivel7 (){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 76; i++){
                if ((i >= 0 && i <= 5) || (i >= 16 && i <= 41) || (i >= 53 && i <= 75)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 76; i++){
                if ((i >= 0 && i <= 22) || (i >= 35 && i <= 61) || (i >= 71 && i <= 75)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 76; i++){
                if ((i>= 0 && i <= 7) || (i >= 14 && i <= 26) || (i >= 31 && i <= 43) || (i >= 51 && i <= 64) || (i >= 69 && i <= 75)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 76; i++){
                if ((i >= 0 && i <= 24) || (i >= 33 && i <= 42) || (i >= 48 && i <= 62) || (i >= 71 && i <= 75)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }
        return distribuccion;
    }
    
    private ArrayList<Integer> distribuccionNivel6 (){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 76; i++){
                if ((i >= 0 && i <= 6) || i == 9 || i == 10 || (i >= 16 && i <= 24) || i == 28 || i == 29 || i == 48 || (i >= 32 && i <= 44) || (i >= 52 && i <= 64) || (i >= 67 && i <= 69)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 76; i++){
                if ((i >= 0 && i <= 3) || i == 6 || (i >= 9 && i <= 13) || (i >= 15 && i <= 20) || i == 23 || i == 26 || i == 28 || i == 29){
                    distribuccion.add(1);
                }else if (i == 31 || (i >= 33 && i <= 36) || (i >= 38 && i <= 43) || i == 46 || i == 48 || i == 49 || (i >= 52 && i <= 57)){
                    distribuccion.add(1);
                }else if ((i >= 59 && i <= 63) || i == 66 || i == 73 || (i >= 68 && i <= 70)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 76; i++){
                if (i == 0 || (i >= 2 && i <= 4) || i == 6 || (i >= 8 && i <= 10) || i == 12 || i == 14 || i == 16 || (i >= 18 && i <= 20)){
                    distribuccion.add(1);
                }else if ((i >= 22 && i <= 24) || i == 26 || (i >= 28 && i <= 30) || (i >= 32 && i <= 34) || i == 36 || (i >= 38 && i <= 40)){
                    distribuccion.add(1);
                }else if ((i >= 42 && i <= 44) || i == 46 || (i >= 48 && i <= 50) || (i >= 52 && i <= 54) || i == 56 || (i >= 62 && i <= 64)){
                    distribuccion.add(1);
                }else if (i == 66 || i == 68 || i == 70 || i == 72 || i == 74 || (i >= 58 && i <= 60)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 76; i++){
                if ((i >= 1 && i <= 3) || (i <= 6 && i <= 9) || (i >= 12 && i <= 15) || (i >= 18 && i <= 20) || (i >= 22 && i <= 24)){
                    distribuccion.add(1);
                }else if ((i >= 27 && i <= 30) || (i >= 33 && i <= 36) || (i >= 39 && i <= 43) || (i >= 46 && i <= 49) || (i >= 52 && i <= 60) || (i >= 63 && i <= 69)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }
        return distribuccion;
    }
    
    private ArrayList<Integer> distribuccionNivel5 (){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 4) || (i >= 10 && i <= 32) || (i >= 39 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 56; i++){
                if((i >= 0 && i <= 5) || (i >= 11 && i <= 32) || (i >= 37 && i <= 47) || (i >= 50 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 16) || (i >= 26 && i <= 47) || (i >= 50 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 5) || (i >= 9 && i <= 19) || (i >= 23 && i <= 33) || (i >= 37 && i <= 47) || (i >= 50 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }
        return distribuccion;
    }
    
    private ArrayList<Integer> distribuccionNivel4 (){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 4) || (i >= 9 && i <= 18) || (i >= 23 && i <= 34) || (i >= 38 && i <= 46) || (i >= 52 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 4) || i == 8 || i == 9 || (i >= 12 && i <= 18) || (i >= 21 && i <= 23) || (i >= 26 && i <= 33)){
                    distribuccion.add(1);
                }else if (i == 36 || (i >= 38 && i <= 46) || i == 48 || i == 49 || i == 52 || i == 54 || i == 55){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 4) || i == 9 || i == 38 || (i >= 15 && i <= 34) || (i >= 43 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 56; i++){
                if (i == 2 || i == 3 || i == 18 || i == 48 || i == 30 || i == 31 || (i >= 5 && i <= 14) || (i >= 20 && i <= 26) || (i >= 33 && i <= 44) || (i >= 50 && i <= 54)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }
        return distribuccion;
    }
    
    private ArrayList<Integer> distribuccionNivel3 (){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 4) || (i >= 13 && i <= 19) || (i >= 23 && i <= 30) || (i >= 38 && i <= 47) || (i >= 51 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 3) || (i >= 14 && i <= 28) || (i >= 40 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 4) || (i >= 14 && i <= 28) || (i >= 38 && i <= 47) || (i >= 51 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 20) || (i >= 42 && i <= 55)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }
        return distribuccion;
    }
    
    private ArrayList<Integer> distribuccionNivel2(){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 56; i++){
                if (i == 1 || i == 3 || i == 4 || i == 6 || i == 8 || i == 10 || (i >= 12 && i <= 15) || i == 17 || i == 20){
                    distribuccion.add(1);
                }else if (i == 23 || i == 25 || (i >= 27 && i <= 29) || i == 31 || i == 33 || i == 36 || i == 38 || i == 39 || i == 41){
                    distribuccion.add(1);
                }else if (i == 43 || i == 45 || i == 48 || i == 50 || i == 52 || i == 53 || i == 55){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 56; i++){
                if ((i >= 1 && i <= 3) || i == 6 || i == 8 || (i >= 11 && i <= 14) || i == 16 || i == 18 || i == 20 || i == 22){
                    distribuccion.add(1);
                }else if(i == 24 || i == 26 || (i >= 29 && i <= 31) || i == 33 || i == 36 || i == 39 || i == 40){
                    distribuccion.add(1);
                }else if ((i >= 43 && i <= 45) || i == 48 || i == 50 || (i >= 52 && i <= 54)){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 4) || (i >= 7 && i <= 10) || (i >= 13 && i <= 15) || i == 18 || i == 23 || i == 26 || i == 28 || i == 29){
                    distribuccion.add(1);
                }else if ((i >= 32 && i <= 34) || i == 36 || (i >= 38 && i <= 40) || i == 42 || i == 43 || i == 45 || i == 48 || i == 52 || i == 54){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 56; i++){
                if ((i >= 0 && i <= 4) || i == 10 || (i >= 12 && i <= 17) || i == 22 || (i >= 26 && i <= 32) || i == 36 || i == 39){
                    distribuccion.add(1);
                }else if ((i >= 42 && i <= 48) || i == 52){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }
        return distribuccion;
    }
    
    private ArrayList<Integer> distribuccionNivel1(){
        ArrayList<Integer> distribuccion = new ArrayList<Integer>();
        Random r = new Random();
        int indice = r.nextInt(4);
        if (indice == 0){
            for (int i = 0; i < 56; i++){
                if (i == 0 || i == 2 || i == 6 || i == 10 || i == 13 || i ==  14 || i == 18 || i == 22 || i == 25){
                    distribuccion.add(1);
                }else if (i == 27 || i == 28 || i == 30 || i == 33 || i == 36 || i == 39 || (i >= 41 && i <= 43) || i == 45){
                    distribuccion.add(1);
                }else if (i == 46 || (i >= 48 && i <= 50) || i == 52 || i == 54){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 1){
            for (int i = 0; i < 56; i++){
                if (i == 3 || i == 4 || i == 6 || i == 8 || i == 9 || i == 12 || i == 14 || i == 16 || (i >= 20 && i <= 22)){
                    distribuccion.add(1);
                }else if (i == 26 || i == 29 || i == 30 || i == 33 || i == 34 || i == 36 || i == 38 || i == 39 || i == 41){
                    distribuccion.add(1);
                }else if (i == 43 || i == 46 || i == 48 || i == 50 || i == 53){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 2){
            for (int i = 0; i < 56; i++){
                if (i == 1 || i == 4 || i == 6 || i == 8 || i == 10 || i == 13 || i == 15 || i == 18 || i == 20 || i == 20 || i == 22){
                    distribuccion.add(1);
                }else if (i == 24 || (i >= 27 && i <= 29) || i == 32 || i == 34 || i == 36 || i == 38 || i == 41 || i == 43 || i == 46){
                    distribuccion.add(1);
                }else if (i == 48 || i == 50 || i == 52 || i == 55){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }else if(indice == 3){
            for (int i = 0; i < 56; i++){
                if (i == 0 || i == 1 || i == 3 || i == 6 || i == 8 || i == 11 || (i>= 13 && i <= 15) || i == 17 || i == 25 || (i >= 27 && i <= 29)){
                    distribuccion.add(1);
                }else if (i == 31 || i == 34 || i == 36 || i == 39 || (i >= 41 && i <= 43) || i == 45 || i == 48 || i == 53 || i == 55){
                    distribuccion.add(1);
                }else{
                    distribuccion.add(0);
                }
            }
        }
        return distribuccion;
    }
}
