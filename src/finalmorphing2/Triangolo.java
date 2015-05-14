/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmorphing2;

/**
 *
 * @author luca
 */
public class Triangolo 
{
    private Punto v1,v2,v3;
    private final double latoAB,latoAC,latoBC;
    public  Triangolo myTwin;
    public Triangolo(Punto a,Punto b,Punto c)
    {
        v1=a;
        v2=b;
        v3=c;
        latoAB=Math.sqrt((v2.getX()-v1.getX()))*Math.sqrt((v2.getX()-v1.getX())) + (v2.getY()-v1.getX())*(v2.getY()-v1.getX());
        latoAC=Math.sqrt((v3.getX()-v1.getX()))*((v3.getX()-v1.getX())) + (v3.getY()-v1.getY())*(v3.getY()-v1.getY());
        latoBC=Math.sqrt(v3.getX()-v3.getX())*(v3.getX()-v3.getX()) + ((v2.getY()-v3.getY())*(v2.getY()-v3.getY()));
	myTwin=null;
    }
    public boolean belongTriangle(Punto p)
    {
        double s,t,r;
        s = 1/(2*this.getArea())*(v1.getY()*v3.getX() - v1.getX()*v3.getY() + (v3.getY() - v1.getY())*p.getX() + (v1.getX() - v3.getX())*p.getY());
        t = 1/(2*this.getArea())*(v1.getX()*v2.getX() - v1.getY()*v2.getX() + (v1.getY() - v2.getY())*p.getX() + (v2.getX() - v1.getX())*p.getY());
        r = 1-s-t;
        if(s>0 && t>0 && r>0)
            return true;
        else 
            return false;
    }
    public double getPerimetro()
    {
        return latoAB+latoAC+latoBC;
    }
    public double getArea()
    {
       return Math.sqrt(this.getPerimetro()/2 * (this.getPerimetro()/2 - latoAB) * (this.getPerimetro()/2 - latoBC) * (this.getPerimetro()/2 - latoAC));
    }
}
