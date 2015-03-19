package datei;

import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;

public class StringFileIO implements Runnable{

	
	private ArrayList<String> datei = new ArrayList<String>();
	private String dateiName = "";
	private boolean loaded = false;
	private boolean validFile = false;
	private ActionListener ac = null;
	
	
	/**
	 * @return the loaded
	 */
	public boolean isLoaded() {
		return loaded;
	}
	

	/**
	 * @return the validFile
	 */
	public boolean isValidFile() {
		return validFile;
	}
	

	/**
	 * Setzt den Datei-Name 
	 * @param dateiName
	 */
 	public void setDateiName(String dateiName){
		this.dateiName = dateiName;
		validFile = true;
	}
	
 	/**
 	 * Zeigt die Datei in der Konsole. Öffnet die Datei dafür wieder
 	 */
	public void zeigeDatei(){
		String textZeile = "";
		try(FileReader meinFile = new FileReader(dateiName);BufferedReader meinLeseStream = new BufferedReader(meinFile)){
			textZeile = meinLeseStream.readLine();
			while(textZeile != null){
				System.out.println(textZeile);
				textZeile = meinLeseStream.readLine();
			}
			System.out.println("############### ENDE DER DATEI #################");
		}catch(Exception e){}
	}
	
	/**
	 * Liest die Datei in den Puffer
	 */
	public void leseDatei(){
		datei.clear();
		try(FileReader fs = new FileReader(dateiName);BufferedReader sr = new BufferedReader(fs)){
			String zeile = sr.readLine();
			while(zeile != null){
				datei.add(zeile);
				zeile = sr.readLine();
			}
			loaded = true;
		}catch(Exception e){
			datei.add(e.getMessage());
		}
	}	
	
	/**
	 * Konvertiert eine ArrayList of Integer, in ein Array of int
	 * @param x ArrayList of Integer
	 * @return Array of int
	 */
	private int[] getArray(ArrayList<Integer> x){
		int d[] = new int[x.size()];
		for(int i = 0; i < d.length;i++){
			d[i] = x.get(i);
		}
		return d;
	}
	
	/**
	 * Gibt die Zeilen-Nummern zurück, die einen Suchtext beinhalten
	 * @param suche Suchtext
	 * @return
	 */
	public int[] getZeileSuchText(String suche){
		ArrayList<Integer> zeilen = new ArrayList<Integer>();
		for(int i = 0; i < datei.size(); i++){
			if(datei.get(i).contains(suche)){
				zeilen.add(i);
			}
		}
		return getArray(zeilen);
	}
	
	/**
	 * Gibt die Zeilen zurück, die mittels einen regulären Ausdruck gescuht werden
	 * @param expr Regulären Ausdruck
	 * @return
	 */
	public int[] getZeileRegExp(String expr){
		ArrayList<Integer> zeilen = new ArrayList<Integer>();
		for(int i = 0; i < datei.size(); i++){
			if(datei.get(i).matches(expr)){
				zeilen.add(i);
			}
		}
		return getArray(zeilen);
	}
	
	/**
	 * Gibt die Datei als solches zurück
	 * @return
	 */
	public ArrayList<String> getDatei(){
		return datei;
	}

	/**
	 * Gibt eine einzelne Zeile zurück
	 * @param index Zeilenummer
	 * @return
	 */
	public String getZeile(int index){
		if(index > datei.size() || index < 0){
			return "Zeile ist nicht vorhanden";
		}else{
			return datei.get(index);
		}
	}
	
	/**
	 * Zeigt die komplette Datei in der Konsole. Aus dem Puffer
	 */
	public void showAllLines(){
		for(int i = 0; i < datei.size(); i++){
			System.out.println(getZeile(i));
		}
	}
	
	/**
	 * Zeigt die Zeilen, die mit einem Suchtext gesucht wurden
	 * @param s Suchtext
	 */
	public void showZeilenWithSearch(String s){
		int zeilen[] = getZeileSuchText(s);
		for(int i = 0; i < zeilen.length;i++){
			System.out.println(zeilen[i]);
		}
	}
	
	/**
	 * Zeigt die Zeilen, die nach einem regulären Audruck gescuht werden
	 * @param expr Regulärer Ausdruck
	 */
	public void showZeilenWithRegExp(String expr){
		int zeilen[] = getZeileRegExp(expr);
		for(int i = 0; i < zeilen.length; i++){
			System.out.println(zeilen[i] + " : " + getZeile(zeilen[i]));
		}
	}

	private void raiseEvent(){
		if(ac != null){
			ac.actionPerformed(null);
		}
	}
	

	@Override
	public void run() {
		leseDatei();
		raiseEvent();
	}


	/**
	 * @param ac the ac to set
	 */
	public void setAc(ActionListener ac) {
		this.ac = ac;
	}
	
	public int[] getTextInZeile(int zeile, String txt){
		int erg[] = new int[2]; //0 = pos1 1 = pos2
		String z = getZeile(zeile);
		erg[0] = z.indexOf(txt);
		erg[1] = txt.length();
		return erg;
	}
	

	public String getTextAsString(){
		String d = "";
		for(String s:datei){
			d += s + System.lineSeparator();
		}
		return d;
	}
	
	
	public int[] getPositionsOfNormalText(String suche){
		int position = 0;
		ArrayList<Integer> zeilen = new ArrayList<Integer>();
		for(int i = 0; i < datei.size(); i++){
			if(datei.get(i).contains(suche)){
				zeilen.add(position);
			}
			position += datei.get(i).length();
		}
		return getArray(zeilen);
	}
	

	
	
	
	
}

