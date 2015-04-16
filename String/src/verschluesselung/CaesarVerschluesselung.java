package verschluesselung;

public class CaesarVerschluesselung {

	private int verschiebung = 0;
	private CaesarTabelle tabelle = null;

	/**
	 * Initialisiert die Caesar-Verschlüsselung mit der Verschiebung um 0
	 */
	public CaesarVerschluesselung(){
		tabelle = new CaesarTabelle(getVerschiebung());
	}
	
	/**
	 * Initialisiert die Caesar-Verschlüsselung mit der übergebene Verschiebung
	 * @param verschiebung
	 */
	public CaesarVerschluesselung(int verschiebung){
		try{
			setVerschiebung(verschiebung);
		}catch(Exception e){
			System.out.println("Fehler beim Initialiseren: " + e.getMessage());
			System.out.println("Tabelle wird mit Verschiebung=0 erstellt");
			tabelle = new CaesarTabelle(0);
		}
	}
	
	/**
	 * @return the verschiebung
	 */
	public int getVerschiebung() {
		return verschiebung;
	}
	
	/**
	 * @param verschiebung the verschiebung to set
	 * @throws Exception 
	 */
	public void setVerschiebung(int verschiebung) throws Exception {
		if(verschiebung > 26){
			throw new Exception("Verschiebung darf nicht länger als 26 sein!");
		}else{
			this.verschiebung = verschiebung;
			tabelle = new CaesarTabelle(getVerschiebung());
		}
	}
	
	/**
	 * Verschlüsselt den Text mittels der zuvor festgelegten Verschiebung
	 * @param txt
	 * @return
	 */
	public String verschluessele(String txt){
		txt = txt.toUpperCase();
		String erg = "";
		for(int i = 0; i < txt.length();i++){
			erg += (char) tabelle.getVerschluesselt(txt.codePointAt(i));
		}
		return erg;
	}
	
	
	/**
	 * Verschlüsselt den Text mittels der übergebene Verschiebung
	 * @param txt
	 * @param verschiebung
	 * @return
	 */
	public String verschluessele(String txt,int verschiebung){
		CaesarTabelle x = new CaesarTabelle(verschiebung);
		txt = txt.toUpperCase();
		String erg = "";
		for(int i = 0; i < txt.length();i++){
			erg += (char) x.getVerschluesselt(txt.codePointAt(i));
		}
		return erg;
	}
	
	
	/**
	 * Entschlüsselt den Text mittels der zuvor festgelegten Verschiebung
	 * @param txt
	 * @return
	 */
	public String entschluessele(String txt){
		txt = txt.toUpperCase();
		String erg = "";
		for(int i = 0; i < txt.length();i++){
			erg += (char) tabelle.getEntschluesselt(txt.codePointAt(i));
		}
		return erg;
	}
	
	
	/**
	 * Entschlüsselt den Text mittels der übergebene Verschiebung
	 * @param txt
	 * @param verschiebung
	 * @return
	 */
	public String entschluessele(String txt, int verschiebung){
		CaesarTabelle x = new CaesarTabelle(verschiebung);
		txt = txt.toUpperCase();
		String erg = "";
		for(int i = 0; i < txt.length();i++){
			erg += (char) x.getEntschluesselt(txt.codePointAt(i));
		}
		return erg;
	}

	
	/**
	 * Stellt eine Tabelle für die Caesar-Verschiebung
	 * @author bsit13serr
	 *
	 */
	private class CaesarTabelle{
		
		/**
		 * Enthält die normale Zeichentabelle
		 */
		private int[] normal = null;
		
		/**
		 * Enthält die verschlüsselte Zeichentabelle
		 */
		private int[] verschluesselt = null;
		
		/**
		 * Erstellt eine Caesar-Tabelle anhand der übergebene Verschiebung 
		 * @param verschiebung 
		 */
		public CaesarTabelle(int verschiebung){
			normal = new int[26];
			verschluesselt = new int[26];
			int zahl = 0;
			for(int i = 0; i < 26; i++){
				normal[i] = i + 65;
				if(zahl + 65 + verschiebung > 90){
					zahl = 0;
					verschiebung = 0;
				}
				verschluesselt[i] = zahl + 65 + verschiebung;
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
		
	}
}
