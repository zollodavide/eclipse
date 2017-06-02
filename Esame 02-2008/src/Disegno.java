import java.util.*;

public class Disegno {
	
	private Map<Integer, List<Forma>> livello2forme;

	public Disegno() {
		this.livello2forme = new TreeMap<Integer, List<Forma>>();
	}

	public Map<Integer, List<Forma>> getLivello2forme() {
		return this.livello2forme;
	}

	public void aggiungiForma(Forma forma, int livello) {
		List<Forma> list;
		
		if (this.getLivello2forme().containsKey(livello)) {
			list = this.getLivello2forme().get(livello);
			list.add(forma);
		}
		else {
			list = new ArrayList<Forma>();
			list.add(forma);
		}
	
		this.getLivello2forme().put(livello, list);

	}

	public Set<Colore> coloriPresentiNelDisegno() {
		Set<Colore> coloriNelDisegno = new HashSet<>();
	
		for(List<Forma> lista : this.getLivello2forme().values()) 
			for(Forma f : lista)
				coloriNelDisegno.add(f.getColore());
		
		return coloriNelDisegno;
	}

	public Map<Colore, List<Forma>> colore2forme() {
		Map<Colore, List<Forma>> colore2forme = new HashMap<Colore, List<Forma>>();
		List<Forma> tmp;
		
		for(List<Forma> coll : this.getLivello2forme().values())
			for(Forma f : coll) {
				tmp = colore2forme.get(f.getColore());
				
				if(tmp == null)
					tmp = new ArrayList<Forma>();
				
				tmp.add(f);
				tmp.sort(new ComparatoreSuperficie());
				colore2forme.put(f.getColore(), tmp);
			}
		
		return colore2forme;
	}

	public List<Forma> formeOrdinatePerLuminosita() {
		List<Forma> forme = new ArrayList<Forma>();
		
		for(List<Forma> list : this.getLivello2forme().values())
			forme.addAll(list);
		
		forme.sort(new ComparatoreLuminosita());
			
		return forme;
	}
	
	private class ComparatoreSuperficie implements Comparator<Forma> {

		@Override
		public int compare(Forma o1, Forma o2) {
			return (int)(o1.superficie() - o2.superficie());
		}
		
	}
	
	
	private class ComparatoreLuminosita implements Comparator<Forma> {

		@Override
		public int compare(Forma o1, Forma o2) {
			return o1.getColore().luminosita() - o2.getColore().luminosita();
		}
		
	}
}