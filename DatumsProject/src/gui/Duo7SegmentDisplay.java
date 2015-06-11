package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Duo7SegmentDisplay extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Single7SegmentDisplay zahl1 = new Single7SegmentDisplay();
	private Single7SegmentDisplay zahl2 = new Single7SegmentDisplay();
	
	private int zahl = 0;
	
	
	public Duo7SegmentDisplay(){
		this.setLayout(null);
		this.setSize(zahl1.getWidth() * 2, zahl1.getHeight());
		
		zahl1.setLocation(0, 0);
		zahl2.setLocation(zahl1.getWidth() + 5, 0);
		
		this.add(zahl1);
		this.add(zahl2);
	}
	
	
	public void setColorZahl1(Color x){
		zahl1.setFarbe(x);
	}
	
	public void setColorZahl2(Color x){
		zahl2.setFarbe(x);
	}
	
	public void setColor(Color x){
		setColorZahl1(x);
		setColorZahl2(x);
	}
	
	public void setZahl(int z){
		if(z <= 99){
			zahl = z;
		}
	}
	
	public void setZahlSize(int width, int height){
		zahl1.setSize(width, height);
		zahl2.setSize(width, height);
		
		zahl2.setLocation(zahl1.getWidth() + 5, 0);
	
		
		this.setSize(zahl1.getWidth() * 2 + 5, zahl1.getHeight());
	}
	
	public void paint(Graphics g){
		String zahlAlsText = String.valueOf(zahl);
		String zahl1Str = String.valueOf(zahlAlsText.charAt(0));
		String zahl2Str = "";
		try{
			zahl2Str = String.valueOf(zahlAlsText.charAt(1));
		}catch(Exception e){
			zahl2Str = "0";
		}
		
		zahl1.setZahl(Integer.parseInt(zahl1Str));
		zahl2.setZahl(Integer.parseInt(zahl2Str));
		super.paint(g);
	}
	
}
