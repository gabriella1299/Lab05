package it.polito.tdp.anagrammi.model;


import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	Set<String> risultato;
	AnagrammaDAO anagramma;
	
	public Model() {
		anagramma=new AnagrammaDAO();
	}
	
	public Set<String> getSoluzione(String parola){

		risultato=new HashSet<String>();//si svuota sempre ogni volta che viene premuto il bottone 'Calcola Anagrammi'
										//non serve piu' la funzione svuotaSet()
		
		if(anagramma.isCorrect(parola)==false) {
			return null;			
		}
		
		permuta("",0,parola);
		return risultato;
		
	}
	
	public void permuta(String parziale, Integer livello, String residui) {
		
		//caso terminale
		if(residui.length()==0) { 
			risultato.add(parziale);
			return;
		}
		
		for(int i=0; i<residui.length();i++) {
			parziale=parziale+residui.charAt(i);
			permuta(parziale,livello+1,residui.substring(0, i)+residui.substring(i+1));
			//backtracking
			parziale=parziale.substring(0,parziale.length()-1);
		}
	}
	
	/*public void svuotaSet() {
		risultato.clear();
	}*/
		
}
