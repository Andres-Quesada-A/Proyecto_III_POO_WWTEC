/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracionPueblo;

import Defensa.AereosD;
import Defensa.Bombas;
import Defensa.Cañon;
import Defensa.Defensa;
import Defensa.Edificio;
import Defensa.Mortero;
import Defensa.Muro;
import Defensa.Pueblo;
import Defensa.Torre;
import FilesManagers.Serealizar_Deserializar_Objeto;

/**
 *
 * @author andre
 */
public class ModeloPuebloConfiguracion {
    private Pueblo pueblo = new Pueblo();

    public ModeloPuebloConfiguracion() {
        CargarObjetoSerealizado();
    }
    
    private void CargarObjetoSerealizado(){
        Pueblo recuperado = Serealizar_Deserializar_Objeto.deserializarObjeto("Pueblo.Dat", Pueblo.class);
        if (recuperado == null){
            System.out.println("Los recursos recuperados son nulos");
        }else{
            System.out.println("Si existen recursos");
            pueblo = recuperado;
        }
    }
    
    public int getTamañoPueblo(){
        return this.pueblo.getLegthArray();
    }
    
    public Defensa getObjetoPueblo(int index){
        return this.pueblo.GetUsuario(index);
    }
    
    public void EliminarObjeto(int index){
        this.pueblo.EliminarSoldado(index);
    }
    
    public void ActualizarDatos(int index, int vida, int disparos){
        this.pueblo.ActualizarDatos(index, vida, disparos);
    }
    
    public int ObtenerBienes(){
        return this.pueblo.getBienes();
    }
    
    public void EstablecerBienes(int bienes){
        this.pueblo.setBienes(bienes);
    }
    
    public void CrearNuevoObjeto(String tipo, int vida, int disparos){
        if (tipo.equalsIgnoreCase("Aereos")){
            AereosD nuevo = new AereosD(1, vida, tipo, disparos, 1);
            this.pueblo.insertarMiembro((Defensa)nuevo);
        }else if (tipo.equalsIgnoreCase("Bombas")){
            Bombas nuevo = new Bombas(1, vida, tipo, disparos, 1);
            this.pueblo.insertarMiembro((Defensa)nuevo);
        }else if (tipo.equalsIgnoreCase("Cañon")){
            Cañon nuevo = new Cañon(1, vida, tipo, disparos, 1);
            this.pueblo.insertarMiembro((Defensa)nuevo);
        }else if (tipo.equalsIgnoreCase("Edificio")){
            Edificio nuevo = new Edificio(1, vida, tipo, disparos, 1);
            this.pueblo.insertarMiembro((Defensa)nuevo);
        }else if (tipo.equalsIgnoreCase("Mortero")){
            Mortero nuevo = new Mortero(1, vida, tipo, disparos, 1);
            this.pueblo.insertarMiembro((Defensa)nuevo);
        }else if (tipo.equalsIgnoreCase("Muro")){
            Muro nuevo = new Muro(1, vida, tipo, disparos, 1);
            this.pueblo.insertarMiembro((Defensa)nuevo);
        }else if (tipo.equalsIgnoreCase("Torre")){
            Torre nuevo = new Torre(1, vida, tipo, disparos, 1);
            this.pueblo.insertarMiembro((Defensa)nuevo);
        }
    }
    
    public void GuardarEnSerializable(){
        Serealizar_Deserializar_Objeto.serializarObjeto("Pueblo.Dat", pueblo);
    }
}
