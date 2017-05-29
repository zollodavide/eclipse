import java.util.*;
public class Libro {
	
	private Set<Autore> autori;
	private String titolo;

	public Libro(String titolo) {
		this.titolo = titolo;
		this.autori = new HashSet<Autore>();
	}

	public void addAutore(Autore autore){
		this.autori.add(autore);
	}
	
	public Set<Autore> getAutori() {
		return Collections.unmodifiableSet(this.autori);
	}
	
	public String getTitolo(){
		return this.titolo;
	}

	@Override
	public boolean equals(Object obj) {
		Libro that = (Libro)obj;
		return this.getTitolo().equals(that.getTitolo()) && this.getAutori().equals(that.getAutori());
	}

	@Override
	public int hashCode() {
		return this.getTitolo().hashCode() + this.getAutori().hashCode();
	}

	@Override
	public String toString() {
		return this.titolo + " " + this.getAutori().toString() + "\n";
	}
	
	

	
}