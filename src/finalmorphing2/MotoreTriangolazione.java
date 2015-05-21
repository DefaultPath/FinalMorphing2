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
		}
	    }
	    else if(chisono==1)
	    {
		if(coppie.get(i).destinazione.belongTriangle(p))
		{
		    t= coppie.get(i).destinazione;		    
		}
	    }
	}
	    return t;
    }
	public void AggiungiPunto(Punto p,int chisono)
	{
	    Triangolo contenitore = trovaTriangoloContenitoreDi(p,chisono);
	    //coppie.remove(coppie.indexOf(contenitore));
        //rimuovo la coppia che contiene questo triangolo
        //trovo i tre triangoli in entrambi gli editor
	//coppie.add(t);
	}
    }
}
