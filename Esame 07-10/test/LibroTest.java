import static org.junit.Assert.*;

import org.junit.Test;

public class LibroTest {

	@Test
	public void test() {
		Libro lilli = new Libro("le cagate di dodo");
		lilli.addAutore(new Autore("dodrio", 1995));
		lilli.addAutore(new Autore("boh", 1887));
		
		Libro lillo = new Libro("le cagate di dodo");
		lillo.addAutore(new Autore("boh", 1887));
		lillo.addAutore(new Autore("dodrio", 1995));
		
		assertTrue(lillo.equals(lillo));
		assertTrue(new Autore("aa", 1).equals(new Autore("aa", 1)));
		
		assertTrue(lillo.equals(lilli));
	}

}
