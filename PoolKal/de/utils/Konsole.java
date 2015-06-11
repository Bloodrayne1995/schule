package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Stellt Funktionen und Eigenschaften bereit, um Daten aus der Konsole zu lesen
 * @author bsit13serr (Marcel Serr)
 * @version 1.0 / 23.06.2014
 */
public class Konsole {
	
	/**
	 * Reader, der den Input-Stream, in dem Fall die Konsole-Eingabe, liest.
	 */
	private static InputStreamReader d = new InputStreamReader(System.in);
	
	/**
	 * Cached einen gewissen Teil aus dem Stream, um so besser mit dem Streamarbeiten zu können
	 */
	private static BufferedReader b = new BufferedReader(d);
	
	
	/**
	 * Liest eine Ganzzahl aus der Konsole
	 * @return Ganzzahl aus der Konsole
	 */
	public static int leseInteger(){
		int erg = 0;
		try{
			String x = b.readLine();
			int s = Integer.parseInt(x);
			erg = s;
		}catch(Exception e){
			System.out.print("Bitte eine Ganzzahl eingeben: ");
			erg =  leseInteger();
		}
		return erg;
	}
	
	/**
	 * Liest eine Ganzzahl aus der Konsole
	 * @param t Text der mit ausgegeben werden soll
	 * @return Ganzzahl aus der Konsole
	 */
	public static int leseInteger(String t){
		int erg = 0;
		try{
			System.out.print(t);
			String x = b.readLine();
			int s = Integer.parseInt(x);
			erg = s;
		}catch(Exception e){
			System.out.print("Bitte eine Ganzzahl eingeben: ");
			erg =  leseInteger(t);
		}
		return erg;
	}
	
	/**
	 * Liest eine Kommazahl aus der Konsole
	 * @return Kommazahl aus der Konsole
	 */
	public static float leseFloat(){
		float erg = 0;
		try{
			
			String x = b.readLine();
			float s = Float.parseFloat(x);
			erg = s;
		}catch(Exception e){
			System.out.print("Bitte eine Kommazahl eingeben: ");
			erg =  leseFloat();
		}
		return erg;
	}
	
	/**
	 * Liest eine Kommazahl aus der Konsole
	 * @param t Text der mit ausgegeben werden soll
	 * @return Kommazahl aus der Konsole
	 */
	public static float leseFloat(String t){
		float erg = 0;
		try{
			System.out.print(t);
			String x = b.readLine();
			float s = Float.parseFloat(x);
			erg = s;
		}catch(Exception e){
			System.out.print("Bitte eine Kommazahl eingeben: ");
			erg =  leseFloat(t);
		}
		return erg;
	}
	
}
