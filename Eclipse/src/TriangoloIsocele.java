
public class TriangoloIsocele {
	
	public static void main(String[] args) {
		
		
		Punto a1 = new Punto(-3,4);
		Punto a2 = new Punto(-1,2);
		Punto a3 = new Punto(-1,4);
		
		Triangolo t1 = new Triangolo(a1, a2, a3);
		
		System.out.println("/QUESTO TRIANGOLO è ISOSCELE/ = " + triangoloIsoscele(t1));
		
		
		Punto b1 = new Punto(3,4);
		Punto b2 = new Punto(-1,1);
		Punto b3 = new Punto(-1,5);
		
		Triangolo t2 = new Triangolo(b1, b2, b3); //Triangolo Non Isoscele
		
		System.out.println("/QUESTO TRIANGOLO NON è ISOSCELE/ = " + triangoloIsoscele(t2));
		
		
		Punto c1 = new Punto(3,0);
		Punto c2 = new Punto(1,2);
		Punto c3 = new Punto(1,0);
		
		Triangolo t3 = new Triangolo(c1, c2, c3);
		
		System.out.println("/QUESTO TRIANGOLO è ISOSCELE/ = " + triangoloIsoscele(t3));
		
		
	}
	
	public static boolean triangoloIsoscele(Triangolo t) {
		
		double lato1X, lato1Y;
		double lato2X, lato2Y;
		boolean isoscele = false; 
		
		lato1X = t.getV1().getX() - t.getV3().getX();
		lato1Y = t.getV1().getY() - t.getV3().getY();
		
		lato2X = t.getV2().getX() - t.getV3().getX();
		lato2Y = t.getV2().getY() - t.getV3().getY();
		
		double modulo1 = Math.sqrt((Math.pow(lato1X,2) + Math.pow(lato1Y, 2)));
		double modulo2 = Math.sqrt((Math.pow(lato2X,2) + Math.pow(lato2Y, 2)));
		
		if (modulo1 == modulo2) {
			isoscele = true;
		}
		
		return isoscele;
			
	}

}
