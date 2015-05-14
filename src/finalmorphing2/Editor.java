/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmorphing2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class Editor extends JPanel  implements MouseMotionListener      
{
    public  int ngriglia;
    private  Griglia punti;
    private boolean primaVolta;
    public CoppiaPunti coppiaSelezionata;
    public boolean modalitaMovimentoAttiva;
    public boolean modalitaInserimentoAttiva;
    public boolean modalitaRimozioneAttiva;
    public int altezza,larghezza;
    private boolean DEBUG;
    
    public Editor(int chisono)
    {
        DEBUG = true;
        ngriglia=chisono;
        primaVolta = true;
        coppiaSelezionata = null;
        addMouseMotionListener(this);
        modalitaMovimentoAttiva=true;
        modalitaInserimentoAttiva=false;
        modalitaRimozioneAttiva=false;
    }
    
    public void init(Griglia g)
    {
        punti=g;
    }
    @Override
    public void paint(Graphics g)
    {
        Dimension d = this.getSize();
        larghezza=d.width;
        altezza=d.height;
        if (ngriglia==0)
        {
            g.setColor(Color.green);
            g.fillRect(0,0,d.width,d.height);
            for(CoppiaPunti p : punti.twins) 
            {
                if (p.sorgente.selected)
                    g.setColor(Color.yellow);
                else
                    g.setColor(Color.black);
                g.fillOval((int)((p.sorgente.getX()*larghezza)-Punto.defaultRaggio), (int)((p.sorgente.getY()*altezza)-Punto.defaultRaggio), 2*Punto.defaultRaggio, 2*Punto.defaultRaggio);
            }
            g.setColor(Color.black);
        }
        if (ngriglia==1)
       {
            g.setColor(Color.red);
            g.fillRect(0,0,d.width,d.height);
            for (CoppiaPunti p : punti.twins) {
                if (p.destinazione.selected)
                    g.setColor(Color.yellow);
                else
                    g.setColor(Color.black);
                g.fillOval((int)((p.destinazione.getX()*larghezza)-Punto.defaultRaggio), (int)((p.destinazione.getY()*altezza)-Punto.defaultRaggio), 2*Punto.defaultRaggio, 2*Punto.defaultRaggio);
            }
            g.setColor(Color.black);
        }
        /*for(int index=0;index<punti.twins.size();index++)
        {
            
        }*/
    }
    public boolean clicked(double x, double y, double px, double py)
    {
        Dimension d = this.getSize();
        double piccola = d.getWidth();
        if (piccola>d.getHeight())
            piccola = d.getHeight();
        double raggio = ((piccola * 5 )/100) / piccola;
        double dist = Math.sqrt((px-x)*(px-x)+(py-y)*(py-y));
        if (dist<=raggio)
        {
          for(CoppiaPunti p: punti.twins)
          {
              p.destinazione.selected=false;
              p.sorgente.selected=false;
            }
          return true;
          
        }
        else
            return false;
    }
    
    public boolean selezionatoUnPunto(double x, double y)
    {
        for (CoppiaPunti pp : punti.twins)
        {
           Punto p;
           if (ngriglia==0)
               p=pp.sorgente;               
           else
           
               p=pp.destinazione;
           if (clicked(x,y,p.getX(),p.getY()))
           {
               coppiaSelezionata = pp;
               if (p.editable)
               {
               p.selected=true;
               p.myTwin.selected=true;
               }
               return true;
           }
           else
           {

           }
        }
        return false;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) 
    {
        Dimension d=this.getSize();
        larghezza=d.width;
        altezza=d.height;
        if(modalitaMovimentoAttiva==true)
        {
            if (primaVolta)
            {
                double xpunto = (double)(e.getX())/larghezza;
                double ypunto = (double)(e.getY())/altezza;
                debug("Fatto click in :("+xpunto+","+ypunto+")");
                if (selezionatoUnPunto(xpunto,ypunto))
                {
                    
                    primaVolta = false;
                    repaint();
                    debug("Selezionato il punto in coordinate:("+xpunto+","+ypunto+")");
                }
            }
            else
            {
                Punto p;
                if (ngriglia==0) p = coppiaSelezionata.sorgente;
                else             p = coppiaSelezionata.destinazione;
                double xpunto = (double)(e.getX())/larghezza;
                double ypunto = (double)(e.getY())/altezza;
                p.setCoordinate(xpunto, ypunto);
                repaint();
            }
        }
        else if(modalitaInserimentoAttiva==true)
        {
            if (primaVolta)
            {
                double xpunto = (double)(e.getX())/larghezza;
                double ypunto = (double)(e.getY())/altezza;
                debug("Aggiunto il punto:("+xpunto+","+ypunto+")");
                punti.twins.add(new CoppiaPunti(new Punto(xpunto,ypunto,true,null),new Punto(xpunto,ypunto,true,null)));
                primaVolta=false;
                repaint(); 
            }    
            else 
            {
                repaint();
            }    
        }
        else if(modalitaRimozioneAttiva==true)
        {
            double xpunto = (double)(e.getX())/larghezza;
            double ypunto = (double)(e.getY())/altezza;
            if (selezionatoUnPunto(xpunto,ypunto))
                for (CoppiaPunti p : punti.twins)
                    try
                    {
                    if(p.destinazione.selected || p.sorgente.selected)
                        punti.twins.remove(p);
                    }
                    catch(Exception a)
                    {
                        System.out.println("Punto non presente");
                    }
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) 
    {
        primaVolta = true;
        repaint();
    }
    
    void debug(String s)
    {
        if (DEBUG)
            System.out.println(s);
    }
}
