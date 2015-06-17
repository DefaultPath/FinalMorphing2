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
    public int conta = 2;
    public ArrayList<CoppiaTriangoli> coppie = new ArrayList(); 
    public MotoreTriangolazione(Triangolo t1Editor1,Triangolo t1Editor2,Triangolo t2Editor1,Triangolo t2Editor2)            
    {
        coppie.add(new CoppiaTriangoli(t1Editor1,t1Editor2,0));
	coppie.add(new CoppiaTriangoli(t2Editor1,t2Editor2,0));	
    }
    public CoppiaTriangoli trovaTriangoliContenitoriDi(Punto p )//Chisono = 0 sorgete chisono=1 destinatario
    {
	CoppiaTriangoli t;
	Triangolo a = null,b = null; 
	for(int i=0;i<coppie.size();i++)
	{
	    
		if(coppie.get(i).sorgente.belongTriangle(p))
		{
		    a= coppie.get(i).sorgente;		   		     
                    if(coppie.get(i).sorgente.myTwin.belongTriangle(p.myTwin))
                            return coppie.get(i);
                    else
                    {
                        System.err.println("Errore punto messo troppo lontano");
                        System.exit(10);
                    }
                }
	}
        System.err.println("il punto "+p+" non e' contenuto in nesusn triangolo!!!!");
        System.exit(11);
        return null;
    }
    
	public void AggiungiPunto(Punto p)
	{

	    CoppiaTriangoli contenitore = trovaTriangoliContenitoriDi(p);
	    Punto vertice1,vertice2,vertice3;
	    coppie.add(new CoppiaTriangoli(new Triangolo(contenitore.sorgente.v1,contenitore.sorgente.v2,p),new Triangolo(contenitore.destinazione.v1,contenitore.destinazione.v2,p),0));
	    coppie.add(new CoppiaTriangoli(new Triangolo(contenitore.sorgente.v2,contenitore.sorgente.v3,p),new Triangolo(contenitore.destinazione.v2,contenitore.destinazione.v3,p),0));
	    coppie.add(new CoppiaTriangoli(new Triangolo(contenitore.sorgente.v1,contenitore.sorgente.v3,p),new Triangolo(contenitore.destinazione.v1,contenitore.destinazione.v3,p),0));
       
	}
   
}


