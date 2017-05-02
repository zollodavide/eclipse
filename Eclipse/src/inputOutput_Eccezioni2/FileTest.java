package inputOutput_Eccezioni2;

import java.io.*;
import java.util.Scanner;

public class FileTest {

	public static void main(String[] args) throws FileNotFoundException {

		/*FileUse r;
		
		r = new FileUse();
		
		r.apriFile();
		r.scriviFile();
		r.chiudiFile();
		*/

		PrintWriter out = new PrintWriter("try.txt");
		out.println("Questo è un nuovo file");
		out.print("Speriamo funzioni");
		out.close();
	
			
		FileReader reader = new FileReader("try.txt");
		
		Scanner in = new Scanner(reader);
		
		while (in.hasNext()) {
			String a = in.nextLine();
			System.out.println(a);
		
		}
		in.close();
	}

}
