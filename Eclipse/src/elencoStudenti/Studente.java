package elencoStudenti;

import java.util.Arrays;

public class Studente {
	
	private String cognome;	
	private String nome;
	private String universita;	
	private int matricola;	
	private Esame[] esami;
	
	
	public Studente(String c, String n, String u, int m, Esame[] e){
		
		this.cognome=c;
		this.nome=n;
		this.universita=u;
		this.matricola=m;
		this.esami= e;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getUniversita() {
		return universita;
	}


	public void setUniversita(String universita) {
		this.universita = universita;
	}


	public int getMatricola() {
		return matricola;
	}


	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	
	public Esame[] getEsami() {
		return esami;
	}


	public void setEsami(Esame[] esami) {
		this.esami = esami;
	}	


	public String toString() {
		return "Studente: " + cognome + ", " + nome + ". Universita: " + universita + ", Matricola: "
				+ matricola + ", Lista Esami e voti:" + Arrays.toString(esami);
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (matricola != other.matricola)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (universita == null) {
			if (other.universita != null)
				return false;
		} else if (!universita.equals(other.universita))
			return false;
		return true;
	}
	
	
	
	public int media() {
		
		int media = 0;
		
		for (int i = 0; i< this.esami.length; i++) {
			media += this.esami[i].getVoto();
		}
		
		return media/this.esami.length;
		
	}



	
	
}
