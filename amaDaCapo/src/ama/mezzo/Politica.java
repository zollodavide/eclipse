package ama.mezzo;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public abstract class Politica {

	private int id;
	
	private Citta citta;
	
	public Politica(Citta citta, int id){
		this.citta = citta;
		this.id = id;
	}
	
	abstract public Posizione decidiDirezione(Posizione corrente);
		
	
	public int getId() {
		return this.id;
	}
	
	public Citta getCitta() {
		return this.citta;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}


	abstract public Image getImmagine() ;
}
