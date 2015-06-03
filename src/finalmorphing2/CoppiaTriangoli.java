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
public class CoppiaTriangoli 
{
    public final Triangolo sorgente,destinazione;
    public Triangolo finale;
    public CoppiaTriangoli(Triangolo t1,Triangolo t2,double perc)
    {
	sorgente=t1;
	destinazione=t2;
	t1.myTwin=t2;
	t2.myTwin=t1;
        finale = new Triangolo();
        GeneraTriangoloFinale(perc);
    }
    public final void GeneraTriangoloFinale(double perc)
    {
        finale.v1.setX((sorgente.v1.getX()*perc)+(destinazione.v1.getX()*(1-perc)));
        finale.v1.setY((sorgente.v1.getY()*perc)+(destinazione.v1.getY()*(1-perc)));
        finale.v2.setX((sorgente.v2.getX()*perc)+(destinazione.v2.getX()*(1-perc)));
        finale.v2.setY((sorgente.v2.getY()*perc)+(destinazione.v2.getY()*(1-perc)));
        finale.v3.setX((sorgente.v3.getX()*perc)+(destinazione.v3.getX()*(1-perc)));
        finale.v3.setY((sorgente.v3.getY()*perc)+(destinazione.v3.getY()*(1-perc)));      
    }
}
