/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargarPartida;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import FilesManagers.FileManager;


/**
 *
 * @author Jose
 */
public class ControladorCargarPartida implements ListSelectionListener, ActionListener{

    private VistaCargarPartida vista;
    private String usuario;
    private String contrase;
    
    private static final String PARTIDAS_GUARDADAS = "/partidas.txt";
    
    public ControladorCargarPartida(VistaCargarPartida vista, String usuario, String contrase) {
        this.vista = vista;
        this.usuario = usuario;
        this.contrase = contrase;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            vista.getCargarButton().setEnabled(true);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String partidaSeleccionada = vista.getPartidasGuardadasList().getSelectedValue();
        cargarPartidaSeleccionada(partidaSeleccionada);
    }

    //Muestra las partidas guardadas en la lista
    public void mostrarPartidasGuardadas(){
        ArrayList<String> partidas = leerPartidasGuardadas();
        DefaultListModel<String> model = new DefaultListModel<>();
        for(String partida:partidas){
            model.addElement(partida);
        }
        
        vista.getPartidasGuardadasList().setModel(model);
    }
    
    private ArrayList<String> leerPartidasGuardadas(){
        //Cargar la lista de partidas del usuario en ArrayList<Partida>
        //String partidas = new FileManager().readFile(PARTIDAS_GUARDADAS);
        ArrayList<String> ejemplo = new ArrayList<>();
        ejemplo.add("Nivel 1  - 25/11/2021 20:09:45");
        ejemplo.add("Nivel 2  - 25/11/2021 08:44:05");
        ejemplo.add("Nivel 4  - 26/11/2021 12:14:54");
        ejemplo.add("Nivel 7  - 27/11/2021 14:44:18");
        return ejemplo;
    }

    private void cargarPartidaSeleccionada(String partidaSeleccionada) {
        //Cargar partida seleccionada
        System.out.println("Cargando partida "+partidaSeleccionada);
    }

    
    
}
