package ama.mezzo;

import java.awt.Image;
import java.util.Random;

import ama.Posizione;

public abstract class Politica {
	
	private int id;
	final private Random rnd;

	public Politica() {
		this.rnd = new Random();
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	
	/**
	 * @return un numero intero casuale tra -1,0,+1
	 */
	protected int deltaCasuale() {
		return this.rnd.nextInt(3)-1;
	}
	
	public abstract Image getImmagine();
	
	public abstract Posizione decidiDirezione(Posizione p);


}
