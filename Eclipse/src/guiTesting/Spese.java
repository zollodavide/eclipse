package guiTesting;

public class Spese {
	
	private String nome;
	private double costo;
	
	public Spese(String nome, double costo) {
		
		this.nome = nome;
		this.costo = costo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}


	public String toString() {
		return nome + ": " + costo;
	}
	
	

}
