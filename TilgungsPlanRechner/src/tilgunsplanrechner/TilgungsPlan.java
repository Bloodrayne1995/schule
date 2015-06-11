package tilgunsplanrechner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TilgungsPlan {

	private int kredit;
	private double rate;
	private double p;
	private int aM = 1;
	private int gZ;
	
	
	private boolean checkKredit(){
		return (kredit * (p / 100) ) < rate;
	}
	
	
	public void setTestWerte(){
		kredit = 10000;
		rate =  1000;
		p = 10;
	}
	
	public void werteEinlesen(){
		do{
			kredit = leseEingabeINT("Kredit eingeben: ");
			rate = leseEingabeDBL("Monatliche Rate eingeben: ");
			p = leseEingabeDBL("Zinsatz eingeben: ");
		}while(checkKredit() != true);
	}
	
	
	private void ausgabe(){
		System.out.println("Ausgabe:");
		System.out.println("Höhe des Kredits: " + kredit + " Euro");
		System.out.println("Höhe der monatlichen Raten: " + rate + " Euro");
		System.out.println("Zinsatz in Prozent: " + p + " %");
		System.out.println("");
		System.out.println("Tilgungsplan:");
		System.out.println("--------------------------------------------------------");
		System.out.println("Monat Restkredit mtl. Rate Tilgung Zinsen");
		System.out.println("--------------------------------------------------------");
	}
	
	
	public void tilgungsplanausgeben(){
		ausgabe();
		double restkredit = kredit ;
		double z;
		double tilgung;
		while(restkredit > rate){
			z = (restkredit * (p / 100)) / 12;
			tilgung = rate - z;
			System.out.println(aM + " " +  restkredit + " " +  rate +  " " +  tilgung + " " + z);
			gZ += z;
			restkredit -= tilgung;
			aM++;
		}
		z = (restkredit * (p / 100)) /12;
		tilgung = restkredit ;
		gZ += z;
		rate = (restkredit + z);
		System.out.println(aM + " " +  restkredit + " " +  rate +  " " +  tilgung + " " + z);
		System.out.println("");
		System.out.println("Die Laufzeit war " + aM + " Monate");
		System.out.println("Gesamtzinsen " + gZ + " Euro");
		
	}
	
	/**
	 * Liest die Eingabe
	 * @param t Text der angezeigt wird
	 * @return zahl
	 */
	private int leseEingabeINT(String t){
		InputStreamReader d = new InputStreamReader(System.in);
		BufferedReader s = new BufferedReader(d);
		int erg = 0; 
		try{
			System.out.print(t);
			String x = s.readLine();
			erg = Integer.parseInt(x);
		}catch(NumberFormatException ex){
			erg = leseEingabeINT("Bitte wiederholen Sie Eingabe! Eingabe muss eine Zahl sein." );
		}catch(Exception e){
			e.printStackTrace();
		}
		return erg;
	}
	
	/**
	 * Gibt den Tilgungsplan in CSV zurück
	 * @return
	 */
	public ArrayList<String > getTilgungsplanCSV(){
		ArrayList<String> erg = new ArrayList<String>();
		double restkredit = kredit ;
		double z;
		double tilgung;
		while(restkredit > rate){
			z = (restkredit * (p / 100)) / 12;
			tilgung = rate - z;
			erg.add(aM + ";" +  restkredit + ";" +  rate +  ";" +  tilgung + ";" + z);
			gZ += z;
			restkredit -= tilgung;
			aM++;
		}
		z = (restkredit * (p / 100)) /12;
		tilgung = restkredit ;
		gZ += z;
		rate = (restkredit + z);
		erg.add(aM + ";" +  restkredit + ";" +  rate +  ";" +  tilgung + ";" + z);
		return erg;
	}
	
	/**
	 * Liest die Eingabe
	 * @param t Text der angezeigt wird
	 * @return zahl
	 */
	private double leseEingabeDBL(String t){
		InputStreamReader d = new InputStreamReader(System.in);
		BufferedReader s = new BufferedReader(d);
		double erg = 0; 
		try{
			System.out.print(t);
			String x = s.readLine();
			erg = Double.parseDouble(x);
		}catch(NumberFormatException ex){
			erg = leseEingabeDBL("Bitte wiederholen Sie Eingabe! Eingabe muss eine Zahl sein." );
		}catch(Exception e){
			e.printStackTrace();
		}
		return erg;
	}
	
	
	
}
