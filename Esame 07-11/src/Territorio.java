

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * C'erano duplicato perchè non c'erano i metodi hashCode e equals in posizione e quindi non si potevano 
 * verificare i duplicati
 */

public class Territorio {
	private static final int NUM_INIZIALE_ANIMALI = 2200;
	private static final double PROBABILITA_CARNIVORO = 0.2;

	private int dimensione;	

	private Map<Posizione, Animale> posizione2animale;	


	public Territorio(int dimensione){
		this.dimensione = dimensione;
		this.posizione2animale = new HashMap<Posizione, Animale>();
		this.popolaTerritorio();
	}
	
	public Animale getAnimale(Posizione posizione){
		return posizione2animale.get(posizione);
	}


	public void rimuoviAnimale(Animale animale) {
		this.posizione2animale.remove(animale.getPosizione());
	}



	public void setAnimale(Animale animale, Posizione posizione) {
		if (this.getAnimale(posizione)==null){
			this.posizione2animale.put(posizione, animale);
			animale.setPosizione(posizione);
		} 
	}

	
	public Collection<Animale> getAnimali(){
		return this.posizione2animale.values();
	}
	
	public void sposta(Animale animale, Posizione nuovaPosizione) {
		this.rimuoviAnimale(animale);
		this.setAnimale(animale, nuovaPosizione);		
	}	


	public List<Posizione> adiacenti(Posizione posizione) {
		List<Posizione> adiacenti = new LinkedList<Posizione>();
		int x = posizione.getX();
		int y = posizione.getY();
		
		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				adiacenti.add(new Posizione(x+i, y+j));
				}
			}
		Iterator<Posizione> it = adiacenti.iterator();
		while(it.hasNext()){
			Posizione p = it.next();
			if ((p.getX()<0) || (p.getX()>=this.dimensione) || (p.getY()<0) || 
					(p.getY()>=this.dimensione) || (p.equals(posizione)))
				it.remove();
		}
		Collections.shuffle(adiacenti);
		return adiacenti;
	} 
	
	public Posizione posizioneLiberaVicino(Posizione posizione) {
		for(Posizione p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}
	
	public boolean isLibera(Posizione posizione) {
		if (this.getAnimale(posizione)==null) 
			return true;
		else
			return false;
	}

	public int getDimensione() {
		return this.dimensione;
	}
	
	public Map<Integer, Set<Animale>> anno2Erbivori() {
		Set<Animale> tmp;
		Map<Integer, Set<Animale>> mappa = new HashMap<Integer, Set<Animale>>();
		
		for(Animale erb : this.getAnimali()) {
			tmp = mappa.get(erb.getAnni());
			
			if (tmp==null)
				tmp = new HashSet<>();
			
			tmp.add(erb);
			mappa.put(erb.getAnni(), tmp);	
		}
		
		return mappa;
		
	}
	
	public Set<Posizione> posizioniAnimaliVecchi() {
		
		Set<Posizione> animaliVecchi = new HashSet<>();
		
		Iterator<Animale> it = this.getAnimali().iterator();
		
		while(it.hasNext()) {
			
			Animale e = it.next();
			
			if(e.getAnni()==4)
				animaliVecchi.add(e.getPosizione());
		}
		
		return animaliVecchi;
	}
	
	private void popolaTerritorio(){

		int numeroAnimali = 0;

		while (numeroAnimali < NUM_INIZIALE_ANIMALI) {
			int x = (int)(Math.random()*this.dimensione);
			int y = (int)(Math.random()*this.dimensione);
			Posizione posizione = new Posizione(x, y);
			if (this.isLibera(posizione)) {
				if(Math.random() < PROBABILITA_CARNIVORO) {
					Carnivoro nuovoAnimale = new Carnivoro();
					this.setAnimale(nuovoAnimale, posizione);
				} else {
					Erbivoro nuovoAnimale = new Erbivoro();
					this.setAnimale(nuovoAnimale, posizione);
				}
				numeroAnimali++;
			}
		}
	}
}
