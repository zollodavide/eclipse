
public class ListaRombo {
	
	public static void main(String[] args) {
		
		Rombo a, b, c, d, e, f;
		
		a= new Rombo(3,3);
		b= new Rombo(5,8);
		c= new Rombo(4,4);
		d= new Rombo(2,1);
		e= new Rombo(5,5);
		f= new Rombo(7,5);
		
		NodoListaR n = new NodoListaR();
		NodoListaR p = n;
		
		p.info = a;
		p.next = new NodoListaR();
		p = p.next;
		
		p.info = b;
		p.next = new NodoListaR();
		p = p.next;
		
		p.info = c;
		p.next = new NodoListaR();
		p = p.next;
		
		p.info = d;
		p.next = new NodoListaR();
		p = p.next;
		
		p.info = e;
		p.next = new NodoListaR();
		p = p.next;
		
		p.info = f;
		p.next = null;
		
		stampa(n);
		System.out.println();
		NodoListaR t = nonQuadrati(n);
		System.out.println("----------Rombi non Quadrati----------");
		stampa(t);
	}
	
	public static void stampa(NodoListaR a) {
		
		while(a!=null) {
			System.out.println(a.info.toString());
			a = a.next;
		}
		
	}
	
	public static NodoListaR nonQuadrati(NodoListaR a) {
		
		NodoListaR m = new NodoListaR();
		NodoListaR p = m;
		
		while(a.next!=null) {
			
			if (a.info.quadrato())
				a = a.next;
			
			
			else {
				p.info = a.info;
				p.next = new NodoListaR();
				a = a.next;
				p = p.next;
			}
			

		}
		
		if (!a.info.quadrato()){
	
			p.info = a.info;
			p.next = null;
		} 
		
		return m;
	}

}
