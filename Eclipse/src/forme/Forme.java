package forme;

public class Forme {
	
	public int perimetro;
	public int area;

}

class Punto {
	
	private int x;
	private int y;
	
	public Punto(int xx, int yy) {
		this.x = xx;
		this.y = yy;
	}
	
}

class Quadrato extends Forme {
	
	private int lato;
	private Punto centro;
	
}

class Cerchio extends Forme {
	
	private int raggio;
	private Punto centro;
	
	public Cerchio(int Raggio, Punto Centro) {
		this.raggio = Raggio;
		this.centro = Centro;
	}
	
}

class Rettangolo extends Forme {
	
	private Punto verticeAS;
	private Punto verticeBD;
	
	public Rettangolo(Punto AS, Punto BD) {
		
		this.verticeAS = AS;
		this.verticeBD = BD;
		
	}
	
}



