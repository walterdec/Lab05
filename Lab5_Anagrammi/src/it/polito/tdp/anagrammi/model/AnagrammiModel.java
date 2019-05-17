package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class AnagrammiModel {
	
	AnagrammaDAO dao = new AnagrammaDAO();
	
	Set<String> anagrammi = new HashSet<String>();
	Set<String> corretti = new HashSet<String>();
	Set<String> errati = new HashSet<String>();
	
	public Set<String> cercaAnagramma(String input) {
		String parziale = "";
		
		cerca(parziale, 0, input, anagrammi);
		return anagrammi;
	  
	   }
	
	public void cerca(String parziale, int livello, String input, Set<String> anagrammi) {
			//condizione di terminazione
			if(livello==input.length()) {
				anagrammi.add(parziale);
				return;
			}
			
			//
			for(int i=0; i<input.length(); i++) {
				//generare una soluzione
				parziale+=input.charAt(i);
				
				//filtro
				if(conta(parziale, input.charAt(i))<=conta(input, input.charAt(i))){
					cerca(parziale, livello+1, input, anagrammi);
				}
				//backtrack
				parziale = parziale.substring(0, parziale.length()-1);
				
			}
		}
	
	
	private static int conta(String string, char c) {
		int count = 0;
		for(int i=0; i<string.length(); i++) {
			if(string.charAt(i)==c) {
				count++;
			}
		}
		return count;
	}

	public void verificaAnagramma() {
		corretti.clear();
		errati.clear();
		for(String a : anagrammi) {
			if(dao.isCorrect(a)) {
				corretti.add(a);
				}
			else {
				errati.add(a);
			}
		}
	}
	
	public Set<String> getAnagrammiCorretti(){
		return corretti;
	}
	
	public Set<String> getAnagrammiErrati(){
		return errati;
	}
	
	public void clearAnagrammi() {
		anagrammi.clear();
	}

}
