package binBaum;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MeinFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Turtle x;
	private int winkel = 45;
	private JPanel drawArea = null;
	private JPanel ctrl = null;
	private int mWidth = 1650;
	private int mHeight = 1050;
	private int mLaenge = 10;
	private int mTiefe = 10;
	private int mode = 1;

	
	
	public static void main(String[] args) {
		MeinFrame d = new MeinFrame();
		d.createGUI();
		
	}
	
	public void createGUI(){
		this.setTitle("Binärer Baum");
		this.setSize(mWidth,mHeight);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		drawArea = getDrawPanel();
		this.add(drawArea,BorderLayout.WEST);
		ctrl = getControlPanel();
		this.add(ctrl, BorderLayout.EAST);
	}
	
	private JPanel getDrawPanel(){
		JPanel x = new JPanel();
		x.setBackground(Color.white);
		int breite = (int) (mWidth * 0.75);
		x.setPreferredSize(new Dimension(breite, mHeight));
		return x;
	}
	
	

	
	
	private JPanel getControlPanel(){
		JPanel x = new JPanel();
		x.setBackground(Color.gray);
		int breite = (int) (mWidth * 0.25);
		x.setPreferredSize(new Dimension(breite, mHeight));
		
		MeinChangeLstener a = new MeinChangeLstener();
		x.setLayout(new BoxLayout(x, BoxLayout.Y_AXIS));
		x.add(getModeSelection());
		
		x.add(MeineFabrik.getLabel("Settings:"));
		x.add(MeineFabrik.getControl("Tiefe: ", "tiefe", 50, 2, mTiefe, a));
		x.add(MeineFabrik.getControl("Länge: ", "laenge", 500, 10, mLaenge, a));
		x.add(MeineFabrik.getControl("Winkel: ", "winkel", 90, 10, winkel, a));
		return x;
	}
	
	private void setWinkel(boolean x){
		for(Component d:ctrl.getComponents()){
			if(d.getName() == "winkel"){
				d.setEnabled(x);
			}
		}
	}
	
	
	public JPanel getModeSelection(){
		JPanel d = new JPanel(new FlowLayout());
		MeinActionListener a = new MeinActionListener();
		d.add(MeineFabrik.getButton("cmdBINBAUM", "Binärer Baum", a));
		d.add(MeineFabrik.getButton("cmdYBAUM", "Y-Baum", a));
		return d;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		x = new Turtle(drawArea);
		x.dreheLinks(90);
		if(mode == 0){
			zeichne_bin_baum(mTiefe, mLaenge);
		}else{
			zeichne_Y_baum(mTiefe, mLaenge);
		}
	}
	
	public void zeichne_Y_baum(int tiefe, long laenge){
		int winkel = 45;
		if(tiefe > 0){
			x.setFarbe(getRandomColor());
			x.stiftRunter();
			x.bewege(laenge);
			x.dreheLinks(winkel);
			x.bewege(laenge);
			zeichne_Y_baum(tiefe - 1, Math.round(laenge * 0.5));
			x.back((int)laenge);
			x.dreheRechts(winkel * 2 );
			zeichne_Y_baum(tiefe - 1, Math.round(laenge * 0.5));
			x.dreheLinks(winkel);
			x.back((int)laenge);
		}
	}
	
	public void zeichne_bin_baum(int tiefe, long laenge){
		if(tiefe > 0){
			x.setFarbe(getRandomColor());
			x.stiftRunter();
			x.bewege(laenge);
			x.stiftHoch();
			x.dreheLinks(winkel);
			//Alle links
			zeichne_bin_baum(tiefe -1,Math.round(laenge * 0.8));
			x.dreheRechts(winkel * 2);
			
			//alle rechts
			zeichne_bin_baum(tiefe -1,Math.round(laenge * 0.8));
			
			x.dreheLinks(winkel);
			//Zurück
			x.back((int) laenge);
		}
		
	}
	
	
	public Color getRandomColor(){
		Random a = new Random();
		int r = a.nextInt(255);
		int g = a.nextInt(255);
		int b = a.nextInt(255);
		return new Color(r, g, b);
	}
	
	public class MeinActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton d = (JButton) e.getSource();
			if(d.getName() == "cmdBINBAUM"){
				mode = 0;
				setWinkel(true);
			}else{
				setWinkel(false);
				mode = 1;
			}
			repaint();
		}
		
	}
	
	
	public class MeinChangeLstener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider d = (JSlider) e.getSource();
			switch(d.getName()){
			case "tiefe":
				mTiefe = d.getValue();
				break;
			case "laenge":
				mLaenge = d.getValue();
				break;
			case "winkel":
				winkel = d.getValue();
				break;
			}
			repaint();
		}
	}




}
