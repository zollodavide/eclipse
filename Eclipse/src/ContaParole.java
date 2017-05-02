/*
SPECIFICA
* Input: STRINGA
* Pre-condizione: NON NULLA E NON VUOTA
* Output: INTERO
* Post-condizione: NUMERO DI PAROLE PRESENTI NELLA STRINGA
* TIPO DI PROBLEMA: ACCUMULAZIONE
* ...  */

public class ContaParole{

	public static void main(String[] args) {

		testContaParole();

	}


	public static int contaParole(String s) {

		int i = 0;
		int parole;
		char c;

		if(s.charAt(0)>=0)
			parole = 1;
		else
			return parole = 0;

		while (i<s.length()) {

			c = s.charAt(i);

			if (c == ' ')
				parole++;

			i++;

		}

		return parole;

	}


	public static void testContaParole() {


		System.out.println("quant’è lunga questa stringa " + "/4/ = " + contaParole("quant’è lunga questa stringa"));

		System.out.println("aspetta…Eccola! " + "/1/ = " + contaParole("aspetta…Eccola!"));

		System.out.println("£ s d f g h j j " + "/8/ = " + contaParole("£ s d f g h j j"));

		System.out.println("quinoncisonospazi " + "/1/ = " + contaParole("quinoncisonospazi"));


	}

}
