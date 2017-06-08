package quizPO;

import java.util.*;

class Persona {
	private String nome;

	public Persona(String nome) {
		this.nome = nome;
	}

	public void setNome(String n) {
		nome = n;
	}

	public String toString() {
		return nome;
	}
}

public class Quiz4 {

	public static void main(String[] argc) {
		List<Persona> l = new LinkedList<Persona>();

		Persona a = new Persona("Paolo");
		l.add(a);
		a.setNome("Luca");
		a = new Persona("Antonio");
		l.add(a);
		Persona b;
		b = a;
		b.setNome("Elisabetta");
		l.add(b);
		for (Persona p : l)
			System.out.print(p.toString() + " ");
	}
}