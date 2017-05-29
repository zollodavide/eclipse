import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SelezionatoreAutoriGiovani implements Selezionatore {
	
	@Override
	public List<Autore> eseguiSelezione(List<Libro> libriInBiblioteca) {
		
		List<Autore> select = new ArrayList<>();
		
		for(Libro o : libriInBiblioteca) {
			List<Autore> ord = new ArrayList<>();
			ord.addAll(o.getAutori());
			select.add(Collections.max(ord, new ComparatoreAutore()));
		}
		
		return select;
	}
	
	private class ComparatoreAutore implements Comparator<Autore> {

		@Override
		public int compare(Autore o1, Autore o2) {
			int comp = o1.getAnnoNascita()-o2.getAnnoNascita();
			
			if(comp == 0)
				comp = o1.getNome().compareTo(o2.getNome());
			
			return comp;
		}
	}

}
