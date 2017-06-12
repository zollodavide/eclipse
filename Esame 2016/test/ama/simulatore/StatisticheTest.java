package ama.simulatore;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
	
	/* N.B. E' POSSIBILE USARE I METODI SOPRA (E CREARNE DI SIMILARI) 
	 * PER VELOCIZZARE IL TESTING RELATIVO ALLE DOMANDE 3 E SUCCESSIVE */
	
	@Test
	public void testRaccoltoPerMezzo() {
		Set<Rifiuto> smaltiti = new HashSet<>();
		Vetro rBrown = creaVetroRaccoltoDaBrowniano();
		Vetro rChaser = creaVetroRaccoltoDaChaser();
		smaltiti.add(rBrown);
		smaltiti.add(rChaser);
		Map<Mezzo, Integer> raccolto = this.stats.raccoltoPerMezzo(smaltiti);
		assertEquals(2, raccolto.size());
		assertEquals(1, raccolto.get(rBrown.getRaccoglitore()).intValue());
	}
	
	@Test
	public void testOrdinaMezziPerRaccolta_listaVuota() {
		Map<Class<?>, Integer> empty = new HashMap<Class<?>, Integer>();
		assertTrue(this.stats.ordinaPolitichePerRaccolta(empty).isEmpty());
	}
	
	@Test
	public void testOrdinaMezziPerRaccolta_Singleton() {
		Map<Class<?>, Integer> singleton = new HashMap<Class<?>, Integer>();
		singleton.put(Pendo.class, 1);
		assertTrue(this.stats.ordinaPolitichePerRaccolta(singleton).contains(Pendo.class));
	}
	
	@Test
	public void testOrdinaMezziPerRaccolta_Doubleton() {
		Map<Class<?>, Integer> doubleton = new HashMap<Class<?>, Integer>();
		doubleton.put(Pendo.class, 1);
		doubleton.put(Brown.class, 2);
		assertEquals(2, this.stats.ordinaPolitichePerRaccolta(doubleton).size());
	}
	/*                              */
	/* DA COMPLETARE VEDI DOMANDA 6 */
	/*                              */

}
