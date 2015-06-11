package bbssuew;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Konsole {
	static InputStreamReader d = new InputStreamReader(System.in);
	static BufferedReader b = new BufferedReader(d);
	
	
	
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
