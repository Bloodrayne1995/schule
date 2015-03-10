package tankbeleg;

import java.text.DecimalFormat;

/**
 * Erstellt eine Tabelle um Tankbelegge auszuwerten
 * @author bsit13serr
 *
 */
public class Auswertung {

	//Tabelle der Tankbelege
	private double tabelle[][] = null;
	
	//KONSTANTEN
	private final int ANZAHL = 20;
	private final int SUPER = 0;
	private final int SUPER10 = 1;
	private final int DIESEL = 2;
	
	/**
	 * Initialisiert die Tabelle, falls noch nicht geschehen und setzt sie auf 0 zurück
	 */
	public void initTabelle(){
		if(tabelle == null){
			tabelle = new double[3][3];
		}
		for(int i = 0; i < 3;i++){
			for(int j = 0; j < 3;j++){
				tabelle[i][j] = 0;
			}
		}
	}
	
	/**
	 * Gibt einen Tank-Beleg in die Tabelle ein
	 * @param spritart 0 = SUPER, 1 = SUPER10, 2 = DIESEL
	 * @param liter Anzahl Liter des Belegs
	 * @param preis Höhe des Preises des Belegs
	 */
	private void insertBeleg(int spritart, double liter,double preis){
		tabelle[spritart][0] += liter;
		tabelle[spritart][1] += preis;
		tabelle[spritart][2] = (double) tabelle[spritart][1] / tabelle[spritart][0];
	}
	
	/**
	 * Erfasst bis zu 20 Tank-Belege (definiert durch Konstante ANZAHL)
	 * Kann mittels dem definierten Abbruchzeichen abgebrochen werden 
	 */
	public void erfasseBelege(){
		String abbruch = "#";
		int zaehler = 0;
		while(zaehler < ANZAHL){
			int art = eingabeArt();
			double liter = BBSKonsole.leseFloat("Geben Sie die Liter-Anzahl ein:");
			double preis = BBSKonsole.leseFloat("Geben Sie den Preis ein:");
			insertBeleg(art, liter, preis);
			String cmd = BBSKonsole.leseString("Nächster Beleg? '" + abbruch + "' eingeben um das Erfassen zu beenden.");
			if(cmd.equalsIgnoreCase(abbruch)){
				zaehler = ANZAHL;
			}else{
				zaehler++;
			}
		}
	}
	
	/**
	 * Prüft ob die eingegebene Spritart gültig ist
	 * @param art
	 * @return
	 */
	private boolean isArtOK(String art){
		if(art == "SUPER"){
			return true;
		}
		
		if(art == "SUPER10"){
			return true;
		}
		
		if(art == "DIESEL"){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Realisiert die Eingabe des Spritartes
	 * @return
	 */
	private int eingabeArt(){
		String art = "";
		do{
			art = BBSKonsole.leseString("Geben Sie die Spritart ein. Auswahl SUPER, SUPER10, DIESEL.");
		}while(isArtOK(art));
		
		art = art.toUpperCase();
		switch(art){
		case "SUPER":
			return SUPER;
		case "SUPER10":
			return SUPER10;
		case "DIESEL":
			return DIESEL;
		}
		return SUPER;
	}
	
	/**
	 * Zeigt die Tabelle in der Konsole an
	 */
	public void zeigeTabelle(){
		DecimalFormat x = new DecimalFormat("#0.00");
		System.out.println("Art\tSumme Liter\tSumme Preis\tDurchschnitt");
		for(int i=0; i < 3;i++){
			System.out.println(getArt(i) + "\t" + x.format(tabelle[i][0]) + "\t\t" + x.format(tabelle[i][1]) + "\t\t" + x.format(tabelle[i][2]));
		}
	}

	/**
	 * Gibt den Text-Wert des Spritartes zurück
	 * @param art
	 * @return
	 */
	private String getArt(int art){
		switch(art){
		case 0:
			return "SUPER";
		case 1:
			return "SUPER10";
		case 2:
			return "DIESEL";
		}
		return "SUPER";
	}
	
	
}
