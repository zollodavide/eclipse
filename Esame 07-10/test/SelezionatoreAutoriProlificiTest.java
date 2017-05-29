import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SelezionatoreAutoriProlificiTest {

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
		
		List<Libro> lib = new ArrayList<>();
		lib.add(lilli);
		lib.add(lillo);
		lib.add(lilla);
		
		List<Autore> list = new SelezionatoreAutoriProlifici().eseguiSelezione(lib);

		assertSame(dodrio, list.get(0));
	}

}
