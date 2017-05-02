package formeGeometriche;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RettangoloTest {
	
	Rettangolo unitario;

	@Before
	public void setUp() {
		unitario = new Rettangolo(new Punto(0,0), 1, 1);
	}

	@Test
	public void testTraslaZero() {
		unitario.trasla(0,0);
		assertEquals(new Punto(0,0), unitario.getVertice());
	}
	
	@Test
	public void testTrasla() {
		unitario.trasla(0,1);
		assertEquals(new Punto(0,1), unitario.getVertice());
	}

}
