package battlefield;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

public class RobotOrdinatiPerPosizioneTest {
	
	private Battlefield field;
	
	@Before
	public void setUp() throws Exception {
		this.field = new Battlefield(3);
	}


	@Test
	public void testGetRobotOrdinatiPerPosizione_CampoVuoto() {
		List<Robot> list = this.field.getRobotOrdinatiPerPosizione();
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testGetRobotOrdinatiPerPosizione_Singleton() {
		Walker singleton = new Walker(new Position(0,0));
		this.field.addRobot(singleton);
		List<Robot> list = this.field.getRobotOrdinatiPerPosizione();
		assertSame(singleton, list.get(0));
	}
	
	@Test
	public void testGetRobotOrdinatiPerPosizione_Doubleton() {
		Walker singleton = new Walker(new Position(1,0));
		this.field.addRobot(singleton);
		Walker doubleton = new Walker(new Position(0,0));
		this.field.addRobot(doubleton);
		List<Robot> list = this.field.getRobotOrdinatiPerPosizione();
		assertSame(doubleton, list.get(0));
		assertSame(singleton, list.get(1));
	}
	
	@Test
	public void testGetRobotOrdinatiPerPosizione_StessaX() {
		Walker singleton = new Walker(new Position(0,1));
		this.field.addRobot(singleton);
		Walker doubleton = new Walker(new Position(0,0));
		this.field.addRobot(doubleton);
		List<Robot> list = this.field.getRobotOrdinatiPerPosizione();
		assertSame(doubleton, list.get(0));
		assertSame(singleton, list.get(1));
	}
	
	
	@Test
	public void testGetRobotOrdinatiPerPosizione_Quadruplo() {
		Walker quarto = new Walker(new Position(3,0));
		this.field.addRobot(quarto);
		
		Walker terzo = new Walker(new Position(1,1));
		this.field.addRobot(terzo);
		
		Walker primo = new Walker(new Position(0,0));
		this.field.addRobot(primo);
		
		Walker secondo = new Walker(new Position(1,0));
		this.field.addRobot(secondo);
		
		List<Robot> list = this.field.getRobotOrdinatiPerPosizione();
		assertSame(primo, list.get(0));
		assertSame(secondo, list.get(1));
		assertSame(terzo, list.get(2));
		assertSame(quarto, list.get(3));
	}
}
