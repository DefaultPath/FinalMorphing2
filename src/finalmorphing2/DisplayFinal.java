/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmorphing2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Luca
 */
public class DisplayFinal extends JPanel
{
    Immagine f;
    BufferedImage b;
    
    public DisplayFinal()
    {
        f = null;
        b = null;
    }
    
    public void setImage(Immagine img)
    {
        f = img;
        b = f.toBufferedImage();
        repaint();
    } 
    
    @Override
    public void paint(Graphics g)
    {
        Dimension d=this.getSize();
        if (b!=null) 
            g.drawImage(b,0 ,0 ,d.width,d.height, this);
    }
}
