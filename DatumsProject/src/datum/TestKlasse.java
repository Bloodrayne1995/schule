package datum;

public class TestKlasse {

	
	public static void main(String args[]){
		UhrzeitKlasse x = new UhrzeitKlasse();
		x.setStartzeitAsSystemZeit();
		x.setStoppZeit(8, 33, 50);
		x.zeigeUhrzeit();
	}
	
}
