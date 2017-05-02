package elencoStudenti;

public class NodoListaSt {
	
	public Studente info;
	
	public NodoListaSt next;
	
	public NodoListaSt(Studente s, NodoListaSt n) {
		
		info=s;
		next=n;
		
	}

}
