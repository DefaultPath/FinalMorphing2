package finalmorphing2;

public class Punto 
{
    public static int defaultRaggio = 10;
    private double x,y;
    public boolean editable;
    public Punto myTwin;
    boolean selected;
    
    public Punto(boolean editable, Punto myTwin)
    {
        x=0;
        y=0;
        this.editable = editable;
        this.myTwin = myTwin;
        System.out.println("Errore nessun parametro al punto");	
        System.exit(1);
    }
    public Punto(double x,double y, boolean editable, Punto myTwin) 
    {
        this.x=x;
        this.y=y;  
        this.editable = editable;
        this.myTwin = myTwin;
        this.selected=false;
    }
    public void setCoordinate(double x,double y)
    {
        if (editable)
        {
            this.x=x;
            this.y=y;
        }
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    
    public void setX(double n)
    {
        if (editable && n>0)
            this.x=n;
    }
    public void setY(double n)
    {
        if (editable && n>0)
            this.y=n;
    }
    public void select(boolean state)
    {
        if (state)
            selected=true;
        else
            selected=false;
    }

}
