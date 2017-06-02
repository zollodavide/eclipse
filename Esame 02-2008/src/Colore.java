public class Colore {
	private int red;
	private int green;
	private int blue;

	public Colore(int red, int green, int blue) {
		this.red = red;
		this.blue = blue;
		this.green = green;
	}

	public int getRed() {
		return this.red;
	}

	public int getGreen() {
		return this.green;
	}

	public int getBlue() {
		return this.blue;
	}

	public int luminosita() {
		return (this.red + this.green + this.blue);
	}

	@Override
	public boolean equals(Object obj) {
		Colore that = (Colore)obj;
		return this.getBlue()==that.getBlue() && 
			   this.getGreen()==that.getGreen() &&
			   this.getRed()==that.getRed();
	}

	@Override
	public int hashCode() {
		return this.getBlue() + this.getGreen() + this.getRed();
	}
	
}