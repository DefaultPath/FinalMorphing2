package finalmorphing2;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

/*
        asx=new CoppiePunti(a.asx,b.asx);
        adx=new CoppiePunti(a.adx,b.adx);
        bsx=new CoppiePunti(a.bsx,b.bsx);
        bdx=new CoppiePunti(a.bdx,b.bdx);
        coppie = new ArrayList();
        coppie.add(asx);
        coppie.add(adx);
        coppie.add(bsx);
        coppie.add(bdx); 
  @author luca
 */
public class Griglia  
{
    /*public Punto adx;
    public Punto bdx;
    public Punto asx;
    public Punto bsx;*/
    ArrayList<CoppiaPunti> twins = new ArrayList();
    
    public Griglia(Dimension d)
    {
        double larghezza=d.getWidth();
        double altezza=d.getHeight();
        //alto destra, basso destra, alto sinistra, basso sinistra
        twins.add(new CoppiaPunti(new Punto(0,0,false,null),new Punto(0,0,false,null)));
        twins.add(new CoppiaPunti(new Punto(0,1,false,null),new Punto(0,1,false,null)));
        twins.add(new CoppiaPunti(new Punto(1,0,false,null),new Punto(1,0,false,null)));
        twins.add(new CoppiaPunti(new Punto(1,1,false,null),new Punto(1,1,false,null)));
        
        twins.add(new CoppiaPunti(new Punto(0.5,0.5,true,null) , new Punto(0.5,0.5,true,null) ));
        //asx=new Punto(0,0);
        //bsx=new Punto(0,d.height-Punto.defaultRaggio/2);               
    }    
}
