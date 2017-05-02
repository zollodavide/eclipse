package rectangleTester;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class RectangleComponent extends JComponent {
	
	public void paintComponent(Graphics g) {
		
		Graphics2D G2 = (Graphics2D) g;
		
		Rectangle box = new Rectangle(5, 10, 20, 30);
		G2.draw(box);
		
		box.translate(15, 25);
		
		G2.draw(box);
	
	
		Rectangle box2 = new Rectangle(80, 80, 40, 50);
		
		G2.setColor(Color.RED);
		G2.draw(box2);
		G2.fill(box2);
		
		box2.translate(40, 0);
		
		G2.setColor(Color.BLUE);
		G2.draw(box2);
		G2.fill(box2);
		
		box2.translate(0, 50);
		
		G2.setColor(Color.GREEN);
		G2.draw(box2);
		G2.fill(box2);
		
		box2.translate(-40, 0);
		
		G2.setColor(Color.YELLOW);
		G2.draw(box2);
		G2.fill(box2);

	
	}

}
