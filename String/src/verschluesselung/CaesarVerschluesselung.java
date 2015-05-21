package verschluesselung;

public class CaesarVerschluesselung {

	private int verschiebung = 0;
	private CaesarTabelle tabelle = null;
	private CaesarTabelle klein = null;

	/**
	 * Initialisiert die Caesar-Verschlüsselung mit der Verschiebung um 0
	 */
	public CaesarVerschluesselung(){
		tabelle = new CaesarTabelle(getVerschiebung());
		klein = new CaesarTabelle(getVerschiebung(), 97);
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
			klein = new CaesarTabelle(getVerschiebung(), 97);
		}
	}
	
	/**
	 * Verschlüsselt den Text mittels der zuvor festgelegten Verschiebung
	 * @param txt
	 * @return
	 */
	public String verschluessele(String txt){
		String erg = "";
		for(int i = 0; i < txt.length();i++){
			if(txt.codePointAt(i) > 64 && txt.codePointAt(i) < 91){
				erg += (char) tabelle.getVerschluesselt(txt.codePointAt(i));				
			}else{
				erg += (char) klein.getVerschluesselt(txt.codePointAt(i));
			}
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
		CaesarTabelle g = new CaesarTabelle(verschiebung);
		CaesarTabelle k = new CaesarTabelle(verschiebung,97);
		String erg = "";
		for(int i = 0; i < txt.length();i++){
			if(txt.codePointAt(i) > 64 && txt.codePointAt(i) < 91){
				erg += (char) g.getVerschluesselt(txt.codePointAt(i));				
			}else{
				erg += (char) k.getVerschluesselt(txt.codePointAt(i));
			}
		}
		return erg;
	}
	
	
	/**
	 * Entschlüsselt den Text mittels der zuvor festgelegten Verschiebung
	 * @param txt
	 * @return
	 */
	public String entschluessele(String txt){
		String erg = "";
		for(int i = 0; i < txt.length();i++){
			if(txt.codePointAt(i) > 64 && txt.codePointAt(i) < 91){
				erg += (char) tabelle.getEntschluesselt(txt.codePointAt(i));				
			}else{
				erg += (char) klein.getEntschluesselt(txt.codePointAt(i));
			}
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
		CaesarTabelle g = new CaesarTabelle(verschiebung);
		CaesarTabelle k = new CaesarTabelle(verschiebung,97);
		String erg = "";
		for(int i = 0; i < txt.length();i++){
			if(txt.codePointAt(i) > 64 && txt.codePointAt(i) < 91){
				erg += (char) g.getEntschluesselt(txt.codePointAt(i));				
			}else{
				erg += (char) k.getEntschluesselt(txt.codePointAt(i));
			}
		}
		return erg;
	}

	
	
}
