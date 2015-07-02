package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import util.Zeitklasse;
import dameproblem.DamenProblemLoeser;

public class MainFrame extends JFrame {

	private Schachfeld d = null;
	private int anzahlDamen = 15;
	
	private JSpinner numFeldW = null;		//FeldBreite
	private JSpinner numFeldH = null;		//FeldHöhe
	private JSpinner numFeld = null;		//Damenanzahl
	private boolean fertig = false;
	
	
	
	public static void main(String args[]){
		MainFrame x = new MainFrame();
		x.create();
		x.setVisible(true);
	}
	
	
	public void create(){
		createGUI();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1650, 1050);
		this.repaint();
		d.setEventfertigListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fertig = true;
				
			}
		});
	}
	
	
	private void createGUI(){
		//Hauptpanel
		JPanel main = getMainPanel();
		
		//Linkes Panel
		DamenProblemLoeser x = new DamenProblemLoeser(4);
		d = new Schachfeld(x);
		d.setFeldSize(100, 100);
		d.generateAsync();
		main.add(d,BorderLayout.CENTER);
		
		
		//KontrollPanel
		main.add(getControlPanel(),BorderLayout.EAST);
		
		
		//Frame
		this.add(main);
	}
	
	
	private JPanel getMainPanel(){
		JPanel x = new JPanel(new BorderLayout());
		return x;
	}
	
	
	private JPanel getControlPanel(){
		JPanel x = new JPanel();
		x.setLayout(new BoxLayout(x, BoxLayout.Y_AXIS));
		
		
		numFeld = getSpinner(4);
		numFeldW = getSpinner(100);
		numFeldH = getSpinner(100);
		
		
		x.add(getLabel("Anzahl Damen:"));
		x.add(numFeld);
		
		x.add(getLabel("Feld-Breite:"));
		x.add(numFeldW);
		
		x.add(getLabel("Feld-Höhe"));
		x.add(numFeldH);
		
		JButton b = new JButton("Refresh");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DamenProblemLoeser a = new DamenProblemLoeser((int)numFeld.getValue());
				d.setDp(a);
				d.setFeldSize((int) numFeldW.getValue(), (int) numFeldH.getValue());
				new Thread(new ZeitThread()).start();
				d.generateAsync();
				d.repaint();
			}
		});
		
		x.add(b);
		
		return x;
	}
	
	private JSpinner getSpinner(int def){
		JSpinner x = new JSpinner();
		x.setValue(def);
		return x;
	}
	
	
	private JLabel getLabel(String x){
		JLabel a = new JLabel();
		a.setText(x);
		return a;
	}
	
	
	private class ZeitThread implements Runnable{

		@Override
		public void run() {
			Zeitklasse x = new Zeitklasse();
			do{
				setTitle("Dauer (ns): " + x.getDifference());
				try{
					Thread.sleep(100);
				}catch(Exception e){
					
				}
			}while(!fertig);
			
			
		}
		
		
		private String getTime(long x){
			String erg = "%h% Stunden, %m% Minuten, %s% Sekunden";
			long st = 1000 * 1000 * 60 * 60;
			long h = x / st;
			long m = (x - h * st) / (1000 * 1000 * 60);
			long s = (x - h * st - m * (1000 * 1000 * 60)) 
			
		}
		
	}
	
}
