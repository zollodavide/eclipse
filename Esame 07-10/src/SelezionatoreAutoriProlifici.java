import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SelezionatoreAutoriProlifici implements Selezionatore {

	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		Map<Autore, Set<Libro>> autore2libri = this.autore2Libri(libriInBiblioteca);
		Map<Autore, Integer> autore2Numlibri = new TreeMap<>(new ComparatoreNumLibri(autore2libri));
		
		for(Autore aut : autore2libri.keySet()) {
			autore2Numlibri.put(aut, autore2libri.get(aut).size());
		}
		
		List<Autore> lista = new ArrayList<Autore>(autore2Numlibri.keySet());
		List<Autore> max = new ArrayList<>();
		max.add(lista.get(lista.size()-1));
		
		return max;
	}

	public Map<Autore, Set<Libro>> autore2Libri(List<Libro> libriInBiblioteca) {
		Map<Autore, Set<Libro>> autore2libri = new HashMap<Autore, Set<Libro>>();
		Set<Libro> tmp;
		
		
		for(Libro o : libriInBiblioteca) {
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
	
	
	private class ComparatoreNumLibri implements Comparator<Autore> {
		Map<Autore, Set<Libro>> base;
		
		public ComparatoreNumLibri(Map<Autore, Set<Libro>> b) {
			this.base = b;
		}

		@Override
		public int compare(Autore arg0, Autore arg1) {
			if(base.get(arg0).size() >= base.get(arg1).size())
				return 1;
			else 
				return -1;
		}
	}
}
