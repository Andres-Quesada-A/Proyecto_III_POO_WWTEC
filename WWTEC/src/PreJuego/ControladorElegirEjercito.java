/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreJuego;

import Ejercito.Ejercito;
import Progreso.VistaProgreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ControladorElegirEjercito implements ActionListener{
    private ModeloElegirEjercito modelo;
    private VistaElegirEjercito vista;
    private int indice = 0;
    private int Campos = 0;

    public ControladorElegirEjercito(ModeloElegirEjercito modelo, VistaElegirEjercito vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.setTextMoneta(Integer.toString(this.modelo.ObtenerDinero()));
        this.vista.setCampos(this.modelo.GetCampos());
        this.Campos = Integer.parseInt(this.modelo.GetCampos());
        init();
    }
    
    public void ShowView(){
        this.vista.setVisible(true);
    }
    
    private void init(){
        this.vista.btnAtras.addActionListener(this);
        this.vista.btnAtras.setActionCommand("Atras");
        this.vista.btnSiguiente.addActionListener(this);
        this.vista.btnSiguiente.setActionCommand("Siguiente");
        this.vista.Continuar.addActionListener(this);
        this.vista.Continuar.setActionCommand("Continuar");
        this.vista.Elegir.addActionListener(this);
        this.vista.Elegir.setActionCommand("Elegir");
        this.vista.Eliminar.addActionListener(this);
        this.vista.Eliminar.setActionCommand("Eliminar");
        MostrarUsuario(indice);
    }

    private void MostrarUsuario(int index){
        Ejercito Soldado = this.modelo.ObtenerSoldados(index);
        String Arma = this.modelo.getArmaObjeto();
        ImageIcon icon = this.modelo.getImagen();
        this.vista.SetIcon(icon);
        //{"Tipo de ataque", "Nombre","Vida","Cantidad de golpes /s","Nivel","Campos",
        //"Nivel de aparición","Costo","Fuerza de golpe", "Arma"};
        this.vista.SetTexto(0, Soldado.getNombreClase());
        this.vista.SetTexto(1, Soldado.getNombre());
        this.vista.SetTexto(2, Integer.toString(Soldado.getVida()));
        this.vista.SetTexto(3, Integer.toString(Soldado.getCantidadGolpes()));
        this.vista.SetTexto(4, Integer.toString(Soldado.getNivel()));
        this.vista.SetTexto(5, Integer.toString(Soldado.getCampos()));
        this.vista.SetTexto(6, Integer.toString(Soldado.getNivelAparicion()));
        this.vista.SetTexto(7, Integer.toString(Soldado.getCosto()));
        this.vista.SetTexto(8, Integer.toString(Soldado.getFuerza()));
        this.vista.SetTexto(9, Arma);
    }
    
    private void BotonAnteriorAction(){
        if (indice == 0){
            indice = this.modelo.getSizeEquipo() - 1;
        }else{
            indice--;
        }
        MostrarUsuario(indice);
    }
    
    private void botonSiguienteAction(){
        if (indice == this.modelo.getSizeEquipo() - 1){
            indice = 0;
        }else{
            indice++;
        }
        MostrarUsuario(indice);
    }
    
    private void botonContinuarAction(){
        this.modelo.SerealizarObjeto();
        String path =  this.modelo.getPATH();
        String[] pathDividido = path.split("_");
        VistaProgreso nuevaVentana = new VistaProgreso(pathDividido[0], pathDividido[1]);
        nuevaVentana.setVisible(true);
        this.vista.dispose();
    }
    
    //"Tipo de ataque", "Nombre","Vida","Cantidad de golpes /s","Nivel","Campos",
    //"Nivel de aparición","Costo","Fuerza de golpe", "Arma"};
    //{vida, cantidadGolpes, nivel, Campos, NivelAparicion, costo, fuerza};
    private void botonElegirAction(){
        if (Integer.parseInt(vista.GetTexto(5)) <= Integer.parseInt(this.modelo.GetCampos())){
            if (Integer.parseInt(this.vista.GetTexto(6)) <= this.modelo.GetNivelUsuario()){
                if (Integer.parseInt(this.vista.GetTexto(7)) <= this.modelo.ObtenerDinero()){
                    int [] datos = new int[7];
                    String tipo = this.vista.GetTexto(0);
                    String Nombre = this.vista.GetTexto(1);
                    datos[0] = Integer.parseInt(this.vista.GetTexto(2));
                    datos[1] = Integer.parseInt(this.vista.GetTexto(3));
                    datos[2] = Integer.parseInt(this.vista.GetTexto(4));
                    datos[3] = Integer.parseInt(this.vista.GetTexto(5));
                    datos[4] = Integer.parseInt(this.vista.GetTexto(6));
                    datos[5] = Integer.parseInt(this.vista.GetTexto(7));
                    datos[6] = Integer.parseInt(this.vista.GetTexto(8));
                    String arma = this.vista.GetTexto(9);
                    this.modelo.CrearSoldados(tipo, Nombre, arma, datos);
                    this.vista.SetItemVariable(this.modelo.getLegthArray() + ": Tipo: " + tipo + ", Nombre: " + Nombre + ", Campos: " + datos[3]);
                    this.modelo.EstablecerDinero(this.modelo.ObtenerDinero() - datos[5]);
                    this.vista.setTextMoneta(Integer.toString(this.modelo.ObtenerDinero()));
                    /////////////////////////////////////////////////////////////////////////////////
                    //this.modelo.SetCampos(Integer.parseInt(this.modelo.GetCampos()) - datos[3]);
                    this.Campos = Campos - datos[3];
                    this.vista.setCampos(Integer.toString(this.Campos));
                }else{
                    this.vista.setMensajeError("No tiene suficiente dinero");
                }
            }else{
                this.vista.setMensajeError("El nivel del soldado es mayor al que usted posee");
            }
        }else{
            this.vista.setMensajeError("No quedan suficientes campos");
        }
    }
    
    //Se establecen los soldados elegidos en el combo box de la ventana
    private void EstablecerCmbx(){
        int cant = this.modelo.getLegthArray();
        this.vista.CmbxElegidos.removeAllItems();
        for (int i = 0; i < cant; i++){
            Ejercito aux = this.modelo.getSoldado(i);
            String tipo = aux.getNombreClase();
            String nombre = aux.getNombre();
            int campos = aux.getCampos();
            this.vista.SetItemVariable((i + 1) + ": Tipo: " + tipo + ", Nombre: " + nombre + ", Campos: " + campos);
        }
    }
    
    private void botonEliminarAction(){
        String elegido = this.vista.GetItemVariable();
        String[] datos = elegido.split(": ");
        int index = Integer.parseInt(datos[0]);
        Ejercito Aux = this.modelo.getSoldado(index - 1);
        int precio = Aux.getCosto();
        this.modelo.EstablecerDinero(this.modelo.ObtenerDinero() + precio);
        this.vista.setTextMoneta(Integer.toString(this.modelo.ObtenerDinero()));
        this.modelo.EliminarSoldado(index - 1);
        EstablecerCmbx();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String boton = e.getActionCommand();
        if (boton.equalsIgnoreCase("Atras")){
            BotonAnteriorAction();
        }else if (boton.equalsIgnoreCase("Siguiente")){
            botonSiguienteAction();
        }else if (boton.equalsIgnoreCase("Continuar")){
            botonContinuarAction();
        }else if (boton.equalsIgnoreCase("Elegir")){
            botonElegirAction();
        }else if (boton.equalsIgnoreCase("Eliminar")){
            botonEliminarAction();
        }
    }
}
