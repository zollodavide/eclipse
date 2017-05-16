

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulatore {

	private static final int PASSI = 10;
	private static final int DIMENSIONE = 50;

	private Territorio territorio;
	private VisualizzatoreTerritorio visualizzatore;
	
	public Simulatore(){
		this.territorio = new Territorio(DIMENSIONE);
		this.visualizzatore = new VisualizzatoreTerritorio(DIMENSIONE);
	}

	public void run(){
		for(int i=0;i<PASSI; i++) {
			List<Animale> animale = new ArrayList<Animale>(this.territorio.getAnimali());
			Collections.shuffle(animale);
			
			for(Animale a : animale) {
				a.agisci(territorio);
			}
			this.visualizzatore.aggiornaSchermata(i, this.territorio);
			
			try {
				Thread.sleep(5 *100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Simulatore s = new Simulatore();
		s.run();
	}
}
