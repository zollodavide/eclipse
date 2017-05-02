//Metodo che verifica se un array composto di stringhe non vuote e non nulle
//contiene solo stringhe con almeno una cifra tra i caratteri

public class Ricorsione_ArrayAlmenoUnaCifra {
	
	public static void main(String[] args) {
		
		String[] a = new String[] {"aaa1", "aa2a", "9aaa"};
		String[] b = new String[] {"aaa1", "aaa", "9aaa"};
		String[] c = new String[] {"aaa1", "1aaa", "9aaa", "aaa"};
		String[] d = new String[] {"1aaa", "1aaa", "9aaa", "aaa2"};
		
		System.out.println("/TRUE/ = " + controllaArray(a));
		System.out.println("/FALSE/ = " + controllaArray(b));
		System.out.println("/FALSE/ = " + controllaArray(c));
		System.out.println("/TRUE/ = " + controllaArray(d));
	}
	
	public static boolean controllaArray(String[] dati) {
		return aux(dati, 0);
	}
	
	public static boolean aux(String[] a, int i) {
		
		boolean stringa;
		
		if (i == a.length)
			stringa = true;
		else
			stringa = almenoUnaCifra(a[i]) && aux(a, i+1);
			
		return stringa;
	}
	
	public static boolean almenoUnaCifra(String cif) {
		
		if (cif.equals(""))
			return false;
		else 
			return (cif.charAt(0)>= '0' && cif.charAt(0)<='9') || almenoUnaCifra(cif.substring(1));
			
	}
	
}
