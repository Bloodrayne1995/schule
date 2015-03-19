package datei;

import java.util.ArrayList;


public class HTMLDatei extends StringFileIO{

	public HTMLDatei(){
		
	}
	
	public HTMLDatei(String fileName){
		this.setDateiName(fileName);
		this.leseDatei();
	}
	
	public void setDateiName(String fileName){
		if(fileName.endsWith(".htm") || fileName.endsWith(".html") || fileName.endsWith(".hta")){
			super.setDateiName(fileName);
		}else{
			System.out.println("Datei muss eine HTML-Datei sein");
		}
	}
	
	/**
	 * Gibt den Link in einer Zeile zurück
	 * @param txt
	 * @return
	 */
	private String getHyperlink(String txt){
		int pos = txt.indexOf("<a ");
		txt = txt.substring(pos + "<a " .length(), txt.length());
		
		pos = txt.indexOf("href");
		txt = txt.substring(pos + "href=\"".length(), txt.length());
		
		pos = txt.indexOf("\"");
		txt = txt.substring(0, pos );
		return txt;
	}
	
	public ArrayList<String> getHyperLinksInDocument(){
		ArrayList<String> erg = new ArrayList<String>();
		int zeilen[] = getZeileRegExp(".*(<[aA].*href.*>)");
		for(int i = 0; i < zeilen.length;i++){
			erg.add(getHyperlink(getZeile(zeilen[i])));
		}
		return erg;
	}
	
	
	public void showAllLinks(){
		for(String s:getHyperLinksInDocument()){
			System.out.println(s);
		}
	}
	
}
