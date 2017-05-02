public class MergeSort_Numerico {
	
	public static void main(String[] args) {
		
		int[] a = new int[] {6, 2, 8, 4, 6, 0, 1, 5, -3};
		int[] b = new int[] {10, 2, 16, 0, -1, 51, 4, 23, 9, 8};
		
		mergeSort(a);
		
		System.out.print("ARRAY ORDINATO (ULTIMA PASSATA): ");
		
		for(int i = 0; i < a.length; i++) 
			System.out.print(a[i] + " ");
		
		System.out.println("");
		
		
		mergeSort(b);
		
		System.out.print("ARRAY ORDINATO (ULTIMA PASSATA): ");
		
		for(int l = 0; l < b.length; l++)
			System.out.print(b[l] + " ");
	}
	
	
	public static void mergeSort(int[] v) {
		msort(v, 0, v.length-1);
	}
	
	
	public static void msort(int[] v, int inf, int sup) {
		
		if (inf<sup) {
			int med = (inf+sup)/2;
			msort(v, inf, med);
			msort(v, med+1, sup);
			merge(v, inf, med, sup);
		}
		
	}
	
	
	public static void merge(int[] v, int inf, int med, int sup) {
		
		int[] a = new int[sup-inf+1];
		int i1 = inf;
		int i2 = med+1;
		int i = 0;
		
		
		while((i1<=med) && (i2<=sup)) {
			if (v[i1] <= v[i2]) {
				a[i] = v[i1];
				i1++;
				i++;
			}
			else {
				a[i] = v[i2];
				i2++;
				i++;
			}	
		}
		
		if (i2 > sup) {
			for (int k = i1; k<= med; k++) {
				a[i] = v[k];
				i++;
			}
		}
		
		else {
			for (int k = i2; k<= sup; k++) {
				a[i] = v[k];
				i++;
			}
		}
		
		for(int k=0; k<a.length; k++) 
			v[inf+k] = a[k];
		
		
	}
}
