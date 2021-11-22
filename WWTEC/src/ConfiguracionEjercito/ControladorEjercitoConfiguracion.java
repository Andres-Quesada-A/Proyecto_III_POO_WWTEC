/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracionEjercito;

import FondoVentana.FondoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.Action;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ControladorEjercitoConfiguracion implements ActionListener{
    private VistaEjercitoConfiguracion vista; //La interfaz gráfica de la configuración para el ejercito
    private ModeloEjercitoConfiguracion modelo; //El modelo utilizado para las operaciones en la configuracion del ejercito
    
    //Contructor
    public ControladorEjercitoConfiguracion(VistaEjercitoConfiguracion vista, ModeloEjercitoConfiguracion modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setLocationRelativeTo(null);
        this.vista.setResizable(false);
        this.vista.setTitle("Configuración del ejercito");
        _Init_();
    }
    
    //Mostrar la interfaz gráfica
    public void ShowView(){
        this.vista.setVisible(true);
    }
    
    //Establece a los botones y combo box un comando y un listener
    private void _Init_(){
        this.vista.btnCrear.addActionListener(this);
        this.vista.btnCrear.setActionCommand("Crear");
        this.vista.btnClear.addActionListener(this);
        this.vista.btnClear.setActionCommand("Clear");
        this.vista.btnRegresar.addActionListener(this);
        this.vista.btnRegresar.setActionCommand("Regresar");
        this.vista.cmbxTipo.setActionCommand("Combo");
        this.vista.cmbxTipo.addActionListener(this);
        ComboBoxAction();
    }

    //Por cada cambio que sufra el combo box de tipos de miembros de ejercito, se cambia la
    //imagen que representa el tipo de puesto en el ejercito
    private void ComboBoxAction(){
        ImageIcon imagen = this.modelo.getImageIcon(this.vista.getCmbxTipo());
        this.vista.SetIcone(imagen);
    }
    
    //Realiza validaciones de todos los campos de texto de la interfaz gráfica
    private void BotonCrearAction(){
        if (this.vista.getTxfNombre().equalsIgnoreCase("")){
            this.vista.setMensajeError("El nombre del soldado es incorrecto");
            return;
        }
        if(this.vista.getTxfVida().matches("[+-]?\\d*(\\.\\d+)?") == false){
            this.vista.setMensajeError("La vida debe ser un valor numérico");
            return;
        }
        if(this.vista.getTxfCantidadGolpe().matches("[+-]?\\d*(\\.\\d+)?") == false){
            this.vista.setMensajeError("La cantidad de golpes debe ser un valor numérico");
            return;
        }
        if (this.vista.getTxfNivel().matches("[+-]?\\d*(\\.\\d+)?") == false){
            this.vista.setMensajeError("El nivel debe ser un valor numércio");
            return;
        }
        if (this.vista.getTxfCampos().matches("[+-]?\\d*(\\.\\d+)?") == false){
            this.vista.setMensajeError("Los campos debe ser un valor numércio");
            return;
        }
        if (this.vista.getTxfCosto().matches("[+-]?\\d*(\\.\\d+)?") == false){
            this.vista.setMensajeError("El costo debe ser un valor numércio");
            return;
        }
        if (this.vista.getTxfFuerzaGolpe().matches("[+-]?\\d*(\\.\\d+)?") == false){
            this.vista.setMensajeError("La fuerza de golpe debe ser un valor numércio");
            return;
        }
    }
    
    //Le establece a cada campo de texto un string vacio
    private void botonClearAction(){
        this.vista.setTxfCampos("");
        this.vista.setTxfCantidadGolpe("");
        this.vista.setTxfCosto("");
        this.vista.setTxfFuerzaGolpe("");
        this.vista.setTxfNivel("");
        this.vista.setTxfNivelAparicion("");
        this.vista.setTxfNombre("");
        this.vista.setTxfVida("");
    }
    
    //Manda a guardar todos los objetos creados y cierra la interfaz
    private void botonRegresarAction(){
        //Tambien tiene que mandar a guardar
        this.vista.dispose();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String boton = e.getActionCommand();
        if (boton.equalsIgnoreCase("Crear")){
            BotonCrearAction();
        }else if (boton.equalsIgnoreCase("Clear")){
            botonClearAction();
        }else if (boton.equalsIgnoreCase("Regresar")){
            botonRegresarAction();
        }else if (boton.equalsIgnoreCase("Combo")){
            ComboBoxAction();
        }
    }
}
