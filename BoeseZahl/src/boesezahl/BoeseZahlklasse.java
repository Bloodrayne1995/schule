package boesezahl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Böse Zahl nach den Greedy-Schema
 * @author bsit13serr
 *
 */
public class BoeseZahlklasse {
	private int obergrenze;
	private int boeseZahl;
	/**
	 * @return the obergrenze
	 */
	public int getObergrenze() {
		return obergrenze;
	}
	/**
	 * @param obergrenze the obergrenze to set
	 */
	public void setObergrenze(int obergrenze) {
		this.obergrenze = obergrenze;
	}
	/**
	 * @return the boeseZahl
	 */
	public int getBoeseZahl() {
		return boeseZahl;
	}
	/**
	 * @param boeseZahl the boeseZahl to set
	 */
	public void setBoeseZahl(int boeseZahl) {
		this.boeseZahl = boeseZahl;
	}
	
	
	/**
	 * Prüft, ob die Böse Zahl in der Zahl steht
	 * @param zahl Zahl, die geprüft werden soll
	 * @return
	 */
	private boolean existsBoeseZahl(int zahl){
		if(zahl % 10 == boeseZahl){
			return true;
		}else{
			if(zahl <= 10){
				return false;
			}else{
				return existsBoeseZahl(zahl / 10);
			}
		}
	}
	
	/**
	 * Prüft, ob die Zahl durch die Böse Zahl teilbar sind.
	 * @param zahl Zahl, die überprüft werden soll.
	 * @return
	 */
	private boolean isTeilbar(int zahl){
		return (zahl % boeseZahl == 0);
	}
	
	/**
	 * Prüft ob die Zahl eine Böse Zahl ist
	 * @param zahl Die Zahl, die überprüft werden soll
	 * @return true = Wenn die Zahl eine Böse Zahl ist
	 */
	private boolean isBoeseZahl(int zahl){
		return (existsBoeseZahl(zahl)) || (isTeilbar(zahl));
	}
	
	/**
	 * Sucht alle Böse Zahlen zwischen 1 und Obergrenze
	 */
	public void start(){
		for(int i = 1; i <= obergrenze;i++){
			if(isBoeseZahl(i)){
				System.out.println("Böse " + boeseZahl);
			}else{
				System.out.println(i);
			}
		}
	}
	
	/**
	 * Liest die Obergrenze ein
	 */
	public void leseObergrenze(){
		obergrenze = leseEingabe("Bitte Obergrenze eingeben: ");
	}
	
	/**
	 * Liest die Böse Zahl ein
	 */
	public void leseBoeseZahl(){
		boeseZahl = leseEingabe("Bitte böse Zahl eingeben: ");
	}
	
	
	/**
	 * Liest die Eingabe
	 * @param t Text der angezeigt wird
	 * @return zahl
	 */
	private int leseEingabe(String t){
		InputStreamReader d = new InputStreamReader(System.in);
		BufferedReader s = new BufferedReader(d);
		int erg = 0; 
		try{
			System.out.print(t);
			String x = s.readLine();
			erg = Integer.parseInt(x);
		}catch(NumberFormatException ex){
			erg = leseEingabe("Bitte wiederholen Sie Eingabe! Eingabe muss eine Zahl sein." );
		}catch(Exception e){
			e.printStackTrace();
		}
		return erg;
	}
	
	
}
