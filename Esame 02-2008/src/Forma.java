
public abstract class Forma {
	
	public Forma(Colore colore) {
		this.colore = colore;
	}

	private Colore colore;

	public Colore getColore() {
		return colore;
	}

	public void setColore(Colore colore) {
		this.colore = colore;
	}
	public abstract double superficie();


	
	


}
