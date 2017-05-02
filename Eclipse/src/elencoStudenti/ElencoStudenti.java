package elencoStudenti;

public class ElencoStudenti {
	
	public static void main(String[] args) {
		
		NodoListaSt s, p, j, amm;
		Studente m, n, o;
		Esame[] t = { new Esame("Analisi", 20),  new Esame ("Geometria", 26) };
		Esame[] y = { new Esame ("Chimica Inorganica", 26), new Esame ("Citologia", 27), new Esame("Botanica", 27) };
		Esame[] h = { new Esame("Analisi", 17) };
				
		
		m = new Studente("Zollo", "Davide", "Roma Tre", 486136, t);
		
		n = new Studente("Kero", "Ginevra", "Roma Tre", 484124, y);
		
		o = new Studente("Malvati", "Ennio", "La Sapienza", 483619, h);
		
		s = new NodoListaSt(m, null);
		p = s;
		
		j = new NodoListaSt(n, null);
		p.next = j;
		p = p.next;
		
		p.next = new NodoListaSt(o, null);
		p = p.next;
		
		stampa(s);
		
		System.out.println("");
		
		System.out.println("Media di Zollo, Davide: " + m.media());
		System.out.println("Media di Kero, Ginevra: " + n.media());
		System.out.println("Media di Malvati, Ennio: " + o.media());
		
		System.out.println("");

		System.out.println("Gli studenti ammessi sono quelli con la media maggiore o uguale a " + mediaTotale(s) + ":");
		
		amm = studentiAmmessi(s);
		
		stampaAmmessi(amm);
		
		
		
		
	}
	
	public static void stampa(NodoListaSt p) {
		
		System.out.println("******************Lista Studenti******************");
		
		while(p != null) {
			
			System.out.println(p.info.toString());
			p = p.next;
			
		}
		
	}
	
	
	public static int mediaTotale(NodoListaSt p) {
		
		int med = 0;
		int i = 0;
		
		while (p!=null) {
			i++;
			med += p.info.media();
			p=p.next;
		}
		
		int mediaN = med/i;
		return mediaN;
		
	}
	
	
	public static NodoListaSt studentiAmmessi(NodoListaSt g) {
		
		NodoListaSt p = g;
		NodoListaSt t = new NodoListaSt(null, null);
		NodoListaSt s = t;
		
		while (p!=null) {
			
			if (p.info.media()>mediaTotale(g)) {
				
				s.next = new NodoListaSt(p.info, null);
				s = s.next;
				
			}
			
			p = p.next;
			
		}
		
		return t.next;
		
	}
	
	
	public static void stampaAmmessi(NodoListaSt p) {
		
		System.out.println("******************Lista Studenti Ammessi******************");
		
		while(p != null) {
			
			System.out.println(p.info.toString());
			p = p.next;
			
		}
		
	}
	
	
	
	

}
