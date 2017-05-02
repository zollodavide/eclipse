package frames;
import java.net.MalformedURLException;
import java.net.URL; 
import javax.swing.ImageIcon; 
import javax.swing.JOptionPane;

public class ImageGreeter {
	
	public static void main(String[] args) throws MalformedURLException {
		
		String name = JOptionPane.showInputDialog("Qual'è il tuo nome?");   
		System.out.println(name);    
		
		JOptionPane.showMessageDialog(null, "Ciao, " + name + "!");   
		
		URL imageLocation = new URL("http://gifanimate.html.it/ga_img/gif-animate/Frecce/Frecce196.gif");      
		JOptionPane.showMessageDialog(null, "PijaloInDerCulo " + name + "!", "Title", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));      
		System.out.println(name);      
		System.exit(0);     
		
	}
	
	

}
