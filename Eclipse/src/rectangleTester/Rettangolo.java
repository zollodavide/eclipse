package rectangleTester;

public class Rettangolo {
	
	private double base;
	
	private double altezza;
	
	private double x;
	
	private double y;
	
	
	public Rettangolo(double x, double y, double base, double altezza) {
		
		this.base = base;
		
		this.altezza = altezza;
	
	}
	
	
	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public double getBase() {
		
		return base;
	}
	
	public double getAltezza() {
		
		return altezza;
		
	}
	
	
	public double area() {
		
		return base*altezza;
	
	}
	
	public double perimetro() {
		
		return (base*2)+(altezza*2);
	}
	
	
	public void trasla(double xx, double yy) {
		
		this.x += xx;
		this.y += yy;
		
		
	}

}
