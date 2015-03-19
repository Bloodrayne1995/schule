package datei;

import javax.swing.text.Document;

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
	
	
	
	
}
