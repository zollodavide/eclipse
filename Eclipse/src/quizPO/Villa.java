package quizPO;
/*
  Obiettivo: verifica comprensione tipi statici e dinamici

  Il seguente programma contiene molti errori.
  - quali?
  - compialre il programma e verificare le proprie risposte

*/

interface Edificio{
	public void numeroPiani();
}

class Palazzo implements Edificio {
	@Override
	public void numeroPiani() {
		System.out.println("Numero Piani Palazzo");
	}
}

public class Villa implements Edificio {
	@Override
	public void numeroPiani(){
		System.out.println("Numero Piani Villa");
	}

	public static void main(String[] argc){

		Edificio e;
		Villa v = new Villa();
		Edificio e1 = new Villa();

		e=v;
		v=(Villa)e1; //UPCASTING
		e1.numeroPiani();
		e = new Palazzo();
		v=(Villa)e; //NON SI PUò FARE IL CASTING
	}

}
