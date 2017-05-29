package ama.mezzo;

import java.awt.Image;
import static ama.costanti.CostantiGUI.IMMAGINE_CAMION_ROSSO;

import ama.Citta;
import ama.Posizione;

public class Pendo extends Politica {

	static private int progId=0;
	private Citta citta;	
	static private boolean rimbalzo;

	public Pendo(Citta citta) {
		super();
		this.citta = citta;
		super.setId(progId++);
		rimbalzo = false;
	}

	@Override
	public Image getImmagine() {
		return IMMAGINE_CAMION_ROSSO;
	}

	@Override
	public Posizione decidiDirezione(Posizione corrente) {
		Posizione vicino;
		
		if (!rimbalzo) {
			vicino = corrente.traslazioneUnitaria(1, 0);
			if(this.getCitta().sulBordo(vicino)) {
				vicino = corrente.traslazioneUnitaria(-1, 0);
				rimbalzo = true;
			}
		}
		
		else {
			vicino = corrente.traslazioneUnitaria(-1, 0);
			if(this.getCitta().sulBordo(vicino)) {
				vicino = corrente.traslazioneUnitaria(1, 0);
				rimbalzo = false;
			}

		}
		
		return vicino;
	}

	public Citta getCitta() {
		return citta;
	}
	

	@Override
	public String toString() {
		return getClass().getSimpleName()+getId();
	}
	
	

}
