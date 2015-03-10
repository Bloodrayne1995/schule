package lotto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class LottoQuadrat {

	private int meineZahlen[] = new int[6];
	private int gezogeneZahlen[] = new int[6];
	
	private boolean useRandom = true;
	
	/**
	 * Initialisiert die Klasse und die darin enthalten Arrays
	 */
	public LottoQuadrat(){
		this.initArrays();
	}
	
	/**
	 * Setzt den Wert der Arrays auf 0
	 */
	private void initArrays(){
		for(int i = 0; i < meineZahlen.length;i++){
			meineZahlen[i] = 0;
		}
		
		for(int i = 0; i < gezogeneZahlen.length;i++){
			gezogeneZahlen[i] = 0;
		}
	}
	
	/**
	 * Setzt die gezogene Zahlen. Für EIn Lottospiel mit mehrere Quadraten gedacht
	 * @param arr
	 */
	public void setGezogeneZahlen(int arr[]){
		for(int i = 0; i < arr.length ; i++){
			gezogeneZahlen[i] = arr[i];
		}
		useRandom = false;
	}
	
	/**
	 * Generiert die Zufallszahlen
	 */
	private void calculateRandomGezogeneZahlen(){
	
		Random x = new Random();
		int zahl = 0;
		for(int i = 0; i < gezogeneZahlen.length ;i++){
			zahl = x.nextInt(49);
			while(zahl == 0 || checkEingegebeneZahl(zahl, gezogeneZahlen)){
				zahl = x.nextInt(49);
			}
			gezogeneZahlen[i] = zahl;
		}
	}
	
	/**
	 * Eingabe der eigene Zahlen
	 */
	public void zieheZahl(){
		int x = 50;
		for(int i = 0; i < meineZahlen.length;i++){
			while((x > 49 || x <= 0) || checkEingegebeneZahl(x,meineZahlen)){
				x = gebeIntEin("Geben Sie die " + (i + 1) + ". Zahl ein: " );
			}
			meineZahlen[i] = x;
			x=50;
		}
	}
	
	private boolean checkEingegebeneZahl(int x, int arr[]){
		boolean erg = false;
		for(int a:arr){
			if(a == x){
				erg = true;
				break;
			}
		}
		
		return erg;
	}
	
	/**
	 * Prüft die eingebene Zahlen mit den gezogen Zahlen
	 * Wenn der Flag useRandom = true ist werden die gezogene Zahlen vorher generiert
	 */
	public void checkZahlen(){
		int erg[] = new int[6];
		int anzahl = 0;
		
		if(useRandom){
			calculateRandomGezogeneZahlen();
		}
		
		
		for(int x:gezogeneZahlen){
			if(checkEingegebeneZahl(x, meineZahlen)){
				erg[anzahl] = x;
				anzahl++;
			}
		}
		
		if(anzahl > 0){
			System.out.print("Folgende " + anzahl + " Zahlen waren richtig: ");
			for(int x:erg){
				System.out.print(x + " | ");
			}
			System.out.println("");
		}else{
			System.out.print("0 Zahlen waren richtig.");
		}
		
	}
	
	/**
	 * Zeigt die gezogene Zahlen an
	 */
	public void zeigeGezogeneZahlen(){
		zeigeFeld(gezogeneZahlen);
	}
	
	/**
	 * Zeigt die eingegbene Zahlen an
	 */
	public void zeigeMeineZahlen(){
		zeigeFeld(meineZahlen);
	}
	
	/**
	 * Zeigt Inhalte eines Feldes
	 * @param x
	 */
	private void zeigeFeld(int x[]){
		for(int a:x){
			System.out.print(a + ";");
		}
		System.out.println("");
	}
	
	/**
	 * Eingabe-Methode für integer
	 * @param ausgabeText
	 * @return
	 */
	private int gebeIntEin(String ausgabeText){
		BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
		int erg = -1;
		String txt = "";
		try{
			while(!isNumber(txt)){
				System.out.print(ausgabeText);
				txt = d.readLine();
				System.out.println("");
			}
			erg = Integer.parseInt(txt);
		}catch(Exception e){
			
		}
		return erg;
	}
	
	/**
	 * Prüft ob der Text eine Zahl ist
	 * @param x
	 * @return
	 */
	private boolean isNumber(String x){
		boolean erg = false;
		try{
			Integer.parseInt(x);
			erg = true;
		}catch(NumberFormatException e){
			erg = false;
		}
		return erg;
	}
	
	
}
