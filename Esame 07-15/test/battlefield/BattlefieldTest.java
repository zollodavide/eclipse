package battlefield;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/* Modificare la classe Position affinche' 
 * il primo test abbia successo (vedi DOMANDA 1) 
 */
public class BattlefieldTest {
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(3);
	}

	@Test
	public void testAddWalker() {
		assertEquals(0, this.field.getAllRobots().size());
		this.field.addRobot(new Walker(new Position(0,0)));
		assertEquals(1, this.field.getAllRobots().size());
	}
	
	@Test
	public void testRaggruppaRobotDiDueTipiDiversi() {
		Walker w1 = new Walker(new Position(0,0));
		this.field.addRobot(w1);
		Chaser c1 = new Chaser(new Position(0,1));
		this.field.addRobot(c1);
		Walker w2 = new Walker(new Position(1,0));
		this.field.addRobot(w2);
	
		@SuppressWarnings("rawtypes")
		Map<Class, Set<Robot>> mappa = this.field.raggruppaRobotPerTipo();
		
		Set<Walker> walker = new HashSet<>();
		walker.add(w1);
		walker.add(w2); 
				
		Iterator<Robot> it= mappa.get(Walker.class).iterator();
		assertSame(w1, it.next());
		assertSame(w2, it.next());
		assertFalse(it.hasNext());
		
		it = mappa.get(Chaser.class).iterator();
		assertSame(c1, it.next());
		assertFalse(it.hasNext());

	}

}