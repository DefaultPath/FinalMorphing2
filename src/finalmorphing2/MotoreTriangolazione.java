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
    public Triangolo trovaTriangoloContenitoreDi(Punto p ,int chisono)//Chisono = 0 sorgete chisono=1 destinatario
    {
	Triangolo t = null;
	
	for(int i=0;i<coppie.size();i++)
	{
	    if(chisono==0)
	    {
		if(coppie.get(i).sorgente.belongTriangle(p))
		{
		    t= coppie.get(i).sorgente;
		    index=i;		    
		}
	    }
	    else if(chisono==1)
	    {
		if(coppie.get(i).destinazione.belongTriangle(p))
		{
		    t= coppie.get(i).destinazione;
		    index=i;
		}
	    }
	}
	    return t;
    }
	public void AggiungiPunto(Punto p,int chisono)
	{
	    Triangolo contenitore = trovaTriangoloContenitoreDi(p,chisono);
	    Punto vertice1,vertice2,vertice3;
	    vertice1=contenitore.v1;
	    vertice2=contenitore.v2;
	    vertice3=contenitore.v3;
	    
	    //coppie.remove(coppie.indexOf(contenitore));
        //rimuovo la coppia che contiene questo triangolo
        //trovo i tre triangoli in entrambi gli editor
	//coppie.add(t);
	}
    }

