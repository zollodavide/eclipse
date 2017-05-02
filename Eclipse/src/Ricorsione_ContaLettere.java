//Metodo che trova le occorrenze di un carattere in una stringa

public class Ricorsione_ContaLettere {

	public static void main(String[] args) {
		
		System.out.println(contaLettere("calcare", 'c'));
		System.out.println(contaLettere("mamamomu", 'm'));
		
	}
		
	public static int contaLettere(String s, char c) {
		
		int parole;
		
		if (s.equals("")) 
			parole = 0;
		
		else if (s.charAt(0)==c) 
			parole = 1 + contaLettere(s.substring(1), c);
		
		else 
			parole = contaLettere(s.substring(1), c);
		
		return parole;
		
	}

}