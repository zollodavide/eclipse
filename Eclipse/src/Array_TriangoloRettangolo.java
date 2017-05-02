public class Array_TriangoloRettangolo {
	
	public static void main(String[] args) {
		
		Punto a1 = new Punto(3, 0);
		Punto a2 = new Punto(0, 0);
		Punto a3 = new Punto(0, 2);
		
		Triangolo t1 = new Triangolo(a1, a2, a3);
			
		
		Punto b1 = new Punto(4, -1);
		Punto b2 = new Punto(-2, -1);
		Punto b3 = new Punto(-2, -2);
		
		Triangolo t2 = new Triangolo(b1, b2, b3);
		
		
		Punto d1 = new Punto(-3,4);
		Punto d2 = new Punto(-1,2);
		Punto d3 = new Punto(-1,4);
		
		Triangolo t3 = new Triangolo(d1, d2, d3);
		
		
		Punto e1 = new Punto(3,4);
		Punto e2 = new Punto(-1,1);
		Punto e3 = new Punto(-1,5);
		
		Triangolo t4 = new Triangolo(e1, e2, e3); 
		
		
		Punto c1 = new Punto(3,0);
		Punto c2 = new Punto(1,2);
		Punto c3 = new Punto(1,0);
		
		Triangolo t5 = new Triangolo(c1, c2, c3);
		

		
		Triangolo[] t = new Triangolo[] {t1, t4, t3, t2, t5};
		
		System.out.println("---------------------Lista Triangoli---------------------");
		
		for(int i=0; i<t.length; i++)
			System.out.println("T" + i +": " + t[i].toString());
		
		System.out.println("");
		
		Triangolo[] f = selezioneRettangoli(t);
		
		System.out.println("---------------------Lista Triangoli Rettangoli---------------------");
		
		for(int j=0; j<f.length; j++) {
			System.out.println("T" + j +": " + t[j].toString());
			
		}
		
	}
	
	public static boolean triangoloRettangolo(Triangolo t) {
		
		boolean rettangolo = false;
				
		double lato1X = t.getV1().getX() - t.getV3().getX();
		double lato1Y = t.getV1().getY() - t.getV3().getY();
		
		double lato2X = t.getV2().getX() - t.getV3().getX();
		double lato2Y = t.getV2().getY() - t.getV3().getY();
		
		double lato3X = t.getV1().getX() - t.getV2().getX();
		double lato3Y = t.getV1().getY() - t.getV2().getY();
		
		double hipotenusaC = Math.sqrt((Math.pow(lato1X,2) + Math.pow(lato1Y, 2)));
		double catetoB = Math.sqrt((Math.pow(lato2X,2) + Math.pow(lato2Y, 2)));
		double catetoA = Math.sqrt((Math.pow(lato3X,2) + Math.pow(lato3Y, 2)));
		

		if (Math.round((Math.pow(catetoA, 2) + Math.pow(catetoB, 2))) == Math.round(Math.pow(hipotenusaC, 2))) {
			rettangolo = true;	
		}
		return rettangolo;
	}
	
	
	public static Triangolo[] selezioneRettangoli(Triangolo[] t) {
		
		Triangolo[] r;
		int c=0;
		boolean rett;
		
		for(int i=0; i<t.length; i++) {
			rett = false;
			rett = triangoloRettangolo(t[i]);

			if (rett)
				c++;
		}
		
		r = new Triangolo[c];
		int j = 0;
		
		for (int i=0; i<t.length; i++) {
			while (j<r.length) {
				rett = false;
				rett = triangoloRettangolo(t[i]);
				
				if (rett) {
					r[j] = r[i];
					j++;
				}
			}
		}
		
		return r;
		
	}

}

