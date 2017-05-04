
public class DivisoreStringhe {

	public static void main(String[] args) {
		String s = "due stringhe";
		String s1 = null;
		String s2 = null;

		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i)==' ') {
				s1 = s.substring(0,i);
				s2 = s.substring(i+1, s.length());
			}
		}
		
		System.out.println(s1);
		System.out.println(s2);

	}

}
