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
    public Punto v1,v2,v3;
    private double latoAB,latoAC,latoBC;
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
    public Triangolo()
    {
        v1=new Punto(0,0,false,null);
        v2=new Punto(0,0,false,null);
        v3=new Punto(0,0,false,null);
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
        public boolean belongTriangle(Pixel p,int x,int y)
    {
        /*double s,t,r;
        s = 1/(2*this.getArea())*(v1.getY()*v3.getX() - v1.getX()*v3.getY() + (v3.getY() - v1.getY())*x + (v1.getX() - v3.getX())*y);
        t = 1/(2*this.getArea())*(v1.getX()*v2.getX() - v1.getY()*v2.getX() + (v1.getY() - v2.getY())*x + (v2.getX() - v1.getX())*y);
        r = 1-s-t;
        if(s>0 && t>0 && r>0)
            return true;
        else 
            return false;*/
	boolean b1,b2,b3;
	b1 = sign(new Punto(x, y, false, null), v1, v2) < 0.0d;
	b2 = sign(new Punto(x, y, false, null), v2, v3) < 0.0d;
	b3 = sign(new Punto(x, y, false, null), v3, v1) < 0.0d;
	return ((b1==b2) && (b2==b3));
    }	
    public double getPerimetro()
    {
        return latoAB+latoAC+latoBC;
    }
    public double getArea()
    {
       return Math.sqrt(this.getPerimetro()/2 * (this.getPerimetro()/2 - latoAB) * (this.getPerimetro()/2 - latoBC) * (this.getPerimetro()/2 - latoAC));
    }
    private double sign(Punto p1,Punto p2,Punto p3)
    {
	return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }
}
