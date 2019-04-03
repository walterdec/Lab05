package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class AnagrammiModel {
	
	AnagrammaDAO dao = new AnagrammaDAO();
	
	List<String> anagrammi = new ArrayList<String>();
	List<String> corretti = new ArrayList<String>();
	List<String> errati = new ArrayList<String>();
	
	public void cercaAnagramma(String anagramma) {
		anagrammi.add(anagramma);
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
	
	public List<String> getAnagrammiCorretti(){
		return corretti;
	}
	
	public List<String> getAnagrammiErrati(){
		return errati;
	}
	
	public void clearAnagrammi() {
		anagrammi.clear();
	}

}
