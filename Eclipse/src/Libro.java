
public class Libro {
	private String titolo;

	private String autore;

	private int anno;

	private int pagine;



	//Costruttore

	public Libro (String t, String aut, int a, int p) {

		this.titolo = t;
		this.autore = aut;
		this.anno = a;
		this.pagine = p;

	}


	//Metodi set

	public String getTitolo() {
		return this.titolo;
	}

	public String getAutore() {
		return this.autore;
	}

	public int getAnno() {
		return this.anno;
	}

	public int getPagine() {
		return this.pagine;
	}


	//Metodi set

	public void setTitolo(String t){
		this.titolo = t;
	}

	public void setAutore(String a){
		this.autore = a;
	}

	public void setAnno(int a){
		this.anno = a;
	}

	public void setPagine(int p){
		this.pagine = p;
	}




	//Metodo toString

	public  String toString() {

		return  ("AUTORE:    " + this.autore + "\n" +
				 "TITOLO:    " + this.titolo + "\n" +
				 "ANNO:      " + this.anno + "\n" +
				 "N. PAGINE: " + this.pagine + "\n");

	}


	//Metodo equals

	public boolean equals(Libro b) {

		return (this.autore.equals(b.autore) &&
				this.titolo.equals(b.titolo) &&
				this.anno == b.anno &&
				this.pagine == b.pagine);

	}



}
