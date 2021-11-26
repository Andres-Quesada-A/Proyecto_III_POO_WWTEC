/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracionEjercito;

import Ejercito.Ejercito;
import EquipoEjercito.EquipoEjercito;
import FactoryEjercito.FactoryEjercito;
import FilesManagers.Serealizar_Deserializar_Objeto;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ModeloEjercitoConfiguracion {
    //Utiliado para las imagenes que dan una representación gráfica de los tipos de puestos en el ejercito
    private ArrayList<ImageIcon> imagenes = new ArrayList<ImageIcon>();
    private EquipoEjercito Integrantes;

    //Constructor
    public ModeloEjercitoConfiguracion() {
        CargarIconos();
        this.Integrantes = new EquipoEjercito();
    }
    
    //Metodos
    //Crea los iconos de cada tipo de soldado y los añade al arraylist de las imagenes
    private void CargarIconos(){
        String[] Categorias = {"/ConfiguracionEjercito/Imagenes/Soldadoscontacto.jpg" ,"/ConfiguracionEjercito/Imagenes/Alcancemedio.jpg" , 
        "/ConfiguracionEjercito/Imagenes/Aereos.jpg" , "/ConfiguracionEjercito/Imagenes/Choque.jpg" , "/ConfiguracionEjercito/Imagenes/Impacto.jpg"};
        for (int i = 0; i < Categorias.length; i++){
            ImageIcon icon = new ImageIcon(getClass().getResource(Categorias[i]));
            imagenes.add(icon);
        }
    }
    
    //Identifica el tipo de puesto en el ejercito y devuelve la referencia del objeto que representa
    //el soldado...(se menciona soldado paro también puede ser un vehículo)
    public ImageIcon getImageIcon(String tipo){
        if (tipo.equalsIgnoreCase("Soldados de contacto")){
            return imagenes.get(0);
        }else if (tipo.equalsIgnoreCase("Alcance medio")){
            return imagenes.get(1);
        }else if (tipo.equalsIgnoreCase("Aéreos")){
            return imagenes.get(2);
        }else if (tipo.equalsIgnoreCase("Choque")){
            return imagenes.get(3);
        }else if (tipo.equalsIgnoreCase("Impacto")){
            return imagenes.get(4);
        }
        return imagenes.get(0);
    }
    
    /*tipo, Nombre, Arma, {vida, cantidadGolpes, nivel, Campos, NivelAparicion, costo, fuerza, limite};*/
    public void CrearMiembro(String tipo, String nombre, String arma, int[] datos){
        Ejercito nuevo;
        if (tipo.equalsIgnoreCase("Soldados de contacto")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.SOLDADOCONTACTO, nombre, arma, datos);
            Integrantes.insertarMiembro(nuevo);
        }else if (tipo.equalsIgnoreCase("Alcance medio")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.ALCANCEMEDIO, nombre, arma, datos);
            Integrantes.insertarMiembro(nuevo);
        }else if (tipo.equalsIgnoreCase("Aéreos")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.AEREOS, nombre, arma, datos);
            Integrantes.insertarMiembro(nuevo);
        }else if (tipo.equalsIgnoreCase("Choque")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.CHOQUE, nombre, arma, datos);
            Integrantes.insertarMiembro(nuevo);
        }else if (tipo.equalsIgnoreCase("Impacto")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.IMPACTO, nombre, arma, datos);
            Integrantes.insertarMiembro(nuevo);
        }
    }
    
    //Manda a guardar los objetos creados en el archivo serializable
    public void guardarEnSerializable(){
        Serealizar_Deserializar_Objeto.serializarObjeto("Ejercito.Dat", Integrantes);
    }
    
    //Si hay objetso guardados en el archivo serializable... los carga que se puedan editar en la ventana de configuracion
    public boolean DeserealizarObjeto(){
        EquipoEjercito recuperado = Serealizar_Deserializar_Objeto.deserializarObjeto("Ejercito.Dat", EquipoEjercito.class);
        if (recuperado == null){
            System.out.println("Los recursos recuperados son nulos");
            return false;
        }else{
            System.out.println("Si existen recursos");
            for (int i = 0; i < recuperado.getLegthArray(); i++){
                Integrantes.insertarMiembro(recuperado.GetUsuario(i));
            }
            return true;
        }
    }
    
    public int getSizeEquipo(){
        return Integrantes.getLegthArray();
    }
    
    public Ejercito ObtenerSoldados(int index){
        return Integrantes.GetUsuario(index);
    }
    
    //Actualiza los datos de un soldado ya creado
    public void ActualizarDatos(int index, String tipo, String nombre, String arma, int[] atributos){
        Integrantes.ActualizarDatos(index, tipo, nombre, arma, atributos);
    }
    
    //Elimina el soldado que pertenezca al indice que se pasa por parametro
    public void EliminarSoldado(int index){
        Integrantes.EliminarSoldado(index);
    }
}
