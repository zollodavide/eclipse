package tetris.pozzo;

import static tetris.Costanti.COLORE_BORDO;

import java.util.*;

import tetris.tetramino.Tetramino;

/**
 * Questa classe modella il pozzo in cui cadono i tetramini del gioco
 * <A href="https://it.wikipedia.org/wiki/Tetris"> <em>Tetris</em></A>
 * <BR/>
 * Possiede un bordo formato da due lati e da il fondo ove si posano
 * gli oggetti {@link Tetramino} mano a mano che cadono.
 * <BR/>
 * Contiene un insieme di oggetti {@link Cella} che derivano dagli oggetti
 * {@link Tetramino} una volta che questi raggiunge il fondo del pozzo e
 * collide con una {@link Cella} già presente. 
 * <BR/>
 * Le righe completate sono rimosse invocando il metodo 
 * {@link #aggiungiCelleErimuoviRigheCompletate(Set)}
 * <BR>
 * Le celle possiedono coordinate basate in (0,0) con ascissa crescente 
 * verso dx, ed ordinata crescente verso il basso, secondo lo schema che
 * segue (<i>h</i> è l'altezza del pozzo ed  <i>l</i> la sua larghezza)
 * <PRE>
 *          (0,0) *   ---->   * (<i>l</i>,0)
 *          (0,1) *     x     * (<i>l</i>,1)
 *                *           *   
 *                . |y        .   
 *                . |         .
 *                . V         .
 *                *           * 
 *                *           *   
 *          (0,h) ************* (<i>l</i>,<i>h</i>)  
 *   
 * </PRE>
 */
public class Pozzo {

	/**
	 * Larghezza di default del pozzo;
	 * include 2 colonne di celle per i bordi
	 */
	static final public int LARGHEZZA = 12; // in celle
	
	/**
	 * Altezza di default del pozzo;
	 * 	include 1 riga di celle per il fondo
	 */
	static final public int ALTEZZA   = 24; // in celle

	
	/* serie di metodi factory per creare celle lungo il bordo */
	static final private Cella bordoDX(int riga) {
		return new Cella(LARGHEZZA-1,riga, COLORE_BORDO);
	}

	static final private Cella fondo(int colonna) {
		return new Cella(colonna, ALTEZZA-1, COLORE_BORDO);
	}

	static final private Cella bordoSX(int riga) {
		return new Cella(0,riga, COLORE_BORDO);
	}

	/**
	 * Rappresentazione dell'insieme di celle contenute nel pozzo.
	 * <BR/>
	 * N.B. anche i bordi sono oggetti {@link Cella} che fanno 
	 *      parte di questo insieme
	 */
	final private NavigableSet<Cella> celle;
	
	/**
	 * Crea un pozzo delle dimensioni di default (12x24 bordi inclusi)
	 */
	public Pozzo() {
		this(LARGHEZZA,ALTEZZA);
	}

	/**
	 * Crea un pozzo delle dimensioni date.
	 * <BR/>
	 * <B>E' un costruttore molto utile per scrivere test-minimali!</B>
	 * @param l larghezza
	 * @param h altezza
	 */
	public Pozzo(int l, int h) {
		this.celle = new TreeSet<Cella>(); /* DA COMPLETARE (esercizi 2,3,4) */
		this.addBordo(l, h);
	}

	private void addBordo(int l, int h) {
		this.addBordoSX(h);    // lato sx alto h
		this.addBordoDX(h);    // lato dx alto h
		this.addFondo(l); // fondo largo l
	}
	
	private void addBordoSX(int h) {
		for (int riga=0; riga<h; riga++) {
			this.celle.add(bordoSX(riga));
		}
	}

	private void addBordoDX(int h) {
		for (int riga=0; riga<h; riga++) {
			this.celle.add(bordoDX(riga));
		}
	}

	private void addFondo(int l) {
		for (int colonna=0; colonna<l; colonna++) {
			this.celle.add(fondo(colonna));
		}
	}

	public boolean contiene(Cella c) {
		return this.celle.contains(c);
	}
	
	public Set<Cella> getCelle() {
		return this.celle;
	}

	/**
	 * Aggiunge un insieme di celle e quindi rimuove tutte le righe 
	 * completate, dal basso verso l'alto, spostandole le celle sopra 
	 * le righe completate di una posizione verso il basso
	 * @param celle - un {@link Set} di celle da aggiungere
	 * @return il numero di righe completate e rimosse
	 */
	public int aggiungiCelleErimuoviRigheCompletate(Set<Cella> celle) {
		/* aggiungi le nuove celle */
		this.celle.addAll(celle);
		
		/* controlla le linee dalla più in basso verso l'alto (y decrescenti) */
		final NavigableSet<Integer> righeCoinvolte = getInsiemeOrdinateY(celle);
		int contatoreRimosse = 0;
		while (!righeCoinvolte.isEmpty()) {
			int rigaPiùInBasso = righeCoinvolte.pollLast(); // y alta <-> riga bassa
		
			if (isCompleta(rigaPiùInBasso)) {
				rimuoviRigaScendendoCelleSopra(rigaPiùInBasso);
				contatoreRimosse++;
			}
		}
		
		return contatoreRimosse;
	}
	
	/**
	 * 
	 * @param inputCelle - un insieme di celle
	 * @return l'insieme ({@link NavigableSet}) delle ordinate (y)
	 *         delle posizioni delle celle passate. L'insieme è
	 *         ordinato crescente.
	 * @see {@link Posizione},  {@link Cella}
	 */
	NavigableSet<Integer> getInsiemeOrdinateY(Set<Cella> inputCelle) {

		NavigableSet<Integer> risultato = new TreeSet<Integer>();
		
		Iterator<Cella> it = inputCelle.iterator();
		while(it.hasNext()) {
			Cella cella = it.next();
			risultato.add(cella.getPosizione().getY());
		}
		
		return risultato;
		
	}

	/**
	 * @param y ordinata della riga controllata
	 * @return true se e solo se la riga è attualmente completa
	 */
	public boolean isCompleta(int y) {
		return ( getCelleDellaRigaSenzaBordo(y).size() == LARGHEZZA-2 );
	}

	/**
	 * Sposta le celle sopra alla riga di riferimento di una posizione
	 * verso il basso (y risultata incrementato)
	 * 
	 * @param riga - indice della riga di riferimento
	 */
	void rimuoviRigaScendendoCelleSopra(int riga) {
		this.celle.removeAll(getCelleDellaRigaSenzaBordo(riga));
		for(Cella cella : getCelleSopraRigaYdecrescente(riga)) {
			this.celle.remove(cella);
			this.celle.add(cella.scesaDiUnaRiga());
		}
	}

	/**
	 * @param riga indice di una riga
	 * @return l'insieme di celle (escluso i bordi) della riga di indice dato
	 */
	Set<Cella> getCelleDellaRigaSenzaBordo(int riga) {
		/* DA COMPLETARE (senza iterazioni - esercizio 3) */
		NavigableSet<Cella> celleYX = new TreeSet<>(new ComparatoreYX());
		celleYX.addAll(this.celle);
		NavigableSet<Cella> senzaBordo = celleYX.subSet(bordoSX(riga), false, bordoDX(riga), false);
		NavigableSet<Cella> sopraAllaRiga= new TreeSet<>(new ComparatoreYX());
		sopraAllaRiga.addAll(senzaBordo);
		
		return sopraAllaRiga.headSet(bordoSX(riga), false);
	}
	
		
	/**
	 * 
	 * @param riga
	 * @return il  @link {@link NavigableSet} di tutte le celle attualmente nel
	 *         pozzo e sopra la riga passata come riferimento; le celle sono 
	 *         ordinate per Y decrescente delle rispettive posizioni, ed a
	 *         parità di Y, per X.
	 *         N.B. il risultato non include le celle del bordo! */
	 
	NavigableSet<Cella> getCelleSopraRigaYdecrescente(int riga) {
		
		NavigableSet<Cella> celleXY = new TreeSet<>(new ComparatoreXY());
		celleXY.addAll(this.celle);
		
		return celleXY.subSet(fondo(0), false, bordoDX(0), false);
		
	}
	
	private class ComparatoreYX implements Comparator<Cella> {
		
		@Override
		public int compare(Cella c1, Cella c2) {
			int ord = c1.getPosizione().getY() - c2.getPosizione().getY();
			
			if (ord == 0) 	
				ord = c1.getPosizione().getX() - c2.getPosizione().getX();
			
			return ord;
			
		}
		
	}
	
	private class ComparatoreXY implements Comparator<Cella> {

		@Override
		public int compare(Cella c1, Cella c2) {
			int ord = c1.getPosizione().getX() - c2.getPosizione().getX();

			if (ord == 0) 	
				ord = c1.getPosizione().getY() - c2.getPosizione().getY();

			return ord;

		}

	}

}
