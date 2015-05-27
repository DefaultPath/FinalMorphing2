
package finalmorphing2;
import java.awt.Color;
import java.util.ArrayList;

public class Pixel 
{
    int r;
    int g;
    int b;
    
    public Pixel()
    {
       r=0;
       g=0;
       b=0;
    }
    public Pixel(int r,int g,int b)
    {
        this.r=r;
        this.g=g;
        this.b=b;
    }
    public Pixel(int i)
    {
        int argb = i;
        r = (argb)&0xFF;
        g = (argb>>8)&0xFF;
        b = (argb>>16)&0xFF;
    }
    public Pixel mix(Pixel p, double percentForMe)
    {
        if (percentForMe>=0 && percentForMe<=1)
        {
            double percent2=1-percentForMe;
            Pixel pfinal ;
            pfinal = new Pixel((int)(this.r*percentForMe+p.r*percent2),(int)(this.g*percentForMe+p.g*percent2),(int)(this.b*percentForMe+p.b*percent2));
            return pfinal;
        }
        else
        {
            System.out.println("Mi viene chiesto di fare un mix di valore:"+percentForMe);
            return p;
        }
    }
    public CoppiaTriangoli TrovaContenitoreDi(ArrayList<CoppiaTriangoli> t,Pixel p,int x,int y)
    {
        for(int i=0;i<t.size();i++)
        {
            if(t.get(i).sorgente.belongTriangle(p, x, y))
                return t.get(i);
        }
        return null;
    }
    public void setPixelColor(int i)
    {
        /*int argb = i;
        b = argb & 0xFF;
        g = (argb & 0xff00) >> 8 ;
        r = (argb & 0xff0000) >> 16 ;     */
        Color rgb = new Color(i);
        b = rgb.getBlue();
        g = rgb.getGreen();
        r = rgb.getRed();
            
    }    
    
}
