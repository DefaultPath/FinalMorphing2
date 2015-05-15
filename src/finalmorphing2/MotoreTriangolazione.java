/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finalmorphing2;

import java.util.ArrayList;

/**
 *
 * @author studente
 */
public class MotoreTriangolazione 
{
     ArrayList<CoppiaTriangoli> coppie = new ArrayList();
    public MotoreTriangolazione(Triangolo t1Editor1,Triangolo t1Editor2,Triangolo t2Editor1,Triangolo t2Editor2)            
    {
        coppie.add(new CoppiaTriangoli(t1Editor1,t1Editor2));
	coppie.add(new CoppiaTriangoli(t2Editor1,t2Editor2));
    }
    
    public Triangolo trovaTriangoloContenitoreDi(Punto p)
    {
        return t;
    }
    
    public void AggiungiPunto(Punto p)
    {
        Triangolo contenitore = trovaTriangoloContenitoreDi(p);
        //rimuovo la coppia che contiene questo triangolo
        //trovo i tre triangoli in entrambi gli editor
	coppie.add(t);
    }
}
