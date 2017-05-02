
public class ListaNumeroRazionale {
	
	public static void main(String[] args) {
		
		NumeroRazionale[] n;
		NodoListaQ p;
		
		n = new NumeroRazionale[] { new NumeroRazionale(4,3), new NumeroRazionale(7,5), 
									new NumeroRazionale(12,15), new NumeroRazionale(5,8) };
		
		selectionSort(n);

		p = creaLista(n);
		
		stampa(p);
	}
	
	
	public static void selectionSort(NumeroRazionale[] a) {
		
		int i, j, pos=-1;
		double min;
		
		for (i = 0; i<a.length-1; i++)  {
			
			min = a[i].valore();
			
			for(j=i+1; j<a.length; j++) 
				
				if(min>a[j].valore()) {
					min = a[j].valore();
					pos = j;
					
				}
					
		
			if(min!=a[i].valore())
				scambia(i, pos, a);
			
		}
						
	}
	
	
	public static void scambia(int a, int b, NumeroRazionale[] c) {
		
		NumeroRazionale temp;
		
		temp = c[a];
		c[a] = c[b];
		c[b] = temp;
	}
	
	
	public static void stampa(NodoListaQ p) {
		
		System.out.println("------------Nodo Lista------------");
		
		while(p!=null) {
			System.out.println(p.info.toString());
			p = p.next;
		}
	}
	
	
	public static NodoListaQ creaLista(NumeroRazionale[] r) {
		NodoListaQ a = new NodoListaQ();
		NodoListaQ p = a;
		int i;
		
		for (i=0; i<r.length-1; i++) {
			p.info = r[i];
			p.next = new NodoListaQ();
			p = p.next;
		}
		
		p.info = r[i];
		p.next = null;
		
		return a;
		
	}

}
