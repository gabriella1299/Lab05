package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	List<String> risultato=new ArrayList<String>();
	AnagrammaDAO anagramma=new AnagrammaDAO();
	
	public List<String> getSoluzione(String parola){
		
		if(anagramma.isCorrect(parola)==false) {
			return null;			
		}
		
		permuta("",0,parola);
		//System.out.println(risultato);
		return risultato;
		
	}
	
	public void permuta(String parziale, Integer livello, String residui) {
		
		//caso terminale
		if(residui.length()==0) { 
			risultato.add(parziale);
		}
		
		for(int i=0; i<residui.length();i++) {
			parziale=parziale+residui.charAt(i);
			permuta(parziale,livello+1,residui.substring(0, i)+residui.substring(i+1));
			//backtracking
			parziale=parziale.substring(0,parziale.length()-1);
		}
	}
	
	public void svuotaLista() {
		risultato.clear();
	}
		
}
