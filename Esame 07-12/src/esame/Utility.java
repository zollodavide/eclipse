package esame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utility {

	static public Map<Utente, List<Documento>> utente2docs(List<Documento> docs, String nomePermesso) {
		Map<Utente, List<Documento>> map = new HashMap<>();
		List<Documento> tmp;
		
		for(Documento documento : docs) {
			
			PermessoAccesso permtmp = documento.getPermessoAccesso(nomePermesso);

			for(Utente e : permtmp.getUtenti()) {
				
				tmp = map.get(e);
				
				if(tmp == null)
					tmp = new ArrayList<Documento>();
				
				tmp.add(documento);
				map.put(e, tmp);
				
			}
					
		}
		
		return map;
	}

}
