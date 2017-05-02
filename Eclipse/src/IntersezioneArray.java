public class IntersezioneArray {

	public static void main(String[] args) {
		
		int[] a = new int[] {96,4,9,5,3,8,11,7,0,78};
		int[] b = new int[] {0,3,5,1,2,8,43,96,11};
		
		int[] c = intersezione(a, b);
		
		System.out.println("****Array A****");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		
		System.out.println("****Array B****");
		for(int i=0; i<b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println("");
	
		System.out.println("****Array Intersezione Tra A e B****");
		for(int i=0; i<c.length; i++) {
			System.out.print(c[i] + " ");
		}
		
		System.out.println("");
		ordina(c);
		System.out.println("****Array Intersezione Ordinato****");
		
		for(int i=0; i<c.length; i++) {
			System.out.print(c[i] + " ");
		} 
		
		

	}
	
	public static int[] intersezione(int[] a, int[] b) {
		
		int[] inters;
		int i, j;
		int cont=0;
		
		for(i=0;i<a.length;i++) 
			for(j=0; j<b.length; j++)
				if(a[i]==b[j])
					cont++;
		
		inters = new int[cont];
		
		int k = 0;
		
		for(i=0;i<a.length;i++) 
			for(j=0; j<b.length; j++) 
				if(a[i]==b[j]) {
					inters[k] = a[i];
					k++;
				}
		
		return inters;
		
		
	}	
	
	//BubbleSort
	public static void ordina(int[] dati) {
		
		int i, j;
		
		for(i=1;i<dati.length; i++) 
			for(j=0; j<dati.length-i; j++) 
				if (dati[j] > dati[j+1])
					scambia(dati, j, j+1);
		
	}
	
	public static void scambia(int[] dati, int pos1, int pos2) {		
		int temp;

		temp = dati[pos1];
		dati[pos1] = dati[pos2];
		dati[pos2] = temp;

	}
	
}
