package verschluesselung;


public class Vigenere {

	public String getVerschluesselt(String text, String key){
		String ergebnis = "";
		
		int zahl = 0;
		
		for(int i = 0; i < text.length(); i++){
			char zeichen = text.charAt(i);
			zahl = i;
			if(zahl > key.length()){
				zahl = 0;
			}
			CaesarTabelle x = new CaesarTabelle(key.codePointAt(zahl) - 65);
			ergebnis += x.getVerschluesselt((int) zeichen);
		}
		
		
		return ergebnis;
	}
	
	
}
