package it.unibs.fp.medagliere;

public class Nazione {
	private String nome;
	private int [] risultati = {0,0,0};
	
	public Nazione(String nome) {
		this.nome = nome;
	}
	
	public void aggiungiOro() {
		this.risultati[0]++;
	}
	
	public void aggiungiAg() {
		this.risultati[1]++;
	}
	
	public void aggiungiBronzo() {
		this.risultati[2]++;
	}
	
	public String toString(){
		return risultati[0] + "\t" + risultati[1] + "\t" + risultati[2] + "\t" + nome;
	}
	
	public String getNome() {
		return nome;
	}

	public boolean isUguale(Nazione n){
		if(n.getNome().toUpperCase().equals(nome.toUpperCase()))
			return true;
		else
			return false;
	}
}
