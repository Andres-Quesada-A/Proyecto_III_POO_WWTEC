/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Progreso;

import FondoVentana.FondoPanel;
import Juego.ControladorVideoJuego;
import Juego.ModeloVideoJuego;
import Juego.VistaVideoJuego;
import PartidasJugador.PartidaUsuario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Jose
 */
public class VistaProgreso extends javax.swing.JFrame {

    private ArrayList<JButton> niveles = new ArrayList<>();
    private static final Color COLOR_DESBLOQUEADO = new Color(0,150,50);
    private static final Color COLOR_DESBLOQUEADO_SECUNDARIO = new Color(255, 204, 51);
    private static final int ANCHO_BORDE = 4;
    private static final Font FONT_BOTON = new Font("Segoe UI Black", 1, 13);
    private static final Border BORDE_DESBLOQUEADO= new LineBorder(COLOR_DESBLOQUEADO_SECUNDARIO, ANCHO_BORDE, true);
    private String user = "";
    private String password =  "";
    
    private int nivelActual = 1;
    private int nivelesTotales = 10;
    private int numeroDeTabs = 1;
    private int valorNivel = 1;
    /**
     * Creates new form VistaProgreso
     */
    public VistaProgreso(String user, String password) {
        FondoPanel fondo = new FondoPanel("/Progreso/Imagenes/bg1.jpg");
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.user = user;
        this.password = password;
        ultimaTab = container1;
        ObtenerNivel();
    }
    
    private void ObtenerNivel(){
        nivelActual = ModeloProgreso.ObtenerNivel(user, password);
        cargarBotones();
        cargarNiveles();
    }
    
    public void cargarBotones(){
        niveles.add(Nivel1); 
        niveles.add(Nivel2);
        niveles.add(Nivel3);
        niveles.add(Nivel4);
        niveles.add(Nivel5);
        niveles.add(Nivel6);
        niveles.add(Nivel7);
        niveles.add(Nivel8);
        niveles.add(Nivel9);
        niveles.add(Nivel10);
        
        for (int i = 0; i < 10; i++){
            niveles.get(i).setActionCommand(valorNivel + ""); 
            niveles.get(i).addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickNivel(evt);
            }
            });
            valorNivel++;
        }
        
        generarNivel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearNivel();
            }
        });
    }

    private void clickNivel(java.awt.event.MouseEvent evt){
        // obtiene el boton 
        JButton botonTemp = (JButton)evt.getComponent();
        // obtiene el i,j de action command del boton
        String identificadorBoton = botonTemp.getActionCommand();
        
        String PATH = ModeloProgreso.CrearDistribucciones(Integer.parseInt(identificadorBoton), user, password);
        VistaVideoJuego vista =  new VistaVideoJuego();
        ModeloVideoJuego modelo = new ModeloVideoJuego();
        ControladorVideoJuego controlador = new ControladorVideoJuego(vista, modelo);
        controlador.ShowView();
        controlador.IniciarNormal(PATH);
        this.dispose();
    }
    
    public void cargarNiveles(){
        System.out.println("Cargar niveles");
        for(int i=0;i<nivelActual;i++){
            niveles.get(i).setBackground(COLOR_DESBLOQUEADO);
            niveles.get(i).setForeground(COLOR_DESBLOQUEADO_SECUNDARIO);
            niveles.get(i).setBorder(BORDE_DESBLOQUEADO);
        }
        
        for(int i=nivelActual;i<nivelesTotales;i++){
            niveles.get(i).setEnabled(false);
        }
    }
    
    public void activarGeneradorDeNiveles(){
        generarNivel.setEnabled(true);
    }
    
    public void crearNivel(){
        nivelesTotales++;
        generarNivel(false,nivelesTotales);
    }
    
    public void generarNivel(boolean desbloqueado, int nivel){
        JButton nivelButton = new JButton("Nivel "+nivel);
        nivelButton.setFont(FONT_BOTON);
        
        if(nivel>numeroDeTabs*10){
            numeroDeTabs++;
            JPanel nuevoContainer = new JPanel();
            javax.swing.GroupLayout container1Layout = new javax.swing.GroupLayout(nuevoContainer);
            nuevoContainer.setLayout(container1Layout);
            nuevoContainer.setOpaque(false);
            ultimaTab = nuevoContainer;
            containerNiveles.addTab(""+numeroDeTabs, nuevoContainer);
            containerNiveles.setSelectedIndex(numeroDeTabs-1);
            agregarBoton(nuevoContainer, nivelButton, nivel-1);
        }else{
            agregarBoton(ultimaTab, nivelButton, nivel-1);
        }
        
        if(desbloqueado){
            nivelButton.setBackground(COLOR_DESBLOQUEADO);
            nivelButton.setBorder(BORDE_DESBLOQUEADO);
            nivelButton.setForeground(COLOR_DESBLOQUEADO_SECUNDARIO);
        }else{
            nivelButton.setEnabled(false);
            nivelButton.setBorder(null);
        }
    }
    
    public void agregarBoton(JPanel container, JButton boton, int nivel){
        //if(numeroDeTabs<2) return;
        
        JButton botonEjemplo = niveles.get(nivel%10);
        container.add(boton);
        boton.setBounds(botonEjemplo.getBounds());
        boton.setMargin(botonEjemplo.getMargin());
        boton.setPreferredSize(botonEjemplo.getPreferredSize());
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerNiveles = new javax.swing.JTabbedPane();
        container1 = new javax.swing.JPanel();
        Nivel1 = new javax.swing.JButton();
        Nivel2 = new javax.swing.JButton();
        Nivel3 = new javax.swing.JButton();
        Nivel4 = new javax.swing.JButton();
        Nivel5 = new javax.swing.JButton();
        Nivel6 = new javax.swing.JButton();
        Nivel7 = new javax.swing.JButton();
        Nivel8 = new javax.swing.JButton();
        Nivel9 = new javax.swing.JButton();
        Nivel10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        generarNivel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));
        setResizable(false);

        container1.setOpaque(false);

        Nivel1.setBackground(new java.awt.Color(51, 51, 51));
        Nivel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel1.setText("Nivel 1");
        Nivel1.setBorder(null);

        Nivel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel2.setText("Nivel 2");
        Nivel2.setBorder(null);

        Nivel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel3.setText("Nivel 3");
        Nivel3.setBorder(null);

        Nivel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel4.setText("Nivel 4");
        Nivel4.setBorder(null);

        Nivel5.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel5.setText("Nivel 5");
        Nivel5.setBorder(null);

        Nivel6.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel6.setText("Nivel 6");
        Nivel6.setBorder(null);

        Nivel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel7.setText("Nivel 7");
        Nivel7.setBorder(null);

        Nivel8.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel8.setText("Nivel 8");
        Nivel8.setBorder(null);

        Nivel9.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel9.setText("Nivel 9");
        Nivel9.setBorder(null);

        Nivel10.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Nivel10.setText("Nivel 10");
        Nivel10.setBorder(null);

        javax.swing.GroupLayout container1Layout = new javax.swing.GroupLayout(container1);
        container1.setLayout(container1Layout);
        container1Layout.setHorizontalGroup(
            container1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Nivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nivel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nivel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, container1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Nivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nivel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nivel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Nivel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        container1Layout.setVerticalGroup(
            container1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(container1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nivel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nivel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nivel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nivel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nivel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(container1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nivel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nivel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nivel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nivel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nivel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        containerNiveles.addTab("1", container1);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tu Progreso");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51), 2));
        jPanel1.setOpaque(false);

        generarNivel.setBackground(new java.awt.Color(255, 204, 51));
        generarNivel.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        generarNivel.setText("Generar Nivel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generarNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(generarNivel, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(containerNiveles)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(containerNiveles, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaProgreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaProgreso("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Nivel1;
    private javax.swing.JButton Nivel10;
    private javax.swing.JButton Nivel2;
    private javax.swing.JButton Nivel3;
    private javax.swing.JButton Nivel4;
    private javax.swing.JButton Nivel5;
    private javax.swing.JButton Nivel6;
    private javax.swing.JButton Nivel7;
    private javax.swing.JButton Nivel8;
    private javax.swing.JButton Nivel9;
    private javax.swing.JPanel container1;
    private javax.swing.JTabbedPane containerNiveles;
    private javax.swing.JButton generarNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private JPanel ultimaTab;

}
