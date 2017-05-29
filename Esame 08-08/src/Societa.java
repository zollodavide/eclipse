import java.util.HashSet;
import java.util.Set;

public abstract class Societa implements Comparable<Societa>{

	private int annoDiCostituzione;
	private String nazione;
	private String nome;
	private Set<Dipendente> dipendenti;

	public Societa(int annoDiCostituzione, String nazione, String nome) {
		this.annoDiCostituzione = annoDiCostituzione;
		this.nazione = nazione;
		this.nome = nome;
		this.dipendenti = new HashSet<Dipendente>();
	}

	public int getAnnoDiCostituzione() {
		return this.annoDiCostituzione;
	}

	public void setAnnoDiCostituzione(int annoDiCostituzione) {
		this.annoDiCostituzione = annoDiCostituzione;
	}

	public String getNazione() {
		return this.nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Dipendente> getDipendenti() {
		return this.dipendenti;
	}

	public void setDipendenti(Set<Dipendente> dipendenti) {
		this.dipendenti = dipendenti;
	}

	@Override
	public int compareTo(Societa that) {
		return this.getNome().compareTo(that.getNome());
	}

	public int getNumeroDipendenti () {
		return this.getDipendenti().size();
	}


	@Override
	public boolean equals(Object obj) {

		if (obj==null || obj.getClass()!=this.getClass())
			return false;

		Societa that = (Societa)obj;
		return 	this.getNome().equals(that.getNome()) && 
				this.getNazione().equals(that.getNazione()) &&
				this.getAnnoDiCostituzione() == that.getAnnoDiCostituzione() &&
				this.getDipendenti().equals(that.getDipendenti());
	}

	@Override
	public int hashCode() {
		return 	this.getNome().hashCode() +
				this.getNazione().hashCode() + 
				this.getAnnoDiCostituzione() + 
				this.getDipendenti().hashCode();
	}

	@Override
	public String toString() {
		return this.getNome() + " " + this.getNazione() + " " + this.getAnnoDiCostituzione(); 
	}
	



}
