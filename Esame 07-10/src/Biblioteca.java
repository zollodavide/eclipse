import java.util.*;

public class Biblioteca {

	private Map<String, Libro> codice2libro;
	
	public Biblioteca() {
		this.codice2libro = new HashMap<String, Libro>();
	}
	
	public void addLibro(String codice, Libro libro) {
		this.codice2libro.put(codice, libro);
	}
	
	public List<Autore> autoriGiovani() {
		List<Autore> autoriGiovani = null;
		// codice omesso
		return autoriGiovani;
	}
	
	
	public Map<Autore, Set<Libro>> autore2libri() {
		Map<Autore, Set<Libro>> autore2libri = new HashMap<Autore, Set<Libro>>();
		Set<Libro> tmp;
		Collection<Libro> libri = this.codice2libro.values();
		
		for(Libro o : libri) {
			for(Autore aut : o.getAutori()) {
				
				tmp = autore2libri.get(aut);
				
				if(tmp == null) 
					tmp = new HashSet<>();
				
				tmp.add(o);
				autore2libri.put(aut, tmp);
				
			}
			
		}
		
		return autore2libri;
	}
	// altri metodi omessi
}