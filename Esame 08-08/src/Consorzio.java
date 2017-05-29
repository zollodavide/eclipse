import java.util.*;

public class Consorzio extends Societa{

	private Map<String, Societa> societa;

	public Consorzio(int annoCostituzione, String nazione, String nome) {
		super(annoCostituzione, nazione, nome);
		this.societa = new HashMap<String, Societa>();
	}

	public void aggiungiConsorziata(Societa societa) {
		this.getSocieta().put(societa.getNome(), societa);
	}

	public void aggiungiDipendente(Dipendente dipendente) {
		this.getDipendenti().add(dipendente); 
	}

	public Map<String, Societa> getSocieta() {
		return societa;
	}

	public boolean isVuoto() {
		return this.getSocieta().isEmpty();
	}
	
	@Override
	public int getNumeroDipendenti () {
		int dip = 0;
		
		for(Societa soc : this.getSocieta().values())
			dip += soc.getNumeroDipendenti();
		
		return dip;
			
	}		
	
	
	
	public Map<String, List<Societa>> nazione2consorziate() {
		Map<String, List<Societa>> map = new HashMap<>();
		List<Societa> tmp;
		
		for(Societa soc : societa.values()) {

			if(soc.getClass()==Impresa.class) {

				tmp = map.get(soc.getNazione());

				if(tmp == null)
					tmp = new ArrayList<Societa>();
				
				tmp.add(soc);				
				tmp.sort(new ComparatoreAnno());
				map.put(soc.getNazione(), tmp);

			}
			
			if(soc.getClass()==Consorzio.class) {
				
				Consorzio con = (Consorzio)soc;
				
				if(con.isVuoto()) {
					
					tmp = map.get(soc.getNazione());

					if(tmp == null)
						tmp = new ArrayList<Societa>();

					tmp.add(soc);
					tmp.sort(new ComparatoreAnno());
					map.put(soc.getNazione(), tmp);
					
				}
				
				else {
					
				
					Map<String, List<Societa>> map_con = con.nazione2consorziate();
					List<Societa> tmp_2;

					
					for(String s : map_con.keySet()) {
						
						tmp_2 = map.get(s);
						
						if(tmp_2 == null)
							tmp_2 = new ArrayList<Societa>();
						
						tmp_2.addAll(map_con.get(s));
						tmp_2.sort(new ComparatoreAnno());
						map.put(s, tmp_2);
					}
					
				}
				
			}

		}
		
		tmp = map.get(this.getNazione());
		
		if (tmp == null)
			tmp = new ArrayList<Societa>();
		
		tmp.add(this);
		tmp.sort(new ComparatoreAnno());
		map.put(this.getNazione(), tmp);
		
		
		return map;
	}

}