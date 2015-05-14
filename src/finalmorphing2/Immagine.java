/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmorphing2;
import java.awt.Color;
import java.awt.image.BufferedImage;


public class Immagine 
{
    private Pixel[][] m;
    public int larghezza;
    public int altezza;
    BufferedImage result=new BufferedImage(larghezza, altezza, BufferedImage.TYPE_INT_ARGB);
    
    public Immagine(int w, int h)
    {
        if(w>0 && h>0)
        {
            m=new Pixel[h][w];
            altezza=h;
            larghezza=w;
        }
        else
            System.out.print("Error  value of height or width negative");
    }
    
    public Immagine(BufferedImage img)
    {
        altezza=img.getHeight();
        larghezza=img.getWidth();
        m=new Pixel[altezza][larghezza];
        for(int i=0;i<altezza;i++)
            for(int j=0;j<larghezza;j++)
            {                
                m[i][j] = new Pixel(img.getRGB(j, i));
            }
    }
    
    public void setPixel(int x,int y,Pixel p)
    {
       // nota Y = riga    X e' la colonna
       m[y][x]=p; 
    }
    
    public Pixel getPixel(int x, int y)
    {
        return m[y][x];
    }
  
    public BufferedImage toBufferedImage()
    {
         
        
        for(int i=0;i<altezza;i++)
           for(int j=0;j<larghezza;j++)
           {               
                int Argb = new Color(m[i][j].b,m[i][j].g,m[i][j].r,255).getRGB();
                result.setRGB(j, i, Argb);
           }
        return result;
    }
}
