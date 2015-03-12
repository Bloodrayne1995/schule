package datei;

public class TestHTMLDatei {

	
	public static void main(String args[]){
		HTMLDatei x = new HTMLDatei();
		x.load("/home/bsit13serr/Desktop/test.html");
		x.showZeilenWithSearch("a href");
	}
	
}
