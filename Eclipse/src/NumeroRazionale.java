
public class NumeroRazionale {
	
	private int num;
	private int den;
	
	public NumeroRazionale(int n, int d) {
		
		this.num = n;
		this.den = d;
		
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int getDen() {
		return this.den;
	}
	
	public String toString() {
		return this.num + "/" + this.den;
	}
	
	public double valore() {
		return ((double)(this.num)/(double)this.den);
	}


}
