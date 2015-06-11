package modulo;

public class ZahlenKlasse {

	
	public void quersumme(int zahl){
		int rest = zahl;
		int anzahltausend = rest / 1000;
		rest %= 1000;
		int anzahlhundert = rest / 100;
		rest %= 100;
		int anzahlZehn = rest / 10;
		rest %= 10;
		int anzahlEins = rest;
		int ergebnis = anzahlEins + anzahlhundert + anzahlZehn + anzahltausend;
		System.out.println("Quersumme: " + ergebnis);
	}
	
	public void quersummeE(){
		int x = BBSKonsole.leseInteger("Bitte Zahl eingeben (xD): ");
		quersumme(x);
	}
	
	
	
	
}
