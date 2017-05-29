
public class Dipendente {
	
	private String nome;
	private int matricola;
	
	public Dipendente(String nome, int matricola) {
		this.nome = nome;
		this.matricola = matricola;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricola() {
		return this.matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	@Override
	public boolean equals(Object obj) {
		Dipendente that = (Dipendente)obj;
		return this.getNome().equals(that.getNome()) && this.getMatricola()==that.getMatricola();
		
	}

	@Override
	public int hashCode() {
		return this.getNome().hashCode() + this.getMatricola();
	}
	
	


}
