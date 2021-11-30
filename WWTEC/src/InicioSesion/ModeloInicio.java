/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InicioSesion;

import Defensa.AereosD;
import Defensa.Bombas;
import Defensa.Cañon;
import Defensa.Edificio;
import Defensa.Mortero;
import Defensa.Muro;
import Defensa.Pueblo;
import Defensa.Torre;
import EquipoEjercito.EquipoEjercito;
import FilesManagers.FileManager;
import FilesManagers.Serealizar_Deserializar_Objeto;
import JuegoUsuario.JuegoUsuario;
import PantallaConfiguracion.ConfigurationWindow;
import PartidasJugador.PartidaUsuario;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class ModeloInicio {
    private String Path; //Direccion del archivo para los usuarios
    private String PathAdmin; //Direccion al archivo que contiene los datos del admin
    private FileManager data; //objeto utilizado para leer el archivo de los jugadores
    private FileManager dataAdmin; //objeto utilizado para leer el archivo de los jugadores

    //CONSTRUCTOR
    public ModeloInicio() {
        this.data = new FileManager();
        this.dataAdmin = new FileManager();
        this.Path = "Usuarios.txt";
        this.PathAdmin = "Administrador.txt";
        this.data.createFile(Path);
        this.dataAdmin.createFile(PathAdmin);
    }
    
    //METODOS
    //Recorre el archivo del admin (puede haber más de uno) y verifica si los datos
    //suministrados pertenecen a un administrador del juego
    public boolean VerificarAdmin(String usuario, String contraseña){
        String datos = dataAdmin.readFile(PathAdmin);
        String datosJ[] = datos.split("\n");
        String admin[];
        int i;
        for (i = 0; i < datosJ.length; i++){
            admin = datosJ[i].split(", ");
            if (admin[0].equals(usuario)){
                if (admin[1].equals(contraseña)){
                    return true;
                }
                else{
                   return false;
                }
            }
        }
        if (i == datosJ.length)
            return false;
        return false;
    } 
    
    //Almacena un nuevo usuario con su debido nombre o ID y contraseña para poder ingresar al sistema
    public void AlmacenarUsuario(String usuario, String contraseña){
        data.writeToFile(Path, usuario + ", " + contraseña + "\n");
    }
    
    
    //Recorre el archivo que contiene los datos de los jugadores y verifica si los datos
    //ingresados desde la interfaz de usuario, pertenecen a un usuario registrado
    public boolean VerificarUsuario(String nombre, String contraseña){
        String datos = data.readFile(Path);
        String datosJ[] = datos.split("\n");
        String jugador[];
        int i;
        for (i = 0; i < datosJ.length; i++){
            jugador = datosJ[i].split(", ");
            if (jugador[0].equals(nombre)){
                if (jugador[1].equals(contraseña)){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        if (i == datosJ.length)
            return false;
        return false;
    }
    
    //Utilizado para que los usuarios que se quieran registrar tengan nombres de usuario
    //unicos y que no se repitan, así como un ID
    public boolean VerificarNombreUsuario(String nombre){
        String datos = data.readFile(Path);
        String datosJ[] = datos.split("\n");
        String jugador[];
        int i;
        for (i = 0; i < datosJ.length; i++){
            jugador = datosJ[i].split(", ");
            if (jugador[0].equals(nombre)){
                return false;
            }
        }
        if (i  == datosJ.length)
            return true;
        return false;
    }
    
    //Crea y habre la ventana de configuracion del juego (esto solo para el administrador)
    public void VentanaDeConfiguracion(){
        ConfigurationWindow configWindow = new ConfigurationWindow();
        configWindow.setVisible(true);
    }
    
    public void GuardarEnHistorial(String PathAux){
        System.out.println(PathAux + " --> PATH");
        String[] AuxPath = PathAux.split(".dat");
        System.out.println(AuxPath[0] + " --> con split");
        FileManager file = new FileManager();
        file.createFile("HistorialPartidas.txt");
        file.writeToFile("HistorialPartidas.txt", AuxPath[0] + "\n");
    }
    
    public void CrearArchivo(String user, String password){
        String PathTemp = user + "_" + password + "_Nivel_1.dat";
        GuardarEnHistorial(PathTemp);
        FileManager file = new FileManager();
        file.createFile(PathTemp);
        EquipoEjercito recuperado = Serealizar_Deserializar_Objeto.deserializarObjeto("Ejercito.Dat", EquipoEjercito.class);
        PartidaUsuario partidaUsuario =  new PartidaUsuario();
        
        Pueblo pueblo = Serealizar_Deserializar_Objeto.deserializarObjeto("Pueblo.dat", Pueblo.class);
//      
        partidaUsuario.juegoUsuario.setEjercito(recuperado);
        partidaUsuario.juegoUsuario.sustituirPueblo(pueblo);
        Serealizar_Deserializar_Objeto.serializarObjeto(PathTemp,partidaUsuario);
    }
    
    
    
    public void ActualizarConfiguraciones(String user, String password){
        String PathTemp = user + "_" + password + "_Nivel_1.dat";
        //Obtiene el juego del usuario actual
        PartidaUsuario recuperado = Serealizar_Deserializar_Objeto.deserializarObjeto(PathTemp, PartidaUsuario.class);
        //Obtiene la configuracion del ejercito
        EquipoEjercito equipoRecuperado = Serealizar_Deserializar_Objeto.deserializarObjeto("Ejercito.Dat", EquipoEjercito.class);
        recuperado.juegoUsuario.sustituirEjercito(equipoRecuperado);
        //Obtiene la configuracion de los elementos del pueblo
        Pueblo pueblo = Serealizar_Deserializar_Objeto.deserializarObjeto("Pueblo.dat", Pueblo.class);
        recuperado.juegoUsuario.sustituirPueblo(pueblo);
        //Guarda nueva mente el archivo
        Serealizar_Deserializar_Objeto.serializarObjeto(PathTemp, recuperado);
        
    }
}
