package datei;

import java.io.*;

public class StringFileIO {

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
	
}
