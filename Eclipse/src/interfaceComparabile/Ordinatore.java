package interfaceComparabile;

public class Ordinatore {
	
	public static void ordina(Comparabile[] lista) {

		int imin;

		for (int ord=0; ord<lista.length-1; ord++) {
			imin = ord;

			for (int i=ord+1; i<lista.length; i++)

				if (lista[i].minoreDi(lista[imin])) {
					Comparabile temp=lista[i];
					lista[i]=lista[imin];
					lista[imin]=temp;
				}
		}
	}
	
	public static int ricercaBinaria(Comparabile[] v, Comparabile cercato) {
		int basso = 0;
	    int alto = v.length -1;
	    int medio;
	    
	    while (basso<=alto) {
	    	medio = (basso+alto) /2;
	    	if (v[medio].compara(cercato)==1) 
	    		alto = medio -1;
	    	else if (v[medio].compara(cercato)==-1) 
	    		basso = medio +1;
	    	else 
	    		return medio;
	    }
	    return -1;
	}
		
}
