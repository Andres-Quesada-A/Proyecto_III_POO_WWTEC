/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PreJuego;

import FondoVentana.FondoPanel;
import Juego.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author andre
 */
public class VistaElegirEjercito extends javax.swing.JFrame {
    private FondoPanel fondo = new FondoPanel("/PreJuego/Imagenes/FondoJuegoInicial.jpg");
    public JLabel moneda = new JLabel(new ImageIcon(getClass().getResource("/PreJuego/Imagenes/Moneda.png")));
    public JLabel dinero = new JLabel();
    private JLabel[] atributos = new JLabel[10];
    public JTextField[] AtributosLlenar = new JTextField[10];
    private JLabel fondoConfig = new JLabel(new ImageIcon(getClass().getResource("/PreJuego/Imagenes/FondoConfig.jpg")));
    public JButton Continuar = new JButton("Continuar");
    public JButton Elegir = new JButton("Elegir");
    public JButton Eliminar = new JButton("Eliminar");
    public JLabel Campos = new JLabel();
    private JLabel lblCampos = new JLabel("Campos: ");
    
    public VistaElegirEjercito() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Elegir Ejercito");
        this.lblTitulo.setText("Escoge tu ejército");
        init();
        CrearLabels();
        CrearTextField();
        CrearBotones();
    }

    private void init(){
        this.jPanel1.add(moneda);
        moneda.setBounds(30, 10, 50, 50);
        this.jPanel1.add(dinero);
        dinero.setBounds(90, 15, 100, 25);
        dinero.setFont(new java.awt.Font("Tahoma MS", 0, 23));
        dinero.setForeground(new java.awt.Color(255, 255, 255));
        this.btnSiguiente.setIcon(new ImageIcon(getClass().getResource("/PreJuego/Imagenes/Siguiente.jpg")));
        this.btnAtras.setIcon(new ImageIcon(getClass().getResource("/PreJuego/Imagenes/Anterior.jpg")));
    }
    
    /*Se crean los titulos de todos los datos necesarios para crear un miembro del ejercito*/
    private void CrearLabels(){
        String[] nombres = {"Tipo de ataque", "Nombre","Vida","Cantidad de golpes /s","Nivel","Campos","Nivel de aparición","Costo","Fuerza de golpe", "Arma"};
        for (int i = 0; i < 10; i++){
            atributos[i] = new JLabel(nombres[i]);
            this.jPanel1.add(atributos[i]);
            atributos[i].setBounds(810, 120 + 34 * i, 200, 25);
            //atributos[i].setHorizontalAlignment(JLabel.RIGHT);
            atributos[i].setFont(new java.awt.Font("Tahoma MS", 3, 18));
            atributos[i].setForeground(new java.awt.Color(0, 255, 0));
        }
        this.jPanel1.add(this.lblCampos);
        lblCampos.setBounds(30, 70, 80, 25);
        lblCampos.setFont(new java.awt.Font("Tahoma MS", 0, 18));
        lblCampos.setForeground(new java.awt.Color(255, 255, 255));
        this.jPanel1.add(this.Campos);
        Campos.setBounds(110, 70, 100, 25);
        Campos.setFont(new java.awt.Font("Tahoma MS", 0, 18));
        Campos.setForeground(new java.awt.Color(255, 255, 255));
    }
    
    private void CrearTextField(){
        for (int i = 0; i < 10; i++){
            AtributosLlenar[i] = new JTextField();
            this.jPanel1.add(AtributosLlenar[i]);
            AtributosLlenar[i].setBounds(640, 115 + 35 * i, 150, 30);
            AtributosLlenar[i].setFont(new java.awt.Font("Tahoma MS", 0, 15));
            //AtributosLlenar[i].setForeground(new java.awt.Color(255, 255, 255));
            AtributosLlenar[i].setEditable(false);
        }
        this.jPanel1.add(fondoConfig);
        fondoConfig.setBounds(630, 105, 370, 365);
    }
    
    public void CrearBotones(){
        this.jPanel1.add(Continuar);
        Continuar.setBounds(860, 590, 100, 30);
        Continuar.setFont(new java.awt.Font("Tahoma MS", 0, 15));
        this.jPanel1.add(Elegir);
        Elegir.setBounds(740,590, 100, 30);
        Elegir.setFont(new java.awt.Font("Tahoma MS", 0, 15));
        this.jPanel1.add(Eliminar);
        Eliminar.setBounds(620,590, 100, 30);
        Eliminar.setFont(new java.awt.Font("Tahoma MS", 0, 15));
    }

    public String GetItemVariable(){
        return this.CmbxElegidos.getSelectedItem().toString();
    }
    
    public void SetItemVariable(String item){
        this.CmbxElegidos.addItem(item);
    }
    
    public void SelectItem(String item){
        this.CmbxElegidos.getModel().setSelectedItem(item);
    }
    
    public void setCampos(String Campos) {
        this.Campos.setText(Campos);
    }
    
    public void SetTexto(int index, String texto){
        AtributosLlenar[index].setText(texto);
    }
    
    public void setTextMoneta(String moneda){
        this.dinero.setText(moneda);
    }
    
    public void SetIcon(ImageIcon icon){
        this.lblFigura.setIcon(icon);
    }
    
    public String GetTexto(int index){
        return AtributosLlenar[index].getText();
    }
    
    public void setMensajeError(String error){
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public void setMensaje(String error){
        JOptionPane.showMessageDialog(this, error, "Informativo", JOptionPane.INFORMATION_MESSAGE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanel("/PreJuego/Imagenes/FondoJuegoInicial.jpg");
        lblTitulo = new javax.swing.JLabel();
        lblFigura = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        CmbxElegidos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblFigura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        CmbxElegidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(lblFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(CmbxElegidos, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(331, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(lblFigura, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(CmbxElegidos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(VistaElegirEjercito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaElegirEjercito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaElegirEjercito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaElegirEjercito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaElegirEjercito().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> CmbxElegidos;
    public javax.swing.JButton btnAtras;
    public javax.swing.JButton btnSiguiente;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblFigura;
    public javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
