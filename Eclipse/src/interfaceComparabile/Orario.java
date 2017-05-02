package interfaceComparabile;

public class Orario implements Comparabile {

	private int ore;
	private int minuti;

	public Orario(int ore, int minuti) {
		this.ore = ore;
		this.minuti = minuti;
	}

	public int getOre() {
		return this.ore;
	}

	public int getMinuti() {
		return this.minuti;
	}
	
	@Override
	public boolean minoreDi(Comparabile c) {
		Orario o = (Orario)c;
		
		if (this.getOre() > o.getOre())
			return false;

		if (this.getOre() == o.getOre())
			return (this.getMinuti() < o.getMinuti());

		return true;
	}
	
	@Override
	public int compara(Comparabile c) {
		Orario o = (Orario)c;
		
		if(this.getOre()==o.getOre()) {
			
			if(this.getMinuti()<o.getMinuti())
				return -1;
			if(this.getMinuti()>o.getMinuti())
				return 1;
			else 
				return 0;			
			
		}
		else {

			if(this.getOre()<o.getOre())
				return -1;
			if(this.getOre()>o.getOre())
				return 1;
			else 
				return 0;

		}
	}

	public String toString() {
		return this.getOre() + ":" + this.getMinuti();
	}

}
