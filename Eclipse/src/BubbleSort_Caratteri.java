import java.util.Scanner;

public class BubbleSort_Caratteri {
			
	public static void main(String[] args) {
		
		Scanner in;
		char[] dati;
		int lung;
		int i;
		
		in = new Scanner(System.in);
		lung = in.nextInt();
		
		dati = new char[lung];
		
		for(i=0; i<lung; i++)
			dati[i] = in.next().charAt(0);
		
		bubbleSort(dati);
		
		System.out.print("L'ARRAY ORDINATO (ULTIMA PASSATA): ");
		
		for(int j=0; j<dati.length; j++){
			System.out.print(dati[j] + " ");
		}
		
		in.close();
		
	}
	
	public static void bubbleSort(char[] arr) {
		
		int j;
		int i, k, m=1;
		
		for(j=1; j<arr.length; j++) {
			
			System.out.print("PASSATA " + m + ": "); //PASSATE
			m++;									 //PASSATE
			
			for(k=0; k<arr.length; k++)				 //PASSATE
				System.out.print(arr[k] + " ");		 //PASSATE
			System.out.println("");					 //PASSATE
			
			for(i=0; i<arr.length-j; i++) 				
				if(arr[i] > arr[i+1])
					scambia(arr, i, i+1);	
						
		}
			
	}
	
	public static void scambia(char[] arr, int i, int j) {
		
		char temp;
		
		temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;	
	
	}
}



