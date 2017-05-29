package battlefield;

import java.util.*;

public class Battlefield{

	static final private Class<?>[] TIPOLOGIE = { Walker.class, Chaser.class } ;

	static final private int NUMERO_TIPOLOGIE = TIPOLOGIE.length;

	static final private double OCCUPAZIONE_INIZIALE = 0.01d; // 1%

	private int dim;

	private Random random;
	
	private Map<Position, Robot> posizione2robot;
	

	public Battlefield(int dimensione) {
		this.dim = dimensione;
		this.posizione2robot = new HashMap<Position, Robot>();
		this.random = new Random();
	}

	
	public void addRobot(Robot r) {
		this.posizione2robot.put(r.getPosizione(), r);
	}

	public Robot getRobot(Position p) {
		return this.posizione2robot.get(p);
	}

	public Collection<Robot> getAllRobots() {
		return this.posizione2robot.values();
	}


	@SuppressWarnings("rawtypes")
	public Map<Class, Set<Robot>> raggruppaRobotPerTipo() {
		
		Set<Robot> tmp;
		Map<Class, Set<Robot>> mappa = new HashMap<Class, Set<Robot>>();

		for(Robot p : this.posizione2robot.values()) {
			tmp = mappa.get(p.getClass());

			if(tmp == null) 
				tmp = new HashSet<>();

			tmp.add(p);
			mappa.put(p.getClass(), tmp);
		}

		return mappa;
	}
	
	public List<Robot> getRobotOrdinatiPerPosizione() {
		List<Robot> ord = new ArrayList<>(this.getAllRobots());
		ord.sort(new ComparatorePerPosizione());
		return ord;
	}
	
	public SortedSet<Robot> getRobotOrdinatiPerLongevita() {
		SortedSet<Robot> ord = new TreeSet<Robot>(this.getAllRobots());
		return ord;
	}
	
	public List<Position> adiacenti(Position perno) {
		final List<Position> adiacenti = new LinkedList<>();
		int x = perno.getX();
		int y = perno.getY();

		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				Position adiacente = new Position(x+i, y+j);
				if (inCampo(adiacente))
					adiacenti.add(adiacente);
			}
		}
		adiacenti.remove(perno);  // coincidono: quindi non sono adiacenti
		
		Collections.shuffle(adiacenti); /* ordine casuale */
		return adiacenti;
	}

	private boolean inCampo(Position p) {
		return  p.getX()>=0 && p.getX()<this.dim && 
				p.getY()>=0 && p.getY()<this.dim  ;
				
	} 

	public Position posizioneLiberaVicino(Position posizione) {
		for(Position p : this.adiacenti(posizione)) {
			if (this.isLibera(p)) {
				return p;
			}
		}
		return null;
	}

	public boolean isLibera(Position posizione) {
		return (this.getRobot(posizione)==null);
	}

	public int getDimensione() {
		return this.dim;
	}

	public void riempi() {
		long numeroIniziale = Math.round(OCCUPAZIONE_INIZIALE * dim * dim);
		for(int i=0 ; i<numeroIniziale; i++) {
			int x = this.random.nextInt(this.dim);
			int y = this.random.nextInt(this.dim);
			Position posizione = new Position(x, y);
			if (this.isLibera(posizione)) {
				switch (this.random.nextInt(NUMERO_TIPOLOGIE)) {
				case 0: Chaser chaser = new Chaser(posizione);
						this.addRobot(chaser);
				break;
				case 1: Walker walker = new Walker(posizione);
						this.addRobot(walker);
				break;
				//case: NUMERO_TIPOLOGIE-1...
				default: throw new IllegalStateException();
				} 
			}
		}
	}
	
	
	private class ComparatorePerPosizione implements Comparator<Robot> {

		@Override
		public int compare(Robot r1, Robot r2) {
			int comp = r1.getPosizione().getX()-r2.getPosizione().getX();
			
			if(comp == 0)
				comp = r1.getPosizione().getY()-r2.getPosizione().getY();
			
			return comp;
			
		}
		
	}
	
	
}
