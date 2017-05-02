package collezioniPO;

public class Coppia<T> {
	
	private T primo;
	private T secondo;
	
	public Coppia(T primo, T secondo){
		this.primo = primo;
		this.secondo = secondo;
	}
	
	public void setPrimo(T primo) {
		this.primo = primo;
	}
	
	public T getPrimo(){
		return this.primo;
	}
	
	public void setSecondo(T secondo) {
		this.secondo = secondo;
	}
	
	public T getSecondo() {
		return this.secondo;
	}
	
	public void copyAll(Coppia<? extends T> c) {
		this.setPrimo(c.getPrimo());
		this.setSecondo(c.getSecondo());
	}
	

}
