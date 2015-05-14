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
public class CoppiaPunti 
{
    public Punto sorgente,destinazione;
    public CoppiaPunti(Punto a,Punto b)
    {
        sorgente=a;
        destinazione=b;
        a.myTwin = b;
        b.myTwin = a;
    }
    
    //public void setColor()
}
