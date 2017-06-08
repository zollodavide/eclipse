import java.util.*;

public class Prova {

	public static void main(String[] args) {
		Map<Integer, String> ma = new HashMap<Integer, String>();
		
		ma.put(1, "a");
		ma.put(2, "a");
		
		ma.put(1, "b");
		System.out.println(ma.toString());
		
	}

}
