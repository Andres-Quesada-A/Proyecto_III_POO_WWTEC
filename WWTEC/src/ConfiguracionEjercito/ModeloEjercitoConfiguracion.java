/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracionEjercito;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ModeloEjercitoConfiguracion {
    //Utiliado para las imagenes que dan una representación gráfica de los tipos de puestos en el ejercito
    private ArrayList<ImageIcon> imagenes = new ArrayList<ImageIcon>(); 

    //Constructor
    public ModeloEjercitoConfiguracion() {
        CargarIconos();
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
}
