/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmorphing2;



import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class MotoreElaborazioneGrafica 
{
    public Immagine sorgente;
    public Immagine destinazione;
    public MotoreTriangolazione t;
    public Immagine result;
   
    public MotoreElaborazioneGrafica(MotoreTriangolazione mot)
    {
        t=mot;
        BufferedImage img;
        try 
        {
               img = ImageIO.read(this.getClass().getClassLoader().getResource("finalmorphing2/image1.jpg"));//Prende la prima immagine
               sorgente=new Immagine(img);
               result = new Immagine(img.getWidth(),img.getHeight());
        } 
        catch (Exception e) 
        {
            System.out.println("Prima immagine non trovata");	
            System.exit(1);
        }	
        try 
        {
            img =ImageIO.read(this.getClass().getClassLoader().getResource("finalmorphing2/image1.jpg"));
            destinazione = new Immagine(img);
        } 
        catch (Exception e) 
        {
            System.out.println("Seconda immagine non trovata");	
            System.exit(2);
        }

    }
    public void elaborate (double percent)
    {
     Pixel p;
     for(int y=0;y<sorgente.altezza;y++)
         for(int x=0;x<sorgente.larghezza;x++)
         {
             p=result.getPixel(x, y);
             CoppiaTriangoli ct = p.TrovaContenitoreDi(this.t.coppie, p, x, y);
             ct.GeneraTriangoloFinale(percent);
             
         }
         
    }
    private Pixel calcoloLambda(Pixel p,int x,int y)
    {

        double[][] m = new double[3][3];
        double[][] m1 = new double[3][3];
        double[][] m2 = new double[3][3];
        double[][] m3 = new double[3][3];
        
        m[0][0]=y;
        
        
        
        
        
        double lambda1, lambda2, lambda3;
        
        lambda1 = this.calcolaDeterminante(m1)/this.calcolaDeterminante(m);
        lambda2 = this.calcolaDeterminante(m2)/this.calcolaDeterminante(m);
        lambda3 = this.calcolaDeterminante(m3)/this.calcolaDeterminante(m);
        

        return null;    
    }
    private double calcolaDeterminante(double[][] m)
    {
    double ris1,ris2,ris3;
    ris1=m[0][0]*(m[1][1]*m[2][2]-m[1][2]*m[2][1]);
    ris2=m[0][1]*(m[1][0]*m[2][2]-m[1][2]*m[2][0]);
    ris3=m[0][2]*(m[1][0]*m[2][1]-m[1][1]*m[2][0]);     
        return ris1-ris2+ris3;      
    }
        
    }
    /*public void elaborate(double percent)
    {
	    Pixel p;
       for (int i=0;i<sorgente.altezza;i++)
            for(int j=0;j<sorgente.larghezza;j++)
            {
                 p = sorgente.getPixel(j, i);
                 p=p.mix(destinazione.getPixel(j,i), percent);
                 result.setPixel(j,i, p);
            }
    }*/
}