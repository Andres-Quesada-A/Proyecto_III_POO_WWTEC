/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtec;

import InicioSesion.ControladorInicio;
import InicioSesion.ModeloInicio;
import InicioSesion.VistaInicio;

/**
 *
 * @author andre
 */
public class WWTEC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaInicio vista = new VistaInicio();
        ModeloInicio modelo = new ModeloInicio();
        ControladorInicio controller = new ControladorInicio(vista, modelo);
        controller.ShowView();
    }
    
}
