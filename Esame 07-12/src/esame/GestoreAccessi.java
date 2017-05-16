package esame;

public class GestoreAccessi {
		
	static public boolean haPermesso(Utente utente, Archivio archivio, String nomePermesso) {
		return (archivio.getPermessoAccesso(nomePermesso).haPermesso(utente));
	}
		
}
