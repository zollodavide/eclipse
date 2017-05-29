import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SelezionatoreAutoriGiovaniTest {

	@Test
	public void test() {
		Libro lilli = new Libro("le cagate di dodo");
		lilli.addAutore(new Autore("dodrio", 1995));
		lilli.addAutore(new Autore("boh", 1887));
		
		Libro lillo = new Libro("le cagatete di dodo");
		lillo.addAutore(new Autore("boh", 1882));
		lillo.addAutore(new Autore("dodrio", 1998));
		
		Libro lilla = new Libro("le cagatetete di dodo");
		lilla.addAutore(new Autore("boh", 1882));
		lilla.addAutore(new Autore("dodrio", 1999));
		
		List<Libro> lista = new ArrayList<>();
		
		lista.add(lilla);
		lista.add(lillo);
		lista.add(lilli);
		
		SelezionatoreAutoriGiovani s = new SelezionatoreAutoriGiovani();
		List<Autore> aut = s.eseguiSelezione(lista);
		
		assertEquals(new Autore("dodrio", 1999),aut.get(0));
		assertEquals(new Autore("dodrio", 1998),aut.get(1));
		assertEquals(new Autore("dodrio", 1995),aut.get(2));
		
	}

}
