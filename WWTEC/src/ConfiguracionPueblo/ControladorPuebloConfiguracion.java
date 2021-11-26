/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracionPueblo;

import ConfiguracionEjercito.ModeloEjercitoConfiguracion;
import Defensa.Defensa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andre
 */
public class ControladorPuebloConfiguracion implements ActionListener{
    private ModeloPuebloConfiguracion modelo;
    private VistaPuebloConfiguracion vista;
    private int Editable = 0;
    
    public ControladorPuebloConfiguracion(ModeloPuebloConfiguracion modelo, VistaPuebloConfiguracion vista){
        this.modelo = modelo;
        this.vista = vista;
        init();
        ActualizarComboBox();
        ActualizarDinero();
    }
    
    public void ShowView(){
        this.vista.setVisible(true);
    }
    
    private void ActualizarDinero(){
        int dinero = this.modelo.ObtenerBienes();
        this.vista.setTxfBienes(Integer.toString(dinero));
    }
    
    private void init(){
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEditar.setActionCommand("Editar");
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnGuardar.setActionCommand("Guardar");
        this.vista.btnRegresar.addActionListener(this);
        this.vista.btnRegresar.setActionCommand("Regresar");
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnActualizar.setActionCommand("Actualizar");
    }

    private void BotonEditarAction(){
        String objeto = this.vista.getCmbxGuardados();
        String[] datos = objeto.split(": ");
        int index = Integer.parseInt(datos[0]);
        this.Editable = index - 1;
        Defensa Aux = this.modelo.getObjetoPueblo(Editable);
        this.vista.SelectItem(Aux.getNameClass());
        this.vista.setTxfBienes(Integer.toString(this.modelo.ObtenerBienes()));
        this.vista.setTxfDisparos(Integer.toString(Aux.getFrecuenciaDisparo()));
        this.vista.setTxfVida(Integer.toString(Aux.getVida()));
    }
    
    private void ActualizarComboBox(){
        this.vista.CmbxGuardados.removeAllItems();
        int tamaño = this.modelo.getTamañoPueblo();
        for (int i = 0; i < tamaño; i++){
            Defensa Aux = this.modelo.getObjetoPueblo(i);
            this.vista.SetItemVariable((i + 1) + ": " + Aux.getNameClass() + "");
        }
    }
    
    private void BotonGuardarAction(){
        if(this.vista.getTxfVida().matches("[+-]?\\d*(\\.\\d+)?") == false){
            this.vista.setMensajeError("La vida debe ser un valor numérico");
            return;
        }
        if(this.vista.getTxfDisparos().matches("[+-]?\\d*(\\.\\d+)?") == false){
            this.vista.setMensajeError("La cantidad de golpes debe ser un valor numérico");
            return;
        }
        this.modelo.CrearNuevoObjeto(this.vista.getCmbxTipo(), Integer.parseInt(this.vista.getTxfVida()), Integer.parseInt(this.vista.getTxfDisparos()));
        this.vista.setMensaje("Ha sido creado correctamente");
        ActualizarComboBox();
    }
    
    private void BotonRegresarAction(){
        int bienes = Integer.parseInt(this.vista.getTxfBienes());
        this.modelo.EstablecerBienes(bienes);
        this.modelo.GuardarEnSerializable();
        this.vista.dispose();
    }
    
    private void BotonActualizarAction(){
        int vida = Integer.parseInt(this.vista.getTxfVida());
        int disparos = Integer.parseInt(this.vista.getTxfDisparos());
        this.modelo.ActualizarDatos(Editable, vida, disparos);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String boton = e.getActionCommand();
        if (boton.equalsIgnoreCase("Editar")){
            BotonEditarAction();
        }else if (boton.equalsIgnoreCase("Guardar")){
            BotonGuardarAction();
        }else if (boton.equalsIgnoreCase("Regresar")){
            BotonRegresarAction();
        }else if (boton.equalsIgnoreCase("Actualizar")){
            BotonActualizarAction();
        }
    }
}
