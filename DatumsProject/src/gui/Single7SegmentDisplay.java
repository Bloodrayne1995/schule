package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Single7SegmentDisplay extends JComponent {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Color farbe = Color.BLACK;
	private int zahl = 0;
	
	public Single7SegmentDisplay(){
		this.setSize(10,11);
	}
	
	public void setZahl(int z){
		if(z <= 9){
			zahl = z;
		}
	}
	
	
	public void paint(Graphics g){
		g.setColor(farbe);
		switch(zahl){
		case 0:
			drawBottomLeftLine(g);
			drawBottomLine(g);
			drawBottomRightLine(g);
//			drawMiddleLine(g);
			drawTopLeftLine(g);
			drawTopLine(g);
			drawTopRightLine(g);
			break;
		case 1:
//			drawBottomLeftLine(g);
//			drawBottomLine(g);
			drawBottomRightLine(g);
//			drawMiddleLine(g);
//			drawTopLeftLine(g);
//			drawTopLine(g);
			drawTopRightLine(g);
			break;
		case 2:
			drawBottomLeftLine(g);
			drawBottomLine(g);
//			drawBottomRightLine(g);
			drawMiddleLine(g);
//			drawTopLeftLine(g);
			drawTopLine(g);
			drawTopRightLine(g);
			break;
		case 3:
//			drawBottomLeftLine(g);
			drawBottomLine(g);
			drawBottomRightLine(g);
			drawMiddleLine(g);
//			drawTopLeftLine(g);
			drawTopLine(g);
			drawTopRightLine(g);
			break;
		case 4:
//			drawBottomLeftLine(g);
//			drawBottomLine(g);
			drawBottomRightLine(g);
			drawMiddleLine(g);
			drawTopLeftLine(g);
//			drawTopLine(g);
			drawTopRightLine(g);
			break;
		case 5:
//			drawBottomLeftLine(g);
			drawBottomLine(g);
			drawBottomRightLine(g);
			drawMiddleLine(g);
			drawTopLeftLine(g);
			drawTopLine(g);
//			drawTopRightLine(g);
			break;
		case 6:
			drawBottomLeftLine(g);
			drawBottomLine(g);
			drawBottomRightLine(g);
			drawMiddleLine(g);
			drawTopLeftLine(g);
			drawTopLine(g);
//			drawTopRightLine(g);
			break;
		case 7:
//			drawBottomLeftLine(g);
//			drawBottomLine(g);
			drawBottomRightLine(g);
//			drawMiddleLine(g);
//			drawTopLeftLine(g);
			drawTopLine(g);
			drawTopRightLine(g);
			break;
		case 8:
			drawBottomLeftLine(g);
			drawBottomLine(g);
			drawBottomRightLine(g);
			drawMiddleLine(g);
			drawTopLeftLine(g);
			drawTopLine(g);
			drawTopRightLine(g);
			break;
		case 9:
//			drawBottomLeftLine(g);
			drawBottomLine(g);
			drawBottomRightLine(g);
			drawMiddleLine(g);
			drawTopLeftLine(g);
			drawTopLine(g);
			drawTopRightLine(g);
			break;
		}
	}


	private void drawTopLine(Graphics g){
		g.drawLine(2, 2, getSize().width - 1, 2);
	}
	
	private void drawBottomLine(Graphics g){
		g.drawLine(2, getHeight()-1, getSize().width - 1, getHeight()-1);
	}
	
	private void drawMiddleLine(Graphics g){
		g.drawLine(2, Math.round(getHeight() / 2), getWidth() - 1, Math.round(getHeight() / 2));
	}
	
	private void drawTopLeftLine(Graphics g){
		g.drawLine(2, 2, 2, (Math.round(getHeight() / 2)));
	}
	
	private void drawTopRightLine(Graphics g){
		g.drawLine(getWidth()-1, 2, getWidth() - 1, (Math.round(getHeight() / 2)));
	}
	
	private void drawBottomLeftLine(Graphics g){
		g.drawLine(2,Math.round(getHeight() / 2),2, getHeight() - 1);
	}
	
	private void drawBottomRightLine(Graphics g){
		g.drawLine(getWidth()-1, Math.round(getHeight() / 2), getWidth() - 1, getHeight() - 1);
	}
	
	
	public void setFarbe(Color d){
		this.farbe = d;
	}
	
}
