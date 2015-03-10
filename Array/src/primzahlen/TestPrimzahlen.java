package primzahlen;

import myStoppUhr.StoppUhr;

public class TestPrimzahlen {

	public static void main(String[] args) {
		StoppUhr clock = new StoppUhr();
		Primzahlen d = new Primzahlen();
		d.setObergrenze(100000);
		d.initFeld();
		clock.useSystem(true);
		clock.start();
		d.berechnePrimzahlenClassic();
		clock.stop();
		d.ausgabe();
		System.out.println("Zeit: " + clock.toString());
		
//		d.initFeld();
//		clock.useSystem(true);
//		clock.start();
//		d.berechnePrimzahlenClassic();
//		clock.stop();
//		d.ausgabe();
//		System.out.println("Zeit: " + clock.toString());
//		
	}

}
