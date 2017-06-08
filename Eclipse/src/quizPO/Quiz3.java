package quizPO;


import java.util.*;

class ComparatoreLibri implements Comparator<Libro2> {
	public int compare(Libro2 l1, Libro2 l2) {
		return (l1.getAnno() - l2.getAnno());
	}
}

class Libro2 implements Comparable<Libro2> {
	public int anno;
	public String titolo;

	public Libro2(String titolo, int anno) {
		this.anno = anno;
		this.titolo = titolo;
	}

	public int compareTo(Libro2 o) {
		return this.titolo.compareTo(o.getTitolo());
	}

	public int getAnno() {
		return this.anno;
	}

	public String getTitolo() {
		return this.titolo;
	}
}

public class Quiz3 {
	public static void main(String[] args) {
		List<Libro2> biblioteca = new LinkedList<Libro2>();

		biblioteca.add(new Libro2("Cronosisma", 2003));
		biblioteca.add(new Libro2("Zorro", 2000));
		biblioteca.add(new Libro2("Zorro", 1800));
		biblioteca.add(new Libro2("Mostri", 1999));
		Collections.sort(biblioteca, new ComparatoreLibri());

		for (Libro2 libro : biblioteca)
			System.out.print(libro.getTitolo() + " ");
	}
}