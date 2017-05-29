import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class BibliotecaTest {

	@Test
	public void test() {
		
		Autore diddo = new Autore("diddo", 1883);
		Autore dodrio = new Autore("dodrio", 1995);
		Autore diddi = new Autore("diddi", 1882);

		
		Libro lilli = new Libro("le cagate di dodo");
		lilli.addAutore(dodrio);
		lilli.addAutore(diddi);
		
		Libro lillo = new Libro("NOn sosdmkmfdifda");
		lillo.addAutore(diddo);
		lillo.addAutore(dodrio);
		
		Libro lilla = new Libro("oooooooookkkkkkkkkk");
		lilla.addAutore(diddi);
		lilla.addAutore(dodrio);
		
		Biblioteca biblio = new Biblioteca();
		biblio.addLibro("aa", lilla);
		biblio.addLibro("aaa", lillo);
		biblio.addLibro("aaaa", lilli);
		Map<Autore, Set<Libro>> a = biblio.autore2libri();
		
		Set<Libro> libriDodrio = new HashSet<>();
		libriDodrio.add(lilli);
		libriDodrio.add(lilla);
		libriDodrio.add(lillo);
		
		Set<Libro> libriDiddi = new HashSet<>();
		libriDiddi.add(lilli);
		libriDiddi.add(lilla);
		
		Set<Libro> libriDiddo = new HashSet<>();
		libriDiddo.add(lillo);

		assertEquals(libriDodrio, a.get(dodrio));
		assertEquals(libriDiddi, a.get(diddi));
		assertEquals(libriDiddo, a.get(diddo));

	}

}
