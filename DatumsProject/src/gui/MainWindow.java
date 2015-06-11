package gui;


import javax.swing.JFrame;

public class MainWindow extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8468614390541993044L;


	public static void main(String[] args) {
		MainWindow d = new MainWindow();
		d.createGUI();
		
	}
	
	
	public void createGUI(){
		this.setSize(500, 200);
		this.setTitle("Digital-Uhr");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);

		UhrzeitPanel d = new UhrzeitPanel();
		d.setSizeZahl(25, 51);
		this.add(d);
	
		d.starteZeit();
		this.setVisible(true);
	}

}
