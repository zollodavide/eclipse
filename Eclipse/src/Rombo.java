
public class Rombo {
	
	private int diagMin;
	private int diagMax;
	
	public Rombo(int min, int max) {
		this.diagMin = min;
		this.diagMax = max;
	}

	public int getDiagMin() {
		return diagMin;
	}

	public void setDiagMin(int diagMin) {
		this.diagMin = diagMin;
	}

	public int getDiagMax() {
		return diagMax;
	}

	public void setDiagMax(int diagMax) {
		this.diagMax = diagMax;
	}
	
	public String toString() {
		return "Rombo: Diagonale Minore: " + this.diagMin + ", Diagonale Maggiore: " + this.diagMax; 
	}
	
	public boolean quadrato() {
		return (this.diagMax==this.diagMin);
	}

}
