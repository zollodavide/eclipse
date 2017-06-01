package battlefield;

public abstract class Robot implements Comparable<Robot>{
	
	private Position posizione;
	private int longevita;
	
	public Robot(Position p) {
		this.posizione = p;
		this.longevita = 0 ;
	}

	public Position getPosizione() {
		return this.posizione;
	}
	
	public int incrementaLongevita() {
		return ++this.longevita;
	}
	
	public int getLongevita() {
		return this.longevita;
	}
	
	public void passo(Battlefield field) {
		Position nuova = this.decidiMossa(field);
		
		if (nuova!=null) {
			Robot clone = this.creaClone(nuova);
			field.addRobot(clone);
		}
		this.incrementaLongevita();
	}
	
	
	public abstract Robot creaClone(Position p);

	
	public abstract Position decidiMossa(Battlefield field);

	@Override
	public boolean equals(Object obj) {
		Robot that = (Robot)obj;
		return this.getLongevita()==that.getLongevita() && this.getPosizione().equals(that.getPosizione());
	}

	@Override
	public int hashCode() {
		return this.getLongevita() + this.getPosizione().hashCode();
	}
	

	@Override
	public int compareTo(Robot r) {
		int comp = this.getLongevita()-r.getLongevita();
		
		if (comp==0)
			comp = this.getPosizione().compareTo(r.getPosizione());
		
		return comp;
	}
	
}
