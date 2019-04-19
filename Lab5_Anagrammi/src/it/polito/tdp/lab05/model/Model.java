package it.polito.tdp.lab05.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab05.DAO.AnagrammaDAO;

public class Model {
	
	private List<String> listaAnagrammi = new LinkedList<String>();
	

	public boolean isCorrect(String anagramma) {
		return ((new AnagrammaDAO()).isCorrect(anagramma));
	}
	
	public List<Parola> soluzione(String parola) {
		this.generaAnagrammi(parola, 0);
		List<Parola> ret = new LinkedList<Parola>();
		for(String s : this.listaAnagrammi) {
			ret.add((new Parola(s)));
		}
		return ret;
	}
	
	private void generaAnagrammi(String parola, int livello) {
		if(livello == parola.length() - 1) {
			this.listaAnagrammi.add(parola);
			return;
		}
		
		for(int i = livello; i < parola.length(); i++) {
			parola = this.swap(parola, livello, i);
			generaAnagrammi(parola, livello + 1);
			parola = this.swap(parola, livello, i);
		}
		
	}
	
	public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
	
	
	private int calcolaFattoriale(int numero) {
		int res = 1;
		for(int i = numero; i < 0; i--) {
			res *= i;
		}
		return res;
	}
	
	private int lettereRipetute(String parola) {
		int ret = 0;
		char[] chars = parola.toCharArray();
		
		for(int c = 0; c < chars.length; c++) {
			for(int counter = c + 1; counter < chars.length; counter++) {
				if(chars[c] == chars[counter]) {
					ret++;
				}
			}
		}
		return ret*2;
	}
	
	private int anagrammiPossibili(String parola) {
		if(this.lettereRipetute(parola) == 0) {
			return this.calcolaFattoriale(parola.length());
		}
		else {
			return this.calcolaFattoriale(parola.length())/this.calcolaFattoriale(this.lettereRipetute(parola));
		}
	}
	
}
