package formeGeometriche;

public class GruppoDiForme implements Forma {

	final static int DEFAULT_NUMERO_MAX_FORME = 10;

	private Forma[] componenti;
	private int numeroForme;

	public GruppoDiForme() {
		this.componenti = new Forma[DEFAULT_NUMERO_MAX_FORME];
		this.numeroForme = 0;
	}

	@Override
	public void trasla(int deltaX, int deltaY) {
		for(int i = 0; i<numeroForme; i++)
			this.componenti[i].trasla(deltaX, deltaY);

	}
	
	public void aggiungiForma(Forma forma) {
		if(this.numeroForme<DEFAULT_NUMERO_MAX_FORME){
			this.componenti[numeroForme]=forma;
			numeroForme++;
		}
	}

	public Forma[] getComponenti() {
		return this.componenti;
	}

	public int getNumeroForme() {
		return numeroForme;
	}


}
