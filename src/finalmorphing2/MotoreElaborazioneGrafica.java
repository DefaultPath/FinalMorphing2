
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
        double sorpx,destpx,destpy,sorpy;
        CoppiaTriangoli t=p.TrovaContenitoreDi(this.t.coppie, p, x, y);
        double[][] m  = new double[3][3];
        double[][] m1 = new double[3][3];
        double[][] m2 = new double[3][3];
        double[][] m3 = new double[3][3];
        m[0][0]=t.finale.v1.getY();
        m[0][1]=t.finale.v2.getY();
        m[0][2]=t.finale.v3.getY();
        m[1][0]=t.finale.v1.getX();
        m[1][1]=t.finale.v2.getX();
        m[1][2]=t.finale.v3.getX();
        m[2][0]=1;
        m[2][1]=1;
        m[2][2]=1;
        m1[0][0]=y;
        m1[0][1]=t.finale.v2.getY();
        m1[0][2]=t.finale.v3.getY();
        m1[1][0]=x;
        m1[1][1]=t.finale.v2.getX();
        m1[1][2]=t.finale.v3.getX();
        m1[2][0]=1;
        m1[2][1]=1;
        m1[2][2]=1;
        m2[0][0]=t.finale.v1.getY();
        m2[0][1]=y;
        m2[0][2]=t.finale.v3.getY();
        m2[1][0]=t.finale.v1.getX();
        m2[1][1]=x;
        m2[1][2]=t.finale.v3.getX();
        m2[2][0]=1;
        m2[2][1]=1;
        m2[2][2]=1;
        m2[0][0]=t.finale.v1.getY();
        m2[0][1]=t.finale.v2.getY();
        m2[0][2]=y;
        m2[1][0]=t.finale.v1.getX();
        m2[1][1]=t.finale.v2.getX();
        m2[1][2]=x;
        m2[2][0]=1;
        m2[2][1]=1;
        m2[2][2]=1;
        double lambda1, lambda2, lambda3;
        lambda1 = this.calcolaDeterminante(m1)/this.calcolaDeterminante(m);
        lambda2 = this.calcolaDeterminante(m2)/this.calcolaDeterminante(m);
        lambda3 = this.calcolaDeterminante(m3)/this.calcolaDeterminante(m);
        
        
        sorpx=(t.sorgente.v1.getX()*lambda1)+(t.sorgente.v2.getX()*lambda2)+(t.sorgente.v3.getX()*lambda3);
        destpx=(t.destinazione.v1.getX()*lambda1)+(t.destinazione.v2.getX()*lambda2)+(t.destinazione.v3.getX()*lambda3);
        sorpy=(t.sorgente.v1.getY()*lambda1)+(t.sorgente.v2.getY()*lambda2)+(t.sorgente.v3.getY()*lambda3);
        destpy=(t.destinazione.v1.getY()*lambda1)+(t.destinazione.v2.getY()*lambda2)+(t.destinazione.v3.getY()*lambda3);
        
        
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