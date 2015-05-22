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