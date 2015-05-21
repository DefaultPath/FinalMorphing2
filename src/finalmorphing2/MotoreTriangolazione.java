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
    private int index;
    ArrayList<CoppiaTriangoli> coppie = new ArrayList(); 
    public MotoreTriangolazione(Triangolo t1Editor1,Triangolo t1Editor2,Triangolo t2Editor1,Triangolo t2Editor2)            
    {
        coppie.add(new CoppiaTriangoli(t1Editor1,t1Editor2));
	coppie.add(new CoppiaTriangoli(t2Editor1,t2Editor2));
	index=0;
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
		    index=i;		    
		}
	    	    {
		if(coppie.get(i).destinazione.belongTriangle(p.myTwin))
		{
		    b= coppie.get(i).destinazione;
		    index=i;
		}
	    }
	}
	t=new CoppiaTriangoli(a,b);
	    return t;
    }
	public void AggiungiPunto(Punto p,int chisono)
	{
	    CoppiaTriangoli contenitore = trovaTriangoliContenitoriDi(p);
	    Punto vertice1,vertice2,vertice3;
	    coppie.add(new CoppiaTriangoli(new Triangolo(contenitore.sorgente.v1,contenitore.sorgente.v2,p),new Triangolo(contenitore.destinazione.v1,contenitore.destinazione.v2,p)));
	    coppie.add(new CoppiaTriangoli(new Triangolo(contenitore.sorgente.v2,contenitore.sorgente.v3,p),new Triangolo(contenitore.destinazione.v2,contenitore.destinazione.v3,p)));
	    coppie.add(new CoppiaTriangoli(new Triangolo(contenitore.sorgente.v1,contenitore.sorgente.v3,p),new Triangolo(contenitore.destinazione.v1,contenitore.destinazione.v3,p)));
	    coppie .remove(contenitore);
	    
	    //coppie.remove(coppie.indexOf(contenitore));
        //rimuovo la coppia che contiene questo triangolo
        //trovo i tre triangoli in entrambi gli editor
	//coppie.add(t);
	}
    }


