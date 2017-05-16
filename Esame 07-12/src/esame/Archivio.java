package esame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Archivio {
	
	private String nome;
	private String dataCreazione;
	private Map<String, PermessoAccesso> permessi;
	
	public Archivio(String nome, String dataCreazione, PermessoAccesso permessoAccesso) {
		this.nome = nome;
		this.dataCreazione = dataCreazione;
		this.permessi = new HashMap<String, PermessoAccesso>();
		this.permessi.put(permessoAccesso.getNome(), permessoAccesso);
	}

	public String getDataCreazione() {
		return this.dataCreazione;
	}

	public String getNome() {
		return this.nome;
	}

	public PermessoAccesso getPermessoAccesso(String nomePermesso) {
		return this.permessi.get(nomePermesso);
	}
	

	public List<Archivio> archiviCreatiIl(String data) {
		List<Archivio> lista;

		if(this.getClass()==Documento.class) {
			lista = new ArrayList<Archivio>();
		
			if(this.getDataCreazione().equals(data))
				lista.add(this);
			
			return lista;
			
		}
		
		if(this.getClass()==Cartella.class)  {
			lista = new ArrayList<Archivio>();
			
			/*--------------NON FINITA-----------*/
			
			return lista;

		}
		
		return null;
	}


}
