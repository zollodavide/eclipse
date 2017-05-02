import java.util.Scanner;

public class BubbleSort_Numerico {
	
	public static void main(String[] args) {
		
		Scanner in;
		int[] dati;
		int lung;
		int i;
		
		in = new Scanner(System.in);
		lung = in.nextInt();
		
		dati = new int[lung];
		
		for(i=0; i<lung; i++)
			dati[i] = in.nextInt();
		
		bubbleSort(dati);
		
		System.out.print("L'ARRAY ORDINATO (ULTIMA PASSATA): ");
		
		for(int j=0; j<dati.length; j++){
			System.out.print(dati[j] + " ");
		}
		
		in.close();
		
	}
	
	public static void bubbleSort(int[] arr) {
		
		int j;
		int i, k, m=1;
		
		for(j=1; j<arr.length-1; j++) {
			
			System.out.print("PASSATA " + m + ": ");
			m++;
			
			for(k=0; k<arr.length; k++)
				System.out.print(arr[k] + " ");
			System.out.println("");
			
			for(i=0; i<arr.length-j; i++) 
				
				if(arr[i] > arr[i+1])
					scambia(arr, i, i+1);	
						
		}
			
	}
	
	public static void scambia(int[] arr, int i, int j) {
		
		int temp;
		
		temp = arr[i];
		arr[i]= arr[j];
		arr[j] = temp;	
	
	}
}
