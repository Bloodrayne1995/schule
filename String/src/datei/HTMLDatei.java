package datei;

public class HTMLDatei {

	private String fileName = "";
	private StringFileIO fileObject = new StringFileIO();
	
	
	public HTMLDatei(){
		
	}
	
	public HTMLDatei(String fileName){
		this.fileName = fileName;
		load();
	}
	
	
	private void load(){
		fileObject.setDateiName(fileName);
		fileObject.leseDatei();
	}
	
	public void load(String fileName){
		this.fileName=fileName;
		load();
	}
	
	public String getZeile(int index){
		if(index > fileObject.getDatei().size() || index < 0){
			return "Zeile ist nicht vorhanden";
		}else{
			return fileObject.getDatei().get(index);
		}
	}
	
	public void showAllLines(){
		for(int i = 0; i < fileObject.getDatei().size(); i++){
			System.out.println(getZeile(i));
		}
	}
	
	public void showZeilenWithSearch(String s){
		int zeilen[] = fileObject.getZeileSuchText(s);
		for(int i = 0; i < zeilen.length;i++){
			System.out.println(zeilen[i] + " : " + getZeile(zeilen[i]));
		}
	}
	
	public void showZeilenWithRegExp(String expr){
		int zeilen[] = fileObject.getZeileRegExp(expr);
		for(int i = 0; i < zeilen.length; i++){
			System.out.println(zeilen[i] + " : " + getZeile(zeilen[i]));
		}
	}
	
	
}
