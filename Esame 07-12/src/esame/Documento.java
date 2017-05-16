package esame;

import java.util.HashMap;
import java.util.Map;

public class Documento extends Archivio {
	
	private int dimensione;
	
	public Documento(String nome, int dimensione, String dataCreazione, PermessoAccesso permessoAccesso) {
		super(nome, dataCreazione, permessoAccesso);
		this.dimensione = dimensione;
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

	
	public int getDimensione() {
		int dimensioni = 0;
		// codice omesso: completare
		return dimensioni;
	}
		
	
	/*	
	public List<Archivio> archiviCreatiIl(String data) {
		// codice omesso: domanda 5. 
	}
	*/

}
