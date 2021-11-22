/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FondoVentana;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author andre
 */
public class FondoPanel extends JPanel{
    private Image imagen;
    private String path;
    
    public FondoPanel(String path){
        this.path = path;
    }
    @Override
    public void paint(Graphics g)
    {
        imagen = new ImageIcon(getClass().getResource(path)).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
