package elencoStudenti;

public class Esame {
	
	private String nome;
	private int voto;
	
	public Esame(String n, int v) {
		
		this.nome = n;
		this.voto = v;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	@Override
	public String toString() {
		return nome + " = " + voto;
	}
	

}
