package it.unibs.fp.medagliere;

public class Gara {
	private String nome;
	
	public Gara(String nome){
		this.nome = nome;
	}
	
	public String toString(){
		return this.nome;
	}
	
	public String getNome() {
		return nome;
	}

	public boolean isUguale(Gara g){
		if(g.getNome().toUpperCase().equals(nome.toUpperCase()))
			return true;
		else
			return false;
	}
}
