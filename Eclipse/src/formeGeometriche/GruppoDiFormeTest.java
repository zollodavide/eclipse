package formeGeometriche;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GruppoDiFormeTest {
	
	GruppoDiForme test;
	
	@Before
	public void setUp() {
		test = new GruppoDiForme();
	}

	@Test
	public void test() {
		test.trasla(0,0);

	}
	
	@Test
	public void testAggiungiUnaForma() {
		test.aggiungiForma(new Cerchio(new Punto(0,0),1));
		assertEquals(new Cerchio(new Punto(0,0),1), test.getComponenti()[0]);
	}
	
	@Test
	public void testAggiungiDueForme() {
		test.aggiungiForma(new Cerchio(new Punto(0,0), 1));
		test.aggiungiForma(new Rettangolo(new Punto(1,0),1,1));
		assertEquals(new Cerchio(new Punto(0,0),1), test.getComponenti()[0]);
		assertEquals(new Rettangolo(new Punto(1,0),1, 1), test.getComponenti()[1]);		
	}
	
	
	@Test
	public void testTraslaGruppoConUnaForma() {
		test.aggiungiForma(new Cerchio(new Punto(0,0), 1));
		test.trasla(0, 1);
		assertEquals(new Cerchio(new Punto(0,1),1), test.getComponenti()[0]);
	}
	
	@Test
	public void testTraslaGruppoConTreForme() {
		test.aggiungiForma(new Cerchio(new Punto(0,0), 1));
		test.aggiungiForma(new Rettangolo(new Punto(1,0),1,1));
		test.aggiungiForma(new Cerchio(new Punto(0,1),1));
		test.trasla(0, 1);
		assertEquals(new Cerchio(new Punto(0,1),1), test.getComponenti()[0]);
		assertEquals(new Rettangolo(new Punto(1,1),1, 1), test.getComponenti()[1]);
		assertEquals(new Cerchio(new Punto(0,2),1), test.getComponenti()[2]);		
	}
	
	@Test
	public void testTraslaGruppoConFormeEGruppi() {
		test.aggiungiForma(new Cerchio(new Punto(0,0), 1));
		
		GruppoDiForme gruppo = new GruppoDiForme();
		gruppo.aggiungiForma(new Rettangolo(new Punto(1,0),1,1));
		
		test.aggiungiForma(gruppo);
		test.aggiungiForma(new Cerchio(new Punto(0,1),1));
		
		test.trasla(0, 1);
		
		assertEquals(new Cerchio(new Punto(0,1),1), test.getComponenti()[0]);
		assertEquals(gruppo, test.getComponenti()[1]);		
		assertEquals(new Rettangolo(new Punto(1,1),1,1), gruppo.getComponenti()[0]);
		assertEquals(new Cerchio(new Punto(0,2),1), test.getComponenti()[2]);		
	}


}
