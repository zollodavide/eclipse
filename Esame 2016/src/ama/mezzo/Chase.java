package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_VERDE;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Chase extends Politica{
	
	private Citta citta;
	static private int progId=0;	

	
	public Chase(Citta citta) {
		super();
		this.citta = citta;
		super.setId(progId++);
	}

	public Citta getCitta() {
		return this.citta;
	}
	
	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		final Posizione posizioneRifiutoNelleVicinanze = 
				this.getCitta().getRifiutoVicinoA(corrente);
		if (posizioneRifiutoNelleVicinanze==null) 
			return corrente.traslazioneUnitaria(deltaCasuale(),deltaCasuale());
		else 
			return posizioneRifiutoNelleVicinanze;
	}


	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_VERDE;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}

}
