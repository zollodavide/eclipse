public class SelectionSort_ArrayLibro {


	public static void main(String[] args) {

		Libro[] alfa;
		int i;
	
		alfa = new Libro[] { new Libro("Le storie dell'asino", "Esopo", 1500, 20) ,
							 new Libro("Il visconte dimezzato", "Italo Calvino", 1400, 158) ,
							 new Libro("Il barone rampante", "Italo Calvino", 1378, 98) ,
							 new Libro("Filastrocche Lunghe e Corte", "Giovanni Rodari", 1700 , 80) ,
							 new Libro("Le Cosmicomiche", "Italo Calvino", 1200, 250) ,
							 new Libro("Raperonzolo", "Fratelli Grimm", 1300, 36) ,
							 new Libro("Il cavaliere inesistente", "Italo Calvino", 1430, 124) ,
							 new Libro("Enciclopedia della favola", "Gianni Rodari", 1656, 1120) ,
							 new Libro("Le favole piu' belle", "Esopo", 1530, 98) };
	
	
		bubbleSort(alfa);
	
		for (i=0; i<alfa.length; i++) {
			System.out.println("=========================");
			System.out.println(alfa[i].toString());
			System.out.println("");
			
		}
		
	}
	
	
	public static void selectionSort(Libro[] dati) {

		int i, j, pos=-1;
		String min;

		for(i=0; i<(dati.length)-1; i++) {

			min = dati[i].getAutore();

			for (j=i+1; j<dati.length; j++) {

				if (min.charAt(0) > dati[j].getAutore().charAt(0)){
					min = dati[j].getAutore();
					pos = j;
				}

				else if (min.equals(dati[j].getAutore())) {

					if (dati[i].getAnno() > dati[j].getAnno()) {
						min = dati[j].getAutore();
						pos = j;

					}
				}
			}
			if (!dati[i].getAutore().equals(min))
				scambiaLibro(dati, i, pos);
		}
	}
	

	public static void scambiaLibro(Libro[] lib, int i, int j) {

		Libro temp;

		temp = lib[i];
		lib[i] = lib[j];
		lib[j] = temp;

	}
	
	
	public static void bubbleSort(Libro[] dati) {
		
		int i, j;
		
		for(i=1;i<dati.length;i++) {
			for(j=0;j<dati.length-i;j++) {
				if (dati[j].getAutore().charAt(0) > dati[j+1].getAutore().charAt(0))
					scambiaLibro(dati, j, j+1);
				else if (dati[j].getAutore()==dati[j+1].getAutore()) {
					if(dati[j].getAnno()>dati[j+1].getAnno())
						scambiaLibro(dati, j, j+1);
				}
			}
		}
	}

	
}
