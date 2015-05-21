package verschluesselung;

/**
 * Stellt eine Tabelle für die Caesar-Verschiebung
 * @author bsit13serr
 *
 */
public class CaesarTabelle{
	
	/**
	 * Enthält die normale Zeichentabelle
	 */
	private int[] normal = null;
	
	/**
	 * Enthält die verschlüsselte Zeichentabelle
	 */
	private int[] verschluesselt = null;
	
	/**
	 * Start-Position
	 */
	private int offSet = 65;
	
	/**
	 * Erstellt eine Caesar-Tabelle anhand der übergebene Verschiebung 
	 * @param verschiebung 
	 */
	public CaesarTabelle(int verschiebung){
		normal = new int[26];
		verschluesselt = new int[26];
		int zahl = 0;
		for(int i = 0; i < 26; i++){
			normal[i] = i + offSet;
			if(zahl + offSet + verschiebung > 90){
				zahl = 0;
				verschiebung = 0;
			}
			verschluesselt[i] = zahl + offSet + verschiebung;
			zahl++;
		}
	}
	
	public CaesarTabelle(int verschiebung, int start){
		offSet = start;
		normal = new int[26];
		verschluesselt = new int[26];
		int zahl = 0;
		for(int i = 0; i < 26; i++){
			normal[i] = i + offSet;
			if(zahl + offSet + verschiebung > 90){
				zahl = 0;
				verschiebung = 0;
			}
			verschluesselt[i] = zahl + offSet + verschiebung;
			zahl++;
		}
	}
	
	/**
	 * Gibt den verschlüsselten Zeichen-Code anhand des originalen Zeichen-Codes zurück
	 * @param zahl
	 * @return
	 */
	public int getVerschluesselt(int zahl){
		int erg = zahl;
		for(int i = 0; i < 26; i++){
			if(normal[i] == zahl){
				erg = verschluesselt[i];
			}
		}
		return erg;
	}
	
	/**
	 * Gibt den originellen Zeichen-Code and des verschlüsselten Zeichen-Codes zurück
	 * @param zahl
	 * @return
	 */
	public int getEntschluesselt(int zahl){
		int erg = zahl;
		for(int i = 0; i < 26; i++){
			if(verschluesselt[i] == zahl){
				erg = normal[i];
			}
		}
		return erg;
	}
	
	
	public int[] getVerschluesseltArr(){
		return verschluesselt;
	}
	
	public int getCodeAt(int x){
		return verschluesselt[x];
	}
}
