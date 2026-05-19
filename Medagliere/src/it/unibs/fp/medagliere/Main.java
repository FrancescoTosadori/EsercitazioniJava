package it.unibs.fp.medagliere;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;

public class Main {
	private static final int INSERISCI_RISULTATO = 1;
	private static final String TITOLO_SUBMENU = "Inserisci Risultati";
	private static final String[] VOCI_SUB = {"Inserisci Risultato"};
	private static final int ESCI = 0;
	private static final int VISUALIZZA_MEDAGLIERE = 4;
	private static final int INTRODUCI_RISULTATI_GARE = 3;
	private static final int INTRODUCI_NUOVA_GARA = 2;
	private static final int INTRODUCI_NUOVA_NAZIONE = 1;
	private static final String TITOLO_PRINC = "Medagliere";
	private static final String[] VOCI_PRINC = {"Introduci nuova nazione",
			  							  "Introduci nuova gara",
			                              "Introduci risultati gare",
			                              "Visualizza medagliere"};

	private static ListaNazioni elencoNazioni = new ListaNazioni();
	private static ListaGare elencoGare = new ListaGare();
		
	public static void main(String[] args) {
		MyMenu menuCasa = new MyMenu(TITOLO_PRINC, VOCI_PRINC);
		
		boolean ciclo = true;
		while(ciclo) {
			switch(menuCasa.scegli()) {
				case INTRODUCI_NUOVA_NAZIONE:
					introduciNuovaNazione();
					break;
				case INTRODUCI_NUOVA_GARA:
					introduciNuovaGara();
					break;
				case INTRODUCI_RISULTATI_GARE:
					if(elencoGare.contieneGare() && elencoNazioni.contieneNazioni())
						introduciRisultatiGare();
					else {
						if(elencoGare.contieneGare())
							System.out.println("Inserire Nazioni!");
						else
							System.out.println("Inserire Gare!");
					}
					break;
				case VISUALIZZA_MEDAGLIERE:
					visualizzaMedagliere();
					break;
				case ESCI:
					ciclo = false;
					break;
			}
		}
	}
	
	private static void introduciNuovaNazione() {
		String leggiStringa = InputDati.leggiStringa("Inserisci nome nazione: ");
		Nazione nuovaNazione = new Nazione(leggiStringa);
		
		if(elencoNazioni.inserisciNazione(nuovaNazione)) {
			System.out.println("Nome inserito correttamente");
		}else{
			System.out.println("Nazione già esistente");
		};
		
	}
	
	private static void introduciNuovaGara() {
		String leggiStringa = InputDati.leggiStringa("Inserisci nome gara: ");
		Gara nuovaGara = new Gara(leggiStringa);
		
		if(elencoGare.inserisciGara(nuovaGara)) {
			System.out.println("Nome inserito correttamente");
		}else{
			System.out.println("Gara già esistente");
		};
	}
	
    private static void introduciRisultatiGare() {
		boolean ciclo = true;
		MyMenu submenu = new MyMenu(TITOLO_SUBMENU, VOCI_SUB);
		
		while(ciclo) {
			switch(submenu.scegli()) {
				case INSERISCI_RISULTATO:
					String nomeGara = InputDati.leggiStringa("Inserisci nome Gara: ");
					Gara garaScelta = new Gara(nomeGara);
					if(elencoGare.contieneGara(garaScelta)) {
						try {
						inserisciPodio(
							elencoNazioni.getNazione(InputDati.leggiStringa("Inserire nome nazione in prima posizione")),
							elencoNazioni.getNazione(InputDati.leggiStringa("Inserire nome nazione in seconda posizione")),
							elencoNazioni.getNazione(InputDati.leggiStringa("Inserire nome nazione in terza posizione"))
						);
						}catch(Exception e) {
							System.out.println("Errore nell'inserimento delle nazioni");
						}
					}else {
						System.out.println("Gara insesistente");
					}
					break;
				case ESCI:
					ciclo = false;
					break;
			}
			
		}
	}
    
    private static void visualizzaMedagliere() {
    	System.out.println(elencoNazioni);
    }
    
    private static void inserisciPodio(Nazione oro, Nazione argento, Nazione bronzo) {
    	oro.aggiungiOro();
    	argento.aggiungiAg();
    	bronzo.aggiungiBronzo();
    }
}
