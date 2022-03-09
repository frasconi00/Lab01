package it.polito.tdp.parole.model;

import java.util.Comparator;

public class ComparatoreParole implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		
		String s1 = o1.toLowerCase();
		String s2 = o2.toLowerCase();
		
		return s1.compareTo(s2);
	}

}
