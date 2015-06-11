package framepack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.util.Random;

import javax.swing.*;

import snake.SnakePlayer;

public class Spielfeld extends JPanel{

	SnakePlayer meinPlayer = null;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Spielfeld(){
		this.setSize(500, 500);
		this.setLayout(null);
		//this.setBackground(getRandomColor());
		this.addKeyListener(meinPlayer);
	}
	
	public void addNewPlayer(){
		meinPlayer = new SnakePlayer(null,getRandomLocation());
		addPlayer(meinPlayer);
	}
	
	public void addPlayer(SnakePlayer x){
		this.add(x);
		repaint();
	}
	
	public void addAllPlayerLaenge(){
		for(Component  d:getComponents()){
			if(d instanceof SnakePlayer){
				((SnakePlayer) d).addLaenge();
			}
		}
	}
	
	
	public Color getRandomColor(){
		Random d = new Random();
		int r = d.nextInt(255);
		int g = d.nextInt(255);
		int b = d.nextInt(255);
		int a = d.nextInt(255);
		return new Color(r, g, b, a);
	}
	
	public Point getRandomLocation(){
		Random d = new Random();
		int w = d.nextInt(this.getWidth());
		int h = d.nextInt(this.getHeight());
		return new Point(w, h);
	}
	
	
	
}
