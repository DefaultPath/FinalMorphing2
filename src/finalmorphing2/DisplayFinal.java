/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmorphing2;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Luca
 */
public class DisplayFinal extends JPanel
{
    Immagine f;
    public DisplayFinal(Immagine g)
    {
	f=g;
    }
    @Override
    public void paint(Graphics g)
    {
	Dimension d=this.getSize();
	
	g.drawImage(f.toBufferedImage(),0 ,0 ,d.width,d.height, this);
    }
}
