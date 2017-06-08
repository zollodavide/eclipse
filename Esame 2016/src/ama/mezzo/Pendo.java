package ama.mezzo;

import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

import java.awt.Image;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {

	static private int progIdPendo=0;	

	private int verso = 1;
	
	public Pendo(Citta citta) {
		super(citta, progIdPendo++);
	}

	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		Posizione nuovaPosizione = corrente.traslazioneUnitaria(this.verso, 0);
		if(this.getCitta().sulBordo(nuovaPosizione)){
			this.verso *= (-1);
			return corrente.traslazioneUnitaria(this.verso, 0);
		}
		else
			return nuovaPosizione;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

}
