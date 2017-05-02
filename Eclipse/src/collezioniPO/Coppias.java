package collezioniPO;

public class Coppias {
	
	public static <T> void reverse(Coppia<T> c){
		T tmp;
		tmp = c.getPrimo();
		
		c.setPrimo(c.getSecondo());
		c.setSecondo(tmp);
	}
	
	public static <T> void fill(Coppia<? super T> c, T e) {
		c.setPrimo(e);
		c.setSecondo(e);
		
	}
	
	public static <T> void copy(Coppia<? super T> dest, Coppia<? extends T> src) {
		dest.setPrimo(src.getPrimo());
		dest.setSecondo(src.getSecondo());
	}

}
