package ama.simulatore;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

import ama.CentroDiRaccolta;
import ama.Citta;
import ama.mezzo.Brown;
import ama.mezzo.Chase;
import ama.mezzo.Mezzo;
import ama.mezzo.Pendo;
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
			if(!mezzo2quantita.containsKey(r.getRaccoglitore())) {
				mezzo2quantita.put(r.getRaccoglitore(), 1);
			}
			
			else {
				Integer cont = mezzo2quantita.get(r.getRaccoglitore());
				mezzo2quantita.put(r.getRaccoglitore(), ++cont);
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
			System.out.println("Il mezzo "+mezzo.getPolitica().toString()+" ha raccolto "+quantita);
		}
	}

	public Map<Class<?>, Integer> raccoltoPerPolitica(Set<Rifiuto> smaltiti) {
		final Map<Class<?>,Integer> politica2quantita = new HashMap<>();
		
		for(Rifiuto rifiuto : smaltiti) {
			
			Class<? extends Politica> c= rifiuto.getRaccoglitore().getPolitica().getClass(); 
			
			if(!politica2quantita.containsKey(c))
				politica2quantita.put(c, 1);
			
				
			else {
				Integer cont = politica2quantita.get(c);
				politica2quantita.put(c, ++cont);
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
		
//		List<Integer> ord=new ArrayList<>(politica2quantita.values());
//		List<Class<?>> classi=new ArrayList<>();
//		Collections.sort(ord,new OrdinaClassiPerRaccolta());
//		for (Integer integer : ord) {
//			if(politica2quantita.get(Pendo.class)==integer)
//				classi.add(Pendo.class);
//			if(politica2quantita.get(Chase.class)==integer)
//				classi.add(Chase.class);
//			if(politica2quantita.get(Brown.class)==integer)
//				classi.add(Brown.class);
//		}
		
		SortedMap<Class<?>, Integer> ord=new TreeMap<>(new ComparatoreP(politica2quantita));
		ord.putAll(politica2quantita);
		List<Class<?>> classi = new ArrayList<>(ord.keySet());
		
//		
		return classi;
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 5
	private void stampaClassificaPolitiche(List<Class<?>> classifica) {
		for(int i=1; i<classifica.size()+1; i++)
			System.out.println(i+") "+classifica.get(i-1).getSimpleName());
	}
	
	public SortedSet<Mezzo> ordinaMezziPerRaccolta(final Map<Mezzo, Integer> mezzo2quantita) {
		
		
		return Collections.emptySortedSet();
	}

	//  UTILE PER STAMPARE RISULTATI DOMANDA 7
	private void stampaClassificaMezzi(SortedSet<Mezzo> classifica) {
		int posto = 1;
		for(Mezzo mezzo : classifica) {
			System.out.println(posto+") "+mezzo);
			posto++;
		}
	}
	
	private class OrdinaClassiPerRaccolta implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
		
		

	}
	
	
	private class ComparatoreP implements Comparator<Class<?>>{
		
		private Map<Class<?>, Integer> politica2quantita;
		
		public ComparatoreP(Map<Class<?>, Integer> politica2quantita){
			this.politica2quantita=politica2quantita;
		}

		@Override
		public int compare(Class<?> c1, Class<?> c2) {
			int comp=politica2quantita.get(c2)-politica2quantita.get(c1);
		
			if(comp==0)
				comp= c2.getSimpleName().compareTo(c1.getSimpleName());
			
			return comp;
		}
		
		
		
	}
}
