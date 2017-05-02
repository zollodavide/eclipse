public class InsertionSort_Numerico {
	
	public static void main(String[] args) {
		
		int[] a = new int[] {6, 2, 8, 4, 6, 0, 1, 5, -3};
		int[] b = new int[] {10, 2, 16, 0, -1, 51, 4, 23, 9, 8};
		
		insertionSort(a);
		
		System.out.print("ARRAY ORDINATO (ULTIMA PASSATA): ");
		
		for(int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		
		System.out.println("");
		
		
		insertionSort(b);
		System.out.print("ARRAY ORDINATO (ULTIMA PASSATA): ");
		
		for(int l = 0; l < b.length; l++)
			System.out.print(b[l] + " ");
	}
	
	
	
	public static void insertionSort(int[] dati) {
		
		int n, i;
		int ordinati, corrente;
		boolean ins;
		int m = 1;
		
		n= dati.length;
		
		for(ordinati=1; ordinati<n; ordinati++) {
			
			int l;
			
			System.out.print("PASSATA " + m + ": ");
			m++;
			
			for(l=0; l<dati.length; l++)
				System.out.print(dati[l] + " ");
			
			System.out.println("");
			
			
			corrente= dati[ordinati];
			ins = false;
			i= ordinati;
			
			while(i>0 && !ins) 
				if(corrente<dati[i-1]) {
					dati[i] = dati[i-1];
					i--;
				} 
				else
					ins = true;
			
			dati[i] = corrente;
		}
	}

}
