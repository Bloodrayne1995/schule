package gui;


import javax.swing.JPanel;

import dameproblem.DamenProblemLoeser;

public class Schachfeld extends JPanel {

	private int laenge = 4;
	private int feldBreite = 100;
	private int feldLaenge = 100;
	private DamenProblemLoeser dp = null;
	
	
	/**
	 * @return the laenge
	 */
	public int getLaenge() {
		return laenge;
	}

	/**
	 * @param laenge the laenge to set
	 */
	public void setLaenge(int laenge) {
		if(laenge >= 4){
			this.laenge = laenge;
		}else{
			System.out.println("Feld muss größer oder gleich 4 sein!");
			this.laenge = 4;
		}
	}

	public Schachfeld(){
		
	}
	
	/**
	 * Erstellt ein Panel mit der angegebene Spalten-Anzahl
	 * @param l Spalten-Anzahl. Wenn kleiner 4, ist die Spaltenanzahl 4
	 */
	public Schachfeld(int l){
		setLaenge(l);
	}
	
	/**
	 * Erstellt ein Panel mit der angegebene Spalten-Anzahl
	 * @param l Spalten-Anzahl. Wenn kleiner 4, ist die Spaltenanzahl 4
	 */
	public Schachfeld(int l,DamenProblemLoeser d){
		setLaenge(l);
		dp = d;
	}
	
	
	/**
	 * Generiert das Panel
	 */
	public void generate(){
		boolean s = true;	
		this.setLayout(null);
		for(int i = 0; i < laenge; i++){
			for(int j = 0; j < laenge; j++){
				Feld x = new Feld(s);
				x.setSize(feldBreite, feldLaenge);
				s = !s;
			
				if(dp != null){
					if(dp.getZeile(i) == j){
						x.setDame(true);
					}
				}
				
				x.setLocation(j * x.getWidth(), i * x.getHeight());
				this.add(x);
			}
			if (laenge % 2 == 0){
				s = !s;
			}
		}
		this.setSize(laenge * feldBreite,laenge * feldLaenge);
		//this.setSize(1280, 720);
	}
	
	
	public void setFeldSize(int w, int h){
		feldBreite = w;
		feldLaenge = h;

	}
	
	public void setFeldSize(int w, int h, boolean neuZeichnen){
		setFeldSize(w, h);
		if(neuZeichnen){
			this.removeAll();
			this.generate();
			this.repaint();
		}
	}
	
	
}
