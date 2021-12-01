/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Defensa.AereosD;
import Defensa.Bombas;
import Defensa.Cañon;
import Defensa.Defensa;
import Defensa.Edificio;
import Defensa.Mortero;
import Defensa.Torre;
import Ejercito.Aereos;
import Ejercito.AlcanceMedio;
import Ejercito.Choque;
import Ejercito.Ejercito;
import Ejercito.Impacto;
import Ejercito.SoldadoContacto;
import FactoryEjercito.FactoryEjercito;
import PartidasJugador.PartidaUsuario;
import PreJuego.ControladorElegirEjercito;
import PreJuego.ModeloElegirEjercito;
import PreJuego.VistaElegirEjercito;
import Threads.ThreadAviones;
import Threads.ThreadBomba;
import Threads.ThreadCamion;
import Threads.ThreadEdificio;
import Threads.ThreadMedioAlcance;
import Threads.ThreadMunicion;
import Threads.ThreadMuro;
import Threads.ThreadPueblo;
import Threads.ThreadSoldado;
import Threads.ThreadTanque;
import java.awt.PageAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ControladorVideoJuego implements ActionListener{
    private static int ANCHO = 1098;
    private static int LARGO = 698;
    private VistaVideoJuego vista;
    private ModeloVideoJuego modelo;
    private ArrayList<ThreadBomba> bombas;
    private ArrayList<ThreadPueblo> torres;
    private ArrayList<ThreadPueblo> cañones;
    private ArrayList<ThreadPueblo> aereos;
    private ArrayList<ThreadPueblo> mortero;
    private ArrayList<ThreadSoldado> contacto;
    private ArrayList<ThreadMedioAlcance> medianoAlcance;
    private ArrayList<ThreadAviones> aviones;
    private ArrayList<ThreadTanque> tanques;
    private ArrayList<ThreadCamion> carros;
    private ThreadEdificio Casa;
    private ArrayList<ThreadMuro> muros;
    private int Nivel;
    private PartidaUsuario partidaUsuario = new PartidaUsuario();
    private double porcentaje = 100;
    private String user = "";
    private String password = "";
    
    
    public ControladorVideoJuego(VistaVideoJuego vista, ModeloVideoJuego modelo){
        this.vista = vista;
        this.modelo = modelo;
        bombas = new ArrayList<ThreadBomba>();
        torres = new ArrayList<ThreadPueblo>();
        cañones = new ArrayList<ThreadPueblo>();
        aereos = new ArrayList<ThreadPueblo>();
        mortero = new ArrayList<ThreadPueblo>();
        contacto = new ArrayList<ThreadSoldado>();
        medianoAlcance = new ArrayList<ThreadMedioAlcance>();
        aviones = new ArrayList<ThreadAviones>();
        tanques = new ArrayList<ThreadTanque>();
        carros = new ArrayList<ThreadCamion>();
        Casa = new ThreadEdificio(this, 480, 260);
        muros = new ArrayList<ThreadMuro>();
        init();
    }
    
    public void ShowView(){
        this.vista.setVisible(true);
    }
    
    public void IniciarNormal(String PATH){
        DatosIniciales(PATH);
    }
    
    private void init(){
        this.vista.btnTrampa.addActionListener(this);
        this.vista.btnTrampa.setActionCommand("Trampa");
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnGuardar.setActionCommand("Guardar");
    }
    
    private void DatosIniciales(String PATH){
        String[] dividido = PATH.split("_");
        this.user = dividido[0];
        this.password = dividido[1];
        
        partidaUsuario = this.modelo.DeserealizarPartida(PATH);
        Nivel = partidaUsuario.juegoUsuario.getNivel();
        
        ArrayList<Integer> muros = new ArrayList<Integer>();
        if (Nivel < 6){;
            muros = this.partidaUsuario.juegoUsuario.getDistribuccionMuro();
            this.vista.SetMuro(muros);
            GuardarMuros(muros);
        }else{
            muros = this.partidaUsuario.juegoUsuario.getDistribuccionMuro();
            this.vista.SetMuro(muros);
            GuardarMuros(muros);
        }
        this.vista.setNivel(Integer.toString(Nivel));
        InsertarBombas();
        //this.vista.insertarBombas(this.partidaUsuario.juegoUsuario.getDistribuccionBombas());
        InsertarTorres();
        //this.vista.insertarTorres(this.partidaUsuario.juegoUsuario.getDistribuccionTorres());
        InsertarCañones();
        //this.vista.insertarCañones(this.partidaUsuario.juegoUsuario.getDistribuccionCañones());
        InsertarAereos();
        //this.vista.insertarAereos(this.partidaUsuario.juegoUsuario.getDistribuccionAereos());
        InsertarMorteros();
        //this.vista.insertarMorteros(this.partidaUsuario.juegoUsuario.getDistribuccionMorteros());
        InsertarEdificio();
        
        
        CargarEjercito();
    }
    
    private void EncenderThreads(){
        for (ThreadBomba bomba : bombas){
            bomba.start();
        }
        for (ThreadPueblo torre : torres){
            torre.start();
        }
        for (ThreadPueblo cañon : cañones){
            cañon.start();
        }
        for (ThreadPueblo aereo : aereos){
            aereo.start();
        }
        for (ThreadPueblo morter : mortero){
            morter.start();
        }
        for (ThreadSoldado soldado : contacto){
            soldado.start();
        }
        for (ThreadMedioAlcance midAlcance : medianoAlcance){
            midAlcance.start();
        }
        for (ThreadAviones avion : aviones){
            avion.start();
        }
        for (ThreadTanque tanque : tanques){
            tanque.start();
        }
        for (ThreadCamion carro : carros){
            carro.start();
        }
        for (ThreadMuro muro : muros){
            muro.start();
        }
        Casa.start();
    }
    
    private void CargarEjercito(){
        ArrayList<Ejercito> paraLuchar = new ArrayList<Ejercito>();
        paraLuchar = partidaUsuario.juegoUsuario.getParaLuchar();
        
        ArrayList<Ejercito> tempSoldado = new ArrayList<Ejercito>();
        ArrayList<Ejercito> tempMidAlcance = new ArrayList<Ejercito>();
        ArrayList<Ejercito> tempAereos = new ArrayList<Ejercito>();
        ArrayList<Ejercito> tempImpacto = new ArrayList<Ejercito>();
        ArrayList<Ejercito> tempChoque = new ArrayList<Ejercito>();
        
        for (Ejercito miembro : paraLuchar){
            if (miembro.getNombreClase().equalsIgnoreCase("Soldados de contacto")){
                tempSoldado.add(miembro);
            }else if (miembro.getNombreClase().equalsIgnoreCase("Alcance medio")){
                tempMidAlcance.add(miembro);
            }else if (miembro.getNombreClase().equalsIgnoreCase("Aéreos")){
                tempAereos.add(miembro);
            }else if (miembro.getNombreClase().equalsIgnoreCase("Impacto")){
                tempImpacto.add(miembro);
            }else if (miembro.getNombreClase().equalsIgnoreCase("Choque")){
                tempChoque.add(miembro);
            }
        }
        
        InsertarSoldados(tempSoldado);
        InsetarMedioAlcance(tempMidAlcance);
        InsertarAereos(tempAereos);
        InsertarImpacto(tempImpacto);
        InsertarChoque(tempChoque);
        
        //EncenderThreads();
    }
    
    private void InsertarSoldados(ArrayList<Ejercito> tempSoldado){
        ArrayList<Integer> distribuccionSoldado = new ArrayList<Integer>();
        distribuccionSoldado = this.partidaUsuario.juegoUsuario.getDistribuccionContacto();
        int contador = 0, indice = 0, coordX = 0, coordY = 0, frecDisparo = 0, pesoGolpe = 0, vidaChoque  = 0, direccion = 0;
        ArrayList<ImageIcon> movimiento = new ArrayList<ImageIcon>();
        ArrayList<ImageIcon> destruir = new ArrayList<ImageIcon>();
        SoldadoContacto Temporal = new SoldadoContacto("Soldado de Contacto", "Arma", "nombre", 1, 1, 1, 1, 1, 1, 1);
        
        for (Ejercito AuxChoque : tempSoldado){
            coordX = distribuccionSoldado.get(contador);
            coordY = distribuccionSoldado.get(contador + 1);
            frecDisparo = AuxChoque.getCantidadGolpes();
            pesoGolpe = AuxChoque.getFuerza();
            vidaChoque = AuxChoque.getVida();
            Temporal = (SoldadoContacto)AuxChoque;
            //direccion 1 >>>  2 <<<<
            if (coordX > 200){
                direccion = 2;
                movimiento = Temporal.getMovimientoL();
                destruir = Temporal.getDestruirL();
            }else{
                direccion = 1;
                movimiento = Temporal.getMovimientoR();
                destruir = Temporal.getDestruirR();
            }
            indice = this.vista.insertarSoldado(coordX, coordY, movimiento.get(0));
            System.out.println("Se inserto soldado" + coordX + "   " + coordY);
            contacto.add(new ThreadSoldado(indice, coordX, coordY, frecDisparo, pesoGolpe, this, movimiento, destruir, direccion, 30, vidaChoque));
            contador += 2;
        }
    }
    
    private void InsetarMedioAlcance(ArrayList<Ejercito> tempMidAlcance){
        ArrayList<Integer> distribuccionAlcance = new ArrayList<Integer>();
        distribuccionAlcance = this.partidaUsuario.juegoUsuario.getDistribuccionAlcanceMedio();
        int contador = 0, indice = 0, coordX = 0, coordY = 0, frecDisparo = 0, pesoGolpe = 0, vidaChoque  = 0, direccion = 0;
        ArrayList<ImageIcon> movimiento = new ArrayList<ImageIcon>();
        ArrayList<ImageIcon> municion = new ArrayList<ImageIcon>();
        ArrayList<ImageIcon> disparo = new ArrayList<ImageIcon>();
        AlcanceMedio Temporal = new AlcanceMedio("Alcance medio", "Arma", "nombre", 1, 1, 1, 1, 1, 1, 1);
        
        for (Ejercito AuxChoque : tempMidAlcance){
            coordX = distribuccionAlcance.get(contador);
            coordY = distribuccionAlcance.get(contador + 1);
            frecDisparo = AuxChoque.getCantidadGolpes();
            pesoGolpe = AuxChoque.getFuerza();
            vidaChoque = AuxChoque.getVida();
            Temporal = (AlcanceMedio)AuxChoque;
            municion = Temporal.getMunicion();
            //direccion 1 >>>  2 <<<<
            if (coordX > 200){
                direccion = 2;
                movimiento = Temporal.getMovimientoL();
                disparo = Temporal.getDispararL();
            }else{
                direccion = 1;
                movimiento = Temporal.getMovimientoR();
                disparo = Temporal.getDispararR();
            }
            indice = this.vista.insertarMidAlcance(coordX, coordY, movimiento.get(0));
            medianoAlcance.add(new ThreadMedioAlcance(vidaChoque, coordX, coordY, indice, frecDisparo, pesoGolpe, this, movimiento, municion, direccion, 90, disparo));
            contador += 2;
        }
    } 
        
    private void InsertarAereos(ArrayList<Ejercito> tempAviones){
        ArrayList<Integer> distribuccionAviones = new ArrayList<Integer>();
        distribuccionAviones = this.partidaUsuario.juegoUsuario.getDistribuccionAviones();
        int contador = 0, indice = 0, coordX = 0, coordY = 0, frecDisparo = 0, pesoGolpe = 0, vidaChoque  = 0, direccion = 0;
        ImageIcon imagen = new ImageIcon();
        ArrayList<ImageIcon> municion = new ArrayList<ImageIcon>();
        Aereos Temporal = new Aereos("Aereos", "Arma", "nombre", 1, 1, 1, 1, 1, 1, 1);
        
        for (Ejercito AuxChoque : tempAviones){
            coordX = distribuccionAviones.get(contador);
            coordY = distribuccionAviones.get(contador + 1);
            frecDisparo = AuxChoque.getCantidadGolpes();
            pesoGolpe = AuxChoque.getFuerza();
            vidaChoque = AuxChoque.getVida();
            Temporal = (Aereos)AuxChoque;
            municion = Temporal.getBalas();
            //direccion 1 >>>  2 <<<<
            if (coordX > 200){
                direccion = 2;
                imagen = Temporal.getMovimientoLeft();
            }else{
                direccion = 1;
                imagen = Temporal.getMovimientoRight();
            }
            indice = this.vista.insertarAviones(coordX, coordY, imagen);
            aviones.add(new ThreadAviones(indice, coordX, coordY, frecDisparo, pesoGolpe, this, vidaChoque, imagen, municion, direccion));
            contador += 2;
        }
    }
   
    private void InsertarImpacto(ArrayList<Ejercito> tempImpacto){
        ArrayList<Integer> distribuccionImpacto = new ArrayList<Integer>();
        distribuccionImpacto = this.partidaUsuario.juegoUsuario.getDistribuccionCamion();
        int contador = 0, indice = 0, coordX = 0, coordY = 0, frecDisparo = 0, pesoGolpe = 0, vidaChoque  = 0, direccion = 0;
        ImageIcon imagen = new ImageIcon();
        Impacto Temporal = new Impacto("Impacto", "Arma", "nombre", 1, 1, 1, 1, 1, 1, 1);
        
        for (Ejercito AuxChoque : tempImpacto){
            coordX = distribuccionImpacto.get(contador);
            coordY = distribuccionImpacto.get(contador + 1);
            frecDisparo = AuxChoque.getCantidadGolpes();
            pesoGolpe = AuxChoque.getFuerza();
            vidaChoque = AuxChoque.getVida();
            Temporal = (Impacto)AuxChoque;
            //direccion 1 >>>  2 <<<<
            if (coordX > 200){
                direccion = 2;
                imagen = Temporal.getMovimientoLeft();
            }else{
                direccion = 1;
                imagen = Temporal.getMovimientoRight();
            }
            indice = this.vista.insertarCarro(coordX, coordY, imagen);
            carros.add(new ThreadCamion(indice, coordX, coordY, frecDisparo, pesoGolpe, this, vidaChoque, imagen, direccion, 100));
            contador += 2;
        }
    }
    
    private void InsertarChoque(ArrayList<Ejercito> tempChoque){
        ArrayList<Integer> distribuccionChoque = new ArrayList<Integer>();
        distribuccionChoque = this.partidaUsuario.juegoUsuario.getDistribuccionTanques();
        int contador = 0, indice = 0, coordX = 0, coordY = 0, frecDisparo = 0, pesoGolpe = 0, vidaChoque  = 0, direccion = 0;
        ImageIcon imagen = new ImageIcon();
        ArrayList<ImageIcon> municion = new ArrayList<ImageIcon>();
        Choque Temporal = new Choque("Tanque", "Arma", "nombre", 1, 1, 1, 1, 1, 1, 1);
        
        for (Ejercito AuxChoque : tempChoque){
            coordX = distribuccionChoque.get(contador);
            coordY = distribuccionChoque.get(contador + 1);
            frecDisparo = AuxChoque.getCantidadGolpes();
            pesoGolpe = AuxChoque.getFuerza();
            vidaChoque = AuxChoque.getVida();
            Temporal = (Choque)AuxChoque;
            municion = Temporal.getMunicion();
            //direccion 1 >>>  2 <<<<
            if (coordX > 200){
                direccion = 2;
                imagen = Temporal.getMovimientoLeft();
            }else{
                direccion = 1;
                imagen = Temporal.getMovimientoRight();
            }
            indice = this.vista.insertarTanque(coordX, coordY, imagen);
            tanques.add(new ThreadTanque(indice, coordX, coordY, frecDisparo, pesoGolpe, this, imagen, municion, vidaChoque, direccion));
            contador += 2;
        }
    }
    
    private void InsertarMorteros(){
        ArrayList<Integer> DistribuccionMorteros = this.partidaUsuario.juegoUsuario.getDistribuccionMorteros();
        int indice = 0, coordX = 0, coordY = 0, pesoGolpe = 0, tipo = 0, vida = 0; //tipo --> 1= bomba, 2 = torres, 3 = cañones, 4 = aereos, 5 = morteros
        double frecDisparo = 0;
        ArrayList<Defensa> equipoPueblo = partidaUsuario.juegoUsuario.getPueblo().getEquipoPueblo();
        Mortero temporal = new Mortero(1,1,"Mortero", 0, 1);
        ArrayList<ImageIcon> Municiones = new ArrayList<ImageIcon>();
        
        for (Defensa equipo : equipoPueblo){
            if (equipo.getNameClass().equalsIgnoreCase("Mortero")){
                temporal = (Mortero)equipo;
                vida = equipo.getVida();
                pesoGolpe = equipo.getFuerzaGolpe();
                frecDisparo = equipo.getFrecuenciaDisparo();
                Municiones = temporal.getMunicion();
                break;
            }
        }
        
        tipo = 5;
        for (int i = 0; i < (DistribuccionMorteros.size() / 2); i++){
            coordX = DistribuccionMorteros.get( i * 2);
            coordY = DistribuccionMorteros.get( (i * 2) + 1);
            indice = this.vista.insertarMorteros(coordX, coordY);
            mortero.add(new ThreadPueblo(indice, coordX, coordY, frecDisparo, pesoGolpe, this, Municiones, tipo, vida));
            i++;
        }
    }
    
    private void InsertarAereos(){
        ArrayList<Integer> DistribuccionAereos = this.partidaUsuario.juegoUsuario.getDistribuccionAereos();
        int indice = 0, coordX = 0, coordY = 0, pesoGolpe = 0, tipo = 0, vida = 0; //tipo --> 1= bomba, 2 = torres, 3 = cañones, 4 = aereos, 5 = morteros
        double frecDisparo = 0;
        ArrayList<Defensa> equipoPueblo = partidaUsuario.juegoUsuario.getPueblo().getEquipoPueblo();
        AereosD temporal = new AereosD(1,1,"Aereos", 0, 1);
        ArrayList<ImageIcon> Municiones = new ArrayList<ImageIcon>();
        
        for (Defensa equipo : equipoPueblo){
            if (equipo.getNameClass().equalsIgnoreCase("Aereos")){
                temporal = (AereosD)equipo;
                vida = equipo.getVida();
                pesoGolpe = equipo.getFuerzaGolpe();
                frecDisparo = equipo.getFrecuenciaDisparo();
                Municiones = temporal.getMunicion();
                break;
            }
        }
        
        tipo = 5;
        for (int i = 0; i < (DistribuccionAereos.size() / 2); i++){
            coordX = DistribuccionAereos.get( i * 2);
            coordY = DistribuccionAereos.get( (i * 2) + 1);
            indice = this.vista.insertarAereos(coordX, coordY);
            aereos.add(new ThreadPueblo(indice, coordX, coordY, frecDisparo, pesoGolpe, this, Municiones, tipo, vida));
            i++;
        }
    }
    
    private void InsertarCañones(){
        ArrayList<Integer> DistribuccionCañones = this.partidaUsuario.juegoUsuario.getDistribuccionCañones();
        int indice = 0, coordX = 0, coordY = 0, pesoGolpe = 0, tipo = 0, vida = 0; //tipo --> 1= bomba, 2 = torres, 3 = cañones, 4 = aereos, 5 = morteros
        double frecDisparo = 0;
        ArrayList<Defensa> equipoPueblo = partidaUsuario.juegoUsuario.getPueblo().getEquipoPueblo();
        Cañon temporal = new Cañon(1,1,"Cañon", 0, 1);
        ArrayList<ImageIcon> Municiones = new ArrayList<ImageIcon>();
        
        for (Defensa equipo : equipoPueblo){
            if (equipo.getNameClass().equalsIgnoreCase("Cañon")){
                temporal = (Cañon)equipo;
                vida = equipo.getVida();
                pesoGolpe = equipo.getFuerzaGolpe();
                frecDisparo = equipo.getFrecuenciaDisparo();
                Municiones = temporal.getMunicion();
                break;
            }
        }
        
        tipo = 3;
        for (int i = 0; i < (DistribuccionCañones.size() / 2); i++){
            coordX = DistribuccionCañones.get( i * 2);
            coordY = DistribuccionCañones.get( (i * 2) + 1);
            indice = this.vista.insertarCañones(coordX, coordY);
            cañones.add(new ThreadPueblo(indice, coordX, coordY, frecDisparo, pesoGolpe, this, Municiones, tipo, vida));
            i++;
        }
    }
    
    private void InsertarTorres(){
        ArrayList<Integer> DistribuccionTorres = this.partidaUsuario.juegoUsuario.getDistribuccionTorres();
        int indice = 0, coordX = 0, coordY = 0, pesoGolpe = 0, tipo = 0, vida = 0; //tipo --> 1= bomba, 2 = torres, 3 = cañones, 4 = aereos, 5 = morteros
        double frecDisparo = 0;
        ArrayList<Defensa> equipoPueblo = partidaUsuario.juegoUsuario.getPueblo().getEquipoPueblo();
        Torre temporal = new Torre(1,1,"Torre", 0, 1);
        ArrayList<ImageIcon> Municiones = new ArrayList<ImageIcon>();
        
        for (Defensa equipo : equipoPueblo){
            if (equipo.getNameClass().equalsIgnoreCase("Torre")){
                temporal = (Torre)equipo;
                vida = equipo.getVida();
                pesoGolpe = equipo.getFuerzaGolpe();
                frecDisparo = equipo.getFrecuenciaDisparo();
                Municiones = temporal.getMunicion();
                break;
            }
        }
        
        tipo = 2;
        for (int i = 0; i < (DistribuccionTorres.size() / 2); i++){
            coordX = DistribuccionTorres.get( i * 2);
            coordY = DistribuccionTorres.get( (i * 2) + 1);
            indice = this.vista.insertarTorres(coordX, coordY);
            torres.add(new ThreadPueblo(indice, coordX, coordY, frecDisparo, pesoGolpe, this, Municiones, tipo, vida));
            i++;
        }
        
    }
    
    private void InsertarEdificio(){
        int x = 480, y = 260;

        ArrayList<Defensa> equipoPueblo = partidaUsuario.juegoUsuario.getPueblo().getEquipoPueblo();
        Edificio edificio = new Edificio(1, 10, "Edificio", 0, 0);
        int vidaEdificio = 0, pesoGolpe = 0, frecDisparo = 0;
        
        for (Defensa equipo : equipoPueblo){
            if (equipo.getNameClass().equalsIgnoreCase("Edificio")){
                edificio = (Edificio)equipo;
                vidaEdificio = equipo.getVida();
                pesoGolpe = equipo.getFuerzaGolpe();
                frecDisparo = equipo.getFrecuenciaDisparo();
                break;
            }
        }
        this.vista.CrearEdificio(x, y);
        Casa = new ThreadEdificio(this, x, y);
    }
    
    private void InsertarBombas(){
        ArrayList<Integer> DistribuccionBombas = this.partidaUsuario.juegoUsuario.getDistribuccionBombas();
        int indice, coordX, coordY, modo, alcance = 0;
        ArrayList<Defensa> equipoPueblo = partidaUsuario.juegoUsuario.getPueblo().getEquipoPueblo();
        Bombas temporal = new Bombas(1, 1, "Bombas", 1, 1);
        ArrayList<ImageIcon> explosion = new ArrayList<ImageIcon>();
        
        for (Defensa equipo : equipoPueblo){
            if (equipo.getNameClass().equalsIgnoreCase("Bombas")){
                temporal = (Bombas)equipo;
                alcance = temporal.getAlcance();
                explosion = temporal.getExplosion();
                break;
            }
        }
        
        for (int i = 0; i < (DistribuccionBombas.size() / 2); i++){
            coordX = DistribuccionBombas.get( i * 2);
            coordY = DistribuccionBombas.get( (i * 2) + 1);
            indice = this.vista.insertarBombas(coordX, coordY);
            bombas.add(new ThreadBomba(coordX, coordY, indice, explosion, this, alcance));
            i++;
        }
    }
    
    private synchronized void ReducirVidaJuego(int defensa){
        double[] percentages = new double[7];
        Porcentajes nuevo = new Porcentajes();
        percentages = nuevo.obtenerPorcentajes(Nivel);
        switch(defensa){
            case 0: this.porcentaje -= percentages[0]; break; //Muros
            case 1: this.porcentaje -= percentages[1]; break; //Bombas
            case 2: this.porcentaje -= percentages[2]; break; //Torres
            case 3: this.porcentaje -= percentages[3]; break; //Cañones
            case 4: this.porcentaje -= percentages[4]; break; //Aereos
            case 5: this.porcentaje -= percentages[5]; break; //Morteros
            case 6: this.porcentaje -= percentages[6]; break; //Edificio
        }
        this.vista.setVida(Double.toString(porcentaje));
    }
    
    private void GuardarMuros(ArrayList<Integer> distribuccion){
        int vida = 10; //Esto debe leerse del objeto deserealizado
        int contador = 0;
        for (int i = 0; i < distribuccion.size(); i++) {
            muros.add(new ThreadMuro(distribuccion.get(i), distribuccion.get(i + 1), vida, this, contador));
            i++;
            contador++;
        }
    }
    
    public synchronized void EliminarMuro(int indice){
        this.vista.EliminarMuro(indice, Nivel);
        int i;
        for(i = 0; i < muros.size(); i++){
            if (muros.get(i).getIndice() == indice){
                break;
            }
        }
        this.muros.remove(i);
        ReducirVidaJuego(0);
    }

    //Se salta el nivel y pasa al siguiente con todo lo que implica (obtener los bienes, aumentar el nivel de los
    //componentes..etc
    private void BotonTrampaAction(){
        if (Nivel < 10){
            this.modelo.PasarAlSiguienteNivel(partidaUsuario);

            //Regresa a elegir el ejercito
            VistaElegirEjercito vista = new VistaElegirEjercito();
            ModeloElegirEjercito modelo = new ModeloElegirEjercito(user, password);
            ControladorElegirEjercito controller = new ControladorElegirEjercito(modelo, vista);
            controller.ShowView();
            this.vista.dispose();
        }else{
            String[] options = {"Ganar Juego", "Generar más niveles"};
            int x = JOptionPane.showOptionDialog(null, "Escoja una opcion",
                "Seleccione un modo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (x == 0){
                JOptionPane.showMessageDialog(null, "Felicidades ha ganado\n el juego!!!");
                this.vista.dispose();
            }else{
                this.modelo.PasarAlSiguienteNivel(partidaUsuario);

                //Regresa a elegir el ejercito
                VistaElegirEjercito vista = new VistaElegirEjercito();
                ModeloElegirEjercito modelo = new ModeloElegirEjercito(user, password);
                ControladorElegirEjercito controller = new ControladorElegirEjercito(modelo, vista);
                controller.ShowView();
                this.vista.dispose();
            }
        }
    }
    //Busca a los enemigos (los del pueblo) que se encuentran en la mira
    public synchronized int IdentificarEnemigo(int x, int y, int direccion){
        int Address = 0;
        Address = VerificarEnemigoEnMira.VerificarEnemigoMira(x, y, direccion, torres, cañones, aereos, mortero, Casa, muros);
        return Address;
    }
    
    //Baja la vida de las torres según el peso de cada golpe
    private synchronized void BajarVidaTorres(int index, int PesoGolpe){
        for (ThreadPueblo torre : torres){
            if (torre.GetIndice() == index)
                torre.ReducirVida(PesoGolpe);
        }
    }
    //Baja la vida de los cañones según el peso de cada golpe
    private synchronized void BajarVidaCañones(int index, int PesoGolpe){
        for (ThreadPueblo cañon : cañones){
            if (cañon.GetIndice() == index)
                cañon.ReducirVida(PesoGolpe);
        }
    }
    //Baja la vida de los cañones según el peso de cada golpe
    private synchronized void BajarVidaAereos(int index, int PesoGolpe){
        for (ThreadPueblo aereo : aereos){
            if (aereo.GetIndice() == index)
                aereo.ReducirVida(PesoGolpe);
        }
    }
    //Baja la vida de los cañones según el peso de cada golpe
    private synchronized void BajarVidaMorteros(int index, int PesoGolpe){
        for (ThreadPueblo morter : mortero){
            if (morter.GetIndice() == index)
                morter.ReducirVida(PesoGolpe);
        }
    }
    //Baja la vida de los cañones según el peso de cada golpe
    private synchronized void BajarVidaCasa(int PesoGolpe){
        this.Casa.BajarVida(PesoGolpe);
    }
    //Baja la vida de los cañones según el peso de cada golpe
    private synchronized void BajarVidaMuro(int index, int PesoGolpe){
        for (ThreadMuro muro : muros){
            if (muro.getIndice() == index)
                muro.ReducirVida(PesoGolpe);
        }
    }
    public synchronized void BajarVidaPueblo(int tipoDefensa, int indice, int PesoGolpe){
        switch(tipoDefensa){
            //case 1: BajarVidaBomba(indice); break;
            case 2: BajarVidaTorres(indice, PesoGolpe); break;
            case 3: BajarVidaCañones(indice, PesoGolpe); break;
            case 4: BajarVidaCañones(indice, PesoGolpe); break;
            case 5: BajarVidaAereos(indice, PesoGolpe); break;
            case 6: BajarVidaMorteros(indice, PesoGolpe); break;
            case 7: BajarVidaCasa(PesoGolpe); break;
            case 8: BajarVidaMuro(indice, PesoGolpe); break;
        }
    }
    
    public void EliminarCasa(){
        this.vista.EliminarEdificio();
        this.Casa = null;
        ReducirVidaJuego(6);
        //Dar ganador
    }
    
    public synchronized void EliminarAvion(int index){
        this.vista.EliminarAvion(index);
        int i;
        for (i = 0; i < aviones.size(); i++){
            if (aviones.get(i).GetIndice() == index)
                break;
        }
        this.aviones.remove(i);
    }
    
    public synchronized void EliminarTanque(int index){
        this.vista.EliminarTanque(index);
        int i;
        for (i = 0; i < tanques.size(); i++){
            if (tanques.get(i).GetIndice() == index)
                break;
        }
        this.tanques.remove(i);
    }
    
    public synchronized void EliminarCamion(int index){
        this.vista.EliminarCamion(index);
        int i;
        for (i = 0; i < carros.size(); i++){
            if (carros.get(i).GetIndice() == index)
                break;
        }
        this.carros.remove(i);
    }
    
    public synchronized void EliminarMedioAlcance(int indice){
        this.vista.EliminarMedioAlcance(indice);
        int i;
        for (i = 0; i < medianoAlcance.size(); i++){
            if (medianoAlcance.get(i).GetIndice() == indice)
                break;
        }
        this.medianoAlcance.remove(i);
    }
    
    public synchronized void EliminarSoldado(int indice){
        this.vista.EliminarSoldado(indice);
        int i;
        for (i = 0; i < contacto.size(); i++){
            if (contacto.get(i).GetIndice() == indice)
                break;
        }
        this.contacto.remove(i);
    }
    
    public synchronized void CambiarLabelSoldado(int indice, ImageIcon icon){
        this.vista.CambiarIconSoldado(indice, icon);
    }
    
    public synchronized void MoverSoldado(int indice, int x, int y){
        this.vista.MoverSoldado(indice, x, y);
    }    
    
    //Utilizado unicamente para los soldados de contacto, es utilizado para saber el componente que se encuentra más
    //cercano al personaje del ejercito, y sabiendo esto, realizar el ataque
    public synchronized int[] ChoqueConEnemigo(int x, int y){
        int coordenadas[] = {0,0};
        coordenadas = VerificarCercanoPueblo.VerificarCercano(bombas, torres, cañones, aereos, mortero, x, y, Casa, muros);
        return coordenadas;
    }
       
    //Verifica si una bala choca con un enemigo
    //Modo: //1: es del ejercito y ataca al pueblo///2: es del pueblo y ataca al ejercito
    public synchronized int[] ChoqueMunicion(int index, int modo, int x, int y, int direccion){
        int[] resultado = {0, 0};
        if (modo == 2){ //Del pueblo al ejercito
            resultado = VerificarChoqueMunicion.choqueConSoldados(x, y, this.contacto, direccion);
            if (resultado[0] != 0)
                return resultado;
            resultado = VerificarChoqueMunicion.choqueAviones(x, y, this.aviones, direccion);
            if (resultado[0] != 0)
                return resultado;
            resultado = VerificarChoqueMunicion.choqueAlcanceMedio(x, y, this.medianoAlcance, direccion);
            if (resultado[0] != 0)
                return resultado;
            resultado = VerificarChoqueMunicion.choqueTanque(x, y, this.tanques, direccion);
            if (resultado[0] != 0)
                return resultado;
            resultado = VerificarChoqueMunicion.choqueCamion(x, y, this.carros, direccion);
            return resultado;
        }else{ //Del ejercito al pueblo
            resultado = VerificarChoqueMunicion.choqueTorres(x, y, this.torres, direccion);
            if (resultado[0] != 0)
                return resultado;
            resultado = VerificarChoqueMunicion.choqueCañones(x, y, this.cañones, direccion);
            if (resultado[0] != 0)
                return resultado;
            resultado = VerificarChoqueMunicion.choqueAereos(x, y, this.aereos, direccion);
            if (resultado[0] != 0)
                return resultado;
            resultado = VerificarChoqueMunicion.choqueMorteros(x, y, this.mortero, direccion);
            if (resultado[0] != 0)
                return resultado;
            resultado = VerificarChoqueMunicion.choqueEdificio(x, y, this.Casa, direccion);
            if (resultado[0] != 0)
                return resultado;
            resultado = VerificarChoqueMunicion.choqueMuros(x, y, this.muros, direccion);
            return resultado;
        }
    }
    
    //Elimina el componente del pueblo cuando su vida es cero
    public synchronized void EliminarComponentePueblo(int tipoDefensa, int index){
        //1= bomba, 2 = torres, 3 = cañones, 4 = aereos, 5 = morteros
        int contador = 0;
        if (tipoDefensa == 1){
            for (ThreadBomba bomba : bombas){
                if (index == bomba.getIndice()){
                    bomba.ApagarBomba();
                    this.vista.EliminarBomba(index);
                    break;
                }
                contador++;
            }
            this.bombas.remove(contador);
            ReducirVidaJuego(tipoDefensa);
        }else if (tipoDefensa == 2){
            contador = 0;
            for (ThreadPueblo torre : torres){
                if (index == torre.getIndice()){
                    torre.ApagarFuncionamiento();
                    this.vista.EliminarTorre(index);
                    break;
                }
                contador++;
            }
            this.torres.remove(contador);
            ReducirVidaJuego(tipoDefensa);
        }else if (tipoDefensa == 3){
            contador = 0;
            for (ThreadPueblo cañon : cañones){
                if (index == cañon.getIndice()){
                    cañon.ApagarFuncionamiento();
                    this.vista.EliminarCañones(index);
                    break;
                }
                contador++;
            }
            this.cañones.remove(contador);
            ReducirVidaJuego(tipoDefensa);
        }else if (tipoDefensa == 4){
            contador =0;
            for (ThreadPueblo aereos : aereos){
                if (index == aereos.getIndice()){
                    aereos.ApagarFuncionamiento();
                    this.vista.EliminarAereos(index);
                    break;
                }
                contador++;
            }
            this.aereos.remove(contador);
            ReducirVidaJuego(tipoDefensa);
        }else if (tipoDefensa == 5){
            contador = 0;
            for (ThreadPueblo mortero : mortero){
                if (index == mortero.getIndice()){
                    mortero.ApagarFuncionamiento();
                    this.vista.EliminarMorteros(index);
                    break;
                }
                contador++;
            }
            this.mortero.remove(contador);
            ReducirVidaJuego(tipoDefensa);
        }
    }
    
    //Verifica si hay algun enemigo en la mira, esto solo es válido cuando está a una distancia correspondiente
    //y ademas cumple con las 8 direcciones básicas: NORTE, SUR, ESTE, OESTE, NOR-ESTE, NOR-OESTE, SUR-ESTE, SUR-OESTE
    public synchronized int[] EnemigoEnMira(int x, int y, int alcance, int direccion){
        int[] enemigo = {0, 0, 0};
        enemigo = VerificarEnemigoMira.VerificarEnemigoEnMira(direccion, x, y, alcance, torres, cañones, aereos, mortero, Casa, muros);
        return enemigo;
    }
    
    private synchronized void BajarVidaSoldado(int indice, int pesoGolpe){
        for (ThreadSoldado soldier : contacto){
            if (soldier.GetIndice() == indice){
                soldier.ReducirVida(pesoGolpe);
                break;
            }
        }
    }
    
    private synchronized void BajarVidaMedioAlcance(int indice, int pesoGolpe){
        for (ThreadMedioAlcance AlcanceMid : medianoAlcance){
            if (AlcanceMid.GetIndice() == indice){
                AlcanceMid.ReducirVida(pesoGolpe);
                break;
            }
        }
    }
    private synchronized void BajarVidaCamion(int indice, int pesoGolpe){
        for (ThreadCamion carro : carros){
            if (carro.GetIndice() == indice){
                carro.ReducirVida(pesoGolpe);
                break;
            }
        }
    }
    private synchronized void BajarVidaTanque(int indice, int pesoGolpe){
        for (ThreadTanque tanque : tanques){
            if (tanque.GetIndice() == indice){
                tanque.ReducirVida(pesoGolpe);
                break;
            }
        }
    }
    private synchronized void BajarVidaAvion(int indice, int pesoGolpe){
        for (ThreadAviones avion : aviones){
            if (avion.GetIndice() == indice){
                avion.ReducirVida(pesoGolpe);
                break;
            }
        }
    }
    
    //Baja la vida del objeto con que colisiona
    public synchronized void BajarVidaMunicion(int index, int grupo, int indice, int pesoGolpe){
        switch(grupo){
            case 1: BajarVidaSoldado(indice, pesoGolpe); break;
            case 2: BajarVidaMedioAlcance(indice, pesoGolpe); break;
            case 3: BajarVidaCamion(indice, pesoGolpe);break;
            case 4: BajarVidaTanque(indice, pesoGolpe);break;
            case 5: BajarVidaAvion(indice, pesoGolpe);break;
            case 6: BajarVidaTorres(index, pesoGolpe); break;
            case 7: BajarVidaCañones(index, pesoGolpe);break;
            case 8: BajarVidaAereos(index, pesoGolpe);break;
            case 9: BajarVidaMorteros(index, pesoGolpe);break;
            case 10: BajarVidaCasa(pesoGolpe);break;
            case 11: BajarVidaMuro(index, pesoGolpe);break;
        }
        EliminarMunicion(index);
    }
    
    //Eliminar la municion de pantalla
    public synchronized void EliminarMunicion(int index){
        int i;
        for(i = 0; i < bombas.size(); i++){
            if (bombas.get(index).GetIndice() == index)
                break;
        }
        this.bombas.get(i).ApagarBomba();
        this.bombas.remove(i);
        this.vista.EliminarBala(index);
    }
    
    //Mueve la municion del que disparo 
    public synchronized void moverMunicion(int indice,int x,int y){
        this.vista.avanzarBala(indice, x, y);
    }
    
    //Verifica que si debe explotar una bomba
    public synchronized boolean explotarBomba(int indice, int x, int y){
        return true;
    }
    
    //Cambia el icono del label que representa a la bomba
    public synchronized void CambiarLabelBomba(int indice, ImageIcon explosion){
        this.vista.CambiarBomba(explosion, indice);
    }
    
    //Reduce una vida al ejercito cuando explota una bomba (para reducir la vida debe estar dentro del rango
    public synchronized void ReducirVidaejercito(int x,int y,int alcance){
        for (ThreadSoldado soldado : contacto){
            if (x + alcance >= soldado.getX() && x - alcance <= soldado.getX() && y - alcance <= soldado.getY() && y + alcance >= soldado.getY()){
                soldado.ReducirVida(1);
            }
        }
        for (ThreadMedioAlcance midAlcance : medianoAlcance){
            if (x + alcance >= midAlcance.getX() && x - alcance <= midAlcance.getX() && y - alcance <= midAlcance.getY() && y + alcance >= midAlcance.getY()){
                midAlcance.ReducirVida(1);
            }
        }
        for (ThreadCamion carro : carros){
            if (x + alcance >= carro.getX() && x - alcance <= carro.getX() && y - alcance <= carro.getY() && y + alcance >= carro.getY()){
                carro.ReducirVida(1);
            }
        }
        for (ThreadTanque tanque: tanques){
            if (x + alcance >= tanque.getX() && x - alcance <= tanque.getX() && y - alcance <= tanque.getY() && y + alcance >= tanque.getY()){
                tanque.ReducirVida(1);
            }
        }
        for (ThreadAviones avion: aviones){
            if (x + alcance >= avion.getX() && x - alcance <= avion.getX() && y - alcance <= avion.getY() && y + alcance >= avion.getY()){
                avion.ReducirVida(1);
            }
        }
    }
    
    //Elimina la bomba que explota
    public synchronized void EliminarBomba(int indice){
        this.vista.EliminarBomba(indice);
    }
    
    //Verifica si debe realizar un disparo a un enemigo y en caso de que deba realizar el disparo, devuelve
    //la direccion a la cual debe disparar, en caso de que no tenga enemigos en mira, devuelve un cero
    public synchronized int RealizarDisparoPueblo(int indice, int x, int y, int TipoDefensa){
        return VerificarAtaque.VerificarPosibleAtaque(x, y, TipoDefensa, aviones, contacto, medianoAlcance, tanques, carros);
    }
    
    //Crea una nueva bala
    public synchronized void RealizarDisparo(int x,int y,int pesoGolpe,int direccion, ImageIcon municion, int modo){
         //modo     1: es del ejercito y ataca al pueblo///2: es del pueblo y ataca al ejercito
        int indice = this.vista.crearBala(municion, x, y);
        ThreadMunicion nuevo = new ThreadMunicion(direccion, x, y, indice, pesoGolpe, modo, this);
        nuevo.start();
    }
    
    private void BotonGuardarAction(){
        this.partidaUsuario.setLblMuroMenor(this.vista.getLblMuroMenor());
        this.partidaUsuario.setLblMuroMayor(this.vista.getLblMuroMayor());
        this.partidaUsuario.setEdificio(this.vista.getEdificio());
        this.partidaUsuario.setBombas(this.vista.getBombas());
        this.partidaUsuario.setTorres(this.vista.getTorres());
        this.partidaUsuario.setCañones(this.vista.getCañones());
        this.partidaUsuario.setAereos(this.vista.getAereos());
        this.partidaUsuario.setMorteros(this.vista.getMorteros());
        this.partidaUsuario.setMorteros(this.vista.getMorteros());
        this.partidaUsuario.setBalas(this.vista.getBalas());
        this.partidaUsuario.setSoldados(this.vista.getSoldados());
        this.partidaUsuario.setAlcanceMedio(this.vista.getAlcanceMedio());
        this.partidaUsuario.setTanque(this.vista.getTanque());
        this.partidaUsuario.setCarro(this.vista.getCarro());
        this.partidaUsuario.setAviones(this.vista.getAviones());
        this.partidaUsuario.setThreadBombas(bombas);
        this.partidaUsuario.setThreadTorres(torres);
        this.partidaUsuario.setThreadCañones(cañones);
        this.partidaUsuario.setThreadAereos(aereos);
        this.partidaUsuario.setThreadMortero(mortero);
        this.partidaUsuario.setThreadContacto(contacto);
        this.partidaUsuario.setThreadMedianoAlcance(medianoAlcance);
        this.partidaUsuario.setThreadAviones(aviones);
        this.partidaUsuario.setThreadTanques(tanques);
        this.partidaUsuario.setThreadCarros(carros);
        this.partidaUsuario.setThreadCasa(Casa, this);
        this.partidaUsuario.setThreadMuros(muros);
        this.partidaUsuario.juegoUsuario.setPorcentaje(this.porcentaje);
        
    }
    
    private void SetterAll(){
        this.vista.setLblMuroMenor(partidaUsuario.getLblMuroMenor());
        this.vista.setLblMuroMayor(partidaUsuario.getLblMuroMayor());
        this.vista.setEdificio(partidaUsuario.getEdificio());
        this.vista.setBombas(partidaUsuario.getBombas());
        this.vista.setTorres(partidaUsuario.getTorres());
        this.vista.setCañones(partidaUsuario.getCañones());
        this.vista.setAereos(partidaUsuario.getAereos());
        this.vista.setMorteros(partidaUsuario.getMorteros());
        this.vista.setBalas(partidaUsuario.getBalas());
        this.vista.setSoldados(partidaUsuario.getSoldados());
        this.vista.setAlcanceMedio(partidaUsuario.getAlcanceMedio());
        this.vista.setTanque(partidaUsuario.getTanque());
        this.vista.setCarro(partidaUsuario.getCarro());
        this.vista.setAviones(partidaUsuario.getAviones());
        this.bombas = partidaUsuario.getThreadBombas();
        this.torres = partidaUsuario.getThreadTorres();
        this.cañones = partidaUsuario.getThreadCañones();
        this.aereos = partidaUsuario.getThreadAereos();
        this.mortero = partidaUsuario.getThreadMortero();
        this.contacto = partidaUsuario.getThreadContacto();
        this.medianoAlcance = partidaUsuario.getThreadMedianoAlcance();
        this.aviones = partidaUsuario.getThreadAviones();
        this.tanques = partidaUsuario.getThreadTanques();
        this.carros = partidaUsuario.getThreadCarros();
        this.Casa = partidaUsuario.getThreadCasa();
        this.muros = partidaUsuario.getThreadMuros();
        
        this.vista.setBienes(Integer.toString(partidaUsuario.juegoUsuario.getDinero()));
        this.vista.setNivel(Integer.toString(partidaUsuario.juegoUsuario.getNivel()));
        this.vista.setVida(Double.toString(partidaUsuario.juegoUsuario.getPorcentaje()));
        this.porcentaje = partidaUsuario.juegoUsuario.getPorcentaje();
        this.Nivel = partidaUsuario.juegoUsuario.getNivel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String boton = e.getActionCommand();
        if (boton.equalsIgnoreCase("Trampa")){
            BotonTrampaAction();
        }else if (boton.equalsIgnoreCase("Guardar")){
            BotonGuardarAction();
        }
    }
}
