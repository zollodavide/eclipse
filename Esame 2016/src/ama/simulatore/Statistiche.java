package ama.simulatore;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import ama.CentroDiRaccolta;
import ama.Citta;
import ama.mezzo.Mezzo;
import ama.mezzo.Politica;
import ama.rifiuto.Rifiuto;

public class Statistiche {

	public void stampaStatisticheFinali(Citta citta) {
		final CentroDiRaccolta centro = citta.getCentroDiRaccolta();

		final Set<Rifiuto> smaltiti = centro.getRifiutiSmaltiti();
		System.out.println("Rifiuti smaltiti in totale: " + smaltiti.size());
		System.out.println();
		
		// (VEDI DOMANDA 3 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta da ciascun mezzo impegnato:");
		final Map<Mezzo,Integer> mezzo2quantita = raccoltoPerMezzo(smaltiti);
		stampaRaccoltoPerMezzo(mezzo2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 4 - metodo da completare a seguire)
		System.out.println("Quantita' raccolta per ogni politica:");
		final Map<Class<?>,Integer> politica2quantita = raccoltoPerPolitica(smaltiti);
		stampaRaccoltoPerPolitica(politica2quantita);
		System.out.println();
		
		// (VEDI DOMANDA 5 - metodo da completare a seguire)
		System.out.println("Classifica finale delle politiche raccolta:");
		final List<Class<?>> classificaTipo = ordinaPolitichePerRaccolta(politica2quantita);
		stampaClassificaPolitiche(classificaTipo);
		System.out.println();

		// (VEDI DOMANDA 7 - metodo da completare a seguire)
		System.out.println("Classifica finale dei mezzi per raccolta:");
		final SortedSet<Mezzo> classificaMezzi = ordinaMezziPerRaccolta(mezzo2quantita);
		stampaClassificaMezzi(classificaMezzi);
		System.out.println();
		
	}

	public Map<Mezzo, Integer> raccoltoPerMezzo(Set<Rifiuto> smaltiti) {
		final Map<Mezzo,Integer> mezzo2quantita = new HashMap<>();
		for(Rifiuto r : smaltiti) {
			Mezzo racc = r.getRaccoglitore();
			if(!mezzo2quantita.containsKey(racc)) {
				Integer cont = 1;
				mezzo2quantita.put(racc, cont);
			}
			else {
				int vecchiaQuantita = mezzo2quantita.get(racc);
				mezzo2quantita.put(racc, ++vecchiaQuantita);
			}
		}
		return mezzo2quantita;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 3
	private void stampaRaccoltoPerMezzo(final Map<Mezzo, Integer> mezzo2quantita) {
		for(Mezzo mezzo : mezzo2quantita.keySet()) {
			Integer quantita = mezzo2quantita.get(mezzo);
			if (quantita==null)
				quantita = 0;
			System.out.println("Il mezzo "+mezzo+" ha raccolto "+quantita);
		}
	}

	public Map<Class<?>, Integer> raccoltoPerPolitica(Set<Rifiuto> smaltiti) {
		final Map<Class<?>,Integer> politica2quantita = new HashMap<>();
		for(Rifiuto r : smaltiti) {
			Class<? extends Politica> pol = r.getRaccoglitore().getPolitica().getClass();
			if(!politica2quantita.containsKey(pol)) {
				Integer cont = 1;
				politica2quantita.put(pol, cont);
			}
			else {
				int vecchiaQuantita = politica2quantita.get(pol);
				politica2quantita.put(pol, ++vecchiaQuantita);
			}
		}
		
		return politica2quantita;
	}

	// UTILE PER STAMPARE RISULTATI DOMANDA 4
	private void stampaRaccoltoPerPolitica(final Map<Class<?>, Integer> tipo2quantita) {
		for(Class<?> tipo : tipo2quantita.keySet()) {
			Integer q = tipo2quantita.get(tipo);
			if (q==null)
				q = 0;
			System.out.println("La politica "+tipo.getSimpleName()+" ha raccolto "+q);
		}
	}
	
	public List<Class<?>> ordinaPolitichePerRaccolta(final Map<Class<?>, Integer> politica2quantita) {
		List<Class<?>> politica2raccolta = new ArrayList<>();
		politica2raccolta.addAll(politica2quantita.keySet());
		Collections.sort(politica2raccolta, new ComparatorePolitichePerRaccolta(politica2quantita));
		return politica2raccolta;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 5
	private void stampaClassificaPolitiche(List<Class<?>> classifica) {
		for(int i=1; i<classifica.size()+1; i++)
			System.out.println(i+") "+classifica.get(i-1).getSimpleName());
	}
	
	public SortedSet<Mezzo> ordinaMezziPerRaccolta(final Map<Mezzo, Integer> mezzo2quantita) {
		SortedSet<Mezzo> risultato = new TreeSet<Mezzo>(new ComparatoreMezziPerRaccolta(mezzo2quantita));
		return risultato;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 7
	private void stampaClassificaMezzi(SortedSet<Mezzo> classifica) {
		int posto = 1;
		for(Mezzo mezzo : classifica) {
			System.out.println(posto+") "+mezzo);
			posto++;
		}
	}
	
	
	private class ComparatorePolitichePerRaccolta implements Comparator<Class<?>> {
		
		Map<Class<?>, Integer> base;
		
		public ComparatorePolitichePerRaccolta(Map<Class<?>, Integer> politica2quantita) {
			this.base = politica2quantita;
		}

		@Override
		public int compare(Class<?> p1, Class<?> p2) {
			return this.base.get(p1) - this.base.get(p2);
		}
		
	}
	
	
	private class ComparatoreMezziPerRaccolta implements Comparator<Mezzo> {
		
		
		Map<Mezzo, Integer> base;
		
		public ComparatoreMezziPerRaccolta(Map<Mezzo, Integer> politica2quantita) {
			this.base = politica2quantita;
		}

		@Override
		public int compare(Mezzo m1, Mezzo m2) {
			int comp = this.base.get(m1) - this.base.get(m2);
			
			if(comp == 0)
				comp = m1.getPolitica().getId() - m2.getPolitica().getId();
			
			if(comp == 0)
				comp = m1.getPolitica().getClass().getSimpleName().compareTo(m2.getPolitica().getClass().getSimpleName());
			
			return comp;
		}
		
	}
}
