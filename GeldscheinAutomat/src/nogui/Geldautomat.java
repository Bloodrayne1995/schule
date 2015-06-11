package nogui;

public class Geldautomat {

	private int anzahlZweihundert = 0;
	private int anzahlFuenfhundert = 0;
	private int anzahlEinhundert = 0;
	private int anzahlFuenfzig = 0;
	private int anzahlZwanzig = 0;
	private int anzahlZehner = 0;
	private int anzahlFuenfer = 0;
	private int rest = 0;
	
	
	private int input = 0;
	
	/**
	 * Berechnet die Scheine anhand der Eingabe
	 * @param eingabe
	 */
	public void berechneScheine(int eingabe){
		this.input = eingabe;
	}
	
	/**
	 * Berechnet die Scheine
	 */
	public void berechneScheine(){
		rest = input;
		anzahlFuenfhundert = (rest / 500);
		rest = rest % 500;
		anzahlZweihundert = rest/200;
		rest = rest % 200;
		anzahlEinhundert = rest / 100;
		rest = rest % 100;
		anzahlFuenfzig = rest / 50;
		rest = rest % 50;
		anzahlZwanzig = rest / 20;
		rest = rest % 20;
		anzahlZehner = rest / 10;
		rest = rest % 10;
		anzahlFuenfer = rest / 5;
		rest = rest % 5;
	}

	public int getAnzahlZweihundert() {
		return anzahlZweihundert;
	}

	public void setAnzahlZweihundert(int anzahlZweihundert) {
		this.anzahlZweihundert = anzahlZweihundert;
	}

	public int getAnzahlFuenfhundert() {
		return anzahlFuenfhundert;
	}

	public void setAnzahlFuenfhundert(int anzahlFuenfhundert) {
		this.anzahlFuenfhundert = anzahlFuenfhundert;
	}

	public int getAnzahlEinhundert() {
		return anzahlEinhundert;
	}

	public void setAnzahlEinhundert(int anzahlEinhundert) {
		this.anzahlEinhundert = anzahlEinhundert;
	}

	public int getAnzahlFuenfzig() {
		return anzahlFuenfzig;
	}

	public void setAnzahlFuenfzig(int anzahlFuenfzig) {
		this.anzahlFuenfzig = anzahlFuenfzig;
	}

	public int getAnzahlZwanzig() {
		return anzahlZwanzig;
	}

	public void setAnzahlZwanzig(int anzahlZwanzig) {
		this.anzahlZwanzig = anzahlZwanzig;
	}

	public int getAnzahlZehner() {
		return anzahlZehner;
	}

	public void setAnzahlZehner(int anzahlZehner) {
		this.anzahlZehner = anzahlZehner;
	}

	public int getAnzahlFuenfer() {
		return anzahlFuenfer;
	}

	public void setAnzahlFuenfer(int anzahlFuenfer) {
		this.anzahlFuenfer = anzahlFuenfer;
	}

	public int getRest() {
		return rest;
	}

	public void setRest(int rest) {
		this.rest = rest;
	}
	
	
	
	
	
}
