package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class SnakePlayer extends JPanel implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int laenge = 1;
	
	public SnakePlayer(Color  farbe, Point location){
		if(farbe == null){
			farbe = Color.red;
		}
		this.setBackground(farbe);
		this.setSize(10, 10);
		this.setLocation(location);
	}
	
	public void paint(Graphics g){
		this.setSize(10 * laenge, 10);
		super.paint(g);
	}
	
	public void addLaenge(){
		laenge ++;
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Point d = getLocation();
		switch(e.getKeyCode()){
		case 37:
			//Links
			setLocation(d.x - 2, d.y);
			break;
		case 38:
			//Oben
			setLocation(d.x, d.y - 2);
			break;
		case 39:
			//Rechts
			setLocation(d.x + 2, d.y);
			break;
		case 40:
			//Unten
			setLocation(d.x, d.y + 2);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
