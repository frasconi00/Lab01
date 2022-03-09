package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	private List<String> listaParole;
	
	public Parole() {
		this.listaParole = new LinkedList<String>(); //si può cambiare con ArrayList
	}
	
	public void addParola(String p) {
		if(!listaParole.contains(p))
			this.listaParole.add(p);
	}
	
	public List<String> getElenco() {
		
		Collections.sort(listaParole, new ComparatoreParole());
		
		return listaParole;
	}
	
	public void reset() {
		this.listaParole.clear();;
	}
	
	public void cancella(String p) {
		listaParole.remove(p);
	}

}
