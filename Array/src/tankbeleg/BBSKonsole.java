package tankbeleg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * liefert eine vereinfachte Konsoleneingabe <br>
 * <b>verwendeteTechnik</b><br>
 * einlesen des System-In in einen BufferedReader
 * 
 * @author: pwe, 
 * V 1.0: pwe 27.05.2006 
 * V 1.1: pwe, 23.10.2006 
 * 		Ergnzt:  LeseFloat(String)//LeseString // LeseString(String)// formatierteAusgabe 
 * 		Gendert: NumberFormatException bei LeseFloat ergnzt
 * 
 */
public class BBSKonsole {
	private static BufferedReader meineEingabe = new BufferedReader(new InputStreamReader(System.in));

	public BBSKonsole() {
	}

	/**
	 * Einlesen eines Integerwertes von der Konsole
	 * 
	 * @return :: die eingelesene Zahl
	 */
	public static int leseInteger() {
		int integerWert = 0;
		
		
		try {
			integerWert = Integer.parseInt(meineEingabe.readLine());
			// integerWert = Integer.parseInt(meineEingabe.readLine());
		} catch (IOException e) {
			System.err.println("Fehler beim Lesen des IntegerWertes (" + e	+ ")");
		}
		return integerWert;
	}// leseInt

	/**
	 * liest einen Integerwert von der Konsole. Gibt vorher einen Text aus
	 * 
	 * @param ausgabeText ::
	 *            der Ausgabetext
	 * @return :: die eingelesene Zahl
	 * @see :: berladene Methode: leseInteger
	 */
	public static int leseInteger(String ausgabeText) {
		System.out.print(ausgabeText);
		return leseInteger();
	}

	/**
	 * liest einen Floatwert von der Konsole
	 * 
	 * @return :: die eingelesene Zahl
	 */
	public static float leseFloat() {
		float floatWert = 0;
		try {
			floatWert = Float.parseFloat(meineEingabe.readLine());
		} catch (NumberFormatException e) {
			System.err.println("Das war keine gltige Fliekommazahl");
		} catch (IOException e) {
			System.err.println("Allgemeiner Fehler beim Lesen des FloatWertes ("+ e + ")");
		}
		return floatWert;
	}// leseFLoat

	/**
	 * liest einen Floatwert von der Konsole. Gibt vorher einen Text aus
	 * 
	 * @param ausgabeText :: der Ausgabetext
	 * @return :: die eingelesene Zahl
	 * @see :: berladene Methode: leseFloat
	 */
	public static float leseFloat(String ausgabeText) {
		System.out.print(ausgabeText);
		return leseFloat();
	}

	/**
	 * liest einen String von der Konsole
	 * 
	 * @return :: der eingelesene Text
	 */
	public static String leseString() {
		String meinString = new String();
		try {
			meinString = meineEingabe.readLine();
		} catch (IOException e) {
			System.err.println("Allgemeiner Fehler beim Lesen von der Konsole ("+ e + ")");
		}
		return meinString;
	}// leseFLoat

	/**
	 * liest einen String von der Konsole. Gibt vorher einen Text aus
	 * 
	 * @param ausgabeText ::
	 *            der Ausgabetext
	 * @return :: der eingegebene Text
	 * @see :: berladene Methode: leseText
	 */
	public static String leseString(String ausgabeText) {
		System.out.print(ausgabeText);
		return leseString();
	}
	/**
	 * liest einen float/double als Parameter ein 
	 * formatiert die Zahl auf 2 Nachkommastellen 
	 * und gibt das Ergebnis als String zurck  
	 * 
	 * @param zahl :: die zu fomatierende Zahl 
	 * @return :: die auf 2 Nachkommastellen formatierte Zahl 
	 */
	public static String formatierteAusgabe(double zahl)
	{
		String sDummy; 
		// Definition das Ausgabeformat die Ausgabe
		DecimalFormat meineAusgabe = new DecimalFormat("#0.00 ");
		sDummy =meineAusgabe.format(zahl); 
		return sDummy;  			
	}

}// BBSKonsole
