import java.util.Scanner;

public class SelectionSort_Numerico {

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
		
		selectionSort(dati);
		
		System.out.print("L'ARRAY ORDINATO (ULTIMA PASSATA): ");
		
		for(int j=0; j<dati.length; j++){
			System.out.print(dati[j] + " ");
		}
		
		in.close();
		
	}
	
	public static void selectionSort(int[] arr) {
		
		int i, j;
		int min;
				
		for(i=0; i<arr.length-1; i++) {
			min = i;
			
			for(int k=i; k<=i; k++)							//PASSATA
				System.out.print("PASSATA " + k + ": ");	//PASSATA
				
			for(int m=0; m<arr.length; m++)					//PASSATA
				System.out.print(arr[m] + " ");				//PASSATA
			
			System.out.println("");							//PASSATA
				
			for(j=i+1; j<arr.length; j++)
				
				if (arr[j]<arr[min])
					scambia(arr, i, j);
			
		}
		
	}		
		
	public static void scambia(int[] dati, int pos1, int pos2) {		
		int temp;
		
		System.out.println("Scambio: " + dati[pos1] + " in posizione " + pos1 + " con " + dati[pos2] + " in posizione " + pos2);
		System.out.println("");
		temp = dati[pos1];
		dati[pos1] = dati[pos2];
		dati[pos2] = temp;

	}
	
}
