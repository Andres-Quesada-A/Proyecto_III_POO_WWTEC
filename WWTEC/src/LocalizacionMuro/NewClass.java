/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocalizacionMuro;

/**
 *
 * @author andre
 */
public class NewClass {
    public static void main(String[] args) {
        LocalizarMuro muros = new LocalizarMuro();
        int[] muro = new int[56];
        int[] Muro = new int [76];
        int cont = 0;
        muro = muros.GetDistribuccion(1);
        System.out.println("Indice 1");
        for (int i = 0; i < muro.length; i++){
            if (muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
        System.out.println("");
        muro = muros.GetDistribuccion(2);
        System.out.println("Indice 2");
        for (int i = 0; i < muro.length; i++){
            if (muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
        
        System.out.println("");
        muro = muros.GetDistribuccion(3);
        System.out.println("Indice 3");
        for (int i = 0; i < muro.length; i++){
            if (muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
        System.out.println("");
        muro = muros.GetDistribuccion(4);
        System.out.println("Indice 4");
        for (int i = 0; i < muro.length; i++){
            if (muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
        System.out.println("");
        muro = muros.GetDistribuccion(5);
        System.out.println("Indice 5");
        for (int i = 0; i < muro.length; i++){
            if (muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
        System.out.println("");
        Muro = muros.GetDistribuccion(6);
        System.out.println("Indice 6");
        for (int i = 0; i < Muro.length; i++){
            if (Muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + Muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
        System.out.println("");
        Muro = muros.GetDistribuccion(7);
        System.out.println("Indice 7");
        for (int i = 0; i < Muro.length; i++){
            if (Muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + Muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
        System.out.println("");
        Muro = muros.GetDistribuccion(8);
        System.out.println("Indice 8");
        for (int i = 0; i < Muro.length; i++){
            if (Muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + Muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
        System.out.println("");
        Muro = muros.GetDistribuccion(9);
        System.out.println("Indice 9");
        for (int i = 0; i < Muro.length; i++){
            if (Muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + Muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
        
        System.out.println("");
        Muro = muros.GetDistribuccion(10);
        System.out.println("Indice 10");
        for (int i = 0; i < Muro.length; i++){
            if (Muro[i] == 1){
                cont++;
            }
            //System.out.println( "Indice " + i + ": " + Muro[i]);
        }
        System.out.println("Contador: " + cont);
        cont = 0;
        
    }
}
