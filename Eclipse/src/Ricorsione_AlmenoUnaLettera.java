public class Ricorsione_AlmenoUnaLettera {
	
	public static void main(String[] args) {
		
		System.out.println(almenoUnaLettera("656484545465"));
		System.out.println(almenoUnaLettera("Limongelli01"));
	
	}
	
	
	public static boolean almenoUnaLettera(String s){
		
		boolean lett;
		
		if (s.equals(""))
			lett = true;
		
		else if (((s.charAt(0)>='A') && (s.charAt(0)<='z')))
			lett = false;
		
		else
			lett = almenoUnaLettera(s.substring(1));
		
		return lett;
		
	}
}
