package it.unibs.fp.medagliere;

import java.util.ArrayList;

public class ListaNazioni {
	private ArrayList<Nazione> listaNazioni;
	
	public ListaNazioni() {
		this.listaNazioni = new ArrayList<Nazione>();
	}
	
	public boolean inserisciNazione(Nazione n) {
		//Controllo che la Nazione non sia già stata inserita
		if(contieneNazione(n))
			return false;
		
		//Aggiungi la Nazione
		listaNazioni.add(n);
		return true;
	}

	public boolean contieneNazione(Nazione n) {
		for(Nazione NazioneNuova : listaNazioni) {
			if(n.isUguale(NazioneNuova))
				return true;
		}
		return false;
	}
	
	public boolean contieneNazioni() {
		if(listaNazioni.size() != 0)
			return true;
		return false;
	}
	
	public String toString() {
		StringBuffer out = new StringBuffer("Ori     ArgentisBronzi  Nazione");
		for(Nazione nazione : listaNazioni) {
			out	
			.append("\n")
			.append(nazione);
		}
		return out.toString();
	}
	
	public Nazione getNazione(String nomeNazioneCercata) {
		Nazione nazioneCercata = new Nazione(nomeNazioneCercata);
		for(int i = 0; i < listaNazioni.size(); i++) {
			if(listaNazioni.get(i).isUguale(nazioneCercata))
					return listaNazioni.get(i);
		}
		return null;
	}
	
}
