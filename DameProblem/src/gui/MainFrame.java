package gui;

import javax.swing.JFrame;

import dameproblem.DamenProblemLoeser;

public class MainFrame extends JFrame {

	private Schachfeld d = null;
	
	
	public static void main(String args[]){
		MainFrame x = new MainFrame();
		x.create();
		x.setVisible(true);
	}
	
	
	public void create(){
		DamenProblemLoeser x = new DamenProblemLoeser(5);
		x.belegeFeld();
		x.setzeDame(0);
		d = new Schachfeld(5,x);
		d.setFeldSize(100, 100);
		d.generate();
		this.add(d);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1650, 1050);
		this.repaint();
	}
	
}
