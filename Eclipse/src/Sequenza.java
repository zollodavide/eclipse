
public class Sequenza {

   private int[] sequenza;
    
    public Sequenza(int n){
        sequenza = new int[n];
    }
    
    public int massimo(){
        int max = this.sequenza[0];
        // scrivere il codice di questo metodo:
        // deve restituire il valore piu' grande 
        // presente nell'array sequenza
        
        int lunghezza = this.sequenza.length;
        
        for (int i=0; i<lunghezza; i++) {
        	
        	if(max<this.sequenza[i])
        		max = this.sequenza[i];
        	
        }

 
        return max;
    }    

    public void setElemento(int indice, int valore) {
        sequenza[indice] = valore;
    }

    public int getElemento(int indice) {
        return sequenza[indice];
    }
    
    public static void main(String[] args) {
    	
    	Sequenza a = new Sequenza(5);
    	
    	a.setElemento(0,4);
    	a.setElemento(1,3);
    	a.setElemento(2,9);
    	a.setElemento(3,7);
    	a.setElemento(4,8);
    	
    	System.out.println(a.massimo());
    }
}

