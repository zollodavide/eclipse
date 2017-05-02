package interfaceComparabile;

public class Studente implements Comparabile{
	
	private String nome;
	private int eta;
	
	public Studente(String nome, int eta) {
		this.nome = nome;
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	} 
	
	@Override
	public boolean minoreDi(Comparabile c) {
		Studente o = (Studente)c;
		
		if (this.getEta() > o.getEta())
			return false;

		if (this.getEta() == o.getEta())
			return (this.getNome().charAt(0) < o.getNome().charAt(0));

		return true;
	}
	
	@Override
	public int compara(Comparabile c) {
		Studente o = (Studente) c;
		
		if(this.getEta()==o.getEta()) {
			
			if(this.getNome().charAt(0)<o.getNome().charAt(0))
				return -1;
			else if(this.getNome().charAt(0)>o.getNome().charAt(0))
				return 1;	
			else
				return 0;			
			
		}
				
		else  {
		
			if(this.getEta()<o.getEta())
				return -1;
			else if(this.getEta()>o.getEta())
				return 1;
			else
				return 0;
		
		}
	}
	

}
