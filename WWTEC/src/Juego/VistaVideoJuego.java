/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author andre
 */
public class VistaVideoJuego extends javax.swing.JFrame {
    private JLabel[] lblMuroMenor = new JLabel[56];
    private JLabel[] lblMuroMayor = new JLabel[76];
    private JLabel edificio = new JLabel();
    private ArrayList<JLabel> bombas = new ArrayList<JLabel>();
    private ArrayList<JLabel> torres = new ArrayList<JLabel>();
    private ArrayList<JLabel> cañones = new ArrayList<JLabel>();
    private ArrayList<JLabel> aereos = new ArrayList<JLabel>();
    private ArrayList<JLabel> morteros = new ArrayList<JLabel>();
    private ArrayList<JLabel> balas = new ArrayList<JLabel>();
    private ArrayList<JLabel> soldados = new ArrayList<JLabel>();
    private ArrayList<JLabel> alcanceMedio = new ArrayList<JLabel>();
    private ArrayList<JLabel> tanque = new ArrayList<JLabel>();
    private ArrayList<JLabel> carro = new ArrayList<JLabel>();
    private ArrayList<JLabel> aviones = new ArrayList<JLabel>();
    
    
    public VistaVideoJuego() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("WWTEC");
        CrearMuro();
    }

    public void CambiarIconSoldado(int indice, ImageIcon icon){
        soldados.get(indice).setIcon(icon);
    }
    
    public void MoverSoldado(int indice, int x, int y){
        soldados.get(indice).setBounds(x, y, 30, 30);
    }
    
    public void EliminarTorre(int index){
        this.torres.get(index).setIcon(null);
    }
    
    public void EliminarCañones(int index){
        this.cañones.get(index).setIcon(null);
    }
    
    public void EliminarAereos(int index){
        this.aereos.get(index).setIcon(null);
    }
    
    public void EliminarMorteros(int index){
        this.morteros.get(index).setIcon(null);
    }
    
    public void CambiarBomba(ImageIcon icon, int index){
        this.bombas.get(index).setIcon(icon);
    }
    
    public void EliminarBomba(int index){
        this.bombas.get(index).setIcon(null);
    }
    
    public int crearBala(ImageIcon icon, int coordx, int coordy){
        balas.add(new JLabel(icon));
        int indice = balas.size() - 1;
        this.jPanel1.add(balas.get(indice));
        balas.get(indice).setBounds(coordx, coordy, 30, 30);
        return indice;
    }
    
    //Elimina la bala de pantalla
    public void EliminarBala(int indice){
        balas.get(indice).setIcon(null);
    }
    
    //Con el modo hace referencia a la direccion de avance, 0 para la izquierda 1 para la derecha
    public void avanzarBala(int indice, int coordx, int coordy){
        balas.get(indice).setBounds(coordx, coordy, 30, 30);
    }
    
    public int insertarBombas(int x, int y){
        int indice = bombas.size();
        bombas.add(new JLabel(new ImageIcon(getClass().getResource("/Defensa/Imagenes/Granada.png"))));
        this.jPanel1.add(bombas.get(indice));
        bombas.get(indice).setBounds(x, y, 30, 30);
        return indice;
    }
    
    public int insertarTorres(int x, int y){
        int indice = torres.size();
        torres.add(new JLabel(new ImageIcon(getClass().getResource("/Defensa/Imagenes/Torre.png"))));
        this.jPanel1.add(torres.get(indice));
        torres.get(indice).setBounds(x, y, 60, 60);
        return indice;
    }
    
    public int insertarCañones(int x, int y){
        int indice = cañones.size();
        cañones.add(new JLabel(new ImageIcon(getClass().getResource("/Defensa/Imagenes/Cañon.png"))));
        this.jPanel1.add(cañones.get(indice));
        cañones.get(indice).setBounds(x, y, 30, 30);
        return indice;
    }
    
    public int insertarAereos(int x, int y){
        int indice = aereos.size();
        aereos.add(new JLabel(new ImageIcon(getClass().getResource("/Defensa/Imagenes/Aereos.png"))));
        this.jPanel1.add(aereos.get(indice));
        aereos.get(indice).setBounds(x, y, 30, 30);
        return indice;
    }
    
    public int insertarMorteros(int x, int y){
        int indice = morteros.size();
        morteros.add(new JLabel(new ImageIcon(getClass().getResource("/Defensa/Imagenes/Mortero.png"))));
        this.jPanel1.add(morteros.get(indice));
        morteros.get(indice).setBounds(x, y, 30, 30);
        return indice;
    }
    
    public int insertarSoldado(int x, int y, ImageIcon icon){
        System.out.println("Se insertan soldados: " + x + "  " + y);
        int indice = this.soldados.size();
        soldados.add(new JLabel(icon));
        this.jPanel1.add(soldados.get(indice));
        soldados.get(indice).setBounds(x, y, 30, 30);
        return indice;
    }
    
    public int insertarMidAlcance(int x, int y, ImageIcon icon){
        int indice = this.alcanceMedio.size();
        alcanceMedio.add(new JLabel(icon));
        this.jPanel1.add(alcanceMedio.get(indice));
        alcanceMedio.get(indice).setBounds(x, y, 30, 30);
        return indice;
    }
    
    public int insertarTanque(int x, int y, ImageIcon icon){
        int indice = this.tanque.size();
        tanque.add(new JLabel(icon));
        this.jPanel1.add(tanque.get(indice));
        tanque.get(indice).setBounds(x, y, 117, 60);
        return indice;
    }
    
    public int insertarCarro(int x, int y, ImageIcon icon){
        int indice = this.carro.size();
        carro.add(new JLabel(icon));
        this.jPanel1.add(carro.get(indice));
        carro.get(indice).setBounds(x, y, 100, 60);
        return indice;
    }
    
    public int insertarAviones(int x, int y, ImageIcon icon){
        int indice = this.aviones.size();
        aviones.add(new JLabel(icon));
        this.jPanel1.add(aviones.get(indice));
        aviones.get(indice).setBounds(x, y, 86, 60);
        return indice;
    }
    
    public void EliminarMuro(int indice, int nivel){
        if (nivel < 6){
            this.lblMuroMenor[indice].setIcon(null);
        }else{
            this.lblMuroMayor[indice].setIcon(null);
        }
    }
    
    private void CrearMuro(){
        int x = 300;
        int y = 80;
        for (int i = 0; i < lblMuroMenor.length; i++){
            lblMuroMenor[i] = new JLabel();
            this.jPanel1.add(lblMuroMenor[i]);
            lblMuroMenor[i].setBounds(x, y, 30, 30);            
            if (x < (300 + (31 * 14)) && y == 80){
                x += 31;
            }else if (x == (300 + (31 * 14)) && y < (80 + (31 * 14))){
                y += 31;
            }else if (y == (80 + (31 * 14)) && x > (300)){
                x -= 31;
            }else if (y >= (80 + 31) && x == 300){
                y -= 31;
            }
        }
        x = 230;
        y = 50;
        for (int i = 0; i < lblMuroMayor.length; i++){
            lblMuroMayor[i] = new JLabel();
            this.jPanel1.add(lblMuroMayor[i]);
            lblMuroMayor[i].setBounds(x, y, 30, 30);            
            if (x < (230 + (31 * 19)) && y == 50){
                x += 31;
            }else if (x == (230 + (31 * 19)) && y < (50 + (31 * 19))){
                y += 31;
            }else if (y == (50 + (31 * 19)) && x > (230)){
                x -= 31;
            }else if (y >= (50 + 31) && x == 230){
                y -= 31;
            }
        }
    }
    
    public void EliminarAvion(int index){
        this.aviones.get(index).setIcon(null);
    }
    
    public void EliminarTanque(int index){
        this.tanque.get(index).setIcon(null);
    }
    
    public void EliminarCamion(int index){
        this.carro.get(index).setIcon(null);
    }
    
    public void EliminarMedioAlcance(int index){
        this.alcanceMedio.get(index).setIcon(null);
    }
    
    public void EliminarSoldado(int index){
        this.soldados.get(index).setIcon(null);
    }
    
    public void EliminarEdificio(){
        this.edificio.setIcon(null);
    }
    
    public void CrearEdificio(int x, int y){
        this.jPanel1.add(edificio);
        edificio.setBounds(x, y, 100, 100);
        SetEdificio(new ImageIcon(getClass().getResource("/Defensa/Imagenes/Edificio2.png")));
    }
    
    public void SetEdificio(ImageIcon imagen){
        this.edificio.setIcon(imagen);
    }
    
    public void SetMuro(ArrayList<Integer> distribuccion){
        ImageIcon ImagenMuro = new ImageIcon(getClass().getResource("/Defensa/Imagenes/Muro.jpg"));
        if (distribuccion.size() < 60){
            for (int i = 0; i < distribuccion.size(); i++){
                if (distribuccion.get(i) == 1){
                    lblMuroMenor[i].setIcon(ImagenMuro);
                }
            }
        }else{
            for (int i = 0; i < distribuccion.size(); i++){
                if (distribuccion.get(i) == 1){
                    lblMuroMayor[i].setIcon(ImagenMuro);
                }
            }
        }
    }
    
    public String getNivel(){
        return this.lblNivel.getText();
    }
    
    public void setNivel(String text){
        this.lblNivel.setText(text);
    }
    
    public String getVida(){
        return this.lblVida.getText();
    }
    
    public void setVida(String text){
        this.lblVida.setText(text);
    }
    
    public String getBienes(){
        return this.lblBienes.getText();
    }
    
    public void setBienes(String text){
        this.lblBienes.setText(text);
    }

    public JLabel[] getLblMuroMenor() {
        return lblMuroMenor;
    }

    public void setLblMuroMenor(JLabel[] lblMuroMenor) {
        this.lblMuroMenor = lblMuroMenor;
    }

    public JLabel[] getLblMuroMayor() {
        return lblMuroMayor;
    }

    public void setLblMuroMayor(JLabel[] lblMuroMayor) {
        this.lblMuroMayor = lblMuroMayor;
    }

    public JLabel getEdificio() {
        return edificio;
    }

    public void setEdificio(JLabel edificio) {
        this.edificio = edificio;
    }

    public ArrayList<JLabel> getBombas() {
        return bombas;
    }

    public void setBombas(ArrayList<JLabel> bombas) {
        this.bombas = bombas;
    }

    public ArrayList<JLabel> getTorres() {
        return torres;
    }

    public void setTorres(ArrayList<JLabel> torres) {
        this.torres = torres;
    }

    public ArrayList<JLabel> getCañones() {
        return cañones;
    }

    public void setCañones(ArrayList<JLabel> cañones) {
        this.cañones = cañones;
    }

    public ArrayList<JLabel> getAereos() {
        return aereos;
    }

    public void setAereos(ArrayList<JLabel> aereos) {
        this.aereos = aereos;
    }

    public ArrayList<JLabel> getMorteros() {
        return morteros;
    }

    public void setMorteros(ArrayList<JLabel> morteros) {
        this.morteros = morteros;
    }

    public ArrayList<JLabel> getBalas() {
        return balas;
    }

    public void setBalas(ArrayList<JLabel> balas) {
        this.balas = balas;
    }

    public ArrayList<JLabel> getSoldados() {
        return soldados;
    }

    public void setSoldados(ArrayList<JLabel> soldados) {
        this.soldados = soldados;
    }

    public ArrayList<JLabel> getAlcanceMedio() {
        return alcanceMedio;
    }

    public void setAlcanceMedio(ArrayList<JLabel> alcanceMedio) {
        this.alcanceMedio = alcanceMedio;
    }

    public ArrayList<JLabel> getTanque() {
        return tanque;
    }

    public void setTanque(ArrayList<JLabel> tanque) {
        this.tanque = tanque;
    }

    public ArrayList<JLabel> getCarro() {
        return carro;
    }

    public void setCarro(ArrayList<JLabel> carro) {
        this.carro = carro;
    }

    public ArrayList<JLabel> getAviones() {
        return aviones;
    }

    public void setAviones(ArrayList<JLabel> aviones) {
        this.aviones = aviones;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblVidaTiturlo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNivel = new javax.swing.JLabel();
        lblNumeroNivel = new javax.swing.JLabel();
        lblBienes = new javax.swing.JLabel();
        lblVida = new javax.swing.JLabel();
        btnTrampa = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblVidaTiturlo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblVidaTiturlo.setText("Vida del pueblo:");

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel2.setText("Bienes:");

        lblNivel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblNivel.setForeground(new java.awt.Color(0, 153, 153));
        lblNivel.setText("1");

        lblNumeroNivel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblNumeroNivel.setText("Nivel");

        lblBienes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblBienes.setForeground(new java.awt.Color(0, 153, 153));
        lblBienes.setText("1");

        lblVida.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        lblVida.setForeground(new java.awt.Color(0, 153, 153));
        lblVida.setText("1");

        btnTrampa.setBackground(new java.awt.Color(204, 255, 255));
        btnTrampa.setText("Trampa");

        btnGuardar.setBackground(new java.awt.Color(204, 255, 255));
        btnGuardar.setText("Guardar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVidaTiturlo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVida, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(lblNumeroNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBienes, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTrampa, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBienes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTrampa)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblVidaTiturlo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblVida, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNumeroNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(659, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(VistaVideoJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaVideoJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaVideoJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaVideoJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaVideoJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnTrampa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBienes;
    private javax.swing.JLabel lblNivel;
    private javax.swing.JLabel lblNumeroNivel;
    private javax.swing.JLabel lblVida;
    private javax.swing.JLabel lblVidaTiturlo;
    // End of variables declaration//GEN-END:variables
}
