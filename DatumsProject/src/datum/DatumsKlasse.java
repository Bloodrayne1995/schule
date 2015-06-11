package datum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Datumsklasse 
 * @author Marcel Serr (bsit13serr)
 * @version 1
 */
public class DatumsKlasse {

	
	//VARS
	
	/**
	 * Der Wert für den Tag in dieser Instanz
	 */
	private int tag = 1 ;	
	
	/**
	 * Der Wert für den Monat in dieser Instanz
	 */
	private int monat = 11 ;
	
	/**
	 * Der Wert für das Jahr in dieser Instanz
	 */
	private int jahr = 1900;
	
	/**
	 * Wird genutzt zum Vergleichen von 2 Daten
	 */
	private DatumsKlasse secondDate = null;
	
	
	//GETTER & SETTER
	
	/**
	 * Gibt der Wert für den Tag zurück
	 * @return Wert für Tag
	 */
	public int getTag() {
		return tag;
	}
	
	/**
	 * Setzt den Wert für Tag
	 * @param tag Der Tag, der gesetzt werden soll
	 */
	public void setTag(int tag) {
		this.tag = tag;
	}
	
	/**
	 * Gibt den Wert für den Monat zurück
	 * @return Wert für Monat
	 */
	public int getMonat() {
		return monat;
	}
	
	/**
	 * Setzt den Wert für Monat
	 * @param monat Der Monat, der gesetzt werden soll
	 */
	public void setMonat(int monat) {
		this.monat = monat;
	}
	
	/**
	 * Gibt den Wert für das Jahr zurück
	 * @return Wert für Jahr
	 */
	public int getJahr() {
		return jahr;
	}
	
	/**
	 * Setzt den Wert für Jahr
	 * @param jahr Der Wert für Jahr, der gesetzt werden soll
	 */
	public void setJahr(int jahr) {
		this.jahr = jahr;
	}
	
	/**
	 * Gibt den Wert für das zweite Datum zurück
	 * @return Wert für das zweite Datum
	 */
	public DatumsKlasse getSecondDate(){
		return secondDate;
	}
	
	/**
	 * Setzt das zweite Datum
	 * @param d Das zweite Datum, das gesetzt werden soll
	 */
	public void setSecondDate(DatumsKlasse d){
		this.secondDate = d;
	}
	
	
	//LESE-Methoden
	
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
	
	/**
	 * Liest den Tag anhand einer Eingabe
	 */
	public void leseTag(){
		do{
			this.tag = leseEingabe("Bitte geben Sie einen Tag ein: ");		
			if (!this.checkTag()){
				System.out.println("Bitte gültigen Tag für den Monat '" + this.getMonat() + "'");
			}
		}while(!this.checkTag());
	}
	
	/**
	 * Liest den Monat anhand einer Eingabe
	 */
	public void leseMonat(){
		do{
			this.monat = leseEingabe("Bitte geben Sie einen Monat ein: ");
			if(!this.checkMonat()){
				System.out.println("Bitte gültigen Monat eingeben!");
			}
		}while(!this.checkMonat());
	}
	
	/**
	 * Liest das Jahr anhand einer Eingabe
	 */
	public void leseJahr(){
		do{
			this.jahr = leseEingabe("Bitte geben Sie ein Jahr ein: ");			
			if(!this.checkJahr()){
				System.out.println("Bitte geben Sie ein gültiges Jahr ein.");
			}
		}while(!this.checkJahr());
	}

	/**
	 * Liest das ganze Datum ein
	 */
	public void leseDatum(){
		this.leseJahr();
		this.leseMonat();
		this.leseTag();
	}
	
	/**
	 * Liest das 2. Datum ein
	 */
	public void leseZweitesDatum(){
		System.out.println("Lese 2. Datum ein:");
		secondDate = new DatumsKlasse();
		secondDate.leseDatum();
	}
	
	
	//SHOW - Methoden
	
	/**
	 * Zeigt den Tag an
	 */
	public void showTag(){
		System.out.println("TAG: " + this.tag);
	}
	
	/**
	 * Zeigt den Monat an
	 */
	public void showMonat(){
		System.out.println("MONAT: " + this.monat);
	}
	
	/**
	 * Zeigt das Jahr an
	 */
	public void showJahr(){
		System.out.println("JAHR: " + this.jahr);
	}
	
	/**
	 * Zeigt das Datum in dem klassischen Format (TT.MM.JJJJ) an
	 */
	public void showDatumKlassisch(){
		System.out.println("DATUM [KLASSISCH]: " + this.tag + "." + this.monat + "." + this.jahr);
	}
	
	/**
	 * Zeigt das Datum in dem internationalen Format (JJJJ-MM-TT) an
	 */
	public void showDatumInternational(){
		System.out.println("DATUM [INTERNATIONAL]: " + this.jahr + "-" + this.monat + "-" + this.tag);
	}
	
	/**
	 * Zeigt den Wochentag an
	 */
	public void showWochenTag(){
		System.out.println("WOCHENTAG [JAVA]: " + getWochenTag());
		System.out.println("WOCHENTAG [ZELLER]: " + getWochenTagZeller());
	}
	
	/**
	 * Zeigt das Osterdatum des Jahres an
	 */
	public void showOsterDatum(){
		DatumsKlasse d = getOsterDatum();
		System.out.println("OSTERDATUM JAHR " + jahr + " : " + d.getTag() + "." + d.getMonat());
	}
	
	/**
	 * Zeigt den Unterschied zwischen den 2 Daten an
	 */
	public void showDifferences(){
		GregorianCalendar d = new GregorianCalendar(Locale.GERMANY);
		d.set(secondDate.getJahr(), secondDate.getMonat(), secondDate.getTag());
		System.out.println(getDifference(d));
	}
	
	/**
	 * Gibt den Monatsnamen aus
	 */
	public void showMonatsname(){
		String erg = "MONATSNAME: ";
		switch(this.monat){
		case 1:
			erg += "Januar";
			break;
		case 2:
			erg += "Februar";
			break;
		case 3:
			erg += "März";
			break;
		case 4:
			erg += "April";
			break;
		case 5:
			erg += "Mai";
			break;
		case 6:
			erg += "Juni";
			break;
		case 7:
			erg += "Juli";
			break;
		case 8:
			erg += "August";
			break;
		case 9:
			erg += "September";
			break;
		case 10:
			erg += "Oktober";
			break;
		case 11:
			erg += "November";
			break;
		case 12:
			erg += "Dezember";
			break;
		}
		System.out.println(erg);
	}
	
	/**
	 * Gibt die Prüfung des Datums aus
	 */
	public void showPruefeDatum(){
		System.out.println("Datums-Prüfung: " + checkDatum());
	}
	
	
	//CHECK-Methoden
		
	/**
	 * Prüft ob der Monat in dem richtigen Bereich liegt
	 * @return
	 */
	private boolean checkMonat(){
		boolean erg = false;
		if (this.monat >= 1 && this.monat <= 12){
			erg = true;
		}else{
			erg = false;
		}
		return erg;
	}
	
	/**
	 * Prüft ob das Jahr in dem richtigen Bereich liegt
	 * @return 
	 */
	private boolean checkJahr(){
		boolean erg = false;
		if (this.jahr >= 0 && this.jahr <= 9999){
			erg = true;
		}else{
			erg = false;
		}
		return erg;
	}
	
	/**
	 * prüft ob der Tag im richtigen Bereich liegt
	 * @return
	 */
	private boolean checkTag(){
		int min = 1;
		int max = this.getMaxTage();
		
		if(this.tag >= min && this.tag <= max){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Prüft ob das Jahr ein Schaltjahr ist
	 * @return true, wenn Schaltjahr ist
	 */
	private boolean isSchaltJahr(){
		return (jahr % 400 == 0) || ((jahr % 4 == 0) && (jahr % 100 != 0));
	}
	
	/**
	 * Prüft das komplette Datum
	 * @return true, wenn das Datum gültig ist
	 */
	private boolean checkDatum(){
		boolean pruefeJahr = false;
		boolean pruefeMonat = false;
		boolean pruefeTag = false;
		
		pruefeJahr = (jahr >= 1582) && (jahr <= 9999);
		pruefeMonat = (monat >= 1) && (monat <= 12);
		
		int maxTageImMonat = getMaxTage();
		pruefeTag = (tag >= 1) && (tag <= maxTageImMonat);
		
		return (pruefeTag && pruefeJahr && pruefeMonat);
	}
	
	
	//Utils
	
	/**
	 * Gibt die maximale Anzahl des Monats an
	 * @return Anzahl Tage des Monats
	 */
	private int getMaxTage(){
		if((this.monat == 1) || (this.monat == 3) || (this.monat == 5) || (this.monat == 7) || (this.monat == 8) || (this.monat == 10) || (this.monat == 12)){
			return 31;
		}
		if((this.monat == 4) || (this.monat == 6) || (this.monat == 9) || (this.monat == 11)){
			return 30;
		}
		if(isSchaltJahr()){
			return 29;
		}else{
			return 28;
		}
	}
	
	/**
	 * Ermittelt den WochenTag
	 * @return WochenTag in String
	 */
	private String getWochenTag(){
		String erg = "";
		GregorianCalendar x = new GregorianCalendar(Locale.GERMANY);
		x.set(jahr, monat - 1, tag);
		int d = x.get(Calendar.DAY_OF_WEEK) ;
		switch(d){
		case 1:
			erg = "Sonntag";
			break;
		case 2:
			erg = "Montag";
			break;
		case 3:
			erg = "Dienstag";
			break;
		case 4:
			erg = "Mittwoch";
			break;
		case 5:
			erg = "Donnerstag";
			break;
		case 6:
			erg = "Freitag";
			break;
		case 7:
			erg = "Samstag";
			break;
		default:
			erg = "Fehler";
			break;
		}
		return erg;
	}
	
	/**
	 * Ermittelt den WOchentag mithilfe der Formel
	 * @return
	 */
	private String getWochenTagZeller(){
		String erg = "";
		int m = monat;
		int j = jahr;
		if (m < 3){
			m += 12;
			j -= 1;
		}
		int y = j % 100;
		int c = j / 100;
		int w = (tag + ((13 *(m+1))/5)+y+(y/4)+(c/4)-(2*c)) % 7;
		switch(w){
		case 0:
			erg = "Samstag";
			break;
		case 1:
			erg = "Sonntag";
			break;
		case 2:
			erg = "Montag";
			break;
		case 3:
			erg = "Dienstag";
			break;
		case 4:
			erg = "Mittwoch";
			break;
		case 5:
			erg = "Donnerstag";
			break;
		case 6:
			erg = "Freitag";
			break;
		default:
			erg = "Fehler";
		}
		return erg;
	}
	
	/**
	 * Ermittelt das Osterdatum für das eingegebene Jahr
	 * @return
	 */
	private DatumsKlasse getOsterDatum(){
		int day = 0;
		int month = 0;
		if ((jahr >= 1900 && jahr <= 2099)){
			int p = jahr / 100;
			int q = p / 3;
			int r = p / 4;
			int x = (15 + p -q -r) % 30;
			int y = (p - r + 4) % 7;
			int a = jahr % 19;
			int b = jahr % 4;
			int c = jahr % 7;
			int d = (19*a + x) % 30;
			int e = (2*b + 4*c+ 6*d +y) % 7;
			
			if(d == 29 && e == 6){
				day = 19;
				month = 4;
			}else if(d == 28 && e == 6){
				day = 18;
				month = 4;
			}else if(22 + d + e <= 31){
				day = 22 + d + e;
				month = 3;
			}else{
				day = d + e - 9;
				month = 4;
			}
		}
		
		DatumsKlasse erg = new DatumsKlasse();
		erg.setJahr(jahr);
		erg.setMonat(month);
		erg.setTag(day);
		
		return erg;
	}
	
	/**
	 * Ermittelt den Unterschied zwischen 2 Daten
	 * @param compInst Datum mit dem verglichen werden soll
	 * @return
	 */
	private String getDifference(GregorianCalendar compInst){
		String ergebnis = "";
		
		GregorianCalendar myInst = new GregorianCalendar(Locale.GERMANY);
		myInst.set(jahr, monat, tag);
		
		long difference = myInst.getTimeInMillis() - compInst.getTimeInMillis();
		
		if(difference < 0){
			difference = compInst.getTimeInMillis() - myInst.getTimeInMillis();
		}
		
		int tage = (int)(difference / (1000 * 60 * 60 * 24));
		int stunden = (int)(difference / (1000 * 60 * 60) % 24);
		int minuten = (int)(difference / (1000 * 60) % 60);
		int sekunden = (int)(difference / 1000 % 60);
		int millis = (int)(difference % 1000);
		
		ergebnis += "Unterschied zu " + compInst.get(Calendar.DAY_OF_MONTH) + "." + getCalendarMonth(compInst.get(Calendar.MONTH)) + "." + compInst.get(Calendar.YEAR) + ": ";
		ergebnis += tage + " Tage " + stunden + " Stunden " + minuten + " Minuten " + sekunden + " Sekunden " + millis + " Millisekunden";

		return ergebnis;
	}
	
	
	private int getCalendarMonth(int month){
		switch(month){
		case 0:
			return 12;
		default:
			return month;
		}
	}
	
}
