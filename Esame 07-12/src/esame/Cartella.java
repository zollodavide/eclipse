package esame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cartella extends Archivio {

	private Set<Archivio> archivi;
		


	public Cartella(String nome, String dataCreazione, PermessoAccesso permessoAccesso) {
		super(nome, dataCreazione, permessoAccesso);
		this.archivi = new HashSet<Archivio>();
	}


	public String getDataCreazione() {
		return super.getDataCreazione();
	}

	public String getNome() {
		return super.getNome();
	}

	public PermessoAccesso getPermessoAccesso(String nomePermesso) {
		return super.getPermessoAccesso(nomePermesso);
	}

	public Set<Archivio> getArchivi() {
		return this.archivi;
	}
	
	public boolean addDocumento(Documento documento) {
		return this.archivi.add(documento);
	}
			
	
}
