package guiTesting;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;


public class GUITest extends JFrame {
	
	private JButton agg;
	private JButton spe;
	private JLabel sen;
	private JButton vis;
	private double tot = 0;
	private Spese sp;
	
	public GUITest() {
		super("Soldi");
		setLayout(new FlowLayout());
		
		sen = new JLabel("Bello");
		sen.setVerticalAlignment(JLabel.BOTTOM);
		sen.setHorizontalAlignment(JLabel.LEFT);
		add(sen); 
		
		agg = new JButton("Aggiungi");
		agg.setToolTipText("Aggiunge nuove spese");
		add(agg);
		
		vis = new JButton("Visualizza Credito");
		vis.setToolTipText("Visualizza la quantità spesa");
		add(vis);
		
		spe = new JButton("Visualizza Spese");
		spe.setToolTipText("Visualizza la lista delle spese realizzate");
		add(spe);
		
		
		HandlerClass handler = new HandlerClass();
		HandlerClass2 handler2 = new HandlerClass2();
		HandlerClass3 handler3 = new HandlerClass3();
		
		vis.addActionListener(handler);
		agg.addActionListener(handler2);
		spe.addActionListener(handler3);
		
	}
	
	private class HandlerClass implements ActionListener {
		public void actionPerformed(ActionEvent event) {	
			JOptionPane.showMessageDialog(null, "Il tuo credito totale è: " + tot + "€", "Credito Residuo", JOptionPane.INFORMATION_MESSAGE);  
		}
	}
	
	private class HandlerClass2 implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			
			double somma = 0;
			Spese nuova;
			
			String input = JOptionPane.showInputDialog(null, "Quanto vuoi aggiungere? (€)", "Aggiungi Soldi", JOptionPane.QUESTION_MESSAGE);
			if (input == null) {
				input = "0";
			}
			try {
				somma += Double.parseDouble(input);
			}
			catch (NumberFormatException exc) {
				JOptionPane.showMessageDialog(null, "L'input aggiunto non è un numero. Inserisci un valore numerico", "Errore", JOptionPane.ERROR_MESSAGE); 
			}
			
			String motivo = JOptionPane.showInputDialog(null, "Motivo della Spesa?", JOptionPane.QUESTION_MESSAGE);
			
			nuova = new Spese(motivo, somma);
						
			try {
				aggiungiSpesa(nuova);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			aggiungiSomma(somma);
			
			
		}
	}
	
	public double aggiungiSomma(double d) {
		
		return tot+=d;
	}
	
	private class HandlerClass3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			openSpese();
		}
	}
	
	//Invocato dal terzo bottone vis. spese
	private void openSpese() { 
	
		JFrame frame = new JFrame("Spese");
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String i = "Qui ci dovrebbe essere una lista delle spese";
		JLabel sp = new JLabel(i);
		sp.setHorizontalAlignment(JLabel.LEFT);
		sp.setVerticalAlignment(JLabel.TOP);
		frame.add(sp);
		
		
	}
	
	private void aggiungiSpesa(Spese n) throws IOException {
		
		PrintWriter out = new PrintWriter(new FileWriter("spese.txt", true));
		out.println(n.getNome() + " " + n.getCosto() + " " + LocalDateTime.now());
		out.close();
		
	}
	
		
	
}
	