package datei;

public class TestHTMLDatei {

	
	public static void main(String args[]){
		HTMLDatei x = new HTMLDatei();
		x.setDateiName("/home/bsit13serr/Desktop/test.html");
		x.leseDatei();
		x.showZeilenWithRegExp("/([hH][1-6])/g");
	}
	
}
