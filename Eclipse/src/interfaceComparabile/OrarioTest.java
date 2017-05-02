package interfaceComparabile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrarioTest {

	@Test
	public void testMinoreDi() {
		assertTrue(new Orario(9,40).minoreDi(new Orario(10,40)));
	}
	
	@Test
	public void testMinoreDiNonMinore() {
		assertFalse(new Orario(22,50).minoreDi(new Orario(10,40)));
	}
	
	public Orario[] arrayOrari() {
		Orario a = new Orario(12,30);
		Orario b = new Orario(21,40);
		Orario c = new Orario(9,20);
		Orario d = new Orario(4,00);
		Orario e = new Orario(1,35);
		
		Orario[] array = new Orario[] {a,b,c,d,e};
		return array;
	}
	
	@Test
	public void testOrdinatore() {
		Orario[] test = this.arrayOrari();
		Ordinatore.ordina(test);
		assertEquals(1,test[0].getOre());
		assertEquals(4,test[1].getOre());
		assertEquals(9,test[2].getOre());
		assertEquals(12,test[3].getOre());
		assertEquals(21,test[4].getOre());

	}
	
	@Test
	public void testRicercaBinaria() {
		Orario[] test = this.arrayOrari();
		Ordinatore.ordina(test);
		int cercato = Ordinatore.ricercaBinaria(test, new Orario(9,20));
		assertEquals(9, test[cercato].getOre());
	}
	
	@Test
	public void testCompara() {
		Orario test = new Orario(4,00);
		assertEquals(-1,test.compara(new Orario(5,20)));
		assertEquals(1,test.compara(new Orario(2,00)));
		assertEquals(0,test.compara(new Orario(4,00)));

	}
	
	
}
