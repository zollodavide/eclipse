import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ConsorzioTest {

	Consorzio consorzio;

	@Before
	public void setUp() throws Exception {
		this.consorzio = new Consorzio(1, "ger", "Zollo & Co");
	}

	@Test
	public void testVuoto() {
		Map<String, List<Societa>> nazioni = consorzio.nazione2consorziate();
		assertSame(consorzio, nazioni.get("ger").get(0));
	}

	@Test
	public void testSingleton() {
		Societa soc_1 = new Impresa(1, "ita", "BobCo");
		consorzio.aggiungiConsorziata(soc_1);
		Map<String, List<Societa>> nazioni = consorzio.nazione2consorziate();
	
		assertTrue(nazioni.containsKey(soc_1.getNazione()));
		assertSame(soc_1, nazioni.get("ita").get(0));
	}
	
	@Test
	public void testDoubletonDiverse() {
		Societa soc_1 = new Impresa(1, "ita", "BobCo");
		consorzio.aggiungiConsorziata(soc_1);
		Societa soc_2 = new Consorzio(2, "ven", "TomCo");
		consorzio.aggiungiConsorziata(soc_2);
		Map<String, List<Societa>> nazioni = consorzio.nazione2consorziate();
		
		assertTrue(nazioni.containsKey(soc_1.getNazione()));
		assertTrue(nazioni.containsKey(soc_2.getNazione()));
		
		assertSame(soc_1, nazioni.get("ita").get(0));
		assertSame(soc_2, nazioni.get("ven").get(0));
	}
	
	@Test
	public void testDoubletonUguali() {
		Societa soc_1 = new Impresa(1, "ita", "BobCo");
		consorzio.aggiungiConsorziata(soc_1);
		Societa soc_3 = new Impresa(3, "ita", "CipCo");
		consorzio.aggiungiConsorziata(soc_3);
		Map<String, List<Societa>> nazioni = consorzio.nazione2consorziate();

		assertTrue(nazioni.containsKey(soc_1.getNazione()));

		assertSame(soc_1, nazioni.get("ita").get(0));
		assertSame(soc_3, nazioni.get("ita").get(1));
	}
	
	@Test
	public void testNazione2Con() {
		
		Societa soc_2 = new Impresa(1, "ita", "BopCo");
		consorzio.aggiungiConsorziata(soc_2);
		
		Consorzio con_1 = new Consorzio(1, "ven", "Cons");
		
		Societa soc_1 = new Impresa(1, "ita", "BobCo");
		con_1.aggiungiConsorziata(soc_1);
		
		Societa soc_3 = new Impresa(3, "ita", "CipCo");
		con_1.aggiungiConsorziata(soc_3);
		
		consorzio.aggiungiConsorziata(con_1);
		
		Map<String, List<Societa>> nazioni = consorzio.nazione2consorziate();

		assertFalse(nazioni.isEmpty());
		
		assertSame(3, nazioni.get("ita").size());
		assertSame(1, nazioni.get("ven").size());
		assertSame(1, nazioni.get("ger").size());


		assertSame(3, nazioni.size());

		assertSame(soc_1, nazioni.get("ita").get(0));
		assertSame(soc_3, nazioni.get("ita").get(1));
		assertSame(soc_2, nazioni.get("ita").get(2));
		assertSame(con_1, nazioni.get("ven").get(0));
		assertSame(consorzio, nazioni.get("ger").get(0));

	}
	
	@Test
	public void testDipendentiVuoto() {
		assertSame(0, consorzio.getNumeroDipendenti());
	}
	
	@Test
	public void testDipendentiSingleton() {
		consorzio.aggiungiDipendente(new Dipendente("singleton", 1));
		assertSame(1,  consorzio.getNumeroDipendenti());
	}
	
	@Test
	public void testDipendentiDoubleton() {
		consorzio.aggiungiDipendente(new Dipendente("singleton", 1));
		consorzio.aggiungiDipendente(new Dipendente("doubleton", 1));
		assertSame(2,  consorzio.getNumeroDipendenti());
	}
	
	@Test
	public void testDipendentiDoubletonUguali() {
		consorzio.aggiungiDipendente(new Dipendente("singleton", 1));
		consorzio.aggiungiDipendente(new Dipendente("singleton", 1));
		assertSame(1,  consorzio.getNumeroDipendenti());

	}
	
}
