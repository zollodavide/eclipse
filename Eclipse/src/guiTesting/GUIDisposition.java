package guiTesting;
import javax.swing.JFrame;

public class GUIDisposition {
	
	public static void main(String[] args) {

		GUITest m = new GUITest();
		
		m.setSize(300,200);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
		
	}

}
