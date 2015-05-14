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
     ArrayList<CoppiaTriangoli> couple = new ArrayList();
    public MotoreTriangolazione(Triangolo t1Editor1,Triangolo t1Editor2,Triangolo t2Editor1,Triangolo t2Editor2)            
    {
        couple.add(new CoppiaTriangoli(t1Editor1,t1Editor2));
	couple.add(new CoppiaTriangoli(t2Editor1,t2Editor2));
    }
    public void AggiungiCoppia(CoppiaTriangoli t)
    {
	couple.add(t);
    }
    /*public Triangolo CreaTriangolo(Punto p)
    {
	for(int i=0;i<)
    }*/
}
