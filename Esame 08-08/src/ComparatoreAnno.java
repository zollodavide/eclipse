import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ComparatoreAnno implements Comparator<Societa> {
	
	@Override
	public int compare(Societa o1, Societa o2) {
		int comp = o1.getAnnoDiCostituzione() - o2.getAnnoDiCostituzione();
		
		if(comp == 0)
			comp = o1.getNome().compareTo(o2.getNome());
		
		return comp;

	}

}
