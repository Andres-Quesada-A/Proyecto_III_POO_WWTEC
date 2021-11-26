/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InicioSesion;

import PreJuego.ControladorElegirEjercito;
import PreJuego.ModeloElegirEjercito;
import PreJuego.VistaElegirEjercito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author andre
 */
public class ControladorInicio implements ActionListener{
    private VistaInicio vista; //Referencia de la interfaz gráfica de usuario
    private ModeloInicio modelo; //Referencia del modelo utilizado para las operaciones del inicio de sesion

    //COSNTRUCTOR
    public ControladorInicio(VistaInicio vista, ModeloInicio modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setLocationRelativeTo(null);
        this.vista.setResizable(false);
        this.vista.setTitle("Inicio Sesión");
        _Init_();
    }
    
    //Muestra la interfaz de usuario
    public void ShowView(){
        this.vista.setVisible(true);
    }
    
    //Le añade un comando y un listener a los dos botones de la interfaz de usuario
    private void _Init_(){
        this.vista.btnInicioSesion.addActionListener(this);
        this.vista.btnInicioSesion.setActionCommand("Inicio");
        this.vista.btnRegistrarse.addActionListener(this);
        this.vista.btnRegistrarse.setActionCommand("Registro");
    }

    //El usuario tiene que ser diferente a un espacio en blaco y ademas debe tener como minimo un caracter 
    private boolean validarFormatoUsuario(){
        if (!vista.GetUsuario().equalsIgnoreCase("")){
            String usuario = vista.GetUsuario().trim().replaceAll(" ", "");
            if (usuario.length() > 1){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    //La contraseña debe ser mayor o igual a 8 caracteres 
    private boolean validarFormatoContraseña(){
        if (!vista.GetContraseña().equalsIgnoreCase("")){
            String usuario = vista.GetContraseña().trim().replaceAll(" ", "");
            if (usuario.length() > 7){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    //Para iniciar sesion se debe verificar primero que los formatos de usuario y contraseña sean correctos y luego
    //se verifica que sea un administrador, en caso de serlo ingresará a la configurarión del juego , en todo caso
    //si es un jugador más,se habre la interfaz del juego
    private void btnInicioSesionAction(){
        if (validarFormatoUsuario()){
            if (validarFormatoContraseña()){
                if (this.modelo.VerificarAdmin(vista.GetUsuario(), vista.GetContraseña())){
                    IniciarComoAdmin();
                }else if (this.modelo.VerificarUsuario(vista.GetUsuario(), vista.GetContraseña())){
                    IniciarComoJgador(vista.GetUsuario(), vista.GetContraseña());
                }else{
                    this.vista.SetMensajeError("Los datos ingresados son incorrectos");
                }
            }else{
                this.vista.SetMensajeError("La contraseña no es válida\nDebe tener minimo ocho caracteres.");
            }
        }else{
            this.vista.SetMensajeError("El nombre de usuario no es valido\nEl usuario debe tener al menos un caracter");
        }
    }
    
    //Se verifica que los datos suministrados cumplan con su formato previamente definido y ademas que
    //el nombre de usuario no se repita con el de otro jugador
    private void btnRegistrarseAction(){
        if (validarFormatoUsuario()){
            if (validarFormatoContraseña()){
                if (this.modelo.VerificarNombreUsuario(vista.GetUsuario())){
                    this.modelo.AlmacenarUsuario(vista.GetUsuario(), vista.GetContraseña());
                    this.modelo.CrearArchivo(vista.GetUsuario(), vista.GetContraseña());
                    this.vista.SetMensaje("El usuario ha sido registrado");
                }else{
                    this.vista.SetMensajeError("El nombre de usuario ya se encuentra registrado");
                }
            }else{
                this.vista.SetMensajeError("La contraseña no es válida\nDebe tener minimo ocho caracteres.");
            }
        }else{
            this.vista.SetMensajeError("El nombre de usuario no es valido\nEl usuario debe tener al menos un caracter");
        }
    }
    
    //Lleva al usuario a la ventana de configuracion del juego
    private void IniciarComoAdmin(){
        this.modelo.VentanaDeConfiguracion();
        this.vista.dispose();
    }
    
    //lleva al juego 
    private void IniciarComoJgador(String user, String password){
        this.modelo.ActualizarConfiguraciones(vista.GetUsuario(), vista.GetContraseña());
        VistaElegirEjercito vista = new VistaElegirEjercito();
        ModeloElegirEjercito modelo = new ModeloElegirEjercito(user, password);
        ControladorElegirEjercito controller = new ControladorElegirEjercito(modelo, vista);
        controller.ShowView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String boton = e.getActionCommand();
        if (boton.equalsIgnoreCase("Inicio")){
            btnInicioSesionAction();
        }else if (boton.equalsIgnoreCase("Registro")){
            btnRegistrarseAction();
        }
    }
    
}
