public class SelectionSortRicorsivo {

	public static void main(String[] args) {
		
		int[] a = new int[] {6, 2, 8, 4, 6, 0, 1, 5, -3};
		int[] b = new int[] {10, 2, 16, 0, -1, 51, 4, 23, 9, 8};
		
		selectionSortRic(a, 0, a.length);
		
		System.out.print("ARRAY ORDINATO (ULTIMA PASSATA): ");
		
		for(int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		
		System.out.println("");
		
		
		selectionSortRic(b, 0, b.length);
		
		System.out.print("ARRAY ORDINATO (ULTIMA PASSATA): ");
		
		for(int l = 0; l < b.length; l++)
			System.out.print(b[l] + " ");
	}
	
	
	public static void selectionSortRic(int[] v, int i, int n) {
		  if (i < n-1)
			selectionSortRic(scambia(v,i,min(v,i,n-1)), i+1, n);
	}


	public static int min(int[] a, int inf, int sup){
	     int i,indmin;

	     indmin = inf;
	     for (i = inf+1; i <= sup; i++)
	       if (a[i] < a[indmin])
	         indmin = i;
	     return indmin;
	 }

		
	public static int[] scambia(int[] dati, int pos1, int pos2) {		
		int temp;

		temp = dati[pos1];
		dati[pos1] = dati[pos2];
		dati[pos2] = temp;
		
		return dati;
	}
}
