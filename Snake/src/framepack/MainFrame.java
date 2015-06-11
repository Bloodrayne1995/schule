package framepack;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Spielfeld a = new Spielfeld();
	
	public static void main(String[] args) {
		MainFrame d = new MainFrame();
		d.createGUI();
	}
	
	public void createGUI(){
		this.setSize(501, 501);
		this.setTitle("Snake");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(a,BorderLayout.CENTER);
		this.setVisible(true);
		a.addNewPlayer();
	}

}
