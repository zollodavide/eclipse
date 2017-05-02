package rectangleTester;

import java.awt.Graphics;

import javax.swing.JFrame;

public class RectangleViewer {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		
		frame.setSize(300, 400);
		frame.setTitle("Rettangoli");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RectangleComponent component = new RectangleComponent();
		frame.add(component);
		
		frame.setVisible(true);
		
	
		
		
		
		
		
		
		
		/*frame2.setSize(300, 400);
		frame2.setLocationRelativeTo(null);
		frame2.setTitle("Quattro Rettangoli");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		RectangleComponent pipo = new RectangleComponent();
		
		frame2.add(pipo);
		
		frame2.setVisible(true);*/
		
		
		
	}
	
}
