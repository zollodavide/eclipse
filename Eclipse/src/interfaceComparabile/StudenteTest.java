package interfaceComparabile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudenteTest {
	
	@Test
	public void testMinoreDi() {
		assertTrue(new Studente("Federica", 21).minoreDi(new Studente("Ennio", 23)));
	}
	
	@Test
	public void testMinoreDiNONMinore() {
		assertFalse(new Studente("Federica", 21).minoreDi(new Studente("Davide", 19)));
	}
	
	public Studente[] arrayStudente() {
		Studente a = new Studente("Federica", 21);
		Studente b = new Studente("Davide", 19);
		Studente c = new Studente("Douglas", 42);
		Studente d = new Studente("Ennio", 23);
		Studente e = new Studente("Beatrice", 21);
		
		Studente[] array = new Studente[] {a,b,c,d,e};
		return array;
	}
	
	@Test
	public void testOrdinaStudenti() {
		Studente[] test = this.arrayStudente();
		Ordinatore.ordina(test);
		assertEquals("Davide", test[0].getNome());
		assertEquals("Beatrice", test[1].getNome());
		assertEquals("Federica", test[2].getNome());
		assertEquals("Ennio", test[3].getNome());
		assertEquals("Douglas", test[4].getNome());

	}
	
	

}
