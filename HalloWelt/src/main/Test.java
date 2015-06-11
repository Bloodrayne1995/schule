package main;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test x = new Test();
		x.create();

	}

	
	public void create(){
		this.setSize(500, 500);
		this.setTitle("HalloWelt");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JLabel d = new JLabel("HalloWelt");
		this.add(d);
		this.setVisible(true);
	}
}
