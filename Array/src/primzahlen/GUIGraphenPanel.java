package primzahlen;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GUIGraphenPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ErgebnisDaten modern = null;
	private ErgebnisDaten classic = null;
	private MeinACListener list = new MeinACListener();
	private boolean draw_modern = false;
	private boolean draw_classic = false;
	private double scaleFactor = 2.0;
	
	
	public GUIGraphenPanel(){
		this.setLayout(null);
	}
	
	
	public void init(int og){
		modern = new ErgebnisDaten(og, true);
		classic = new ErgebnisDaten(og, false);
		modern.addActionListener(list);
		this.setSize(getScaleInt(og + 50),getScaleInt( og * 10));
		
	}
	
	public void run(){
		new Thread(modern).start();
		new Thread(classic).start();
		repaint();
	}
	
	private int getScaleInt(int orig){
		return (int)(orig * scaleFactor);
	}
	
	public void zeichneDiagramm(Graphics d){
	
		d.setColor(Color.black);
		d.drawLine(getScaleInt(10) , getScaleInt(10), getScaleInt(10), this.getHeight() - 10);
		d.drawLine(getScaleInt(10),getScaleInt(this.getHeight() - 10), getScaleInt(this.getWidth()),getScaleInt(this.getHeight() - 10));
		
		
	}
	
	private void zeichneGraphen(ErgebnisDaten x, Color f,Graphics d){
		d.setColor(f);
		Point x1 = null;
		Point x2 = null;
		x1 = new Point(0,this.getHeight() - 10 );
		for(int i = 1; i < x.getObegrenze();i++){
			x2 = new Point(i,x.getTime(i));
			d.drawLine(x1.x + 10,x1.y , x2.x + 10,x2.y);
			x1 = x2;
		}
		d.setColor(Color.black);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		zeichneDiagramm(g);
		
		if(draw_classic){
			//zeichneGraphen(classic, Color.blue, g);
		}
		
		if(draw_modern){
		//zeichneGraphen(modern, Color.red, g);
		}
	}
	
	
	private class MeinACListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand() == "true"){
				draw_modern = true;
				System.out.println("Moderner Graphen wird gestartet");
			}else{
				draw_classic = true;
				System.out.println("Klassischer Graphen wird gestartet");
			}
			
			repaint();
		}
		
	}
	
}
