package it.unibs.fp.medagliere;

import java.util.ArrayList;

public class ListaGare {
	private ArrayList<Gara> listaGare;
	
	public ListaGare() {
		this.listaGare = new ArrayList<Gara>();
	}
	
	public boolean inserisciGara(Gara g) {
		//Controllo che la gara non sia già stata inserita
		if(contieneGara(g))
			return false;
		
		//Aggiungi la gara
		listaGare.add(g);
		return true;
	}

	public boolean contieneGara(Gara g) {
		for(Gara garaNuova : listaGare) {
			if(g.isUguale(garaNuova))
				return true;
		}
		return false;
	}
	
	public boolean contieneGare() {
		if(listaGare.size() != 0)
			return true;
		return false;
	}
	
}
