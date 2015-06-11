package bbssuew;

import utils.Konsole;

/**
 * Stellt Funktionen und Eigenschaften zum Berechnen eines Pools bereit
 * @author bsit13serr (Marcel Serr)
 * @version 1.0 / 23.06.2014
 */
public class PoolKlasse {

	/**
	 * Grundstücks-Länge
	 */
	private int gL = 0;
	
	/**
	 * Grundstücks-Breite
	 */
	private int gB = 0;
	
	/**
	 * Pooltiefe
	 */
	private int t = 0;
	
	/**
	 * Gesamtkosten
	 */
	private double k = 0;
	
	/**
	 * Flag, das angibt ob Daten bereits eingegeben wurden.
	 */
	private boolean is_inputed = false;
	
	/**
	 * Flag, das angibt ob das Ergebnis schon berechnet wurde
	 */
	private boolean is_calculated = false;
	
	

	/**
	 * Liest die erforderliche Werte ein
	 */
	public void werteEingeben(){
		
		System.out.println("Bitte folgende Werte eingeben");
		
		//Daten, die in die Konsole eingetragen werden, auslesen
		gL = Konsole.leseInteger("Grundstücks-Länge [m]: ");
		gB = Konsole.leseInteger("Grundstücks-Breite [m]: ");
		t = Konsole.leseInteger("Pool-Tiefe [m]: ");
		
		//Flag setzen
		is_inputed = true;
	}
	
	
	/**
	 * Gibt das Ergebnis aus
	 */
	public void werteAusgeben(){
		
		//Falls keine Eingaben gemacht wurden, wird hier mit einer Meldung abgebrochen
		if(!is_inputed){
			System.out.println("Keine Daten eingegeben");
			return;
		}
		
		//Falls keine Berechnungen gemacht wurden, wir hier mit einer Meldung abgebrochen
		if(!is_calculated){
			System.out.println("Noch nicht berechnet");
			return;
		}
		
		System.out.println("Gesamtkosten: " + k  + " €");
		
	}
	
	/**
	 * Berechnet die Werte anhand der Eingabe
	 * @return Gibt einen Fehler aus, falls keine Eingaben gemacht wurden.
	 */
	public void werteBerechnen(){
		
		//Falls keine Eingaben gemacht wurden, wird hier mit einer Meldung abgebrochen
		if(!is_inputed){
			System.out.println("Keine Daten eingetragen!");
			return;
		}
		
		
		int gsFlaeche = gL * gB;
		double poolLaenge = gL * (2.00 / 3.00);
		double poolBreite = gB * (3.00 / 4.00);
		double poolFlaeche = poolBreite * poolLaenge;
		double aussenFlaeche = gsFlaeche - poolFlaeche;
		double wandA = poolLaenge * t;
		double wandB = poolBreite * t;
		double poolVolumen = poolFlaeche * t;
		double fliessenBecken = ((wandA + wandB)*2 + poolFlaeche ) * 12;
		double fliessenAussen = aussenFlaeche * 24;
		double poolKosten = poolVolumen * 200;
		k = fliessenBecken + fliessenAussen + poolKosten;
		
		is_calculated = true;
	}
	
	
	
}
