
public class Persone {

	public static void main(String[] args) {
		
		Persone a = new Persone(5);
		
		a.aggiungiNome(0,"Marcoo");
		a.aggiungiNome(1,"Luca");
		a.aggiungiNome(2,"Maio");
		a.aggiungiNome(3,"Tecla");
		a.aggiungiNome(4,"Marcoo");
		
		System.out.println(a.contaOmonimiDi("Marco"));
 
		
		
		
	}
	
    private String[] nomi;
    
    public Persone(int n) {
        this.nomi = new String[n];
    }
    
    public int contaOmonimiDi(String nome) {
        int contatore=0;
        
        int lunghezza = this.nomi.length;
        
        for(int i=0; i<lunghezza; i++) 
        	if(nome.equals(this.nomi[i]))
        		contatore++;
           
        return contatore;
    }
    
    public void aggiungiNome(int indice, String nome){
        this.nomi[indice] = nome;
    }


}
