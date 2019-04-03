package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class AnagrammiModel {
	
	AnagrammaDAO dao = new AnagrammaDAO();
	
	Set<String> anagrammi = new HashSet<String>();
	Set<String> corretti = new HashSet<String>();
	Set<String> errati = new HashSet<String>();
	
	public void cercaAnagramma(String beginningString, String endingString) {
	   if (endingString.length() <= 1)
	       anagrammi.add(beginningString+endingString);
	      else
	        for (int i = 0; i < endingString.length(); i++) {
	          try {
	            String newString = endingString.substring(0, i) + endingString.substring(i + 1);
	            anagrammi.add(beginningString + endingString);
	            cercaAnagramma(beginningString + endingString.charAt(i), newString);
	          } catch (StringIndexOutOfBoundsException exception) {
	            exception.printStackTrace();
	            throw new RuntimeException();
	          }
	        }
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
