import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class DisegnoTest {

	Disegno disegno;
	
	@Before
	public void setUp() {
		disegno = new Disegno(); 
	}
	
	@Test
	public void testDisegnoColore2forme_Vuoto() {
		Map<Colore, List<Forma>> colore2forme = disegno.colore2forme();
		assertTrue(colore2forme.isEmpty());
	}
	
	@Test
	public void testDisegnoColore2forme_FormaSingola() {
		Forma c1 = new Cerchio(new Colore(1, 1, 1), new Punto(0,0), 1);

		disegno.aggiungiForma(c1,1);
		
		Map<Colore, List<Forma>> colore2forme = disegno.colore2forme();
		assertSame(c1, colore2forme.get(new Colore(1, 1, 1)).get(0));
	}

	@Test
	public void testDisegnoColore2forme_2formeColoreUguale() {
		Forma c1 = new Cerchio(new Colore(1, 1, 1), new Punto(0,0), 1);
		Forma c2 = new Cerchio(new Colore(1, 1, 1), new Punto(1,0), 3);

		disegno.aggiungiForma(c1,1);
		disegno.aggiungiForma(c2,2);
		
		Map<Colore, List<Forma>> colore2forme = disegno.colore2forme();
		assertSame(c1, colore2forme.get(new Colore(1, 1, 1)).get(0));
		assertSame(c2, colore2forme.get(new Colore(1, 1, 1)).get(1));
	}
	
	@Test
	public void testDisegnoColore2forme_2formeColoreDiverso() {
		Forma c1 = new Cerchio(new Colore(1, 1, 1), new Punto(0,0), 1);
		Forma c2 = new Cerchio(new Colore(1, 0, 0), new Punto(1,0), 3);

		disegno.aggiungiForma(c1,1);
		disegno.aggiungiForma(c2,2);
		
		Map<Colore, List<Forma>> colore2forme = disegno.colore2forme();
		assertSame(c1, colore2forme.get(new Colore(1, 1, 1)).get(0));
		assertSame(c2, colore2forme.get(new Colore(1, 0, 0)).get(0));
	}
	
	
	
	
	
	
	
	
	
	@Test
	public void testDisegnoLuminosita_Vuoto() {
		List<Forma> forme = disegno.formeOrdinatePerLuminosita();
		assertTrue(forme.isEmpty());
	}
	
	@Test
	public void testDisegnoLuminosita_FormaSingola() {
		Forma c1 = new Cerchio(new Colore(1, 1, 1), new Punto(0,0), 1);

		disegno.aggiungiForma(c1,1);
		
		List<Forma> forme = disegno.formeOrdinatePerLuminosita();
		assertSame(c1, forme.get(0));
	}

	@Test
	public void testDisegnoLuminosita_2formeColoreDiverso() {
		Forma c1 = new Cerchio(new Colore(1, 1, 1), new Punto(0,0), 1);
		Forma c2 = new Cerchio(new Colore(1, 0, 0), new Punto(1,0), 3);

		disegno.aggiungiForma(c1,1);
		disegno.aggiungiForma(c2,2);
		
		List<Forma> forme = disegno.formeOrdinatePerLuminosita();
		assertSame(c1, forme.get(1));
		assertSame(c2, forme.get(0));
	}
	
	@Test
	public void testDisegnoLuminosita_2formeColoreUguale() {
		Forma c1 = new Cerchio(new Colore(1, 1, 1), new Punto(0,0), 1);
		Forma c2 = new Cerchio(new Colore(1, 1, 1), new Punto(1,0), 3);

		disegno.aggiungiForma(c1,1);
		disegno.aggiungiForma(c2,2);
		
		List<Forma> forme = disegno.formeOrdinatePerLuminosita();
		assertSame(c2, forme.get(1));
		assertSame(c1, forme.get(0));
	}

}
