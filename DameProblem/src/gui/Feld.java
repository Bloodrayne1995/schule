package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Feld extends JComponent {

	private static final long serialVersionUID = -8162139790867805387L;

	/**
	 * Legt fest ob sich eine Dame darin befindet oder nicht
	 */
	private boolean dame = false;
	
	/**
	 * Legt fest ob das Feld Schwarz oder Weiß sein soll
	 */
	private boolean schwarz = false;
	
	
	/**
	 * Erstellt ein neues Feld, mit der Größe 100x100
	 */
	public Feld(){
		setSize(100, 100);
	}
	
	/**
	 * Erstellt ein neues Feld (100x100) mit der Angabe ob es Schwarz sein soll oder nicht
	 * @param schwarz
	 */
	public Feld(boolean schwarz){
		this.schwarz = schwarz;
		setSize(100,100);
	}
	
	
	/**
	 * @return the dame
	 */
	public boolean isDame() {
		return dame;
	}

	/**
	 * @param dame the dame to set
	 */
	public void setDame(boolean dame) {
		this.dame = dame;
	}

	/**
	 * @return the schwarz
	 */
	public boolean isSchwarz() {
		return schwarz;
	}

	/**
	 * @param schwarz the schwarz to set
	 */
	public void setSchwarz(boolean schwarz) {
		this.schwarz = schwarz;
	}

	public void paint(Graphics g){
		if(isSchwarz()){
			g.setColor(Color.BLACK);
		}else{
			g.setColor(Color.WHITE);
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(isDame()){
			g.setColor(Color.RED);
			g.fillOval(0, 0, getWidth(), getHeight());
		}
	}
	
	
	
}
