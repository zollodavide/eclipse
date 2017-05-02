
public class Punto {
	
	private int x;
	private int y;
	
	public Punto(int xx, int yy) {
		this.x = xx;
		this.y = yy;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String toString() {	
		return "(x,y) = (" + this.x + ", " + this.y + ").";
	}
	
	public boolean equals(Punto p) {
		return (this.x==p.x) && (this.y == p.y); 
	}
	
	
}
