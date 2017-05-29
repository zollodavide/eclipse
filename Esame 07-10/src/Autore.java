
public class Autore {

	private int annoNascita;
	private String nome;
	
	public Autore(String nome, int annoNascita) {
		this.nome = nome;
		this.annoNascita = annoNascita;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getAnnoNascita() {
		return this.annoNascita;
	}

	@Override
	public boolean equals(Object obj) {
		Autore that = (Autore) obj;
		return this.getNome().equals(that.getNome()) && this.getAnnoNascita()==that.getAnnoNascita();
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode() + this.getAnnoNascita();
	}

	@Override
	public String toString() {
		return this.getNome() + " " + this.getAnnoNascita();
	}
	
	
	
	
}