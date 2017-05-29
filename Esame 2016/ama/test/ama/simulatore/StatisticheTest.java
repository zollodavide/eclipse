package ama.simulatore;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ama.Posizione;
import ama.mezzo.Brown;
import ama.mezzo.Mezzo;
import ama.mezzo.Pendo;
import ama.rifiuto.Rifiuto;
import ama.rifiuto.Vetro;

public class StatisticheTest {

	private Simulatore simulatore;

	private Statistiche stats;	
	
	final static private Posizione ORIGINE = new Posizione(0, 0);
	
	@Before
	public void setUp() throws Exception {
		this.stats = new Statistiche();
		this.simulatore = new Simulatore();
	}

	/* N.B. E' POSSIBILE USARE I  METODI CHE SEGUONO (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	private Vetro creaVetroRaccoltoDaBrowniano() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaBrowniano());	
		return rifiuto;
	}

	
	private Vetro creaVetroRaccoltoDaChaser() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaChaser());	
		return rifiuto;
	}
	
	private Vetro creaVetroRaccoltoDaPendo() {
		final Vetro rifiuto = new Vetro(ORIGINE);
		rifiuto.setRaccoltoDa(this.simulatore.creaPendo());	
		return rifiuto;
	}
	 
	
	/* N.B. E' POSSIBILE USARE I METODI SOPRA (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	
	@Test
	public void testRaccoltoPerMezzo() {
		Set<Rifiuto> s = new HashSet<>();
		s.add(this.creaVetroRaccoltoDaBrowniano());
		s.add(this.creaVetroRaccoltoDaPendo());
		Map<Mezzo, Integer> mezzo;

		Vetro v = new Vetro(ORIGINE);
		Mezzo m = this.simulatore.creaBrowniano();
		v.setRaccoltoDa(m);
		Vetro x = new Vetro(ORIGINE);
		x.setRaccoltoDa(m);
		s.add(x);
		s.add(v);

		mezzo = this.stats.raccoltoPerMezzo(s);

		Iterator<Rifiuto> it = s.iterator();

		assertSame(2, mezzo.get(it.next().getRaccoglitore()));
		assertSame(1, mezzo.get(it.next().getRaccoglitore()));
		assertSame(1, mezzo.get(it.next().getRaccoglitore()));

	}

	
	@Test
	public void testRaccoltoPerPolitica() {
		/* DA COMPLETARE VEDI DOMANDA 4 */
		fail("VEDI DOMANDA 4");
	}
	
	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */

}
