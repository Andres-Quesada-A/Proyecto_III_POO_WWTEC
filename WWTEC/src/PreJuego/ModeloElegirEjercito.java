/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreJuego;

import Ejercito.Aereos;
import Ejercito.AlcanceMedio;
import Ejercito.Choque;
import Ejercito.Ejercito;
import Ejercito.Impacto;
import Ejercito.SoldadoContacto;
import EquipoEjercito.EquipoEjercito;
import FactoryEjercito.FactoryEjercito;
import FilesManagers.FileManager;
import FilesManagers.Serealizar_Deserializar_Objeto;
import JuegoUsuario.JuegoUsuario;
import PartidasJugador.PartidaUsuario;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author andre
 */
public class ModeloElegirEjercito {
    private EquipoEjercito soldados;
    private ArrayList<ImageIcon> imagenes = new ArrayList<ImageIcon>();
    private ImageIcon imagen = new ImageIcon();
    private String Arma = "";
    private JuegoUsuario juegoUsuario = new JuegoUsuario();
    private String PATH;

    public ModeloElegirEjercito(String user, String password) {
       
        soldados = new EquipoEjercito();
        CargarIconos();
        ExtraerPath(user, password);
    }
    
    private void ExtraerPath(String user, String password){
        FileManager file = new FileManager();
        file.createFile("HistorialPartidas.txt");
        String Historial = file.readFile("HistorialPartidas.txt");
        String [] partidas = Historial.split("\n");
        String PathDefinitivo = "";
        int mayor = 0;
        
        for (int i = 0; i < partidas.length; i++){
            String[] partes = partidas[i].split("_");
            if (partes[0].equalsIgnoreCase(user) && partes[1].equalsIgnoreCase(password)){
                //user_password_Nivel_#
                if (Integer.parseInt(partes[3]) > mayor){
                    mayor = Integer.parseInt(partes[3]);
                    PathDefinitivo = partidas[i];
                }
            }
        }
        PATH = PathDefinitivo + ".dat";
        DeserealizarObjeto();
    }
    
    public void DeserealizarObjeto(){
        PartidaUsuario recuperado = Serealizar_Deserializar_Objeto.deserializarObjeto(PATH, PartidaUsuario.class);
        
        if (recuperado == null){
            System.out.println("Los recursos recuperados en elegir ejercito son nulos");
        }else{
            juegoUsuario = recuperado.getJuegoUsuario();
            juegoUsuario.LimpiarParaLuchar();
            System.out.println("Si existen recursos en elegir ejercito");
            EquipoEjercito recuperado2 = juegoUsuario.getEjercito();
            for (int i = 0; i < recuperado2.getLegthArray(); i++){
                soldados.insertarMiembro(recuperado2.GetUsuario(i));
            }
        }
    }
    
    public void SerealizarObjeto(){
        PartidaUsuario recuperado = Serealizar_Deserializar_Objeto.deserializarObjeto(PATH, PartidaUsuario.class);
        
        if (recuperado == null){
            System.out.println("Los recursos recuperados en elegir ejercito son nulos");
        }else{
            System.out.println("Si existen recursos en elegir ejercito");
            recuperado.setJuegoUsuario(this.juegoUsuario);
            Serealizar_Deserializar_Objeto.serializarObjeto(PATH, recuperado);
            
        }
    }
    
 
    private void CargarIconos(){
        String[] Categorias = {"/PreJuego/Imagenes/PersonajeE.png","/PreJuego/Imagenes/PersonajePuños.png",
        "/PreJuego/Imagenes/PersonajeF.png","/PreJuego/Imagenes/PersonajeM.png","/PreJuego/Imagenes/PersonajeP.png",
        "/PreJuego/Imagenes/avion.png","/PreJuego/Imagenes/Bombardero.png","/PreJuego/Imagenes/tanque.png",
        "/PreJuego/Imagenes/camion.png",};
        for (int i = 0; i < Categorias.length; i++){
            ImageIcon icon = new ImageIcon(getClass().getResource(Categorias[i]));
            imagenes.add(icon);
        }
    }
    
    public int getSizeEquipo(){
        return soldados.getLegthArray();
    }
    
    public Ejercito ObtenerSoldados(int index){
        Ejercito Aux = soldados.GetUsuario(index);
        EscogerImagen(Aux);
        return Aux;
    }

    public String getPATH() {
        return PATH;
    }
    
    private void EscogerImagen(Ejercito Auxiliar){
        String nameClass = Auxiliar.getNombreClase();
        if (nameClass.equalsIgnoreCase("Soldados de contacto")){
            SoldadoContacto soldadoContact = (SoldadoContacto)Auxiliar;
            Arma = soldadoContact.getArma();
        }else if (nameClass.equalsIgnoreCase("Alcance medio")){
            AlcanceMedio alcanceMedio = (AlcanceMedio)Auxiliar;
            Arma = alcanceMedio.getArma();
        }else if (nameClass.equalsIgnoreCase("Aéreos")){
            Aereos aereo = (Aereos)Auxiliar;
            Arma = aereo.getTipo();
        }else if (nameClass.equalsIgnoreCase("Impacto")){
            Impacto impacto = (Impacto)Auxiliar;
            Arma = impacto.getArma();
        }else if (nameClass.equalsIgnoreCase("Choque")){
            Choque choque = (Choque) Auxiliar;
            Arma = choque.getArma();
        }
        if (nameClass.equalsIgnoreCase("Impacto")){
            this.imagen = imagenes.get(8);
        }else if (nameClass.equalsIgnoreCase("Choque")){
            this.imagen = imagenes.get(7);
        }else if (Arma.equalsIgnoreCase("Espadas") || Arma.equalsIgnoreCase("Nanavas") || Arma.equalsIgnoreCase("Cuchillos")){
            this.imagen = imagenes.get(0);
        }else if (Arma.equalsIgnoreCase("Manos")){
            this.imagen = imagenes.get(1);
        }else if (Arma.equalsIgnoreCase("Flechas")){
            this.imagen = imagenes.get(2);
        }else if (Arma.equalsIgnoreCase("Metralleta") || Arma.equalsIgnoreCase("Rifles") || Arma.equalsIgnoreCase("Fusiles")){
            this.imagen = imagenes.get(3);
        }else if (Arma.equalsIgnoreCase("Pistola")){
            this.imagen = imagenes.get(4);
        }else if (Arma.equalsIgnoreCase("Bombas")){
            this.imagen = imagenes.get(6);
        }else if (Arma.equalsIgnoreCase("Misiles")){
            this.imagen = imagenes.get(5);
        }
    }
    
    public int ObtenerDinero(){
        return this.juegoUsuario.getDinero();
    }
    
    public void EstablecerDinero(int dinero){
        this.juegoUsuario.setDinero(dinero);
    }
    
    public ImageIcon getImagen(){
        return this.imagen;
    }
    
    public String getArmaObjeto(){
        return this.Arma;
    }
    
//    public String GetDinero(){
//        return Integer.toString(juegoUsuario.getDinero());
//    }
    
    public String GetCampos(){
        return Integer.toString(juegoUsuario.getCampos());
    }
    
    public void SetCampos(int campos){
        this.juegoUsuario.setCampos(campos);
    }
    
    public void EliminarSoldado(int index){
        this.juegoUsuario.EliminarSoldado(index);
    }
    
    public int getLegthArray(){
        return this.juegoUsuario.getLegthArray();
    }
    
    public Ejercito getSoldado(int index){
        return this.juegoUsuario.ObtenerSoldado(index);
    }
    
    public int GetNivelUsuario(){
        return this.juegoUsuario.getNivel();
    }
    
    public void CrearSoldados(String tipo, String nombre, String arma, int[] datos){
        Ejercito nuevo;
        if (tipo.equalsIgnoreCase("Soldados de contacto")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.SOLDADOCONTACTO, nombre, arma, datos);
            juegoUsuario.InsertarSoldado(nuevo);
        }else if (tipo.equalsIgnoreCase("Alcance medio")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.ALCANCEMEDIO, nombre, arma, datos);
            juegoUsuario.InsertarSoldado(nuevo);
        }else if (tipo.equalsIgnoreCase("Aéreos")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.AEREOS, nombre, arma, datos);
            juegoUsuario.InsertarSoldado(nuevo);
        }else if (tipo.equalsIgnoreCase("Choque")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.CHOQUE, nombre, arma, datos);
            juegoUsuario.InsertarSoldado(nuevo);
        }else if (tipo.equalsIgnoreCase("Impacto")){
            nuevo = FactoryEjercito.CrearSoldado(FactoryEjercito.Soldados.IMPACTO, nombre, arma, datos);
            juegoUsuario.InsertarSoldado(nuevo);
        }
    }
}
