
public class Triangolo {
	
	private Punto v1;
	private Punto v2;
	private Punto v3;
	
	public Triangolo(Punto a, Punto b, Punto c) {
		
		this.v1 = a;
		this.v2 = b;
		this.v3 = c;
		
	}
	
	
	public Punto getV1() {
		return this.v1;
	}


	public Punto getV2() {
		return v2;
	}


	public void setV2(Punto v2) {
		this.v2 = v2;
	}


	public Punto getV3() {
		return v3;
	}


	public void setV3(Punto v3) {
		this.v3 = v3;
	}


	public void setV1(Punto v1) {
		this.v1 = v1;
	}
	
	
	public boolean equals(Triangolo t) {
		return  (this.v1.equals(t.v1)) &&
				(this.v2.equals(t.v2)) &&
				(this.v3.equals(t.v3));
	}
	
	public String toString() {
		return "Triangolo [v1=" + v1.toString() + ", v2=" + v2.toString() + ", v3=" + v3.toString() + "]";
	}
}
