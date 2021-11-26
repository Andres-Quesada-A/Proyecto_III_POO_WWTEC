/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConfiguracionEjercito;

import Ejercito.Aereos;
import Ejercito.AlcanceMedio;
import Ejercito.Choque;
import Ejercito.Ejercito;
import Ejercito.Impacto;
import Ejercito.SoldadoContacto;
import EquipoEjercito.EquipoEjercito;
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
    private int Editando = 0; //Utilizado para saber el indice del objeto que se va a modificar
    
    //Contructor
    public ControladorEjercitoConfiguracion(VistaEjercitoConfiguracion vista, ModeloEjercitoConfiguracion modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setLocationRelativeTo(null);
        this.vista.setResizable(false);
        this.vista.setTitle("Configuración del ejercito");
        _Init_();
        deseriaizarObjetoGuardado();
    }
    
    private void setValoresGuardados(Ejercito nuevo, int indice){
        String nombre = nuevo.getNombre();
        String tipo = nuevo.getNombreClase();
        this.vista.SetItemVariable(indice +": "+ nombre + ": " + tipo);
    }
    
    private void deseriaizarObjetoGuardado(){
        if (this.modelo.DeserealizarObjeto()){
            System.out.println("Tenía contenido");
            for (int i = 0; i < this.modelo.getSizeEquipo(); i++){
                Ejercito recuperado = this.modelo.ObtenerSoldados(i);
                setValoresGuardados(recuperado, i + 1);
            }
        }
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
        this.vista.btnEditar.setActionCommand("Editar");
        this.vista.btnEditar.addActionListener(this);
        this.vista.GuardarCambios.setActionCommand("GuardarCambios");
        this.vista.GuardarCambios.addActionListener(this);
        this.vista.Eliminar.setActionCommand("Eliminar");
        this.vista.Eliminar.addActionListener(this);
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
        /*tipo, Nombre, Arma, {vida, cantidadGolpes, nivel, Campos, NivelAparicion, costo, fuerza, limite};*/
        int[] Atributos = {Integer.parseInt(this.vista.getTxfVida()), Integer.parseInt(this.vista.getTxfCantidadGolpe()),
        Integer.parseInt(this.vista.getTxfNivel()), Integer.parseInt(this.vista.getTxfCampos()), Integer.parseInt(this.vista.getTxfNivelAparicion()),
        Integer.parseInt(this.vista.getTxfCosto()), Integer.parseInt(this.vista.getTxfFuerzaGolpe())};
        this.modelo.CrearMiembro(this.vista.getCmbxTipo(), this.vista.getTxfNombre(), this.vista.getCmbxArma(), Atributos);
        int index = this.modelo.getSizeEquipo();
        setValoresGuardados(this.modelo.ObtenerSoldados(index - 1), index);
        this.vista.setMensaje("Se ingresaron los datos correctamente");
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
        this.modelo.guardarEnSerializable();
        this.vista.dispose();
    }
    
    //Recibe cualquier tipo de soldado y le establece los valores a los elementos de la ventana, como los labels y combo box
    //Esto permite al usuario observar los datos del objeto y ademas poder realizar modificaciones al objeto
    private void EstablecerValores(Ejercito editable){
        String nameClass = editable.getNombreClase();
        System.out.println("Nombre clase: " + nameClass);
        this.vista.setTxfCampos(Integer.toString(editable.getCampos()));
        this.vista.setTxfCantidadGolpe(Integer.toString(editable.getCantidadGolpes()));
        this.vista.setTxfCosto(Integer.toString(editable.getCosto()));
        this.vista.setTxfFuerzaGolpe(Integer.toString(editable.getFuerza()));
        this.vista.setTxfNivel(Integer.toString(editable.getNivel()));
        this.vista.setTxfNivelAparicion(Integer.toString(editable.getNivelAparicion()));
        this.vista.setTxfNombre(editable.getNombre());
        this.vista.setTxfVida(Integer.toString(editable.getVida()));
        this.vista.cmbxTipo.getModel().setSelectedItem(nameClass);
        if (nameClass.equalsIgnoreCase("Soldados de contacto")){
            SoldadoContacto soldadoContact = (SoldadoContacto)editable;
            this.vista.cmbxArma.getModel().setSelectedItem(soldadoContact.getArma());
        }else if (nameClass.equalsIgnoreCase("Alcance medio")){
            AlcanceMedio alcanceMedio = (AlcanceMedio)editable;
            this.vista.cmbxArma.getModel().setSelectedItem(alcanceMedio.getArma());
        }else if (nameClass.equalsIgnoreCase("Aéreos")){
            Aereos aereo = (Aereos)editable;
            this.vista.cmbxArma.getModel().setSelectedItem(aereo.getTipo());
        }else if (nameClass.equalsIgnoreCase("Impacto")){
            Impacto impacto = (Impacto)editable;
            this.vista.cmbxArma.getModel().setSelectedItem(impacto.getArma());
        }else if (nameClass.equalsIgnoreCase("Choque")){
            Choque choque = (Choque) editable;
            this.vista.cmbxArma.getModel().setSelectedItem(choque.getArma());
        }
    }
    
    //Obtiene el nombre del combo box donde se encuentra los soldados que fueron creados anterior mente (también los
    //que se encontraban guardados en el archivo serializable y según su indice, se trae a la variable editable
    private void botonEditarAction(){
        String Objeto = this.vista.getCmbxSoldados();
        String[] index = Objeto.split(": ");
        int valor = Integer.parseInt(index[0]);
        this.Editando = valor - 1;
        Ejercito editable = this.modelo.ObtenerSoldados(Editando);
        EstablecerValores(editable);
    }
    
    //Obtiene el objeto que se está editando en ese momento y llama a otras rubrutinas que le establecen nuevos valores
    private void GuardarCambiosAction(){
        int[] Atributos = {Integer.parseInt(this.vista.getTxfVida()), Integer.parseInt(this.vista.getTxfCantidadGolpe()),
        Integer.parseInt(this.vista.getTxfNivel()), Integer.parseInt(this.vista.getTxfCampos()), Integer.parseInt(this.vista.getTxfNivelAparicion()),
        Integer.parseInt(this.vista.getTxfCosto()), Integer.parseInt(this.vista.getTxfFuerzaGolpe())};
        this.modelo.ActualizarDatos(Editando, this.vista.getCmbxTipo(),this.vista.getTxfNombre(), this.vista.getCmbxArma(), Atributos);
        this.vista.setMensaje("Se han guardado los cambios");
    }
    
    //Solo funciona con objetos creados, lo que hace es que utiliza el indice del objeto que se está editando y por
    //medio del valor del indice del mismo, lo manda a eliminar
    private void EliminarAction(){
        this.modelo.EliminarSoldado(this.Editando);
        botonClearAction();
        this.vista.setMensaje("El soldado se ha eliminado correctamente");
        this.vista.CmbxSoldados.removeAllItems();
        for (int i = 0; i < this.modelo.getSizeEquipo(); i++){
            Ejercito aux = this.modelo.ObtenerSoldados(i);
            setValoresGuardados(aux, i);
        }
        
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
        }else if (boton.equalsIgnoreCase("Editar")){
            botonEditarAction();
        }else if (boton.equalsIgnoreCase("GuardarCambios")){
            GuardarCambiosAction();
        }else if (boton.equalsIgnoreCase("Eliminar")){
            EliminarAction();
        }
    }
}
