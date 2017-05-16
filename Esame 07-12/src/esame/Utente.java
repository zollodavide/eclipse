package esame;

public class Utente {
	private String nome;

	public Utente(String nome) {
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public boolean equals(Object obj) {
		Utente that = (Utente)obj;
		return this.getNome().equals(that.getNome());
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode();		
	}
	
	

}