package primzahlen;

import javax.swing.JFrame;

public class GUIFrame extends JFrame {

	
	GUIGraphenPanel pnl = new GUIGraphenPanel();
	
	public static void main(String[] args) {
		GUIFrame x = new GUIFrame();
		x.createGUI();
			
	}
	
	public void createGUI(){
		this.setTitle("Primzahlen Vergleich");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,500);
		pnl.init(10);
		this.setLayout(null);
		this.add(pnl);
		pnl.run();
		this.setVisible(true);
	}

}
