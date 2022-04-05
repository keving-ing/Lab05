package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.db.DizionarioDAO;

public class Model {
	
	List<String> anagrammi = new LinkedList<String>();
	DizionarioDAO diz = new DizionarioDAO();
	
	public void anagramma(String s)
	{
		anagrammi.clear();
		anagrammaRicorsiva("",0,s);
		
	}

	private void anagrammaRicorsiva(String parziale, int L, String rimanenti) {
		
		
		
		if(rimanenti.length()==0)
		{
			System.out.println(parziale);
			anagrammi.add(parziale);
		}
		
		else
		{
			for(int pos = 0; pos<rimanenti.length(); pos++)
			{
				anagrammaRicorsiva(parziale + rimanenti.charAt(pos), L+1, rimanenti.substring(0, pos)+rimanenti.substring(pos+1));
			}
		}
		
	}
	
	public List<String> paroleGiuste (String s)
	{
		this.anagramma(s);
		return diz.getParolegiuste(anagrammi);
		
	}
	
	public List<String> paroleSbagliate (String s)
	{
		this.anagramma(s);
		return diz.getResultsbagliate();
	}

}
