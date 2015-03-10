package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import farben.FarbenArray;
import pascaldreieck.PascalDreieck;

public class PascalGUI extends JFrame {

	private PascalDreieck pascal = new PascalDreieck(); 
	private int laenge = 50;
	private FarbenArray farben = new FarbenArray();
	
	
	public static void main(String[] args) {
		PascalGUI x = new PascalGUI();
		x.createGUI(); 
	}
	
	private void createGUI(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Pascalsche Dreieck");
		this.setSize(1280,720);
		this.setLayout(new BorderLayout());
		
		this.add(getControlPanel(),BorderLayout.EAST);
		generateDreieck();
		this.add(pascal);
		this.setVisible(true);
	}
	
	private void generateDreieck(){
		pascal.initDreieck(laenge);
		pascal.setFarben(farben);
		pascal.createDreieck();
	}
	
	private JPanel getControlPanel(){
		JPanel x = new JPanel(new BorderLayout());
		x.setBackground(Color.RED);
		x.add(getSlider(),BorderLayout.WEST);
		x.add(farben,BorderLayout.EAST);
		return x;
	}
	
	private JSlider getSlider(){
		int min = 3;
		int max = 50;
		JSlider x =new JSlider(min,max,laenge);
		x.setBackground(Color.RED);
		x.setPaintTrack(true);
		x.setPaintTicks(true);
		x.createStandardLabels(2,min);
		x.setPaintLabels(true);
		x.setOrientation(SwingConstants.VERTICAL);
		x.addChangeListener(new DreieckUpdater());
		return x;
	}
	
	public class DreieckUpdater implements ChangeListener{

		public void stateChanged(ChangeEvent e) {
			JSlider x = (JSlider) e.getSource();
			laenge = x.getValue();
			generateDreieck();
			
			pascal.repaint();
		}
		
	}

}
