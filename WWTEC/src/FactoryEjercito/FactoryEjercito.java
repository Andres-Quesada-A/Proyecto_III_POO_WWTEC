
package FactoryEjercito;

import Ejercito.Aereos;
import Ejercito.AlcanceMedio;
import Ejercito.Choque;
import Ejercito.Ejercito;
import Ejercito.Impacto;
import Ejercito.SoldadoContacto;

public class FactoryEjercito {
    public enum Soldados{
        SOLDADOCONTACTO,
        ALCANCEMEDIO,
        AEREOS,
        IMPACTO,
        CHOQUE
    }
    
    /*El arreglo de enteros se distribuye de la siguiente manera:
    {vida, cantidadGolpes, nivel, Campos, NivelAparicion, costo, fuerza, limite};*/
    public static Ejercito CrearSoldado(Soldados tipo, String nombre, String Arma, int[] datos){
        System.out.println("Tamaño de datos[] " + datos.length);
        System.out.println(datos[0] + "-" + datos[1] +"-" + datos[2] +"-" + datos[3] + "-" + datos[4] + "-" + datos[5] + "-" + datos[6]);
        switch(tipo){
            case SOLDADOCONTACTO: return new SoldadoContacto("Soldados de contacto", Arma, nombre, datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            case ALCANCEMEDIO: return new AlcanceMedio("Alcance medio", Arma, nombre, datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            case AEREOS: return new Aereos("Aéreos",Arma, nombre, datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            case IMPACTO: return new Impacto("Impacto",Arma, nombre, datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            case CHOQUE: return new Choque("Choque",Arma, nombre, datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
            default: return new SoldadoContacto("Soldado de contacto", Arma, nombre, datos[0], datos[1], datos[2], datos[3], datos[4], datos[5], datos[6]);
        }
    }
}
