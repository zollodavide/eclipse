package inputOutput_Eccezioni2;

import java.util.*;
import java.io.*;

public class FileUse {
	
	private Scanner in;
	private Formatter x;
	
	
	public void apriFile() {
		try {
			x = new Formatter("try.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void scriviFile() {
		
		in = new Scanner(System.in);
		System.out.println("Scrivi 2 stringhe");
		String v = in.nextLine() + " ";
		String c = in.nextLine() + " ";
		
		x.format("%s%s", v, c);
		
	}
	
	
	public void chiudiFile() {
		
		x.close();
		
	}
	
	

}
