package frames;
import javax.swing.JOptionPane;


public class DialogueViewer {
		
	public static void dialogueViewer() {
	
	String name = JOptionPane.showInputDialog("What is your name?");   
	System.out.println(name);    
	
	JOptionPane.showMessageDialog(null, "Hello, " + name + "!");   
	
	System.exit(0);     
	
	}
	
}
