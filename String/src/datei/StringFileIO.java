package datei;

import java.io.*;
import java.util.ArrayList;

public class StringFileIO {

	
	private ArrayList<String> datei = new ArrayList<String>();
	private String dateiName = "";
	
	public void setDateiName(String dateiName){
		this.dateiName = dateiName;
	}
	
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
	
	public void leseDatei(){
		datei.clear();
		try(FileReader fs = new FileReader(dateiName);BufferedReader sr = new BufferedReader(fs)){
			String zeile = sr.readLine();
			while(zeile != null){
				datei.add(zeile);
				zeile = sr.readLine();
			}
		}catch(Exception e){
			datei.add(e.getMessage());
		}
	}	
	
	
	private int[] getArray(ArrayList<Integer> x){
		int d[] = new int[x.size()];
		for(int i = 0; i < d.length;i++){
			d[i] = x.get(i);
		}
		return d;
	}
	
	public int[] getZeileSuchText(String suche){
		ArrayList<Integer> zeilen = new ArrayList<Integer>();
		for(int i = 0; i < datei.size(); i++){
			if(datei.get(i).contains(suche)){
				zeilen.add(i);
			}
		}
		return getArray(zeilen);
	}
	
	public int[] getZeileRegExp(String expr){
		ArrayList<Integer> zeilen = new ArrayList<Integer>();
		for(int i = 0; i < datei.size(); i++){
			if(datei.get(i).matches(expr)){
				zeilen.add(i);
			}
		}
		return getArray(zeilen);
	}
	
	public ArrayList<String> getDatei(){
		return datei;
	}
}
