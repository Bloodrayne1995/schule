package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import datum.UhrzeitKlasse;

public class UhrzeitPanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UhrzeitKlasse uhr = new UhrzeitKlasse();
	
	private Duo7SegmentDisplay stunden = new Duo7SegmentDisplay();
	private Duo7SegmentDisplay minuten = new Duo7SegmentDisplay();
	private Duo7SegmentDisplay sekunden = new Duo7SegmentDisplay();
	
	
	public UhrzeitPanel(){
		uhr.setStartzeitAsSystemZeit();
		this.setLayout(null);
		this.setSize(stunden.getWidth() * 3 + 10,stunden.getHeight());
		this.setzeElemente();
		uhr.addActionListener(new TickHandler());
	}
	
	public void setSizeZahl(int width, int height){
		stunden.setZahlSize(width, height);
		minuten.setZahlSize(width, height);
		sekunden.setZahlSize(width, height);
		this.setzeElemente();
		this.setSize(stunden.getWidth() * 3 + 30,stunden.getHeight());
	}
	
	public void starteZeit(){
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		uhr.zeigeUhrzeit();
	}
	
	private void setzeElemente(){
		
		this.removeAll();
		stunden.setLocation(0, 0);
		minuten.setLocation(stunden.getWidth() + 15, 0);
		sekunden.setLocation(minuten.getX() + minuten.getWidth() + 15, 0);
		
		this.add(stunden);
		this.add(minuten);
		this.add(sekunden);
	}
	
	
	private class TickHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			stunden.setZahl(uhr.getStunde());
			sekunden.setZahl(uhr.getSekunde());
			minuten.setZahl(uhr.getMinute());
			repaint();
		}
		
	}


	
	
	
	
	
	
}
