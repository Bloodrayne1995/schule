package pascaldreieck;
import javax.swing.*;

import farben.FarbenArray;

import java.awt.*;

/**
 * Erstellt ein Pascalsches Dreieck
 * @author Marcel Serr
 *
 */
public class PascalDreieck extends JPanel{

	/**
	 * Das Dreieck in einem zwei-dimensionalen Array 
	 */
	private int dreieck[][] = null;
	private FarbenArray farben = null;
	
	
	
	/**
	 * Erstellt das Array mit der angegebene Größe
	 * @param size Größe des Dreiecks
	 */
	public void initDreieck(int size){
		dreieck = new int[size][size];
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				dreieck[i][j] = 0;
			}
		}
	}
	
	public void setFarben(FarbenArray x){
		this.farben = x;
	}
	
	/**
	 * Erstellt das Dreieck.
	 */
	public void createDreieck(){
		try{
		
			//Ränder machen
			for(int i = 0; i < dreieck.length; i++){
				dreieck[0][i] = 1;
				dreieck[i][0] = 1;
			}
			
			int zeile_1 = 0;
			int zeile_2 = 0;
			
			for(int zeile = 1; zeile < dreieck.length - 1;zeile++){
				zeile_2 = zeile;
				for(int i = 1; i < dreieck.length - 1; i++){
					dreieck[i][zeile_2] = dreieck[i][zeile_1] + dreieck[i-1][zeile_2];
				}
				zeile_1 = zeile_2;
			}
		}catch(NullPointerException n){
			System.out.println("Das Array ist nicht vorhanden. Wurde es mit initDreieck anglegt?");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Der Index ist über die Grenze des Arrays");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Zeigt das Dreieck an
	 * Beispiel:
	 * 1 1 1 1 1 
	 * 1
	 * 1
	 * 1
	 * 1
	 */
	public void showDreieck(){
		for(int i = 0; i < dreieck.length ;i++){
			for(int j = 0; j < dreieck.length ;j++){
				if(dreieck[i][j] != 0){
					System.out.print(dreieck[i][j] + "\t\t");
				}else{
					j = dreieck.length;
				}
			}
			System.out.println("");
		}
	}
	
	/**
	 * Gibt die Länge des Dreiecks zurück
	 * @return 
	 */
	public int getLaenge(){
		return dreieck.length;
	}
	
	public int getZelle(int x, int y){
		return dreieck[x][y];
	}
	
	
	public void paint(Graphics g){
		super.paint(g);
		
		int breite = 10;
		int hoehe = 10;
		int startX = this.getWidth() / 2 - breite / 2;
		int startY = 0;
		int laufX = 0;
		int laufY = 0;
		
		for(int i = 0; i < getLaenge();i++){
			laufX = startX;
			laufY = startY;
			for(int j = 0;j < getLaenge() - i;j++){
				g.drawRect(laufX, laufY, breite,hoehe);
				int zahl = dreieck[i][j];
				if(zahl != 0){
					g.setColor(getFarbe(zahl));
					g.fillRect(laufX,laufY,breite,hoehe);
					g.setColor(Color.BLACK);
				}
				laufX = laufX + breite / 2;
				laufY = laufY + hoehe;
			}
			startX = startX - breite / 2;
			startY = startY + hoehe;
		}
	}
	
	private Color getFarbe(int zahl){
		if(zahl == 1){
			return farben.getFarbe(0).getFarbe();
		}else{
			return farben.getFarbe(zahl % farben.getAnzahl()).getFarbe();
		}
	}
	
}
