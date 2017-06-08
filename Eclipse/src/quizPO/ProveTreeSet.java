//package quizPO;
//
///* Obiettivo: comprensione uso TreeSet<T> e HashSet<T>
//- cosa stampa questo programma? perche'?
//- compilare
//- eseguire il programma e verificare la propria risposta
//*/
//
//import java.util.*;
//
//class Libro implements Comparable<Libro2> {
// private int anno;
// private String titolo;
//
// Libro(int anno, String titolo) {
//	  this.anno = anno;
//	  this.titolo = titolo;
// }
//
// public int hashCode() {
// 	return (this.anno + this.titolo.hashCode());
// }
//
//	public int compareTo(Libro2 libro) {
//		return this.anno - libro.getAnno();
//	}
//
//	public String getTitolo() {
//		return this.titolo;
//	}
//
//	public int getAnno() {
//		return this.anno;
//	}
//
// public boolean equals(Object o) {
//	  Libro2 l = (Libro2) o;
//	  return ((this.anno == l.getAnno()) &&
//	          (this.titolo.equals(l.getTitolo())));
// }
//}
//
//public class ProveTreeSet {
//
// public static void main(String[] argv) {
//	  Set<Libro2> set1 = new TreeSet<Libro2>();
//	  Libro2 l1  = new Libro2(2000,"Ieri e oggi");
//	  Libro2 l2 = new Libro2(2000, "Domani e dopodomani");
//	  set1.add(l1);
//	  set1.add(l2);
//
//	  Set<Libro2> set2 = new HashSet<Libro2>();
//	  set2.add(l1);
//	  set2.add(l2);
//
//	  System.out.println("set1.size()="+set1.size());
//	  System.out.println("set2.size()="+set2.size());
// }
//}