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
    public CoppiaTriangoli(Triangolo t1,Triangolo t2)
    {
	sorgente=t1;
	destinazione=t2;
	t1.myTwin=t2;
	t2.myTwin=t1;
    }
    
    //public void setColor()
}
